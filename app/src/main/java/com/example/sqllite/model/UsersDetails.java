package com.example.sqllite.model;

public class UsersDetails {
    private int id;
    private String name;
    private String course;
    private String contact;
    private String fee;

    public UsersDetails() {
        this.id = id;
        this.name = name;
        this.course = course;
        this.contact = contact;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
