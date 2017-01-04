package part2.negative;

import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.StatusCode.STATUS_CODE_404;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;

public class WhenGetNotExistingCustomerThenReturnsStatusCode404 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {
        customerID = 2020;
        customerURL = HOME_URL + CUSTOMER_URL;
    }

    @Test
    public void whenGetNotExistingCustomerThenReturnsStatusCode404() {
        given().when().get(customerURL + customerID).then().statusCode(STATUS_CODE_404);
    }
}
