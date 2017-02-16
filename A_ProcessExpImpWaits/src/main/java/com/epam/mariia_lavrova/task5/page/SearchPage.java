package com.epam.mariia_lavrova.task5.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(css = ".sbico-c")
    private WebElement searchButton;

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
