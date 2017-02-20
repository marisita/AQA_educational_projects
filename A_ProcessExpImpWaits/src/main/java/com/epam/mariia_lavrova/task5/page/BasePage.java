package com.epam.mariia_lavrova.task5.page;

import com.epam.mariia_lavrova.task5.driver.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage() {
        driver = ChromeDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}
