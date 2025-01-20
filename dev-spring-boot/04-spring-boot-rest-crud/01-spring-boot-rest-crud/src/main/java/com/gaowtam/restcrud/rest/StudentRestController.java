package com.gaowtam.restcrud.rest;

import com.gaowtam.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import jdk.jfr.Experimental;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students/{studentId}")//rest service
    public Student getStudent(@PathVariable int studentId)
    {
        //just index into the list ... keep it simple for now

        //check th studentId again list size

        if((studentId>=theStudents.size())||(studentId<0))
        {
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }

        return theStudents.get(studentId);
    }

    //Add an exception handler usig @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exp)/// [http://localhost:8080/api/students/123]
    {
        //create a StudentErrorResponse

        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exp.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add another exception handler ... to catch any exception (catch all)

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exp) //Global Exception handler er jonno [http://localhost:8080/api/students/sdfsdf]
//    {
//        //create a StudentErrorResponse
//
//        StudentErrorResponse error=new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exp.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        // return ResponseEntity
//
//        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//    }

}
