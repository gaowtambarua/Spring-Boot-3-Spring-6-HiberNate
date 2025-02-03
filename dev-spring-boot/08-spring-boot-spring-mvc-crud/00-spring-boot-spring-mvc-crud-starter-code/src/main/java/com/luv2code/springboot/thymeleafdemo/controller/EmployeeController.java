package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService thEmployeeService)
    {
        employeeService=thEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model themodel)
    {
        // get the employees from db
        List<Employee> theEmployees=employeeService.findAll();

        // add to the spring model
        themodel.addAttribute("employees",theEmployees);

        return  "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        //create model add attribute to bind form data
        Employee thEmployee=new Employee();
        theModel.addAttribute("employee",thEmployee);
        return "employees/employeee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")Employee thEmployee)
    {
        // save the employee
        employeeService.save(thEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";n
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model thModel)
    {
        // get the employee form the service
        Employee thEmployee=employeeService.findById(theId);

        // set employee in the model to prepopulate the form
        thModel.addAttribute("employee",thEmployee);

        // sent over to our form

        return "employees/employeee-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("employeeId")int theId)
    {
        //delete the employee
        employeeService.deleteById(theId);
        //redirect to the /eployees/list
        return "redirect:/employees/list";
    }
}
