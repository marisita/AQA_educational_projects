package page;

import driver.ChromeDriverManager;
import element.Label;
import org.openqa.selenium.By;

import static data.TestData.Selector.SEARCH_RESULT_NOTHING_TEXT_SELECTOR;
import static data.TestData.Selector.SEARCH_RESULT_TITLE_SELECTOR;

public class SearchResultNothingPage extends BasePage {

    private Label labelTitle;
    private Label labelNothingText;

    private void findSearchResultTitle() {
        By bySearchResultTitle = By.cssSelector(SEARCH_RESULT_TITLE_SELECTOR.toString());
        labelTitle = new Label(ChromeDriverManager.getDriver().findElement(bySearchResultTitle));
    }

    private void findSearchResultNothingText() {
        By bySearchResultNothingText = By.cssSelector(SEARCH_RESULT_NOTHING_TEXT_SELECTOR.toString());
        labelNothingText = new Label(ChromeDriverManager.getDriver().findElements(bySearchResultNothingText).get(1));
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
