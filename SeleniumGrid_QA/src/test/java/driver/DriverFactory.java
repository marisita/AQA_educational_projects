package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static data.TestData.BrowserName.*;

public class DriverFactory {

    public static RemoteWebDriver createDriver(String browserType, URL hubUrl) {
        if (FF.toString().equals(browserType)) {
            return new RemoteWebDriver(hubUrl, DesiredCapabilities.firefox());
        } else if (CHROME.toString().equalsIgnoreCase(browserType)) {
            return new RemoteWebDriver(hubUrl, DesiredCapabilities.chrome());
        } else if (IE.toString().equalsIgnoreCase(browserType)) {
            return new RemoteWebDriver(hubUrl, DesiredCapabilities.internetExplorer());
        } else {
            throw new RuntimeException();
        }
    }
}
