package part2.positive;

import com.jayway.restassured.http.ContentType;
import domain.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.StatusCode.STATUS_CODE_201;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;

public class WhenPostNotExistingCustomerThenReturnsStatusCode201 {

    private int customerID;
    private String customerURL;
    private String customerXML;

    @Before
    public void setUp() throws Exception {

        customerID = 2020;
        customerURL = HOME_URL + CUSTOMER_URL;

        Customer customer = new Customer(customerID);
        customerXML = customer.convertToXMLValid();
    }

    @Test
    public void whenPostNotExistingCustomerThenReturnsStatusCode201() throws Exception {
        given().contentType(ContentType.XML).body(customerXML).when().post(customerURL).then().statusCode(STATUS_CODE_201);
    }

    @After
    public void tearDown() throws Exception {
        given().delete(customerURL + customerID);
    }
}
