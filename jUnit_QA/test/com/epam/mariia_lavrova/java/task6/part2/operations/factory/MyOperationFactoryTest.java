package com.epam.mariia_lavrova.java.task6.part2.operations.factory;

import com.epam.mariia_lavrova.java.task6.part2.operations.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class MyOperationFactoryTest {

    private MyOperationFactory myOperationFactory;
    private int additionOperationCode;

    @Before
    public void setUp() throws Exception {
        myOperationFactory = new MyOperationFactory();
    }

    @Test
    public void getOperationWhenOperationCodeIs0ThenReturnsAddition() throws Exception {
        additionOperationCode = 0;
        assertThat(myOperationFactory.getOperation(additionOperationCode), instanceOf(Addition.class));
    }

    @Test
    public void getOperationWhenOperationCodeIs1ThenReturnsSubtraction() throws Exception {
        additionOperationCode = 1;
        assertThat(myOperationFactory.getOperation(additionOperationCode), instanceOf(Subtraction.class));
    }

    @Test
    public void getOperationWhenOperationCodeIs2ThenReturnsMultiplication() throws Exception {
        additionOperationCode = 2;
        assertThat(myOperationFactory.getOperation(additionOperationCode), instanceOf(Multiplication.class));
    }

    @Test
    public void getOperationWhenOperationCodeIs3ThenReturnsDivision() throws Exception {
        additionOperationCode = 3;
        assertThat(myOperationFactory.getOperation(additionOperationCode), instanceOf(Division.class));
    }
}