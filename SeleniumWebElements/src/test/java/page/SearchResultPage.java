package page;

import driver.ChromeDriverManager;
import element.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static data.Selector.SEARCH_RESULTS_TITLE_SELECTOR;

public class SearchResultPage extends BasePage{

    private List<Label> labels;

    public SearchResultPage() {
        By bySearchResultLabel = By.cssSelector(SEARCH_RESULTS_TITLE_SELECTOR);
        List<WebElement> webElements = ChromeDriverManager.getDriver().findElements(bySearchResultLabel);
        labels = Label.getLabels(webElements);
    }

    public List<Label> getSearchResultsLabels() {
        return labels;
    }
}
