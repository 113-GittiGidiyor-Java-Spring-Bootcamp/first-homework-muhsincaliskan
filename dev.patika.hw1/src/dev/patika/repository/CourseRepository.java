package dev.patika.repository;

import dev.patika.models.Instructor;

import java.util.List;

public interface CourseRepository {
    void deleteCourseFromDatabase(int id);
    Instructor findInstructorOfCourse(int id);
}
