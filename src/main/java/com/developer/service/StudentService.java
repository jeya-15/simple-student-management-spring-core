package com.developer.service;

import java.util.List;

public interface StudentService {
    String adduser(String name, String password, String role, String personalMailId, String phoneNumber);

    String addCourse(String name);

    String editUser(String id, String name, String personalMailId, String phoneNumber);

    String deleteUser(String id);

    List<String> fetchAllUsers();

    List<String> fetchStudents();

    String fetchUserById(String id);

    List<String> fetchAllCourses();

    String fetchCourseById();

    String mapStudentToCourse();
}
