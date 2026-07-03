package com.developer;


import com.developer.config.AppConfig;
import com.developer.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentController controller = context.getBean(StudentController.class);




        System.out.println("Hello and welcome!");

    }
}