package part2.negative;

import com.jayway.restassured.http.ContentType;
import domain.Customer;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.StatusCode.STATUS_CODE_500;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;

public class WhenPostCustomerWithExistingIDThenReturnsStatusCode500 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {
        customerID = 10;
        customerURL = HOME_URL + CUSTOMER_URL;
    }

    @Test
    public void whenPostCustomerWithExistingIDThenReturnsStatusCode500() throws Exception {
        Customer customer = new Customer(customerID);
        String customerXML = customer.convertToXMLValid();
        given().contentType(ContentType.XML).body(customerXML).when().post(customerURL).then().statusCode(STATUS_CODE_500);
    }
}
