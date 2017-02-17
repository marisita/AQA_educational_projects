package page;

import element.Button;
import element.Input;
import element.Link;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.Selector.*;

public class MainPage extends BasePage{

    @FindBy (css = SEARCH_INPUT_SELECTOR)
    private WebElement searchInputWebElement;

    @FindBy(css = SEARCH_BUTTON_SELECTOR)
    private WebElement searchButtonWebElement;

    @FindBy(xpath = CATEGORY_LINK_SELECTOR)
    private WebElement categoryLinkWebElement;

    private Input searchInput;
    private Button searchButton;
    private Link categoryLink;

    private void findSearchElements() {
        searchInput = new Input(searchInputWebElement);
        searchButton = new Button(searchButtonWebElement);
    }

    private void findCategoryElements() {
        categoryLink = new Link(categoryLinkWebElement);
    }

    public SearchResultPage searchValidText(String searchText) {
        findSearchElements();
        searchInput.fillInput(searchText);
        searchButton.click();
        return new SearchResultPage();
    }

    public SearchResultNothingPage searchInvalidText(String searchText) {
        findSearchElements();
        searchInput.fillInput(searchText);
        searchButton.click();
        return new SearchResultNothingPage();
    }

    public CategoryPage goToCategory() {
        findCategoryElements();
        categoryLink.click();
        return new CategoryPage();
    }
}
