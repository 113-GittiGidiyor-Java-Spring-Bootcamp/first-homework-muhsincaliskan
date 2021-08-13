package dev.patika.service;

import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import java.util.List;

public class InstructorService implements CrudRepository {
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
        try {
            em.getTransaction().begin();

            Customer foundCustomer = em.createQuery("from Customer c WHERE c.ssid =:ssid", Customer.class).setParameter("ssid", customer.getSsid()).getSingleResult();
            em.remove(foundCustomer);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        } try{
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            em.getTransaction().begin();

            Customer foundCustomer = em.find(Customer.class, id);
            em.remove(foundCustomer);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void updateOnDatabase(Object object, int id) {

    }
}
