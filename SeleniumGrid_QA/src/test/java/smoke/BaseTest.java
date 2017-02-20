package smoke;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static data.Url.GOOGLE;
import static data.Url.LOCALHOST;
import static data.BrowserName.CHROME;

public abstract class BaseTest {

    private ThreadLocal<RemoteWebDriver> threadLocal = null;

    @BeforeMethod
    public void setUp() throws Exception {

        threadLocal = new ThreadLocal<RemoteWebDriver>();
        threadLocal.set(DriverFactory.createDriver(CHROME.toString(), new URL(LOCALHOST.toString())));
        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        getDriver().get(GOOGLE.toString());
    }

    public WebDriver getDriver() {
        return threadLocal.get();
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
    }
}
