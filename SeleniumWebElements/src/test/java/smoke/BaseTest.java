package smoke;

import driver.ChromeDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    @BeforeTest
    public void setUp() throws Exception {
        ChromeDriverManager.getDriver();
    }

    @AfterTest
    public void tearDown() throws Exception {
        ChromeDriverManager.close();
    }
}
