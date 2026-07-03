package com.developer.service;

import com.developer.entity.User;

import java.util.List;

public interface StudentService {

    User login(String id, String password);

    String adduser(String name, String password, String role, String personalMailId, String phoneNumber) throws InterruptedException;

    String addCourse(String name);

    String editUser(String id, String name, String personalMailId, String phoneNumber);

    String deleteUser(String id);

    List<String> fetchAllUsers();

    List<String> fetchStudents();

    String fetchUserById(String id);

    List<String> fetchAllCourses();

    String fetchCourseById(String id);

    String mapStudentToCourse(String userId, String courseId) throws InterruptedException;
}
