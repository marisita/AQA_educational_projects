package part2.positive;

import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.StatusCode.STATUS_CODE_200;
import static data.TestData.Url.*;

public class WhenGetExistingCustomerThenReturnsStatusCode200 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {
        customerID = 10;
        customerURL = HOME_URL + CUSTOMER_URL;
    }

    @Test
    public void whenGetExistingCustomerThenReturnsStatusCode200() {
        given().when().get(customerURL + customerID).then().statusCode(STATUS_CODE_200);
    }
}
