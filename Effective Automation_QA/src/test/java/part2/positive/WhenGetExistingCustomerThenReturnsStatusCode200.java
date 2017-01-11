package part2.positive;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;

public class WhenGetExistingCustomerThenReturnsStatusCode200 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {
        customerID = 10;
        customerURL = HOME_URL.concat(CUSTOMER_URL);
    }

    @Test
    public void whenGetExistingCustomerThenReturnsStatusCode200() {
        given().when().get(customerURL + customerID).then().statusCode(HttpStatus.SC_OK);
    }
}
