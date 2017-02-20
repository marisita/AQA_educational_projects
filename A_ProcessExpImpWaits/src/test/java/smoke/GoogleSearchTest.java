package smoke;

import base.BaseTest;
import com.epam.mariia_lavrova.task5.helper.TestAction;
import com.epam.mariia_lavrova.task5.page.SearchPage;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private static final String searchText = "Web driver";

    @Test
    public void testSearch() throws Exception {
        String titleText = new SearchPage().search(searchText).searchedLinkClick().getTitleText();
        TestAction.assertContains(titleText, searchText);
    }
}