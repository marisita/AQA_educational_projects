package com.epam.mariia_lavrova.constant;

import java.util.Date;

/**
 * Class contains the test data
 *
 * @author Mariia_Lavrova
 * @since 02/02/2017
 */

public final class TestData {

    public static final String EMAIL = "nemaria.nelavrova@gmail.com";
    public static final String PASSWORD = "Mania2013";
    public static final String SUBJECT = "subject".concat(String.valueOf(System.currentTimeMillis()));
    public static final String BODY = "body";

    private TestData() {
    }
}
