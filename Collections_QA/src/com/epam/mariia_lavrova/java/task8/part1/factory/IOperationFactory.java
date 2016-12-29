package com.epam.mariia_lavrova.java.task8.part1.factory;

import com.epam.mariia_lavrova.java.task8.part1.operation.Operation;

public interface IOperationFactory {

    Operation getOperation(int operationCode);
}
