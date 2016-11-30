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
public class SubtractionTest {

    private Operation operation;
    private double expected;
    private int a;
    private int b;

    public SubtractionTest(double expected, int a, int b) {
        this.expected = expected;
        this.a = a;
        this.b = b;
    }

    @Before
    public void setUp() throws Exception {
        int additionOperationCode = 1;
        MyOperationFactory factory = new MyOperationFactory();
        operation = factory.getOperation(additionOperationCode);
    }

    @Parameterized.Parameters
    public static Collection dataParameters() {
        return Arrays.asList(new Object[][]{{10, 12, 2}, {0, -5, -5}, {-5, 5, 10}});
    }

    @Test
    public void subtractTwoNumbersThenReturnsSubtraction() throws Exception {
        assertEquals(expected, operation.execute(a, b));
    }

}