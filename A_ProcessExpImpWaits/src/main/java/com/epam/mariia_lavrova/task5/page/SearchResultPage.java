package com.epam.mariia_lavrova.task5.page;


import com.epam.mariia_lavrova.task5.driver.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultPage extends BasePage {

    @FindBy(linkText = "Selenium WebDriver — Selenium Documentation")
    private static WebElement searchedLink;

    private void explicitWait(WebDriver driver) {
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.elementToBeClickable(searchedLink));
    }

    public WebDriverPage searchedLinkClick() {
        explicitWait(ChromeDriverManager.getDriver());
        searchedLink.click();
        return new WebDriverPage();
    }
}
