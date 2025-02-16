package com.gaowtam.cruddemo.dao;

import com.gaowtam.cruddemo.entity.Course;
import com.gaowtam.cruddemo.entity.Instructor;
import com.gaowtam.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor thInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);
}
