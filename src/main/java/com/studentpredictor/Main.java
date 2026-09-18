package com.studentpredictor;

import com.studentpredictor.data.*;
import com.studentpredictor.model.*;
import com.studentpredictor.service.*;
import com.studentpredictor.ui.PredictionFrame;

import javax.swing.*;
import java.util.*;
import java.nio.file.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String dataPath = "data/student_data.csv";
        DataLoader loader = new DataLoader();
        List<StudentRecord> records = loader.load(dataPath);

        Collections.shuffle(records, new Random(42));
        int split = (int)(records.size() * 0.8);

        double[][] trainX = new double[split][6];
        double[] trainY = new double[split];
        double[][] testX = new double[records.size() - split][6];
        double[] testY = new double[records.size() - split];

        for (int i = 0; i < records.size(); i++) {
            if (i < split) {
                trainX[i] = records.get(i).getFeatures();
                trainY[i] = records.get(i).getFinalScore();
            } else {
                testX[i - split] = records.get(i).getFeatures();
                testY[i - split] = records.get(i).getFinalScore();
            }
        }

        StandardScaler scaler = new StandardScaler();
        scaler.fit(trainX);
        double[][] scaledTrain = scaler.transform(trainX);
        double[][] scaledTest = scaler.transform(testX);

        LinearRegressionModel model = new LinearRegressionModel();
        model.fit(scaledTrain, trainY, 10000, 0.01);

        double[] predictions = model.predict(scaledTest);
        ModelEvaluator evaluator = new ModelEvaluator();

        System.out.printf("Training completed.%nMAE: %.4f%nRMSE: %.4f%nR2: %.4f%n",
                evaluator.mae(testY, predictions),
                evaluator.rmse(testY, predictions),
                evaluator.r2(testY, predictions));

        Files.createDirectories(Path.of("models"));
        PredictionService service = new PredictionService(model, scaler);
        service.save("models/student_model.ser", "models/scaler.ser");

        SwingUtilities.invokeLater(() -> new PredictionFrame(service).setVisible(true));
    }
}
