package com.gaowtam.springboot.thymleafdemo.controller;

import com.gaowtam.springboot.thymleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model thModel) {
        //create a student object
        Student thStudent = new Student();
        // add student object to the model
        thModel.addAttribute("student", thStudent);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student thStudent)
    {
        //log the input data
        System.out.println("theStudent: "+thStudent.getFirstName()+" "+thStudent.getLastName());

       return "student-confirmation";
    }
}
