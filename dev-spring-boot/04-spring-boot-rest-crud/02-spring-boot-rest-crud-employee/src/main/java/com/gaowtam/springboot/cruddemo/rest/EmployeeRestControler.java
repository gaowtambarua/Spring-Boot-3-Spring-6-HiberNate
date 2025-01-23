package com.gaowtam.springboot.cruddemo.rest;

import com.gaowtam.springboot.cruddemo.dao.EmployeeDAO;
import com.gaowtam.springboot.cruddemo.entity.Employee;
import com.gaowtam.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestControler {

    /// For EmployeeDAO

//    private EmployeeDAO employeeDAO;
//
//    //quick and dirty: inject employee dao
//    public EmployeeRestControler(EmployeeDAO theEmployeeDAO)
//    {
//        employeeDAO=theEmployeeDAO;
//    }

    //EmployeeService
     private EmployeeService employeeService;

     public EmployeeRestControler(EmployeeService thEmployeeService)
     {
         employeeService=thEmployeeService;
     }

    //expose "/employees" and return a list of employees
//
//    @GetMapping("/employes")
//    public List<Employee> fidAll()
//    {
//        return employeeDAO.findALL();
//    }


    @GetMapping("/employes")
    public List<Employee> fidAll()
    {
        return employeeService.findAll();
    }
}
