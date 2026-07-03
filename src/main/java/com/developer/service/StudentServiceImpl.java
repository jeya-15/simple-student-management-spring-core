package com.developer.service;

import com.developer.entity.User;
import com.developer.repository.InMemoryRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final InMemoryRepository inMemoryRepository;

    private final NotificationService emailNotificationService;

    private final NotificationService phoneNotificationService;

    public StudentServiceImpl(InMemoryRepository inMemoryRepository, NotificationService emailNotificationService, @Qualifier("phone") NotificationService phoneNotificationService) {
        this.inMemoryRepository = inMemoryRepository;
        this.emailNotificationService = emailNotificationService;
        this.phoneNotificationService = phoneNotificationService;
    }

    @PostConstruct
    public void init() {
        logger.info("Student service is created");
    }

    @PreDestroy
    public void destroy() {
        logger.info("Student service is destroyed");
    }

    @Override
    public User login(String id, String password) {
        User user = inMemoryRepository.getUserById(id);
        if (user == null) {
            logger.error("User not found for id:{{}} while login", id);
            return null;
        }
        if (password.equals(user.getPassword())) {
            logger.info("User {} logged in", id);
            return user;
        }
        logger.info("User {} failed to login", id);
        return null;
    }

    @Override
    public String adduser(String name, String password, String role, String personalMailId, String phoneNumber) throws InterruptedException {
        User user = inMemoryRepository.adduser(name, password, role, personalMailId, phoneNumber);
        if (user != null) {
            emailNotificationService.send(user.getPersonalMailId(), "Hi, " + user.getName() + " you have been successfully registered to the system!\n Your Details :" + user);
            phoneNotificationService.send(user.getPersonalMailId(), "Hi, " + user.getName() + " you have been successfully registered to the system!\n Your Details :" + user);
            logger.info("User created :{{}}", user);
            return "User added Successfully - UserId is " + user.getId();
        }
        logger.error("User is not created:{{},{},{},{}}", name, role, personalMailId, phoneNumber);
        return "User is not created!";
    }

    @Override
    public String addCourse(String name) {

        if (inMemoryRepository.getAllCourses().contains(name)) {
            logger.info("Duplicate Course entry : {}", name);
            return "Course name already exists: " + name;
        }

        String course = inMemoryRepository.addCourse(name);

        if (course != null) {
            logger.info("Created Course :{}", course);
            return "Course successfully created! - " + course;
        }

        logger.error("Failed to create course : {}", name);
        return "Can't create course : " + name;
    }

    @Override
    public String editUser(String id, String name, String personalMailId, String phoneNumber) {
        User user = inMemoryRepository.getUserById(id);
        if (user == null) {
            logger.error("User not found for id:{{}} while updating", id);
            return "User id { " + id + " } not found!";
        }
        if (inMemoryRepository.editUser(id, name, personalMailId, phoneNumber)) {
            logger.info("User successfully edited : {{}}", id);
            return "User successfully edited : " + id;
        }

        logger.error("Failed to update User {}", id);
        return "Failed to update user :" + id;
    }

    @Override
    public String deleteUser(String id) {
        User user = inMemoryRepository.getUserById(id);
        if (user == null) {
            logger.error("User not found for id:{{}} while deleting", id);
            return "User id { " + id + " } not found!";
        }
        if (inMemoryRepository.deleteUser(id)) {
            logger.info("User successfully deleted! : {{}}", user);
            return "User successfully deleted: " + user;
        }
        logger.error("Can't delete the User :{{}}", user);
        return "Failed to delete: " + user;
    }

    @Override
    public List<String> fetchAllUsers() {
        List<User> userList = inMemoryRepository.getAllUsers();
        if (userList.isEmpty()) {
            logger.info("No users found!");
            return List.of();
        }
        logger.info("Users list fetched successfully");
        return userList.stream().map(User::toString).toList();
    }

    @Override
    public List<String> fetchStudents() {
        List<User> studentList = inMemoryRepository.getAllStudents();
        if (studentList.isEmpty()) {
            logger.info("No students found!");
            return List.of();
        }
        logger.info("Students list fetched successfully");
        return studentList.stream().map(User::toString).toList();
    }

    @Override
    public String fetchUserById(String id) {
        User user = inMemoryRepository.getUserById(id);
        if (user == null) {
            logger.error("User not found for id:{{}}", id);
            return "User id { " + id + " } not found!";
        }
        logger.info("User fetched : {{}}", user);
        return user.toString();
    }

    @Override
    public List<String> fetchAllCourses() {
        List<String> courseList = inMemoryRepository.getAllCourses();
        if (courseList.isEmpty()) {
            logger.info("Course List is Empty!");
            return List.of();
        }
        logger.info("Courses list fetched successfully");
        return courseList;
    }

    @Override
    public String fetchCourseById(String id) {
        String course = inMemoryRepository.getCourseById(id);
        if (course.isEmpty()) {
            logger.info("Course id is not found : {{}}", id);
            return "Course not found :" + id;
        }
        logger.info("Course fetched : {{}}", course);
        return course;
    }

    @Override
    public String mapStudentToCourse(String userId, String courseId) throws InterruptedException {

        User user = inMemoryRepository.getUserById(userId);
        if (user == null) {
            logger.error("User not found for id:{{}} while while mapping!", userId);
            return "User id { " + userId + " } not found!";
        }

        String course = inMemoryRepository.getCourseById(courseId);
        if (course.isEmpty()) {
            logger.info("Course id is not found for mapping : {{}}", courseId);
            return "Course not found :" + courseId;
        }

        if (inMemoryRepository.addStudentToCourse(userId, courseId)) {
            logger.info("Student id {} is added to the Course {}", userId, course);
            emailNotificationService.send(user.getOfficialMailId(), String.format("Hii %s, You have been enrolled for the course %s", user.getName(), course));
            return "Student id " + userId + "is added to the Course " + courseId;
        }
        logger.error("Failed to add Student Id {} to the Course {}", userId, course);
        return "Unable to add Student id " + userId + "to the Course " + course;
    }
}
