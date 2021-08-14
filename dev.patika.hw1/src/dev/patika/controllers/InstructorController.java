package dev.patika.controllers;

import dev.patika.models.Instructor;
import dev.patika.service.InstructorService;

import java.util.List;

public class InstructorController {
    private InstructorService instructorService = new InstructorService();

    public Instructor findInstructor(int instructorId){
        return instructorService.findById(instructorId);
    }

    public List<Instructor> findAllInstructors(){
        return instructorService.findAll();
    }

    public void saveInstructor(Instructor instructor){
        instructorService.saveToDatabase(instructor);
    }


    public void deleteInstructor(Instructor instructor){
        instructorService.deleteFromDatabase(instructor);
    }

    public void updateInstructor(Instructor instructor, int id){
        instructorService.updateOnDatabase(instructor, id);
    }

}
