package dev.patika.repository;

import dev.patika.models.Course;
import dev.patika.models.Instructor;

import java.util.List;

public interface InstructorRepository {
    void deleteInstructorFromDatabase(int id);
    List<Course> findCoursesOfInstructor(int id);
}
