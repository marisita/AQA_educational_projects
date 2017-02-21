package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static data.BrowserName.*;

public class DriverFactory {

    public static RemoteWebDriver createDriver(String browserType, URL hubUrl) {

        switch (browserType.toLowerCase()) {
            case FF:
                return new RemoteWebDriver(hubUrl, DesiredCapabilities.firefox());
            case CHROME:
                return new RemoteWebDriver(hubUrl, DesiredCapabilities.chrome());
            case IE:
                return new RemoteWebDriver(hubUrl, DesiredCapabilities.internetExplorer());
            default:
                throw new IllegalArgumentException("Invalid browser type");
        }
    }
}
