package com.studentpredictor.ui;

import com.studentpredictor.service.PredictionService;
import javax.swing.*;
import java.awt.*;

public class PredictionFrame extends JFrame {
    private final JTextField[] fields = new JTextField[6];
    private final PredictionService service;

    private static final String[] LABELS = {
        "Study Hours / Day", "Attendance (%)", "Previous Score",
        "Assignments Completed (%)", "Sleep Hours / Day", "Extracurricular Hours / Week"
    };

    public PredictionFrame(PredictionService service) {
        this.service = service;
        setTitle("Student Performance Predictor");
        setSize(520, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        for (int i = 0; i < 6; i++) {
            panel.add(new JLabel(LABELS[i]));
            fields[i] = new JTextField();
            panel.add(fields[i]);
        }

        JButton button = new JButton("Predict Final Score");
        JLabel result = new JLabel("Enter values and click Predict.", SwingConstants.CENTER);

        panel.add(button);
        panel.add(result);
        add(panel);

        button.addActionListener(e -> {
            try {
                double[] x = new double[6];
                for (int i = 0; i < 6; i++) x[i] = Double.parseDouble(fields[i].getText().trim());
                double score = service.predict(x);
                result.setText(String.format("Predicted Final Score: %.2f / 100", score));
            } catch (NumberFormatException ex) {
                result.setText("Please enter valid numeric values.");
            } catch (Exception ex) {
                result.setText("Prediction error: " + ex.getMessage());
            }
        });
    }
}
