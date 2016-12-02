/**
 *
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task7.calculator.operations.impl;

import com.epam.mariia_lavrova.java.task7.calculator.operations.IOperation;

public class Addition implements IOperation {

    @Override
    public double execute(int a, int b) {
        return a + b;
    }
}
