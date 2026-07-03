package com.developer.controller;

import com.developer.entity.User;
import com.developer.service.StudentServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentServiceImpl studentService;

    Scanner sc = new Scanner(System.in);

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostConstruct
    public void init() {
        logger.info("Student Controller is created");
    }

    @PreDestroy
    public void destroy() {
        logger.info("Student Controller is destroyed");
    }

    public User login() {
        System.out.println("Enter Id:");
        String id = sc.next();

        System.out.println("Enter Password:");
        String password = sc.next();

        User user = studentService.login(id, password);

        if (user != null) {
            System.out.println("User logged in");
            return user;
        }

        System.out.println("Id or Password is Wrong");
        return null;
    }

    public void adduser() {
        System.out.println("Enter Name:");
        String name = sc.next();

        System.out.println("Enter Password:");
        String password = sc.next();

        System.out.println("Enter Role:");
        String role = sc.next();

        System.out.println("Enter Personal Mail Id:");
        String personalMailId = sc.next();

        System.out.println("Enter Phone Number:");
        String phoneNumber = sc.next();

        try {
            String result = studentService.adduser(
                    name,
                    password,
                    role,
                    personalMailId,
                    phoneNumber
            );
            System.out.println(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("User creation interrupted.");
        }
    }

    public void addCourse() {
        System.out.println("Enter Course Name:");
        sc.nextLine();
        String courseName = sc.nextLine();

        String result = studentService.addCourse(courseName);
        System.out.println(result);
    }

    public void editUser()  {
        System.out.println("Enter User Id:");
        String id = sc.next();

        System.out.println("Enter New Name:");
        String name = sc.next();

        System.out.println("Enter New Personal Mail Id:");
        String personalMailId = sc.next();

        System.out.println("Enter New Phone Number:");
        String phoneNumber = sc.next();

        try {
            String result = studentService.editUser(
                    id,
                    name,
                    personalMailId,
                    phoneNumber
            );

            System.out.println(result);
        } catch (InterruptedException e) {
            System.out.println("Update of User interrupted.");
            Thread.currentThread().interrupt();

        }
    }

    public void deleteUser()  {
        System.out.println("Enter User Id:");
        String id = sc.next();

        try {
            String result = studentService.deleteUser(id);
            System.out.println(result);
        } catch (InterruptedException e) {
            System.out.println("Deletion of User interrupted.");
            Thread.currentThread().interrupt();
        }
    }

    public void fetchAllUsers() {

        System.out.println("List of Users :");

        List<String> users = studentService.fetchAllUsers();

        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        users.forEach(System.out::println);
    }

    public void fetchStudents() {

        System.out.println("List of Students :");

        List<String> students = studentService.fetchStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        students.forEach(System.out::println);
    }

    public void fetchUserById() {
        System.out.println("Enter User Id:");
        String id = sc.next();

        String user = studentService.fetchUserById(id);
        System.out.println(user);
    }

    public void fetchAllCourses() {

        System.out.println("List of courses :");

        List<String> courses = studentService.fetchAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        courses.forEach(System.out::println);
    }

    public void fetchCourseById() {
        System.out.println("Enter Course Id:");
        String id = sc.next();

        String course = studentService.fetchCourseById(id);
        System.out.println(course);
    }

    public void mapStudentToCourse() {

        System.out.println("List of courses :");

        List<String> courses = studentService.fetchAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        courses.forEach(System.out::println);

        System.out.println("Enter User Id:");
        String userId = sc.next();

        System.out.println("Enter Course Id:");
        String courseId = sc.next();

        try {
            String result = studentService.mapStudentToCourse(userId, courseId);
            System.out.println(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Mapping interrupted.");
        }
    }
}