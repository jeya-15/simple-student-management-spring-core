package com.developer.entity;

public class Course {

    private final String id;

    private final String courseName;

    public Course(String id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", courseName='" + courseName + '\'';
    }
}
