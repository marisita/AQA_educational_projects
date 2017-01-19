package com.epam.mariia_lavrova.task5.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.epam.mariia_lavrova.task5.constant.Attribute.Waiter.*;

public class ChromeDriverManager {

    private static WebDriver webDriver;

    private ChromeDriverManager() {
    }

    public synchronized static WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME_OUT.getWaitMillis(), TimeUnit.SECONDS);
            webDriver.manage().timeouts().setScriptTimeout(SET_SCRIPT_TIME_OUT.getWaitMillis(), TimeUnit.SECONDS);
            webDriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT.getWaitMillis(), TimeUnit.SECONDS);
            return webDriver;
        } else {
            return webDriver;
        }
    }

    public static void close() {
        if (webDriver != null) {
            webDriver.manage().deleteAllCookies();
            webDriver.quit();
            webDriver = null;
        }
    }
}
