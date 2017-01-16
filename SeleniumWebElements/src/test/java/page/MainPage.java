package page;

import driver.ChromeDriverManager;
import element.Button;
import element.Input;
import element.Link;
import org.openqa.selenium.By;

import static data.TestData.Selector.*;

public class MainPage extends BasePage{

    private Input searchInput;
    private Button searchButton;
    private Link categoryLink;

    private void findSearchElements() {
        By bySearchInput = By.cssSelector(SEARCH_INPUT_SELECTOR.toString());
        searchInput = new Input(ChromeDriverManager.getDriver().findElement(bySearchInput));
        By bySearchButton = By.cssSelector(SEARCH_BUTTON_SELECTOR.toString());
        searchButton = new Button(ChromeDriverManager.getDriver().findElement(bySearchButton));
    }

    private void findCategoryElements() {
        By byCategoryLink = By.cssSelector(CATEGORY_LINK_SELECTOR.toString());
        categoryLink = new Link(ChromeDriverManager.getDriver().findElement(byCategoryLink));
    }

    public SearchResultPage searchValidText(String searchText) {
        findSearchElements();
        searchInput.input(searchText);
        searchButton.click();
        return new SearchResultPage();
    }

    public SearchResultNothingPage searchInvalidText(String searchText) {
        findSearchElements();
        searchInput.input(searchText);
        searchButton.click();
        return new SearchResultNothingPage();
    }

    public CategoryPage goToCategory() {
        findCategoryElements();
        categoryLink.click();
        return new CategoryPage();
    }
}
