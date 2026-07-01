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


    private final Map<String, User> Users = new HashMap<>();

    private final Map<String, String> Courses = new HashMap<>();

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
            return false;
        }

        String id = roleStr+idNumber;

        String email = id + "@devschool.in";

        User user = new User(id, role, email, name, password, personalMailId, phoneNumber);

        Users.put(id,user);
        return true;

    }

    @Override
    public boolean addCourse(String name) {

        if(Courses.containsValue(name)){
            return false;
        }

        String courseStr="COURSE";

        String idNumber = String.format("%5s",courseIdNumber).replace(' ','0');

        courseIdNumber++;

        String id = courseStr+idNumber;


        Courses.put(id,name);

        return true;
    }

    @Override
    public boolean editUser(String id, String name, String personalMailId, String phoneNumber) {
        User user = Users.get(id);
        if(user==null) return false;
        user = new User(id,user.getRole(),user.getOfficialMailId(),name,user.getPassword(),personalMailId,phoneNumber);
        return true;
    }

    @Override
    public boolean deleteUser(String id) {
        User user = Users.get(id);
        if(user==null) return false;
        Users.remove(id);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return Users.values().stream().toList();
    }

    @Override
    public List<User> getAllStudents() {
        return Users.values().stream().filter(user -> user.getRole().equals("Student")).toList();
    }

    @Override
    public User getUserById(String id) {
        return Users.get(id);
    }

    @Override
    public List<String> getAllCourses() {
        return Courses.entrySet().stream().map(e->String.format("Id: "+e.getKey()+" - Course: "+e.getValue())).toList();
    }

    @Override
    public String getCourseById(String id) {
        return "Id: "+id+" - Course: "+Courses.get(id);
    }

    @Override
    public boolean addStudentToCourse(String CourseId, String UserId) {
        coursesEnrolled.put(CourseId, UserId);
        return false;
    }
}
