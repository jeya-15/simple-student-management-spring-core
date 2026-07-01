package com.developer.repository;

import com.developer.entity.Course;
import com.developer.entity.User;

import java.util.List;

public interface InMemoryRepository {

    boolean adduser(String name, String password, String role, String personalMailId, String phoneNumber);

    boolean addCourse(String name);

    boolean editUser(String id, String name, String personalMailId, String phoneNumber);

    boolean deleteUser(String id);

    List<User> getAllUsers();

    List<User> getAllStudents();

    User getUserById(String id);

    List<String> getAllCourses();

    String getCourseById(String id);

    boolean addStudentToCourse(String CourseId, String UserId);

}
