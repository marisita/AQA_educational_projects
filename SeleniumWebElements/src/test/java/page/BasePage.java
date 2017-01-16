package page;

import driver.ChromeDriverManager;

public abstract class BasePage {

    public void open(String url) {
        ChromeDriverManager.getDriver().get(url);
    }
}
