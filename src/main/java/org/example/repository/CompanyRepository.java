package org.example.repository;

import org.example.entity.CompanyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.List;

public class CompanyRepository {
    public static void createCompany(CompanyEntity company){
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(
                    null, "Empresa cadastrada com sucesso.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE
            );

        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    null, "Ocorreu um erro ao se conectar ao banco de dados.",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public static CompanyEntity findById(Integer id) {

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
            EntityManager em = emf.createEntityManager();

            return em.find(CompanyEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<CompanyEntity> findAll() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
            EntityManager em = emf.createEntityManager();

            return em.createQuery("SELECT c FROM CompanyEntity c" , CompanyEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
