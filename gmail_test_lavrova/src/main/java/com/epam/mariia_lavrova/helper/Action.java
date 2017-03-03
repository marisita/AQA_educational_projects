package com.epam.mariia_lavrova.helper;

import com.epam.mariia_lavrova.driver.ChromeDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.mariia_lavrova.constant.Message.*;

/**
 * Class for operations with web elements
 *
 * @author Mariia_Lavrova
 * @since 02/02/2017
 */

public class Action {

    private static Logger logger = LogManager.getLogger(Action.class);

    /**
     * Assert that webElement is visible and equals to expected text
     * @param webElement object's text that to be compared
     * @param expectedText to be compare with text in webElement
     * @param webElementName the name of webElement
     * @param pageName the name of page, that contains webElement
     */
    public static void assertText(WebElement webElement, String expectedText, String webElementName, String pageName) {
        ActionAssert.assertIsVisible(webElement, webElementName, pageName);
        ActionAssert.assertContains(webElement, webElementName, expectedText);
    }

    /**
     * Assert that webElement is visible and clickable
     * Click on webElement
     * @param webElement object's text that to be compared
     * @param webElementName the name of webElement
     * @param pageName the name of page, that contains webElement
     */
    public static void click(WebElement webElement, String webElementName, String pageName) {
        ActionAssert.assertIsVisible(webElement, webElementName, pageName);
        ActionAssert.assertIsClickable(webElement, webElementName, pageName);
        webElement.click();
        logger.info(String.format(ELEMENT_WAS_CLICKED_ON_THE_PAGE, webElementName, pageName));
    }

    /**
     * Assert that webElement is visible
     * Clear and fill this input
     * @param webElement object's text that to be compared
     * @param inputValue will be inputted to the webElement
     * @param webElementName the name of webElement
     * @param pageName the name of page, that contains webElement
     */
    public static void fillInput(WebElement webElement, String inputValue, String webElementName, String pageName) {
        ActionAssert.assertIsVisible(webElement, webElementName, pageName);
        webElement.clear();
        webElement.sendKeys(inputValue);
        logger.info(String.format(ELEMENT_WAS_FILLED_WITH_VALUE_ON_THE_PAGE, webElementName, pageName));
    }

    /**
     * Refresh the current page, and click to a alert for confirmation refreshing
     * @param pageName the name of page to be refreshed
     */
    public static void refreshPage(String pageName) {
        ChromeDriverManager.getDriver().navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(ChromeDriverManager.getDriver(), 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = ChromeDriverManager.getDriver().switchTo().alert();
            alert.accept();
            logger.info(String.format(PAGE_WAS_REFRESHED, pageName));
        } catch (TimeoutException e) {
            logger.error(String.format(PAGE_WAS_NOT_REFRESHED, pageName));
        }
    }
}
