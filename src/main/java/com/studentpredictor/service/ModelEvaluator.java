package com.studentpredictor.service;

public class ModelEvaluator {
    public double mae(double[] actual, double[] predicted) {
        double sum = 0;
        for (int i = 0; i < actual.length; i++) sum += Math.abs(actual[i] - predicted[i]);
        return sum / actual.length;
    }

    public double rmse(double[] actual, double[] predicted) {
        double sum = 0;
        for (int i = 0; i < actual.length; i++) sum += Math.pow(actual[i] - predicted[i], 2);
        return Math.sqrt(sum / actual.length);
    }

    public double r2(double[] actual, double[] predicted) {
        double mean = 0;
        for (double v : actual) mean += v;
        mean /= actual.length;

        double ssRes = 0, ssTot = 0;
        for (int i = 0; i < actual.length; i++) {
            ssRes += Math.pow(actual[i] - predicted[i], 2);
            ssTot += Math.pow(actual[i] - mean, 2);
        }
        return 1 - (ssRes / ssTot);
    }
}
