package com.springdemo.rest;

import com.springdemo.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

//    define @PostConstruct to load student data only once
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Saulius", "Vasaris"));
        students.add(new Student("Mantas", "Spalis"));
        students.add(new Student("Edmundas", "Gruodis"));
    }
//    define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
//    define endpoint for "/students/{sudentId}" - return student and index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {  // int studentId turi sutapti su {studentId}
//        just index into the list. keep it simple for now
//        check student id against list size
        if ((studentId>=students.size())||(studentId<0)){
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return students.get(studentId);
    }

}
