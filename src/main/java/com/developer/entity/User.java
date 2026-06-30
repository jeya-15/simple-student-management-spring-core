package com.developer.entity;

public class User {

    private final String id;

    private String name;

    private String password;

    private String personalMailId;

    private final String officialMailId;

    private String phoneNumber;


    public User(String id, String personalMailId, String officialMailId, String phoneNumber, String name, String password) {
        this.id = id;
        this.personalMailId = personalMailId;
        this.officialMailId = officialMailId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalMailId() {
        return personalMailId;
    }

    public void setPersonalMailId(String personalMailId) {
        this.personalMailId = personalMailId;
    }

    public String getId() {
        return id;
    }

    public String getStudentMailId() {
        return officialMailId;
    }
}
