/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author KnaldeKalle
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Exam_Preparation_JPA2_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        //Below I will show the four CRUD oberations
        Book book = new Book();
        book.setIsbn(1000001L);
        book.setTitle("Penis enlargement");
        book.setAuthor("Kacper Cloirk");
        book.setPrice(299.0);
        
        try{
            
       //Here we create a book
       em.getTransaction().begin();
       em.persist(book);
       em.getTransaction().commit();
       
       //Here we retrieve information about the book
       Book book2 = em.find(Book.class, 1000001L);
       System.out.println("Price of the book: " + book2.getPrice());
       
       //Here we update the price on the book
       em.getTransaction().begin();
       book2.setPrice(149);
       em.getTransaction().commit();
       
       //Here we delete the book (It was not PT13)
       em.getTransaction().begin();
       em.remove(book2);
       em.getTransaction().commit();
       
        } finally {
            em.close();
        }
        
    }
    
}
