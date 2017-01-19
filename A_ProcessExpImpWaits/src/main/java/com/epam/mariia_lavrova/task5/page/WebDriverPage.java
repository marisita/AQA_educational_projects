package com.epam.mariia_lavrova.task5.page;


import com.epam.mariia_lavrova.task5.driver.ChromeDriverManager;
import com.epam.mariia_lavrova.task5.waiter.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebDriverPage extends BasePage {

    private WebElement titleText = ChromeDriverManager.getDriver()
            .findElement(By.xpath(".//*[@id='selenium-webdriver']/h1"));

    public String getTitleText() {
        Condition.getInstance().waitForElementHasText(titleText, "Browser Automation");
        return titleText.getText();
    }
}
