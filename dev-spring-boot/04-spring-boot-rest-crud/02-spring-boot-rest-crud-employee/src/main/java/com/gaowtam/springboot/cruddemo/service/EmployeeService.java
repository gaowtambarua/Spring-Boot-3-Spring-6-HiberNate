package com.gaowtam.springboot.cruddemo.service;

import com.gaowtam.springboot.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();
}
