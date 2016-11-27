/**
 * Class for containing operation objects
 *
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task4.part2.operations.factory;

import com.epam.mariia_lavrova.java.task4.part2.operations.*;


public class MyOperationFactory implements OperationFactory {

    private Operation[] operations = new Operation[4];

    public MyOperationFactory() {
        operations[0] = new Addition();
        operations[1] = new Subtraction();
        operations[2] = new Multiplication();
        operations[3] = new Division();
    }

    @Override
    public Operation getOperation(int operationId) {
        return operations[operationId];
    }
}
