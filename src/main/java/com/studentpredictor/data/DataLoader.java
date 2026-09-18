package com.studentpredictor.data;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataLoader {
    public List<StudentRecord> load(String filePath) throws IOException {
        List<StudentRecord> records = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of(filePath));

        if (lines.size() < 2) throw new IllegalArgumentException("Dataset is empty.");

        String[] header = lines.get(0).split(",");
        if (header.length != 7) throw new IllegalArgumentException("Expected 7 CSV columns.");

        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).isBlank()) continue;
            String[] p = lines.get(i).split(",");
            if (p.length != 7) throw new IllegalArgumentException("Invalid row at line " + (i + 1));

            double[] x = new double[6];
            for (int j = 0; j < 6; j++) x[j] = Double.parseDouble(p[j].trim());
            double y = Double.parseDouble(p[6].trim());
            records.add(new StudentRecord(x, y));
        }
        return records;
    }
}
