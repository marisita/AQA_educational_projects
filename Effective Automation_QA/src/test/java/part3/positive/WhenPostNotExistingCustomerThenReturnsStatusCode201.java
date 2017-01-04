package part3.positive;

import domain.Customer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static data.TestData.HttpClient.APACHE_HTTP_CLIENT;
import static data.TestData.StatusCode.STATUS_CODE_201;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import static org.junit.Assert.assertEquals;

public class WhenPostNotExistingCustomerThenReturnsStatusCode201 {

    private int customerID;
    private String customerURL;
    private String customerXML;
    private HttpClient httpClient;

    @Before
    public void setUp() throws Exception {

        customerID = 2020;
        customerURL = HOME_URL + CUSTOMER_URL;

        Customer customer = new Customer(customerID);
        customerXML = customer.convertToXMLValid();

        httpClient = HttpClientBuilder.create().build();
    }

    @Test
    public void whenPostNotExistingCustomerThenReturnsStatusCode201() throws Exception {

        HttpPost postRequest = new HttpPost(customerURL);
        postRequest.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        postRequest.setEntity(new StringEntity(customerXML));
        HttpResponse httpResponse = httpClient.execute(postRequest);
        assertEquals(STATUS_CODE_201, httpResponse.getStatusLine().getStatusCode());
    }

    @After
    public void tearDown() throws Exception {

        HttpDelete deleteRequest = new HttpDelete(customerURL + customerID);
        deleteRequest.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        HttpResponse httpResponse = httpClient.execute(deleteRequest);
    }
}
