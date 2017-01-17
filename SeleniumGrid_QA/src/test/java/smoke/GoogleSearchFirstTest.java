package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static data.TestData.TestAttribute.*;
import static data.TestData.TestSelector.*;

public class GoogleSearchFirstTest extends BaseTest {

    @Test
    public void searchingTest() {
        getDriver().findElement(By.cssSelector(SEARCH_INPUT_SELECTOR.toString())).sendKeys(SEARCH_TEXT.toString(), Keys.ENTER);
        getDriver().findElement(By.cssSelector(SEARCH_RESULT_LINK.toString())).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(URL_YOUTUBE.toString()));
    }
}
