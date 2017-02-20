package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static constant.Waiter.*;

public class ChromeDriverManager {

    private static WebDriver webDriver;

    private ChromeDriverManager() {
    }

    public synchronized static WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            setTimeouts();
            return webDriver;
        } else {
            return webDriver;
        }
    }

    private static void setTimeouts() {
        WebDriver.Timeouts timeouts = webDriver.manage().timeouts();
        timeouts.pageLoadTimeout(PAGE_LOAD_TIME_OUT.getWaitMillis(), TimeUnit.SECONDS);
        timeouts.setScriptTimeout(SET_SCRIPT_TIME_OUT.getWaitMillis(), TimeUnit.SECONDS);
        timeouts.implicitlyWait(IMPLICITLY_WAIT.getWaitMillis(), TimeUnit.SECONDS);
    }

    public static void close() {
        if (webDriver != null) {
            webDriver.manage().deleteAllCookies();
            webDriver.quit();
            webDriver = null;
        }
    }
}
