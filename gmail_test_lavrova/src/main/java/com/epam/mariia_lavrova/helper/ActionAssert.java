package com.epam.mariia_lavrova.helper;

import junit.framework.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.mariia_lavrova.constant.Message.*;
import static com.epam.mariia_lavrova.helper.ActionHelper.*;

public class ActionAssert {

    public static void assertContains(WebElement webElement, String elementName, String expectedText) {
        boolean contains = isContains(webElement, elementName, expectedText);
        String failMessage = String.format(ELEMENT_NOT_CONTAIN_TEXT, elementName, expectedText);
        Assert.assertTrue(failMessage, contains);
    }

    public static void assertContains(List<WebElement> webElements, String elementName, String expectedText) {
        boolean contains = isContains(webElements, elementName, expectedText);
        String failMessage = String.format(ANY_ELEMENT_FROM_LIST_NOT_CONTAIN_TEST, elementName, expectedText);
        Assert.assertTrue(failMessage, contains);
    }

    public static void assertIsVisible(WebElement webElement, String elementName, String pageName) {
        boolean visibility = isVisible(webElement, elementName);
        String failMessage = String.format(ELEMENT_NOT_VISIBLE_ON_THE_PAGE, elementName, pageName);
        Assert.assertTrue(failMessage, visibility);
    }

    public static void assertIsClickable(WebElement webElement, String webElementName, String pageName) {
        boolean clickable = isClickable(webElement, webElementName);
        String failMessage = String.format(ELEMENT_NOT_CLICKABLE_ON_THE_PAGE, webElementName, pageName);
        Assert.assertTrue(failMessage, clickable);
    }
}
