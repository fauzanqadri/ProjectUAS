/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Model.Book;
/**
 *
 * @author fauzan
 */

public class testing {
    
    public void test(){
        Session session = null;
//        try{
//            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.save(new Book("testing book"));
//            session.save(new Book("another book"));
//            session.getTransaction().commit();
//            session.flush();
//            session.close();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
    }
}