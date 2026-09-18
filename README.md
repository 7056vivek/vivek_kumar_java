# Student Performance Predictor — Java

## Overview
A Java-based machine-learning educational project that predicts a student's final score from academic and lifestyle inputs. It implements CSV loading, validation, preprocessing, Linear Regression using gradient descent, evaluation, model persistence, and a Java Swing desktop interface.

## Technologies
- Java 17+
- Java Swing
- Java Collections and File I/O
- Object Serialization
- JUnit 5

## Functional Modules
1. Data loading and validation
2. Data preprocessing and standardization
3. Linear Regression training
4. Model evaluation
5. Prediction and model persistence
6. Swing desktop interface

## Project Structure
```text
Student_Performance_Predictor_Java/
├── pom.xml
├── README.md
├── statement.md
├── data/student_data.csv
├── models/
├── docs/diagrams.md
└── src/
    ├── main/java/com/studentpredictor/
    │   ├── Main.java
    │   ├── data/DataLoader.java
    │   ├── data/StudentRecord.java
    │   ├── model/LinearRegressionModel.java
    │   ├── model/StandardScaler.java
    │   ├── service/ModelEvaluator.java
    │   ├── service/PredictionService.java
    │   └── ui/PredictionFrame.java
    └── test/java/com/studentpredictor/
        └── ProjectTest.java
```

## Run with Maven
Requires Java 17+ and Maven.
```bash
mvn test
mvn package
java -cp target/student-performance-predictor-1.0.0.jar com.studentpredictor.Main
```

## Run without Maven
```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.studentpredictor.Main
```

## Model
Multiple Linear Regression is implemented from scratch using gradient descent. Six features are used:
study hours, attendance, previous score, assignments completed, sleep hours, and extracurricular hours. The target is final score (0–100).

## Academic Note
This is an educational ML demonstration. Predictions are estimates and are not official academic decisions.
