package com.studentpredictor.data;

import java.io.Serializable;

public class StudentRecord implements Serializable {
    private final double[] features;
    private final double finalScore;

    public StudentRecord(double[] features, double finalScore) {
        if (features == null || features.length != 6) {
            throw new IllegalArgumentException("Exactly six features are required.");
        }
        this.features = features.clone();
        this.finalScore = finalScore;
    }

    public double[] getFeatures() { return features.clone(); }
    public double getFinalScore() { return finalScore; }
}
