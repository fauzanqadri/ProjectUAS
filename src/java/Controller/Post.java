/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Book;
import Model.Category;
import Model.Author;
import Model.Publisher;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author fauzan
 */
public class Post {
    public void saveBook(String title, String isbn_issn, String note, String image_path, Date input_date, Date last_data_update, int stock, String book_location,Long publisher_id, Long author_id){
        Session session = null;
        try{
        
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
       
            String qAuthor = "From Author where id = :id";      
            String qPublisher = "From Publisher where id = :id";
            
            Query queryPublisher = session.createQuery(qPublisher);
            queryPublisher.setLong("id", publisher_id);
            Object queryPublisherResult = queryPublisher.uniqueResult();
            Publisher publisher = (Publisher) queryPublisherResult;
            
            Query queryAuthor = session.createQuery(qAuthor);
            queryAuthor.setLong("id",author_id);
            
            Object queryAuthorResult = queryAuthor.uniqueResult();
            Author author = (Author) queryAuthorResult;

            session.save(new Book(title, isbn_issn, note, image_path, input_date,last_data_update, stock, book_location, author, publisher));

            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }catch(Exception e){
            
        }
    }
    
    public int deleteBook(Long id){
        Session session = null;
        int status = 0;
        try{
            
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            
            Book book = (Book) session.load(Book.class, id);
            session.delete(book);
            session.getTransaction().commit();
            
            session.close();
            sessionFactory.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            status = 404;
        }
        return status;
    }
}
