package smoke;

import base.BaseTest;
import com.epam.mariia_lavrova.task5.page.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testSearch() throws Exception {
        String titleText = new SearchPage().search("Web driver").searchedLinkClick().getTitleText();
        Assert.assertTrue(titleText.contains("WebDriver"));
    }
}