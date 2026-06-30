package com.developer.entity;

public class User {

    private final String id;
    private final String role;
    private final String officialMailId;
    private String name;
    private String password;
    private String personalMailId;
    private String phoneNumber;


    public User(String id, String role, String officialMailId, String name, String password, String personalMailId, String phoneNumber) {
        this.id = id;
        this.role = role;
        this.officialMailId = officialMailId;
        this.name = name;
        this.password = password;
        this.personalMailId = personalMailId;
        this.phoneNumber = phoneNumber;
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

    public String getRole() {
        return role;
    }

    public String getOfficialMailId() {
        return officialMailId;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", role='" + role + '\'' +
                        ", personalMailId='" + personalMailId + '\'' +
                        ", officialMailId='" + officialMailId + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'';
    }
}
