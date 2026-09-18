# Student Performance Predictor — Java

## Overview

This is a Java project made to predict a student's final score using
some academic and lifestyle-related information.

The user provides:
- Study hours
- Attendance
- Previous score
- Assignment completion
- Sleep hours
- Extracurricular hours

The project uses Linear Regression implemented in Java.
A Swing interface is used to enter the values and display the
predicted final score.

## Technologies
- Java 17
- Java Swing
- OOP
- File Handling
- JUnit 5

## Functional Modules

1. Data loading
2. Data preprocessing
3. Standardization
4. Linear Regression
5. Model evaluation
6. Prediction
7. Swing GUI


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
