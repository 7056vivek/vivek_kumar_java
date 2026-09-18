# Design Diagrams

## System Architecture
```mermaid
flowchart TD
A[CSV Dataset] --> B[DataLoader]
B --> C[Validation]
C --> D[StandardScaler]
D --> E[Linear Regression]
E --> F[Evaluation]
E --> G[Serialized Model]
G --> H[PredictionService]
H --> I[Java Swing GUI]
I --> J[Predicted Final Score]
```

## Workflow
```mermaid
flowchart LR
A[Start] --> B[Enter Student Data]
B --> C{Valid Input?}
C -- No --> D[Show Error]
D --> B
C -- Yes --> E[Scale Features]
E --> F[Regression Model]
F --> G[Display Score]
G --> H[End]
```

## Use Case
```mermaid
flowchart LR
S((Student)) --> A[Enter Academic Data]
S --> B[Request Prediction]
S --> C[View Predicted Score]
D((Developer/Admin)) --> E[Train Model]
D --> F[Evaluate Model]
```

## Class Diagram
```mermaid
classDiagram
class StudentRecord
class DataLoader
class StandardScaler
class LinearRegressionModel
class ModelEvaluator
class PredictionService
class PredictionFrame
DataLoader --> StudentRecord
StandardScaler --> LinearRegressionModel
LinearRegressionModel --> ModelEvaluator
LinearRegressionModel --> PredictionService
StandardScaler --> PredictionService
PredictionService --> PredictionFrame
```

## Sequence
```mermaid
sequenceDiagram
actor Student
participant GUI
participant Predictor
participant Model
Student->>GUI: Enter values
GUI->>Predictor: Send six features
Predictor->>Model: Scale and predict
Model-->>Predictor: Predicted score
Predictor-->>GUI: Score
GUI-->>Student: Display result
```
