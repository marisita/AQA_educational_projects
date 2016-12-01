/**
 * @author Mariia_Lavrova
 * @since 11/30/2016
 */

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
public class AdditionTest {

    private Operation operation;
    private double expected;
    private int a;
    private int b;

    public AdditionTest(double expected, int a, int b) {
        this.expected = expected;
        this.a = a;
        this.b = b;
    }

    @Before
    public void setUp() throws Exception {
        int additionOperationCode = 0;
        MyOperationFactory factory = new MyOperationFactory();
        operation = factory.getOperation(additionOperationCode);
    }

    @Parameterized.Parameters
    public static Collection dataParameters() {
        return Arrays.asList(new Object[][]{{3, 1, 2}, {10, 0, 10}, {-6, -8, 2}});
    }

    @Test
    public void addTwoNumbersThenReturnsSum() throws Exception {
        assertEquals(expected, operation.execute(a, b));
    }
}