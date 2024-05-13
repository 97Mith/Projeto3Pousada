package org.example.repository;

import org.example.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
    static EntityManager em = emf.createEntityManager();
    public static void registerProduct(ProductEntity product){
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }
}
