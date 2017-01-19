package com.epam.mariia_lavrova.task5.page;


import com.epam.mariia_lavrova.task5.driver.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultPage extends BasePage {

    private static WebElement searchedLink = ChromeDriverManager.getDriver()
            .findElement(By.linkText("Selenium WebDriver — Selenium Documentation"));

    private void explicitWait(WebDriver driver) {
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.elementToBeClickable(searchedLink));
    }

    public WebDriverPage searchedLinkClick() {
        explicitWait(ChromeDriverManager.getDriver());
        searchedLink.click();
        return new WebDriverPage();
    }
}
