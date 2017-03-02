package com.epam.mariia_lavrova.constant;

/**
 * Class contains the locators of html elements on pages
 *
 * @author Mariia_Lavrova
 * @since 02/02/2017
 */

public final class Locator {

    public static final String EMAIL_INPUT_LOCATOR = ".//*[@id='Email']";
    public static final String NEXT_BUTTON_LOCATOR = ".//*[@id='next']";

    public static final String PASSWORD_BUTTON_LOCATOR = ".//*[@id='Passwd']";
    public static final String SIGN_IN_BUTTON_LOCATOR = ".//*[@id='signIn']";

    public static final String WRITE_BUTTON_LOCATOR = ".//*[@class='aic']/div/div";
    public static final String LETTER_SUBJECT_LINK_LOCATOR = "(.//span[@class='bog']/b[contains(text(), 'subject')])[1]";

    public static final String TO_INPUT_LOCATOR = ".//*[@name='to']";
    public static final String SUBJECT_INPUT_LOCATOR = ".//*[@name='subjectbox']";
    public static final String BODY_INPUT_LOCATOR = ".//*[@class='Ap']/div[2]/div";
    public static final String SEND_BUTTON_LOCATOR = ".//*[@class='gU Up']/div/div[2] dfbfdb";

    private Locator() {
    }
}
