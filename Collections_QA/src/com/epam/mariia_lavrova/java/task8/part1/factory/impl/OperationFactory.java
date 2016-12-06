package com.epam.mariia_lavrova.java.task8.part1.factory.impl;

import com.epam.mariia_lavrova.java.task8.part1.factory.IOperationFactory;
import com.epam.mariia_lavrova.java.task8.part1.operation.*;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory implements IOperationFactory {

    private Map<Integer, Operation> operations = new HashMap<>();

    public OperationFactory() {
        operations.put(1, new Frequency());
        operations.put(2, new Length());
        operations.put(3, new Duplicates());
    }

    @Override
    public Operation getOperation(int operationCode) {
        return operations.get(operationCode);
    }
}
