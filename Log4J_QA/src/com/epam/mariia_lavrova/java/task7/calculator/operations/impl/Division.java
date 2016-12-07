/**
 * @author Mariia_Lavrova
 * @since 11/30/2016
 */

package com.epam.mariia_lavrova.java.task7.calculator.operations.impl;

import com.epam.mariia_lavrova.java.task7.calculator.operations.IOperation;

public class Division implements IOperation {

    @Override
    public double execute(int a, int b) throws IllegalArgumentException{

        if (b == 0) {
            throw new IllegalArgumentException("You can't divide by zero!");
        } else {
            return (double) a / b;
        }
    }
}
