package com.epam.mariia_lavrova.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.epam.mariia_lavrova.constant.DriverName.CHROME;
import static com.epam.mariia_lavrova.constant.Waiter.*;

/**
 * Class for Chrome Driver management (getting and close a driver, configure a driver)
 * Provides singleton mode
 *
 * @author Mariia_Lavrova
 * @since 02/02/2017
 */

public class ChromeDriverManager {

    private static WebDriver webDriver;

    private ChromeDriverManager() {
    }

    /**
     * Creates the Chrome Driver instance if it is not exist yet and returns it or just return existing instance
     * @return Chrome Driver instance
     */
    public synchronized static WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = DriverFactory.createDriver(CHROME);
            webDriver.manage().window().maximize();
            setTimeouts();
            return webDriver;
        } else {
            return webDriver;
        }
    }

    /**
     * Closes, delete cookies and set to null existing Driver instance
     */
    public static void closeDriver() {
        if (webDriver != null) {
            webDriver.manage().deleteAllCookies();
            webDriver.quit();
            webDriver = null;
        }
    }

    private static void setTimeouts() {
        WebDriver.Timeouts timeouts = webDriver.manage().timeouts();
        timeouts.pageLoadTimeout(PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
        timeouts.setScriptTimeout(SET_SCRIPT_TIME_OUT, TimeUnit.SECONDS);
        timeouts.implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
    }
}
