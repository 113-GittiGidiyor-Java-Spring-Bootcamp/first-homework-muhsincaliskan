package dev.patika.controllers;

import dev.patika.models.Course;
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


    public void deleteCourse(long ssid){
        courseService.deleteFromDatabase(ssid);
    }

    public void updateCourse(Course course, int id){
        courseService.updateOnDatabase(course, id);
    }
}
