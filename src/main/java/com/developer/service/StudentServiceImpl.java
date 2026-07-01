package com.developer.service;

import com.developer.entity.User;
import com.developer.repository.InMemoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final InMemoryRepository inMemoryRepository;

    public StudentServiceImpl(InMemoryRepository inMemoryRepository) {
        this.inMemoryRepository = inMemoryRepository;
    }

    @Override
    public String adduser(String name, String password, String role, String personalMailId, String phoneNumber) {
        User user = inMemoryRepository.adduser(name,password,role,personalMailId,phoneNumber);
        if(user!=null){
            logger.info("User created :{{}}",user);
            return "User added Successfully - UserId is "+user.getId();
        }
        logger.error("User is not created:{{},{},{},{}}",name,role,personalMailId,phoneNumber);
        return "User is not created!";
    }

    @Override
    public String addCourse(String name) {

        String course = inMemoryRepository.addCourse(name);
        if(course!=null){
            logger.info("Created Course :{}",course);
            return "Course successfully created! - "+course;
        }
        logger.error("Failed to create course : {}",name);
        return "Can't create course : "+name;
    }

    @Override
    public String editUser(String id, String name, String personalMailId, String phoneNumber) {
        return "";
    }

    @Override
    public String deleteUser(String id) {
        return "";
    }

    @Override
    public List<String> fetchAllUsers() {
        return List.of();
    }

    @Override
    public List<String> fetchStudents() {
        return List.of();
    }

    @Override
    public String fetchUserById(String id) {
        return "";
    }

    @Override
    public List<String> fetchAllCourses() {
        return List.of();
    }

    @Override
    public String fetchCourseById() {
        return "";
    }

    @Override
    public String mapStudentToCourse() {
        return "";
    }
}
