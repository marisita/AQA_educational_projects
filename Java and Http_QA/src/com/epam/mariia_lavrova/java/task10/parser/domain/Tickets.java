package com.epam.mariia_lavrova.java.task10.parser.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tickets")
public class Tickets {

    @XmlElement(name = "ticket")
    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "tickets=" + tickets +
                '}';
    }
}
