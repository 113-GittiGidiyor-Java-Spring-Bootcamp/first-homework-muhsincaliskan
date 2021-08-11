package dev.patika.controllers;

import dev.patika.models.Student;
import dev.patika.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService = new StudentService();

    public Student findStudent(int studentId){
        return studentService.findById(studentId);
    }

    public List<Student> findAllStudent(){
        return studentService.findAll();
    }

    public void saveStudent(Student student){
        studentService.saveToDatabase(course);
    }


    public void deleteStudent(long ssid){
        studentService.deleteFromDatabase(ssid);
    }

    public void updateStudent(Student student, int id){
        studentService.updateOnDatabase(course, id);
    }

}
