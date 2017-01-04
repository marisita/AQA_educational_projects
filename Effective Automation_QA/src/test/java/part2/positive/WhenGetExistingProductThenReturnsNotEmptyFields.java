package part2.positive;

import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import utils.RegexMatcher;

import static com.jayway.restassured.RestAssured.given;
import static data.TestData.ProductAttributes.*;
import static data.TestData.Url.*;

public class WhenGetExistingProductThenReturnsNotEmptyFields {

    private int productID;
    private String productURL;

    @Before
    public void setUp() throws Exception {
        productID = 10;
        productURL = HOME_URL + PRODUCT_URL;
    }

    @Test
    public void whenGetExistingProductThenReturnsValidId() throws Exception {
        String actualId = PRODUCT_NODE_NAME + "." + ID_NODE_NAME;
        given().when().get(productURL + productID).then().contentType(ContentType.XML).body(actualId, RegexMatcher.matches(ID_PATTERN));
    }

    @Test
    public void whenGetExistingProductThenReturnsValidName() throws Exception {
        String actualName = PRODUCT_NODE_NAME + "." + NAME_NODE_NAME;
        given().when().get(productURL + productID).then().contentType(ContentType.XML).body(actualName, RegexMatcher.matches(NAME_PATTERN));
    }

    @Test
    public void whenGetExistingProductThenReturnsValidPrice() throws Exception {
        String actualPrice = PRODUCT_NODE_NAME + "." + PRICE_NODE_NAME;
        given().when().get(productURL + productID).then().contentType(ContentType.XML).body(actualPrice, RegexMatcher.matches(PRICE_PATTERN));
    }
}
