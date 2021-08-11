package dev.patika.service;

import dev.patika.repository.CrudRepository;

import java.util.List;

public class StudentService implements CrudRepository {
    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public void saveToDatabase(Object object) {

    }

    @Override
    public void deleteFromDatabase(Object object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Object object, int id) {

    }
}
