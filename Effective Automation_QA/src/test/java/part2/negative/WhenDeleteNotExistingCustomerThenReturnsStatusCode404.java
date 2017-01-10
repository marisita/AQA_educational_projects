package part2.negative;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;

public class WhenDeleteNotExistingCustomerThenReturnsStatusCode404 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {
        customerID = 2020;
        customerURL = HOME_URL.concat(CUSTOMER_URL);
    }

    @Test
    public void whenDeleteNotExistingCustomerThenReturnsStatusCode404() throws Exception {
        given().when().delete(customerURL + customerID).then().statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
