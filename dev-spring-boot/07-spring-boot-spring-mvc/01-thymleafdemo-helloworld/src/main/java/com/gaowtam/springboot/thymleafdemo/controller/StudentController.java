package com.gaowtam.springboot.thymleafdemo.controller;

import com.gaowtam.springboot.thymleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model thModel) {
        //create a student object
        Student thStudent = new Student();
        // add student object to the model
        thModel.addAttribute("student", thStudent);

        // add the list of countries to the model
        thModel.addAttribute("countries",countries);

        // add the list of languages th the model
        thModel.addAttribute("languages",languages);

        // add the list of systems to the model
        thModel.addAttribute("systems",systems);

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
