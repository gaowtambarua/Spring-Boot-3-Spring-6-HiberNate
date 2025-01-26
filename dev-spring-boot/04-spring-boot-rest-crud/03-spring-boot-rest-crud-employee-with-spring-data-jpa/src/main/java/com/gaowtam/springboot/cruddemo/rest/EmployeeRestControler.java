package com.gaowtam.springboot.cruddemo.rest;

import com.gaowtam.springboot.cruddemo.entity.Employee;
import com.gaowtam.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/employees")
    public List<Employee> fidAll()
    {
        return employeeService.findAll();
    }

    //add mapping get /employess/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee=employeeService.findById(employeeId);

        if(theEmployee==null)
        {
            throw new RuntimeException("Emoployee id not found - "+employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST / employees -add new employee
    //save work
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee thEmployee)
    {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        thEmployee.setId(0);
        Employee dbEMEmployee=employeeService.save(thEmployee);
        return dbEMEmployee;
    }

    // add mapping for PUT / employees - update existing employee
    //update work
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for delete /employees{employeeId} - delete employee
    //delete work

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee=employeeService.findById(employeeId);

        //throw exception if null
        if(theEmployee==null)
        {
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id - "+employeeId;
    }

}
