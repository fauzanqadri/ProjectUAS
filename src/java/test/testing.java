/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import Model.Book;
import java.util.List;
import java.util.Iterator;
/**
 *
 * @author fauzan
 */

public class testing {
    
    //public void test(){
    public static void main(String[] a){
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
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("From Book");
            List list = q.list();
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                Book book = (Book) iterator.next();
                System.out.println("title = "+book.getTitle());
            }
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}