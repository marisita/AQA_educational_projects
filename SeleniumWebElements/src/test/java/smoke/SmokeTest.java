package smoke;

import element.Label;
import helper.TestAction;
import org.testng.annotations.Test;
import page.CategoryPage;
import page.MainPage;
import page.SearchResultNothingPage;
import page.SearchResultPage;

import java.util.List;

import static data.TestAttributes.*;
import static data.Url.BASE_URL;

public class SmokeTest extends BaseTest {

    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private SearchResultNothingPage searchResultNothingPage;
    private CategoryPage categoryPage;

    @Test
    public void testSearchWhenInputValidSearchTextThenDisplayProductsWithSearchText() throws Exception {

        mainPage = new MainPage();
        mainPage.open(BASE_URL);
        searchResultPage = mainPage.searchValidText(SEARCH_TEXT_VALID);
        List<Label> labels = searchResultPage.getSearchResultsLabels();
        TestAction.assertContains(labels, SEARCH_TEXT_VALID);
    }

    @Test
    public void testSearchWhenInputInvalidSearchTextThenDisplayMessage() throws Exception {

        mainPage = new MainPage();
        mainPage.open(BASE_URL);
        searchResultNothingPage = mainPage.searchInvalidText(SEARCH_TEXT_INVALID);
        String labelTitle = searchResultNothingPage.getSearchResultTitle();
        String labelNothingText = searchResultNothingPage.getSearchResultNothingText();
        TestAction.assertContains(labelTitle, SEARCH_TEXT_INVALID);
        TestAction.assertContains(labelNothingText, SEARCH_TEXT_NOTHING);
    }

    @Test
    public void testGoToCategoryWhenClickToCategoryNameThenRedirectToSubcategory() throws Exception {

        mainPage = new MainPage();
        mainPage.open(BASE_URL);
        categoryPage = mainPage.goToCategory();
        String labelCategory = categoryPage.getLabelCategory();
        TestAction.assertContains(labelCategory, CATEGORY_TEXT);
    }
}
