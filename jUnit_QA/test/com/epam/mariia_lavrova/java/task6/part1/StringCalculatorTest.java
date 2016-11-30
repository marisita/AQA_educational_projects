package com.epam.mariia_lavrova.java.task6.part1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marisita on 30.11.2016.
 */
public class StringCalculatorTest {

    @Test
    public void addWhenEmptyStringThenReturnsZero() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void addWhenStringWithOneNumberThenReturnsThisNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void addWhenStringWithTwoNumbersDividedCommaThenReturnsSum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void addWhenStringWithUnknownAmountOfNumbersDividedCommaThenReturnsSum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(15, stringCalculator.add("1,2,3,4,5"));
    }

    @Test
    public void addWhenStringNewLinesBetweenNumbersThenReturnsSum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void addWhenStringWithDifferentDelimiterThenReturnsSum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Rule
    public final ExpectedException thrownOneNegativeNumber = ExpectedException.none();

    @Test
    public void addWhenStringWithNegativeNumberThenException() {
        StringCalculator stringCalculator = new StringCalculator();
        thrownOneNegativeNumber.expect(IllegalArgumentException.class);
        thrownOneNegativeNumber.expectMessage("Negatives not allowed: -1 ");
        stringCalculator.add("-1,2,3");
    }

    @Test
    public void addWhenStringWithMultipleNegativeNumbersThenException() {
        StringCalculator stringCalculator = new StringCalculator();
        thrownOneNegativeNumber.expect(IllegalArgumentException.class);
        thrownOneNegativeNumber.expectMessage("Negatives not allowed: -1 -2 ");
        stringCalculator.add("-1,-2,3");
    }

    @Test
    public void addWhenStringWithNumberGreatThan1000ThenReturnsSum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.add("1000,2"));
    }

    @Test
    public void addWhenStringWithDifferentLengthDelimiterThenReturnsSum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//[,,,]\n1,,,2"));
    }


}
