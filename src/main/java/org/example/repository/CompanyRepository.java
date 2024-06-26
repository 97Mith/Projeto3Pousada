package org.example.repository;

import org.example.entity.CompanyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.*;
import java.util.List;

public class CompanyRepository {
    public static void update(CompanyEntity company) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            System.out.println("Atualizando a compania");

            emf = Persistence.createEntityManagerFactory("unit-jpa");
            em = emf.createEntityManager();

            em.getTransaction().begin();
            em.merge(company);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(
                    null, "Empresa atualizada com sucesso.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            JOptionPane.showMessageDialog(
                    null, "Ocorreu um erro ao atualizar a empresa.",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

    public static void create(CompanyEntity company){
        try {
            System.out.println("Cadastrando uma compania");

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
    public static CompanyEntity findOneByName(String name) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
            EntityManager em = emf.createEntityManager();
            CompanyEntity company;

            company = em.createQuery("SELECT c FROM CompanyEntity c WHERE c.name = :name", CompanyEntity.class)
                    .setParameter("name", name)
                    .getSingleResult();

            return company;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<CompanyEntity> findByName(String name) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
            EntityManager em = emf.createEntityManager();

            String queryStr = "SELECT c FROM CompanyEntity c WHERE c.name LIKE :name";
            TypedQuery<CompanyEntity> query = em.createQuery(queryStr, CompanyEntity.class);
            query.setParameter("name", "%" + name + "%");

            return query.getResultList();
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

    public static void delete(Integer companyId) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            CompanyEntity company = em.find(CompanyEntity.class, companyId);

            if (company != null) {
                em.remove(company);
                em.getTransaction().commit();

                JOptionPane.showMessageDialog(
                        null, "Empresa deletada com sucesso.",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                em.getTransaction().rollback();
                JOptionPane.showMessageDialog(
                        null, "Empresa não encontrada.",
                        "Aviso", JOptionPane.WARNING_MESSAGE
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Ocorreu um erro ao deletar a empresa.",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
        }
    }

}
