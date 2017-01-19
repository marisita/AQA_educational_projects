package com.epam.mariia_lavrova.task5.page;

import com.epam.mariia_lavrova.task5.driver.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    private WebElement searchInput = ChromeDriverManager.getDriver().findElement(By.name("q"));
    private WebElement searchButton = ChromeDriverManager.getDriver()
            .findElement(By.cssSelector(".sbico-c"));

    private SearchPage inputSearchRequest(String request) {
        searchInput.sendKeys(request);
        return this;
    }

    private SearchPage searchButtonClick() {
        searchButton.click();
        return this;
    }

    public SearchResultPage search(String request) {
        inputSearchRequest(request);
        searchButtonClick();
        return new SearchResultPage();
    }
}
