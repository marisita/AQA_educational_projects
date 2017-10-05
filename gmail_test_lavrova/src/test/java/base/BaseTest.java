package base;

import com.epam.mariia_lavrova.driver.ChromeDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.epam.mariia_lavrova.constant.Url.GMAIL_URL;

public abstract class BaseTest {

    @BeforeTest
    public void setUp() throws Exception {
        ChromeDriverManager.getDriver().get(GMAIL_URL);
    }

    @AfterTest
    public void tearDown() throws Exception {
        ChromeDriverManager.closeDriver();
    }
}
