/**
 * @author Mariia_Lavrova
 * @since 11/30/2016
 */

package com.epam.mariia_lavrova.java.task6.part2.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorTest {

    private Calculator calculator;
    private double expected;
    private String mathExpression;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    public CalculatorTest(double expected, String mathExpression) {
        this.expected = expected;
        this.mathExpression = mathExpression;
    }

    @Parameterized.Parameters
    public static Collection dataParameters() {
        return Arrays.asList(new Object[][]{{6.0, "5+1"}, {6.0, " 5 +  1"}, {0.0, "-5+5"}, {4.0, "+1++3"}, {-4.0, "-1+-3"},
                {4.0, "5-1"}, {4.0, " 5 -  1"}, {0.0, "5-5"}, {2.0, "-1--3"}, {-4.0, "-1-+3"},
                {5.0, "5*1"}, {5.0, " 5 *  1"}, {0.0, "5*0"}, {-3.0, "-1*+3"}, {3.0, "-1*-3"},
                {5.0, "5/1"}, {0.2, " 1 /  5"}, {0.0, "5/0"}, {-2.0, "-6/3"}, {2.0, "-6/-3"}});
    }

    @Test
    public void calculateWhenStringContainSignAndTwoNumbersThanReturnsOperationResult() throws Exception {
        assertEquals(expected, calculator.calculate(mathExpression));
    }
}