package part3.positive;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import static data.TestData.HttpClient.APACHE_HTTP_CLIENT;
import static data.TestData.StatusCode.STATUS_CODE_200;
import static data.TestData.Url.*;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import static org.junit.Assert.assertEquals;

public class WhenGetExistingCustomerThenReturnsStatusCode200 {

    private int customerID;
    private String customerURL;

    @Before
    public void setUp() throws Exception {

        customerID = 10;
        customerURL = HOME_URL + CUSTOMER_URL;
    }

    @Test
    public void whenGetExistingCustomerThenReturnsStatusCode200() throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(customerURL + customerID);
        request.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        HttpResponse response = client.execute(request);
        assertEquals(STATUS_CODE_200, response.getStatusLine().getStatusCode());
    }
}
