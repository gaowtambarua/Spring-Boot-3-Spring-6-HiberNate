package com.gaowtam.springboot.cruddemo.service;

import com.gaowtam.springboot.cruddemo.dao.EmployeeDAO;
import com.gaowtam.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO thEmployeeDAO)
    {
        employeeDAO=thEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findALL();
    }
}
