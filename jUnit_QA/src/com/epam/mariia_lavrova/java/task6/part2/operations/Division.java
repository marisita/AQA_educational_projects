/**
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task6.part2.operations;

public class Division implements Operation {

    @Override
    public double execute(int a, int b) {

        double divisionResult;

        try {
            if (b == 0) {
                throw new IllegalArgumentException();
            } else {
                divisionResult = (double) a / b;
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            divisionResult = 0;
        }

        return divisionResult;
    }
}
