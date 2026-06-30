package com.developer.repository;

import com.developer.entity.Course;
import com.developer.entity.User;

import java.util.List;

public interface InMemoryRepository {

    void adduser(String name, String password, String role, String personalMailId, String phoneNumber);

    void addCourse(String name);

    void editUser(String id, String name, String personalMailId, String phoneNumber);

    void deleteUser(String id);

    List<User> getAllUsers();

    List<User> getAllStudents();

    User getUserById();

    List<Course> getAllCourses();

    Course getCourseById();

    void addStudentToCourse(String CourseId, String UserId);

}
