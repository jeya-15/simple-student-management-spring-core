package com.developer;


import com.developer.config.AppConfig;
import com.developer.controller.StudentController;
import com.developer.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentController controller = context.getBean(StudentController.class);

        User user = null;

        System.out.println("Hello and welcome!");

        while (true) {
            if (user == null) {
                user = controller.login();
                System.out.println("Welcome Back!");
            }

            if ("Admin".equals(user.getRole())) {
                System.out.println("1) Add new user");
                System.out.println("2) Add new Course");
                System.out.println("3) Edit User");
                System.out.println("4) Delete User");
                System.out.println("5) Fetch all Users");
                System.out.println("6) Fetch Students");
                System.out.println("7) Fetch user by Id");
                System.out.println("8) Fetch all Courses");
                System.out.println("9) Fetch course by Id");
                System.out.println("10) Register Course");
                System.out.println("11) Logout");

                String choice = sc.next();

                switch (choice) {
                    case "1": {
                        controller.adduser();
                        break;
                    }

                    case "2": {
                        controller.addCourse();
                        break;
                    }

                    case "3": {
                        controller.editUser();
                        break;
                    }

                    case "4": {
                        controller.deleteUser();
                        break;
                    }

                    case "5": {
                        controller.fetchAllUsers();
                        break;
                    }

                    case "6": {
                        controller.fetchStudents();
                        break;
                    }

                    case "7": {
                        controller.fetchUserById();
                        break;
                    }

                    case "8": {
                        controller.fetchAllCourses();
                        break;
                    }
                    case "9": {
                        controller.fetchCourseById();
                        break;
                    }

                    case "10": {
                        controller.mapStudentToCourse();
                        break;
                    }

                    case "11": {
                        user = null;
                        break;
                    }

                    default: {
                        System.out.println("Invalid Option");
                        break;
                    }
                }
            }
            else if("Student".equals(user.getRole())){
                System.out.println("1) Fetch all Courses");
                System.out.println("2) Fetch course by Id");
                System.out.println("4) Logout");

                String choice = sc.next();

                switch (choice) {
                    case "1": {
                        controller.fetchAllCourses();
                        break;
                    }
                    case "2": {
                        controller.fetchCourseById();
                        break;
                    }


                    case "3": {
                        user = null;
                        break;
                    }

                    default: {
                        System.out.println("Invalid Option");
                        break;
                    }
                }
            }

        }


    }
}