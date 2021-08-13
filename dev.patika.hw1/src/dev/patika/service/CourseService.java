package dev.patika.service;

import dev.patika.models.Course;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import java.util.List;

public class CourseService implements CrudRepository {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List findAll() {
        return em.createQuery("from Course", Course.class).getResultList();;
    }

    @Override
    public Course findById(int id) {
        return return  em.find(Course.class, id);;
    }

    @Override
    public void saveToDatabase(Course course) {
        try{
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
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
