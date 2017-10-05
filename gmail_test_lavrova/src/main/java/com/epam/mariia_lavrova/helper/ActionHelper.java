package com.epam.mariia_lavrova.helper;

import com.epam.mariia_lavrova.driver.ChromeDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.epam.mariia_lavrova.constant.Message.*;

public class ActionHelper {

    private static Logger logger = LogManager.getLogger(ActionHelper.class);
    private static WebDriverWait wait = new WebDriverWait(ChromeDriverManager.getDriver(), 3);

    public static boolean isContains(String actualText, String expectedText) {
        actualText = actualText.toLowerCase().replace(" ", "");
        expectedText = expectedText.toLowerCase().replace(" ", "");
        return actualText.contains(expectedText);
    }

    public static boolean isContains(WebElement webElement, String elementName, String expectedText) {
        String actualText = webElement.getText().toLowerCase().replace(" ", "");
        expectedText = expectedText.toLowerCase().replace(" ", "");
        if (isContains(actualText, expectedText)) {
            logger.info(String.format(ELEMENT_CONTAINS_TEXT, elementName, expectedText));
            return true;
        } else {
            logger.info(String.format(ELEMENT_NOT_CONTAIN_TEXT, elementName, expectedText));
            return false;
        }
    }

    public static boolean isContains(List<WebElement> webElements, String elementName, String expectedText) {
        for (WebElement webElement: webElements) {
            if (isContains(webElement.getText(), expectedText)) {
                logger.info(String.format(ELEMENT_FROM_LIST_CONTAINS_TEXT, elementName, expectedText));
                return true;
            }
        }
        logger.info(String.format(ANY_ELEMENT_FROM_LIST_NOT_CONTAIN_TEST, elementName, expectedText));
        return false;
    }

    public static boolean isClickable(WebElement webElement, String elementName) {
        ExpectedCondition<WebElement> presenceCondition = ExpectedConditions.elementToBeClickable(webElement);
        try {
            wait.until(presenceCondition);
            logger.info(String.format(ELEMENT_CLICKABLE_ON_THE_PAGE, elementName, ""));
            return true;
        } catch (TimeoutException e) {
            logger.error(String.format(ELEMENT_NOT_CLICKABLE_ON_THE_PAGE, elementName, ""));
        }
        return false;
    }

    public static boolean isVisible(WebElement webElement, String elementName) {
        ExpectedCondition<WebElement> presenceCondition = ExpectedConditions.visibilityOf(webElement);
        try {
            wait.until(presenceCondition);
            logger.info(String.format(ELEMENT_IS_VISIBLE_ON_THE_PAGE, elementName, ""));
            return true;
        } catch (TimeoutException e) {
            logger.error(String.format(ELEMENT_NOT_VISIBLE_ON_THE_PAGE, elementName, ""));
        }
        return false;
    }
}
