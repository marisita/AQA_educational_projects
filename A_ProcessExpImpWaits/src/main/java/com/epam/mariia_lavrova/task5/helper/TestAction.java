package com.epam.mariia_lavrova.task5.helper;

import junit.framework.Assert;

public class TestAction {

    public static void assertContains(String actualText, String expectedText) {
        actualText = actualText.toLowerCase().replace(" ", "");
        expectedText = expectedText.toLowerCase().replace(" ", "");
        Assert.assertTrue(actualText.contains(expectedText));
    }
}
