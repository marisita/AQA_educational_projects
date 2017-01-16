package smoke;

import element.Label;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CategoryPage;
import page.MainPage;
import page.SearchResultNothingPage;
import page.SearchResultPage;

import java.util.List;

import static data.TestData.TestAttributes.*;
import static data.TestData.Url.BASE_URL;

public class SmokeTest extends BaseTest {

    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private SearchResultNothingPage searchResultNothingPage;
    private CategoryPage categoryPage;

    @Test
    public void testSearchWhenInputValidSearchTextThenDisplayProductsWithSearchText() throws Exception {

        mainPage = new MainPage();
        mainPage.open(BASE_URL.toString());
        searchResultPage = mainPage.searchValidText(SEARCH_TEXT_VALID.toString());
        List<Label> labels = searchResultPage.getSearchResultsLabels();
        Assert.assertTrue(Label.containsText(labels, SEARCH_TEXT_VALID.toString()));
    }

    @Test
    public void testSearchWhenInputInvalidSearchTextThenDisplayMessage() throws Exception {

        mainPage = new MainPage();
        mainPage.open(BASE_URL.toString());
        searchResultNothingPage = mainPage.searchInvalidText(SEARCH_TEXT_INVALID.toString());
        String labelTitle = searchResultNothingPage.getSearchResultTitle();
        String labelNothingText = searchResultNothingPage.getSearchResultNothingText();
        Assert.assertEquals(labelTitle, SEARCH_TEXT_INVALID.toString());
        Assert.assertTrue(labelNothingText.contains(SEARCH_TEXT_NOTHING.toString()));
    }

    @Test
    public void testGoToCategoryWhenClickToCategoryNameThenRedirectToSubcategory() throws Exception {

        mainPage = new MainPage();
        mainPage.open(BASE_URL.toString());
        categoryPage = mainPage.goToCategory();
        String labelCategory = categoryPage.getLabelCategory();
        Assert.assertTrue(labelCategory.contains(CATEGORY_TEXT.toString()));
    }
}
