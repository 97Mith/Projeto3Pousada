package org.example.repository;

import org.example.entity.PersonEntity;
import org.example.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
    static EntityManager em = emf.createEntityManager();
    public static void registerProduct(ProductEntity product){
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }
    public static List<ProductEntity> findAllProductsWithFilter(Integer num, boolean isLaundry) {
        return em.createQuery(
                        "SELECT p FROM ProductEntity p WHERE p.bedroomNumber = :num AND p.isLaundry = :isLaundry",
                        ProductEntity.class)
                .setParameter("num", num)
                .setParameter("isLaundry", isLaundry)
                .getResultList();
    }
}
