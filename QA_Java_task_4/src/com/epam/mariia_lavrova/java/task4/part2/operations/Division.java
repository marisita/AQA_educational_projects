/**
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task4.part2.operations;

public class Division implements Operation {

    @Override
    public double execute(int a, int b) {

        double divisionResult;

        try {
            divisionResult = (double) a / b;
        } catch (ArithmeticException e) {
            divisionResult = 0;
        }

        return divisionResult;
    }
}
