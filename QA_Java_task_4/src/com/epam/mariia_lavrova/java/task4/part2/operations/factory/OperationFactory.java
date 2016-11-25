package com.epam.mariia_lavrova.java.task4.part2.operations.factory;

import com.epam.mariia_lavrova.java.task4.part2.operations.Operation;

/**
 * Created by Mariia_Lavrova on 11/24/2016.
 */
public interface OperationFactory {
    Operation getOperation(int operationId);
}
