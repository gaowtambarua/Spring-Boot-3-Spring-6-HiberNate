package com.gaowtam.cruddemo.dao;

import com.gaowtam.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor thInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
