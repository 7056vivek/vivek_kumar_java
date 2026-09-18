package com.studentpredictor.model;

import java.io.Serializable;
import java.util.Arrays;

public class LinearRegressionModel implements Serializable {
    private double[] weights;
    private double bias;

    public void fit(double[][] x, double[] y, int epochs, double learningRate) {
        int n = x.length, m = x[0].length;
        weights = new double[m];
        bias = 0;

        for (int epoch = 0; epoch < epochs; epoch++) {
            double[] gradW = new double[m];
            double gradB = 0;

            for (int i = 0; i < n; i++) {
                double pred = predict(x[i]);
                double error = pred - y[i];
                for (int j = 0; j < m; j++) gradW[j] += error * x[i][j];
                gradB += error;
            }

            for (int j = 0; j < m; j++) weights[j] -= learningRate * gradW[j] / n;
            bias -= learningRate * gradB / n;
        }
    }

    public double predict(double[] x) {
        if (weights == null) throw new IllegalStateException("Model is not trained.");
        double result = bias;
        for (int j = 0; j < weights.length; j++) result += weights[j] * x[j];
        return result;
    }

    public double[] predict(double[][] x) {
        double[] out = new double[x.length];
        for (int i = 0; i < x.length; i++) out[i] = predict(x[i]);
        return out;
    }

    public double[] getWeights() { return weights == null ? null : Arrays.copyOf(weights, weights.length); }
}
