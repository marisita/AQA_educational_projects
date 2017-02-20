package com.epam.mariia_lavrova.task5.page;


import com.epam.mariia_lavrova.task5.waiter.Condition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDriverPage extends BasePage {

    @FindBy(xpath = ".//*[@id='selenium-webdriver']/h1")
    private WebElement titleText;

    public String getTitleText() {
        Condition.getInstance().waitForElementHasText(titleText, "Browser Automation");
        return titleText.getText();
    }
}
