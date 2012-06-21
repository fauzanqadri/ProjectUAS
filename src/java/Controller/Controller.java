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
public class Controller {
    private Session session = null;
    private SessionFactory sessionFactory = null;

    public Controller() {
        this.sessionFactory = sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
        this.session.clear();
        this.session.beginTransaction();
    }
    
    
    
    public Iterator getAllBook(){
    //public static void main(String[] a){
        Iterator iterator = null;

        try{
            
            
            Query q = session.createQuery("From Book");
            List list = q.list();
            iterator = list.iterator();
           
            return iterator;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return iterator;
        }
        
    }
    
    public Iterator getAllAuthor(){
        Iterator iterator = null;
        try{
           
            Query q = session.createQuery("From Author");
            List list = q.list();
            iterator = list.iterator();
            return iterator;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return iterator;
        }
    }
    
    public Iterator getAllPublisher(){
        Iterator iterator = null;
        try{
            Query q = session.createQuery("From Publisher");
            List list = q.list();
            iterator = list.iterator();
            return iterator;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return iterator;
        }
    }
    
    public Iterator getAllCategory(){
        Iterator iterator = null;
        try{
            Query q = session.createQuery("From Category");
            List list = q.list();
            iterator = list.iterator();
            return iterator;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return iterator;
        }
    }
    
    public void CloseSession(){
        this.session.getTransaction().commit();
        this.session.clear();
        this.session.close();
        this.sessionFactory.close();
    }

}
