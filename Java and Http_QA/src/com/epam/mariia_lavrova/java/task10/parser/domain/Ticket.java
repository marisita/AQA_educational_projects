package com.epam.mariia_lavrova.java.task10.parser.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ticket")
public class Ticket {

    private String category;
    private String date;
    private int id;
    private int place;
    private String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", id=" + id +
                ", place=" + place +
                ", title='" + title + '\'' +
                '}';
    }
}
