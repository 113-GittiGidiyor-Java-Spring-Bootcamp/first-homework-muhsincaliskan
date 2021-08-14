package dev.patika.controllers;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.service.CourseService;

import java.util.List;

public class CourseController {

    private CourseService courseService = new CourseService();

    public Course findCourse(int courseId){
        return courseService.findById(courseId);
    }

    public List<Course> findAllCourse(){
        return courseService.findAll();
    }

    public void saveCourse(Course course){
        courseService.saveToDatabase(course);
    }


    public void deleteCourse(Course course){
        courseService.deleteFromDatabase(course);
    }

    public void updateCourse(Course course, int id){
        courseService.updateOnDatabase(course, id);
    }
    public Instructor getInstructor(int id){

        return courseService.findInstructorOfCourse(id);

    }
}
