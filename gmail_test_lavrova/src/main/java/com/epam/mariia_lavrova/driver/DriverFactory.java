package com.epam.mariia_lavrova.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.epam.mariia_lavrova.constant.DriverName.*;
import static com.epam.mariia_lavrova.constant.Message.INVALID_DRIVER_NAME;

public class DriverFactory {

    /**
     * Create an instance of webDriver according to driverName
     * @param driverName the name of driver to be created
     * @return the instance of driver
     */

    public static WebDriver createDriver(String driverName) {
        switch (driverName.toLowerCase()) {
            case CHROME: return new ChromeDriver();
            case FF: return new FirefoxDriver();
            case IE: return new InternetExplorerDriver();
            default: throw new IllegalArgumentException(INVALID_DRIVER_NAME);
        }
    }
}
