package page;

import element.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.Selector.SEARCH_RESULT_NOTHING_TEXT_SELECTOR;
import static data.Selector.SEARCH_RESULT_TITLE_SELECTOR;

public class SearchResultNothingPage extends BasePage {

    @FindBy(css = SEARCH_RESULT_TITLE_SELECTOR)
    private WebElement labelTitleWebElement;

    @FindBy(xpath = SEARCH_RESULT_NOTHING_TEXT_SELECTOR)
    private WebElement labelNothingTextWebElement;

    private Label labelTitle;
    private Label labelNothingText;

    private void findSearchResultTitle() {
        labelTitle = new Label(labelTitleWebElement);
    }

    private void findSearchResultNothingText() {
        labelNothingText = new Label(labelNothingTextWebElement);
    }

    public String getSearchResultTitle() {
        findSearchResultTitle();
        return labelTitle.getText();
    }

    public String getSearchResultNothingText() {
        findSearchResultNothingText();
        return labelNothingText.getText();
    }
}
