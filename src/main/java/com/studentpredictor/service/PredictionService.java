package com.studentpredictor.service;

import com.studentpredictor.model.LinearRegressionModel;
import com.studentpredictor.model.StandardScaler;

import java.io.*;

public class PredictionService {
    private final LinearRegressionModel model;
    private final StandardScaler scaler;

    public PredictionService(LinearRegressionModel model, StandardScaler scaler) {
        this.model = model;
        this.scaler = scaler;
    }

    public double predict(double[] features) {
        if (features.length != 6) throw new IllegalArgumentException("Six inputs are required.");
        double value = model.predict(scaler.transform(features));
        return Math.max(0, Math.min(100, value));
    }

    public void save(String modelPath, String scalerPath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(modelPath))) {
            out.writeObject(model);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(scalerPath))) {
            out.writeObject(scaler);
        }
    }
}
