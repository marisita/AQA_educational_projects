package part3.positive;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import utils.RegexMatcher;
import utils.XMLParser;

import static data.TestData.HttpClient.APACHE_HTTP_CLIENT;
import static data.TestData.ProductAttributes.*;
import static data.TestData.Url.HOME_URL;
import static data.TestData.Url.PRODUCT_URL;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenGetExistingProductThenReturnsNotEmptyFields {

    private int productID;
    private String productURL;
    private Document xmlResponse;

    @Before
    public void setUp() throws Exception {

        productID = 10;
        productURL = HOME_URL + PRODUCT_URL;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(productURL + productID);
        request.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        HttpResponse response = client.execute(request);
        xmlResponse = XMLParser.parse(response);
    }

    @Test
    public void whenGetExistingProductThenReturnsValidId() throws Exception {
        String actualID = xmlResponse.getElementsByTagName(ID_NODE_NAME).item(0).getTextContent();
        assertThat(actualID, RegexMatcher.matches(ID_PATTERN));
    }

    @Test
    public void whenGetExistingProductThenReturnsValidName() throws Exception {
        String actualName = xmlResponse.getElementsByTagName(NAME_NODE_NAME).item(0).getTextContent();
        assertThat(actualName, RegexMatcher.matches(NAME_PATTERN));
    }

    @Test
    public void whenGetExistingProductThenReturnsValidPrice() throws Exception {
        String actualPrice = xmlResponse.getElementsByTagName(PRICE_NODE_NAME).item(0).getTextContent();
        assertThat(actualPrice, RegexMatcher.matches(PRICE_PATTERN));
    }
}
