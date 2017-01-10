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

import static data.TestData.CustomerAttributes.*;
import static data.TestData.HttpClient.APACHE_HTTP_CLIENT;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenGetExistingCustomerThenReturnsNotEmptyFields {

    private int customerID;
    private String customerURL;
    private Document xmlResponse;

    @Before
    public void setUp() throws Exception {

        customerID = 10;
        customerURL = HOME_URL.concat(CUSTOMER_URL);

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(customerURL.concat(String.valueOf(customerID)));
        request.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        HttpResponse response = client.execute(request);
        xmlResponse = XMLParser.parse(response);
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidId() throws Exception {
        String actualID = xmlResponse.getElementsByTagName(ID_NODE_NAME).item(0).getTextContent();
        assertThat(actualID, RegexMatcher.matches(ID_PATTERN));
    }


    @Test
    public void whenGetExistingCustomerThenReturnsValidFirstName() throws Exception {
        String actualFirstName = xmlResponse.getElementsByTagName(FIRSTNAME_NODE_NAME).item(0).getTextContent();
        assertThat(actualFirstName, RegexMatcher.matches(FIRSTNAME_PATTERN));
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidLastName() throws Exception {
        String actualLastName = xmlResponse.getElementsByTagName(LASTNAME_NODE_NAME).item(0).getTextContent();
        assertThat(actualLastName, RegexMatcher.matches(LASTNAME_PATTERN));
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidStreet() throws Exception {
        String actualStreet = xmlResponse.getElementsByTagName(STREET_NODE_NAME).item(0).getTextContent();
        assertThat(actualStreet, RegexMatcher.matches(STREET_PATTERN));
    }

    @Test
    public void whenGetExistingCustomerThenReturnsValidCity() throws Exception {
        String actualCity = xmlResponse.getElementsByTagName(CITY_NODE_NAME).item(0).getTextContent();
        assertThat(actualCity, RegexMatcher.matches(CITY_PATTERN));
    }

}
