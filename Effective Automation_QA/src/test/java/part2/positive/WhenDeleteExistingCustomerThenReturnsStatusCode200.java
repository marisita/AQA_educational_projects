package part2.positive;

import com.jayway.restassured.http.ContentType;
import domain.Customer;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;

public class WhenDeleteExistingCustomerThenReturnsStatusCode200 {

    private int customerID;
    private String customerURL;
    private String customerXML;

    @Before
    public void setUp() throws Exception {

        customerID = 2020;
        customerURL = HOME_URL.concat(CUSTOMER_URL);

        Customer customer = new Customer(customerID);
        customerXML = customer.convertToXMLValid();

        given().contentType(ContentType.XML).body(customerXML).post(customerURL);
    }

    @Test
    public void whenDeleteExistingCustomerThenReturnsStatusCode200() throws Exception {
        given().when().delete(customerURL + customerID).then().statusCode(HttpStatus.SC_OK);
    }
}