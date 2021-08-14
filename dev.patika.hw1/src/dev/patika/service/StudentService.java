package dev.patika.service;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.repository.StudentRepository;
import dev.patika.utils.EntityManagerUtils;
import javax.persistence.EntityManager;

import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List findAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return  em.find(Student.class, id);
    }

    @Override
    public void saveToDatabase(Student object) {
        try{
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(Student object) {
        try {
            em.getTransaction().begin();

            Student foundCustomer = em.createQuery("from Student c WHERE c.name =:name", Student.class).setParameter("name", object.getName()).getSingleResult();
            em.remove(foundCustomer);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void updateOnDatabase(Student object, int id) {
        try {
            em.getTransaction().begin();

            Student student = em.find(Student.class, id);
            student.setAddress(object.getAddress());
            student.setName(object.getName());

            em.merge(student);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteStudentFromDatabase(int id) {
        try {
            em.getTransaction().begin();

            Student foundStudent = em.find(Student.class, id);
            em.remove(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public List<Course> findCoursesOfStudent(int id) {
        return findById(id).getCourseList();
    }
}
