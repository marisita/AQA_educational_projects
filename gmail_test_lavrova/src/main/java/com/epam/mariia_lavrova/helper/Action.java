package com.epam.mariia_lavrova.helper;

import com.epam.mariia_lavrova.driver.ChromeDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.mariia_lavrova.constant.Message.PAGE_WAS_NOT_REFRESHED;
import static com.epam.mariia_lavrova.constant.Message.PAGE_WAS_REFRESHED;

/**
 * Class for operations with web elements
 * Provides singleton mode
 *
 * @author Mariia_Lavrova
 * @since 02/02/2017
 */

public class Action {

    private static Logger logger = LogManager.getLogger(Action.class);

    /**
     *
     * @param webElement
     * @param expectedText
     * @param webElementName
     * @param pageName
     */
    public static void assertText(WebElement webElement, String expectedText, String webElementName, String pageName) {
        ActionAssert.assertIsVisible(webElement, webElementName, pageName);
        ActionAssert.assertContains(webElement, webElementName, expectedText);
    }

    /**
     *
     * @param webElement
     * @param webElementName
     * @param pageName
     */
    public static void click(WebElement webElement, String webElementName, String pageName) {
        ActionAssert.assertIsVisible(webElement, webElementName, pageName);
        ActionAssert.assertIsClickable(webElement, webElementName, pageName);
        webElement.click();
    }

    /**
     *
     * @param webElement
     * @param inputValue
     * @param webElementName
     * @param pageName
     */
    public static void fillInput(WebElement webElement, String inputValue, String webElementName, String pageName) {
        ActionAssert.assertIsVisible(webElement, webElementName, pageName);
        webElement.clear();
        webElement.sendKeys(inputValue);
    }

    /**
     *
     * @param pageName
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
