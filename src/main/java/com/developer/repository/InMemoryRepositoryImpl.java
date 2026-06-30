package com.developer.repository;

import com.developer.entity.Course;
import com.developer.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryRepositoryImpl implements InMemoryRepository {

    private final static Logger logger = LoggerFactory.getLogger(InMemoryRepositoryImpl.class);

    private final Map<String, User> Users = new HashMap<>();

    private final Map<String, Course> Courses = new HashMap<>();

    private final Map<String, List<String>> coursesEnrolled = new HashMap<>();

    int studentIdNumber = 1;

    int adminIdNumber = 1;

    int courseIdNumber = 1;


    @Override
    public boolean adduser(String name, String password, String role, String personalMailId, String phoneNumber) {

        String idNumber;
        String roleStr;

        if(role.equals("Student")) {
            idNumber = String.format("%5s", studentIdNumber).replace(' ', '0');
            roleStr = "STU";
            studentIdNumber++;
        }
        else if(role.equals("Admin")){
            idNumber = String.format("%5s", adminIdNumber).replace(' ', '0');
            roleStr = "ADMIN";
            adminIdNumber++;
        }
        else{
            logger.error("Role is invalid");
            return false;
        }

        String id = roleStr+idNumber;

        String email = id + "@devschool.in";

        User user = new User(id, role, email, name, password, personalMailId, phoneNumber);

        logger.info("User created :{}",user);
        Users.put(id,user);
        return true;

    }

    @Override
    public boolean addCourse(String name) {
        return false;
    }

    @Override
    public boolean editUser(String id, String name, String personalMailId, String phoneNumber) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
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
    public boolean addStudentToCourse(String CourseId, String UserId) {
        return false;
    }
}
