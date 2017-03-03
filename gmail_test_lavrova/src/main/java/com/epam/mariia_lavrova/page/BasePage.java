package com.epam.mariia_lavrova.page;

import com.epam.mariia_lavrova.driver.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected String pageName;
    private WebDriver driver;

    public BasePage() {
        driver = ChromeDriverManager.getDriver();
        pageName = this.getClass().getSimpleName();
        PageFactory.initElements(driver, this);
    }
}
