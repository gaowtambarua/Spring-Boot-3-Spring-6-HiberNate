package com.gaowtam.restcrud.rest;

import com.gaowtam.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents;

    //define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData()
    {
        theStudents =new ArrayList<>();

        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("Mario","Rossi"));
        theStudents.add(new Student("Nabela","Haque"));
    }


    //define endpoint for "/studetns" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents()
    {

        return  theStudents;
    }

    //define endpoint or "/studetns/{studentId}"-return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        //just index into the list ... keep it simple for now

        return theStudents.get(studentId);
    }

}