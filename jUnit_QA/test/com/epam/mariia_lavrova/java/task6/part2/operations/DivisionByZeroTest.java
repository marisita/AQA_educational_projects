package com.epam.mariia_lavrova.java.task6.part2.operations;

import com.epam.mariia_lavrova.java.task6.part2.operations.factory.MyOperationFactory;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DivisionByZeroTest {

    @Test
    public void divideByZeroThenReturnsZero() throws IllegalArgumentException {
        int additionOperationCode = 3;
        MyOperationFactory factory = new MyOperationFactory();
        Operation operation = factory.getOperation(additionOperationCode);
        int a = 10;
        int b = 0;
        double expected = 0.0;

        assertEquals(expected, operation.execute(a, b));
    }

}