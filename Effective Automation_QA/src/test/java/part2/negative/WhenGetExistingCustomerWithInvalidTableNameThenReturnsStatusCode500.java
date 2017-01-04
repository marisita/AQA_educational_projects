package part2.negative;

import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.StatusCode.STATUS_CODE_500;
import static data.TestData.Url.*;

public class WhenGetExistingCustomerWithInvalidTableNameThenReturnsStatusCode500 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {
        customerID = 10;
        customerURL = HOME_URL + CUSTOMER_URL_INVALID;
    }

    @Test
    public void whenGetExistingCustomerWithInvalidTableNameThenReturnsStatusCode500() {
        given().when().get(customerURL + customerID).then().statusCode(STATUS_CODE_500);
    }
}
