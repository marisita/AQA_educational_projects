package part2.positive;

import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import utils.RegexMatcher;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.CustomerAttributes.*;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;

public class WhenGetExistingCustomerThenReturnsNotEmptyFields {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {
        customerID = 11;
        customerURL = HOME_URL.concat(CUSTOMER_URL);
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidId(){
        String actualId = CUSTOMER_NODE_NAME.concat(".").concat(ID_NODE_NAME);
        given().when().get(customerURL + customerID).then().contentType(ContentType.XML).body(actualId, RegexMatcher.matches(ID_PATTERN));
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidFirstName() throws Exception {
        String actualFirstName = CUSTOMER_NODE_NAME.concat(".").concat(FIRSTNAME_NODE_NAME);
        given().when().get(customerURL + customerID).then().contentType(ContentType.XML).body(actualFirstName, RegexMatcher.matches(FIRSTNAME_PATTERN));
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidLastName(){
        String actualLastName = CUSTOMER_NODE_NAME.concat(".").concat(LASTNAME_NODE_NAME);
        given().when().get(customerURL + customerID).then().contentType(ContentType.XML).body(actualLastName, RegexMatcher.matches(LASTNAME_PATTERN));
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidStreet() throws Exception {
        String actualStreet = CUSTOMER_NODE_NAME.concat(".").concat(STREET_NODE_NAME);
        given().when().get(customerURL + customerID).then().contentType(ContentType.XML).body(actualStreet, RegexMatcher.matches(STREET_PATTERN));
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidCity() throws Exception {
        String actualCity = CUSTOMER_NODE_NAME.concat(".").concat(CITY_NODE_NAME);
        given().when().get(customerURL + customerID).then().contentType(ContentType.XML).body(actualCity, RegexMatcher.matches(CITY_PATTERN));
    }
}
