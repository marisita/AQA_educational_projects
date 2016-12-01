/**
 * @author Mariia_Lavrova
 * @since 11/30/2016
 */

package com.epam.mariia_lavrova.java.task6.part2.operations;

import com.epam.mariia_lavrova.java.task6.part2.operations.factory.MyOperationFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DivisionByZeroTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void divideByZeroThenException() throws IllegalArgumentException {

        int additionOperationCode = 3;
        MyOperationFactory factory = new MyOperationFactory();
        Operation operation = factory.getOperation(additionOperationCode);
        int a = 10;
        int b = 0;

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("You can't divide by zero!");

        operation.execute(a, b);
    }
}