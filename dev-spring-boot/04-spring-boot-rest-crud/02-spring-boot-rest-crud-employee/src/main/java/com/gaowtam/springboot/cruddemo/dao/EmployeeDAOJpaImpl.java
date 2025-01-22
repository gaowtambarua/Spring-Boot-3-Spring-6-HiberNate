package com.gaowtam.springboot.cruddemo.dao;

import com.gaowtam.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injecton
    public EmployeeDAOJpaImpl(EntityManager thEntityManager) {
        entityManager = thEntityManager;
    }

    @Override
    public List<Employee> findALL() {

        //create a query
        TypedQuery<Employee> thequQuery=entityManager.createQuery("from Employee",Employee.class);

        //excute query and get result list
        List<Employee> employees=thequQuery.getResultList();

        //return th results
        return employees;
    }
}
