package part3.positive;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import static data.TestData.HttpClient.APACHE_HTTP_CLIENT;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import static org.junit.Assert.assertEquals;

public class WhenGetExistingCustomerThenReturnsStatusCode200 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {

        customerID = 10;
        customerURL = HOME_URL.concat(CUSTOMER_URL);
    }

    @Test
    public void whenGetExistingCustomerThenReturnsStatusCode200() throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(customerURL.concat(String.valueOf(customerID)));
        request.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        HttpResponse response = client.execute(request);
        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }
}
