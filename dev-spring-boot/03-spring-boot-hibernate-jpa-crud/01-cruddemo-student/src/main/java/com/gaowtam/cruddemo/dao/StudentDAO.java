package com.gaowtam.cruddemo.dao;

import com.gaowtam.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student>findByLastName(String thelastName);

    void update (Student theStudent);

    void upateAllLastName();

    void delete(Integer id);

    int deleteALl();
}
