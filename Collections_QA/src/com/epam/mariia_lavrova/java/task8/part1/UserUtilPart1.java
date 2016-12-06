package com.epam.mariia_lavrova.java.task8.part1;

import com.epam.mariia_lavrova.java.task8.part1.factory.impl.OperationFactory;
import com.epam.mariia_lavrova.java.task8.part1.operation.Operation;

import java.util.Scanner;

public class UserUtilPart1 {

    private static final String CONTINUE = "\nDo you want continue? y/n";
    private static final String OPERATION_CODE = "\nPlease input operation code: \n 1 - Frequency \n 2 - Length \n 3 - Duplicates";
    private static final String INPUT_FILE_PATH = "\nPlease input file path";
    private static final String INVALID_OPERATION_CODE = "\nInvalid operation code";
    private static final String OUT_CODE = "n";

    public static void execute() {

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.println(INPUT_FILE_PATH);
                String filePath = scanner.nextLine();

                System.out.println(OPERATION_CODE);
                int operationCode = Integer.parseInt(scanner.nextLine());

                OperationFactory operationFactory = new OperationFactory();
                Operation operation = operationFactory.getOperation(operationCode);

                //operation.setFilePath(filePath);
                operation.setFilePath("input.txt");
                operation.execute();

            } catch (NullPointerException | NumberFormatException e) {
                System.err.println(INVALID_OPERATION_CODE);
            }

            System.out.println(CONTINUE);

        } while (!OUT_CODE.equals(scanner.nextLine()));

        scanner.close();

    }

}
