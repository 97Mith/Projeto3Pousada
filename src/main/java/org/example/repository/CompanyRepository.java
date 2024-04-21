package org.example.repository;

import org.example.entity.CompanyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

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
}
