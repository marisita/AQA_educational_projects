package part2.negative;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.Url.CUSTOMER_URL_INVALID;
import static data.TestData.Url.HOME_URL;

public class WhenGetExistingCustomerWithInvalidTableNameThenReturnsStatusCode500 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {
        customerID = 10;
        customerURL = HOME_URL.concat(CUSTOMER_URL_INVALID);
    }

    @Test
    public void whenGetExistingCustomerWithInvalidTableNameThenReturnsStatusCode500() {
        given().when().get(customerURL + customerID).then().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
}
