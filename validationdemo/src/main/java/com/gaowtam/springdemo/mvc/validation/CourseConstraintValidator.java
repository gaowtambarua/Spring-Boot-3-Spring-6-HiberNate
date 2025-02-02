package com.gaowtam.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode thCourseCode) {
        coursePrefix=thCourseCode.value(); //CourseCode class er moddhe value set kora ace
    }

    @Override
    public boolean isValid(String theCOde, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;

        if(theCOde!=null)
        {
            result=theCOde.startsWith(coursePrefix);
        }
        else
        {
            result=false;
        }

        return result;
    }
}
