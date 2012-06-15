/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author fauzan
 */
public class GetController {
    
    public Iterator getAllBook(){
    //public static void main(String[] a){
        Session session = null;
        Iterator iterator = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("From Book");
            List list = q.list();
            iterator = list.iterator();
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            
            return iterator;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return iterator;
        }
        
    }
}
