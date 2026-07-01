package com.developer.service;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    @Override
    public String adduser(String name, String password, String role, String personalMailId, String phoneNumber) {
        return "";
    }

    @Override
    public String addCourse(String name) {
        return "";
    }

    @Override
    public String editUser(String id, String name, String personalMailId, String phoneNumber) {
        return "";
    }

    @Override
    public String deleteUser(String id) {
        return "";
    }

    @Override
    public List<String> fetchAllUsers() {
        return List.of();
    }

    @Override
    public List<String> fetchStudents() {
        return List.of();
    }

    @Override
    public String fetchUserById(String id) {
        return "";
    }

    @Override
    public List<String> fetchAllCourses() {
        return List.of();
    }

    @Override
    public String fetchCourseById() {
        return "";
    }

    @Override
    public String mapStudentToCourse() {
        return "";
    }
}
