/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.Author;
import Model.Book;
import Model.Category;
import Model.Publisher;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author fauzan
 */
public class teslagi {
    private static Object hashSet;
    
    public static void main(String[] a){
        Session session = null;
        Iterator iterator = null;

        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            
            String qCategory = "From Category Where id = :id";
            String qAuth = "From Author Where id = :id";
            String qPub = "From Publisher Where id = :id";
            
            Query qPubh = session.createQuery(qPub);
            qPubh.setLong("id", 1);
            Object o3 = qPubh.uniqueResult();
            Publisher publish = (Publisher) o3;
            
            Query qAutho = session.createQuery(qAuth);
            qAutho.setLong("id", 1);
            Object o1 = qAutho.uniqueResult();
            Author auth = (Author) o1;
                    
            Query qCat = session.createQuery(qCategory);
            qCat.setLong("id", 1);
            Object o2 = qCat.uniqueResult();
            Category cate = (Category) o2;
            //System.out.println(cate.getName());
            Set<Category> cat = new HashSet<Category>();
            cat.add(cate);
            
            
            
            Book book = new Book();
            book.setTitle("Test Give Cat");
            book.setAuthor(auth);
            book.setPublisher(publish);
            book.setLast_data_update(new Date());
            book.setInput_date(new Date());
            book.setBook_location("Location");
            book.setImage_path("");
            book.setIsbn_issn("12345678909877654321");
            book.setNote("yaaayyy");
            book.setStock(12);
            book.setCategories(cat);
            session.save(book);
            
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            
           // return iterator;
        }catch(Exception e){
            System.out.println(e.getMessage());
            //return iterator;
        }
    }
    
}
