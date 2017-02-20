package base;

import com.epam.mariia_lavrova.task5.driver.ChromeDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    @BeforeTest
    public void setUp() throws Exception {
        ChromeDriverManager.getDriver().get("http://google.com");
    }

    @AfterTest
    public void tearDown() throws Exception {
        ChromeDriverManager.getDriver().close();
    }
}
