package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.util.concurrent.TimeUnit;

import static data.TestData.Waiter.*;

public class ChromeDriverManager {

    private static WebDriver webDriver;

    private ChromeDriverManager() {
    }

    public static void init() {
        webDriver = ThreadGuard.protect(new ChromeDriver());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME_OUT.getWaitMillis(), TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(SET_SCRIPT_TIME_OUT.getWaitMillis(), TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT.getWaitMillis(), TimeUnit.SECONDS);
    }

    public static void close() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    public static WebDriver getDriver() {
        return webDriver;
    }
}
