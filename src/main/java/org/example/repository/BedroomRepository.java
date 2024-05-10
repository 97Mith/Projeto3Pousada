package org.example.repository;

import org.example.entity.BedroomEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BedroomRepository {
    public static void createBedroom(BedroomEntity bedroom){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(bedroom);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
