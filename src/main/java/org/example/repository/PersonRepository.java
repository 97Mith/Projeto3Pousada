package org.example.repository;

import org.example.entity.CompanyEntity;
import org.example.entity.PersonEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.List;

public class PersonRepository {
    public static void saveGuestInDB(PersonEntity guest){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(guest);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
    public static List<PersonEntity> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        return em.createQuery("SELECT c FROM PersonEntity c" , PersonEntity.class).getResultList();
    }
    public static PersonEntity findById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        return em.find(PersonEntity.class, id);
    }
    public static boolean deletePerson(Integer personId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        PersonEntity person = em.find(PersonEntity.class, personId);

        if (person != null) {
            em.remove(person);
            em.getTransaction().commit();
            return true;
        } else {
            em.getTransaction().rollback();
            return false;
        }
    }
    public static void deleteById(List<PersonEntity> people, Integer id) {
        people.removeIf(company -> company.getId().equals(id));
    }
}



