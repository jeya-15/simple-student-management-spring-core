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
        System.out.print("Enter Id:");
        String id = sc.nextLine();

        System.out.print("Enter Password:");
        String password = sc.nextLine();

        User user = studentService.login(id, password);

        if (user != null) {
            System.out.println("User logged in");
            return user;
        }

        System.out.println("Id or Password is Wrong");
        return null;
    }

    public void adduser() {
        System.out.print("Enter Name:");
        String name = sc.nextLine();

        System.out.print("Enter Password:");
        String password = sc.nextLine();

        System.out.print("Enter Role:");
        String role = sc.nextLine();

        System.out.print("Enter Personal Mail Id:");
        String personalMailId = sc.nextLine();

        System.out.print("Enter Phone Number:");
        String phoneNumber = sc.nextLine();

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
        System.out.print("Enter Course Name:");
        String courseName = sc.nextLine();

        String result = studentService.addCourse(courseName);
        System.out.println(result);
    }

    public void editUser()  {
        System.out.print("Enter User Id:");
        String id = sc.nextLine();

        System.out.print("Enter New Name:");
        String name = sc.nextLine();

        System.out.print("Enter New Personal Mail Id:");
        String personalMailId = sc.nextLine();

        System.out.print("Enter New Phone Number:");
        String phoneNumber = sc.nextLine();

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
        System.out.print("Enter User Id:");
        String id = sc.nextLine();

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
        System.out.print("Enter User Id:");
        String id = sc.nextLine();

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
        System.out.print("Enter Course Id:");
        String id = sc.nextLine();

        String course = studentService.fetchCourseById(id);
        System.out.println(course);
    }

    public void mapStudentToCourse() {

        System.out.print("List of courses :");

        List<String> courses = studentService.fetchAllCourses();

        if (courses.isEmpty()) {
            System.out.print("No courses found.");
            return;
        }

        courses.forEach(System.out::println);

        System.out.println("Enter User Id:");
        String userId = sc.nextLine();

        System.out.println("Enter Course Id:");
        String courseId = sc.nextLine();

        try {
            String result = studentService.mapStudentToCourse(userId, courseId);
            System.out.println(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Mapping interrupted.");
        }
    }
}