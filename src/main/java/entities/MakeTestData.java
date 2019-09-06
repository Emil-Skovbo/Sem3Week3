/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import facades.MovieFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author emils
 */
public class MakeTestData {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    private static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Movie book1 = new Movie(1, "emil", "skovbo");
        Movie book2 = new Movie(2, "emill", "sskovbo");
        try {
            em.getTransaction().begin();
            em.persist(book1);
            em.persist(book2);
            em.getTransaction().commit();
            //Verify that books are managed and has been given a database id
            System.out.println(book1.getId());
            System.out.println(book2.getId());

        } finally {
            em.close();
        }
    }
}
