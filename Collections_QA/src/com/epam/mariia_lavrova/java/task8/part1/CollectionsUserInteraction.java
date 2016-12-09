package com.epam.mariia_lavrova.java.task8.part1;

import com.epam.mariia_lavrova.java.task8.part1.factory.impl.OperationFactory;
import com.epam.mariia_lavrova.java.task8.part1.operation.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CollectionsUserInteraction {

    private static final Logger LOGGER = LogManager.getLogger(Operation.class);
    private static final String CONTINUE = "\nDo you want continue? y/n";
    private static final String OPERATION_CODE = "\nPlease input operation code: \n 1 - Frequency \n 2 - Length \n 3 - Duplicates";
    private static final String INPUT_FILE_PATH = "\nPlease input file path";
    private static final String INVALID_OPERATION_CODE = "\nInvalid operation code";
    private static final String OUT_CODE = "n";

    public static void execute() {

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                LOGGER.info(INPUT_FILE_PATH);
                String filePath = scanner.nextLine();

                LOGGER.info(OPERATION_CODE);
                int operationCode = Integer.parseInt(scanner.nextLine());

                OperationFactory operationFactory = new OperationFactory();
                Operation operation = operationFactory.getOperation(operationCode);

                operation.setFilePath(filePath);
                operation.execute();

            } catch (NullPointerException | NumberFormatException e) {
                LOGGER.error(INVALID_OPERATION_CODE);
            }

            LOGGER.info(CONTINUE);

        } while (!OUT_CODE.equals(scanner.nextLine()));

        scanner.close();

    }

}
