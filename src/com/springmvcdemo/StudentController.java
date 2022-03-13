package com.springmvcdemo;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/student")
    public class StudentController {
        @RequestMapping("/showForm")
        public String showForm(Model model) {
            // create a student object
            Student student = new Student();

            // add student object to model
            model.addAttribute("student", student);

            return "student-form";
        }

        @RequestMapping("processForm")
        public String processForm(@ModelAttribute("student") Student student) {
            // log input data
            System.out.println("Student:" + student.getFirstName() + " " + student.getLastName() );
            return "student-confirmation";

        }
    }
