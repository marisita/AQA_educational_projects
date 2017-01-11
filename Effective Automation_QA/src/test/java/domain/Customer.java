package domain;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;

    public Customer(int id) {
        this.id = id;
        this.firstName = "Maria";
        this.lastName = "Kvitka";
        this.street = "10, Nauki av.";
        this.city = "Kharkiv";
    }

    public Customer(int id, String firstName, String lastName, String street, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
    }

    public String convertToXMLValid(){
        return "<?xml version=\"1.0\"?>\n" +
                "<CUSTOMER xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
                "    <ID>" + id + "</ID>\n" +
                "    <FIRSTNAME>" + firstName + "</FIRSTNAME>\n" +
                "    <LASTNAME>" + lastName + "</LASTNAME>\n" +
                "    <STREET>" + street + "</STREET>\n" +
                "    <CITY>" + city + "</CITY>\n" +
                "</CUSTOMER>";
    }

    public String convertToXMLInvalid(){
        return "<?xml version=\"1.0\"?>\n" +
                "<CUSTOMER xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
                "    <id>" + id + "</ID>\n" +
                "    <FIRSTNAME>" + firstName + "</FIRSTNAME>\n" +
                "    <LASTNAME>" + lastName + "</LASTNAME>\n" +
                "    <STREET>" + street + "</STREET>\n" +
                "    <CITY>" + city + "</CITY>\n" +
                "</CUSTOMER>";
    }
}
