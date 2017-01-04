package part3.negative;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import static data.TestData.HttpClient.APACHE_HTTP_CLIENT;
import static data.TestData.StatusCode.STATUS_CODE_404;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import static org.junit.Assert.assertEquals;

public class WhenDeleteNotExistingCustomerThenReturnsStatusCode404 {

    private int customerID;
    private String customerURL;
    private HttpClient httpClient;

    @Before
    public void setUp() throws Exception {

        customerID = 2020;
        customerURL = HOME_URL + CUSTOMER_URL;

        httpClient = HttpClientBuilder.create().build();
    }

    @Test
    public void whenDeleteNotExistingCustomerThenReturnsStatusCode404() throws Exception {

        HttpDelete deleteRequest = new HttpDelete(customerURL + customerID);
        deleteRequest.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        HttpResponse httpResponse = httpClient.execute(deleteRequest);
        assertEquals(STATUS_CODE_404, httpResponse.getStatusLine().getStatusCode());
    }
}
