/**
 * Class for containing operation objects
 *
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task7.calculator.operations.factory.impl;

import com.epam.mariia_lavrova.java.task7.calculator.operations.*;
import com.epam.mariia_lavrova.java.task7.calculator.operations.factory.IOperationFactory;
import com.epam.mariia_lavrova.java.task7.calculator.operations.impl.Addition;
import com.epam.mariia_lavrova.java.task7.calculator.operations.impl.Division;
import com.epam.mariia_lavrova.java.task7.calculator.operations.impl.Multiplication;
import com.epam.mariia_lavrova.java.task7.calculator.operations.impl.Subtraction;


public class OperationFactory implements IOperationFactory {

    private IOperation[] operations = new IOperation[4];

    public OperationFactory() {
        operations[0] = new Addition();
        operations[1] = new Subtraction();
        operations[2] = new Multiplication();
        operations[3] = new Division();
    }

    @Override
    public IOperation getOperation(int operationId) {
        return operations[operationId];
    }
}
