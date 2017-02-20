package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static data.Selector.SEARCH_INPUT_SELECTOR;
import static data.Selector.SEARCH_RESULT_LINK;
import static data.TestAttribute.SEARCH_TEXT;
import static data.TestAttribute.URL_YOUTUBE;

public class GoogleSearchSecondTest extends BaseTest {

    @Test
    public void searchingTest() {
        getDriver().findElement(By.cssSelector(SEARCH_INPUT_SELECTOR.toString())).sendKeys(SEARCH_TEXT.toString(), Keys.ENTER);
        getDriver().findElement(By.cssSelector(SEARCH_RESULT_LINK.toString())).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(URL_YOUTUBE.toString()));
    }
}
