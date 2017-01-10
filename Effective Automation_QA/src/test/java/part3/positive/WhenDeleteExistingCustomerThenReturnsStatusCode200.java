package part3.positive;

import domain.Customer;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import static data.TestData.HttpClient.APACHE_HTTP_CLIENT;
import static data.TestData.Url.CUSTOMER_URL;
import static data.TestData.Url.HOME_URL;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import static org.junit.Assert.assertEquals;

public class WhenDeleteExistingCustomerThenReturnsStatusCode200 {

    private int customerID;
    private String customerURL;
    private String customerXML;
    private HttpClient httpClient;

    @Before
    public void setUp() throws Exception {

        customerID = 2020;
        customerURL = HOME_URL.concat(CUSTOMER_URL);

        Customer customer = new Customer(customerID);
        customerXML = customer.convertToXMLValid();

        httpClient = HttpClientBuilder.create().build();

        HttpPost postRequest = new HttpPost(customerURL);
        postRequest.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        postRequest.setEntity(new StringEntity(customerXML));
        HttpResponse httpResponse = httpClient.execute(postRequest);
    }

    @Test
    public void whenDeleteExistingCustomerThenReturnsStatusCode200() throws Exception {

        HttpDelete deleteRequest = new HttpDelete(customerURL.concat(String.valueOf(customerID)));
        deleteRequest.addHeader(APACHE_HTTP_CLIENT, USER_AGENT);
        HttpResponse httpResponse = httpClient.execute(deleteRequest);
        assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
    }
}
