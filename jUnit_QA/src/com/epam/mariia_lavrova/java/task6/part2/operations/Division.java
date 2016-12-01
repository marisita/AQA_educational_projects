/**
 * @author Mariia_Lavrova
 * @since 11/30/2016
 */

package com.epam.mariia_lavrova.java.task6.part2.operations;

public class Division implements Operation {

    @Override
    public double execute(int a, int b) throws IllegalArgumentException{

        if (b == 0) {
            throw new IllegalArgumentException("You can't divide by zero!");
        } else {
            return (double) a / b;
        }
    }
}
