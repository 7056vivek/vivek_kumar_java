package com.studentpredictor;

import com.studentpredictor.model.StandardScaler;
import com.studentpredictor.service.ModelEvaluator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {
    @Test
    void scalerProducesZeroMeanForSimpleData() {
        StandardScaler scaler = new StandardScaler();
        double[][] x = {{1,2},{3,4},{5,6}};
        scaler.fit(x);
        double[] transformed = scaler.transform(new double[]{3,4});
        assertEquals(0.0, transformed[0], 1e-9);
        assertEquals(0.0, transformed[1], 1e-9);
    }

    @Test
    void evaluatorWorks() {
        ModelEvaluator e = new ModelEvaluator();
        assertEquals(0.0, e.mae(new double[]{1,2}, new double[]{1,2}), 1e-9);
        assertEquals(1.0, e.r2(new double[]{1,2,3}, new double[]{1,2,3}), 1e-9);
    }
}
