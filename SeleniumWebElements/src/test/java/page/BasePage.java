package page;

import driver.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage() {
        driver = ChromeDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        ChromeDriverManager.getDriver().get(url);
    }
}
