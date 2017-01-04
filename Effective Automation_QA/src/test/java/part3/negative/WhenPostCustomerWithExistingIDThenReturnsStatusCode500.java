package part3.negative;

import domain.Customer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import static data.TestData.HttpClient.APACHE_HTTP_CLIENT;
import static data.TestData.StatusCode.STATUS_CODE_500;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import static org.junit.Assert.assertEquals;

public class WhenPostCustomerWithExistingIDThenReturnsStatusCode500 {

    private int customerID;
    private String customerURL;
    private String customerXML;
    private HttpClient httpClient;

    @Before
    public void setUp() throws Exception {

        customerID = 10;
        customerURL = HOME_URL + CUSTOMER_URL;

        Customer customer = new Customer(customerID);
        customerXML = customer.convertToXMLValid();

        httpClient = HttpClientBuilder.create().build();
    }

    @Test
    public void whenPostCustomerWithExistingIDThenReturnsStatusCode500() throws Exception {

        HttpPost postRequest = new HttpPost(customerURL);
        postRequest.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        postRequest.setEntity(new StringEntity(customerXML));
        HttpResponse httpResponse = httpClient.execute(postRequest);
        assertEquals(STATUS_CODE_500, httpResponse.getStatusLine().getStatusCode());
    }
}
