/**
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task4.part2.operations.factory;

import com.epam.mariia_lavrova.java.task4.part2.operations.Operation;


public interface OperationFactory {
    Operation getOperation(int operationId);
}
