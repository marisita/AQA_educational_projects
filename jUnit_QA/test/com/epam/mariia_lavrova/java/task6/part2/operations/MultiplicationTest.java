package com.epam.mariia_lavrova.java.task6.part2.operations;

import com.epam.mariia_lavrova.java.task6.part2.operations.factory.MyOperationFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class MultiplicationTest {

    private Operation operation;
    private double expected;
    private int a;
    private int b;

    public MultiplicationTest(double expected, int a, int b) {
        this.expected = expected;
        this.a = a;
        this.b = b;
    }

    @Before
    public void setUp() throws Exception {
        int additionOperationCode = 2;
        MyOperationFactory factory = new MyOperationFactory();
        operation = factory.getOperation(additionOperationCode);
    }

    @Parameterized.Parameters
    public static Collection dataParameters() {
        return Arrays.asList(new Object[][]{{20, 10, 2}, {-10, -5, 2}, {16, -8, -2}});
    }

    @Test
    public void multiplyTwoNumbersThenReturnsMultiplication() throws Exception {
        assertEquals(expected, operation.execute(a, b));
    }
}