package com.gaowtam.springboot.cruddemo.service;

import com.gaowtam.springboot.cruddemo.dao.EmployeeDAO;
import com.gaowtam.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
