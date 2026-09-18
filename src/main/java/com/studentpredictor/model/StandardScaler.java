package com.studentpredictor.model;

import java.io.Serializable;

public class StandardScaler implements Serializable {
    private double[] mean;
    private double[] std;

    public void fit(double[][] x) {
        int n = x.length, m = x[0].length;
        mean = new double[m];
        std = new double[m];

        for (double[] row : x)
            for (int j = 0; j < m; j++) mean[j] += row[j];
        for (int j = 0; j < m; j++) mean[j] /= n;

        for (double[] row : x)
            for (int j = 0; j < m; j++) std[j] += Math.pow(row[j] - mean[j], 2);
        for (int j = 0; j < m; j++) {
            std[j] = Math.sqrt(std[j] / n);
            if (std[j] == 0) std[j] = 1;
        }
    }

    public double[] transform(double[] row) {
        double[] out = new double[row.length];
        for (int j = 0; j < row.length; j++) out[j] = (row[j] - mean[j]) / std[j];
        return out;
    }

    public double[][] transform(double[][] x) {
        double[][] out = new double[x.length][];
        for (int i = 0; i < x.length; i++) out[i] = transform(x[i]);
        return out;
    }
}
