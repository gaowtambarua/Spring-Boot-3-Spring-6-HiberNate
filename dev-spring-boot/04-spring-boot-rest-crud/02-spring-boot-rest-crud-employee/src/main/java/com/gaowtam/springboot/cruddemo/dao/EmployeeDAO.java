package com.gaowtam.springboot.cruddemo.dao;

import com.gaowtam.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findALL();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
