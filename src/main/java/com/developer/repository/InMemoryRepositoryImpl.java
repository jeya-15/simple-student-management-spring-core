package com.developer.repository;

import com.developer.entity.Course;
import com.developer.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryRepositoryImpl implements InMemoryRepository{

    private final Map<String, User> Users = new HashMap<>();

    private final Map<String,Course> Courses = new HashMap<>();

    private final Map<String,List<String> > coursesEnrolled = new HashMap<>();


    @Override
    public void adduser(String name, String password, String role, String personalMailId, String phoneNumber) {

    }

    @Override
    public void addCourse(String name) {

    }

    @Override
    public void editUser(String id, String name, String personalMailId, String phoneNumber) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public List<User> getAllStudents() {
        return List.of();
    }

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }

    @Override
    public Course getCourseById() {
        return null;
    }

    @Override
    public void addStudentToCourse(String CourseId, String UserId) {

    }
}
