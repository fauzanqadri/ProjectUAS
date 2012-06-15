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
    private Session session = null;
    private SessionFactory sessionFactory = null;
    
    public Iterator getAllBook(){
    //public static void main(String[] a){
        Iterator iterator = null;

        try{
             sessionFactory = new Configuration().configure().buildSessionFactory();
            this.session = sessionFactory.openSession();
            this.session.beginTransaction();
            Query q = session.createQuery("From Book");
            List list = q.list();
            iterator = list.iterator();
            session.getTransaction().commit();
            return iterator;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return iterator;
        }
        
    }
    
    public void CloseSession(){
        this.session.close();
        this.sessionFactory.close();
    }
}
