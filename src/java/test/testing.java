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
import Model.Category;
import java.util.List;
import java.util.Iterator;

/**
 *
 * @author fauzan
 */

public class testing {
    
    public Iterator test(){
    //public static void main(String[] a){
        Session session = null;
        Iterator iterator = null;
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
            iterator = list.iterator();

//            while(iterator.hasNext()){
//                Book book = (Book) iterator.next();
//                System.out.println("title = "+book.getTitle());
//                System.out.println("input date = "+book.getInput_date().toString());
//                System.out.println("Author = "+book.getAuthor().getName());
//                System.out.println("Publisher = "+book.getPublisher().getName());
//                System.out.println("Category : ");
//                for (Category categories :  book.getCategories()) {
//                    System.out.println("\t"+categories.getName());
//                }
//            }
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