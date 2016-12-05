/**
 * @author Mariia_Lavrova
 * @since 11/30/2016
 */

package com.epam.mariia_lavrova.java.task6.part1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void addWhenEmptyStringThenReturnsZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void addWhenStringWithOneNumberThenReturnsThisNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void addWhenStringWithTwoNumbersDividedCommaThenReturnsSum() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void addWhenStringWithUnknownAmountOfNumbersDividedCommaThenReturnsSum() {
        assertEquals(15, stringCalculator.add("1,2,3,4,5"));
    }

    @Test
    public void addWhenStringNewLinesBetweenNumbersThenReturnsSum() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void addWhenStringWithDifferentDelimiterThenReturnsSum() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Rule
    public final ExpectedException thrownOneNegativeNumber = ExpectedException.none();

    @Test
    public void addWhenStringWithNegativeNumberThenException() {
        thrownOneNegativeNumber.expect(IllegalArgumentException.class);
        thrownOneNegativeNumber.expectMessage("Negatives not allowed: -1 ");
        stringCalculator.add("-1,2,3");
    }

    @Test
    public void addWhenStringWithMultipleNegativeNumbersThenException() {
        thrownOneNegativeNumber.expect(IllegalArgumentException.class);
        thrownOneNegativeNumber.expectMessage("Negatives not allowed: -1 -2 ");
        stringCalculator.add("-1,-2,3");
    }

    @Test
    public void addWhenStringWithNumberGreatThan1000ThenReturnsSum() {
        assertEquals(2, stringCalculator.add("1001,2"));
    }

    @Test
    public void addWhenStringWithDifferentLengthDelimiterThenReturnsSum() {
        assertEquals(3, stringCalculator.add("//[,,,]\n1,,,2"));
    }
}
