/**
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task7.calculator.operations.factory;

import com.epam.mariia_lavrova.java.task7.calculator.operations.IOperation;


public interface IOperationFactory {
    IOperation getOperation(int operationId);
}
