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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.*;

import net.sf.jasperreports.engine.*;

import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;


/**
 *
 * @author fauzan
 */
public class Post {
    public void saveBook(String title, String isbn_issn, String note, String image_path, Date input_date, Date last_data_update, int stock, String book_location,Long publisher_id, Long author_id, int[] cat){
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
            
            Set<Category> categorySet = new HashSet<Category>();
            for (int i = 0; i < cat.length; i++) {
                System.out.println(cat[i]);
                String qCategory = "From Category where id = :id";
                Query queryCategory = session.createQuery(qCategory);
                queryCategory.setLong("id", new Long(cat[i]));
                Object queryCategoryResult = queryCategory.uniqueResult();
                Category category = (Category) queryCategoryResult;
                //System.out.println(category.getName());
                categorySet.add(category);
            }

            session.save(new Book(title, isbn_issn, note, image_path, input_date,last_data_update, stock, book_location, author, publisher,  categorySet));

            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteBook(Long id){
        Session session = null;

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
           
        }
        
    }
    
    public void updateBook(Long id, String title, String isbn_issn, String note, String image_path, int stock, String book_location, Long auth, Long publish){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Book book = (Book) session.get(Book.class, new Long(id));
            
            String qAuthor = "From Author where id = :id";      
            String qPublisher = "From Publisher where id = :id";
            
            Query queryPublisher = session.createQuery(qPublisher);
            queryPublisher.setLong("id", publish);
            Object queryPublisherResult = queryPublisher.uniqueResult();
            Publisher publisher = (Publisher) queryPublisherResult;
            
            Query queryAuthor = session.createQuery(qAuthor);
            queryAuthor.setLong("id",auth);
            
            Object queryAuthorResult = queryAuthor.uniqueResult();
            Author author = (Author) queryAuthorResult;
            
            book.setTitle(title);
            book.setIsbn_issn(isbn_issn);
            book.setNote(note);
            book.setImage_path(image_path);
            book.setStock(stock);
            book.setBook_location(book_location);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setLast_data_update(new Date());
            
            session.update(book);
            session.getTransaction().commit();
            session.close();
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertAuthor(String name, String note){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new Author(name, new Date(), new Date(), note));
            session.getTransaction().commit();
            sessionFactory.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteAuthor(Long id){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Author author = (Author) session.load(Author.class, id);
            session.delete(author);
            session.getTransaction().commit();
            
            session.close();
            sessionFactory.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Object getAuthorById(Long id){
        Session session = null;
        Object queryResult = null;
        //Author author = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("From Author Where id = :id");
            query.setLong("id", id);
            queryResult = query.uniqueResult();
            //author = (Author) queryResult;
            session.close();
            sessionFactory.close();
            return queryResult;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return queryResult;
        }
    }
    
    public void updateAuthor(long id,String name, String Note){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Author auth = (Author) session.get(Author.class, new Long(id));
            auth.setName(name);
            auth.setNote(Note);
            auth.setLast_update(new Date());
            session.update(auth);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertPublisher(String name, String note){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new Publisher(name,note ,new Date(), new Date() ));
            session.getTransaction().commit();
            sessionFactory.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deletePublisher(Long id){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Publisher pub = (Publisher) session.load(Publisher.class, id);
            session.delete(pub);
            session.getTransaction().commit();
            
            session.close();
            sessionFactory.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Object getPublisherById(Long id){
        Session session = null;
        Object queryResult = null;
        //Author author = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("From Publisher Where id = :id");
            query.setLong("id", id);
            queryResult = query.uniqueResult();
            //author = (Author) queryResult;
            session.close();
            sessionFactory.close();
            return queryResult;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return queryResult;
        }
    }
    
    public void updatePublisher(long id,String name, String Note){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Publisher pub = (Publisher) session.get(Publisher.class, new Long(id));
            pub.setName(name);
            pub.setNote(Note);
            pub.setLast_update(new Date());
            session.update(pub);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertCategory(String name, String note){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new Category(name ,new Date(), new Date() , note ));
            session.getTransaction().commit();
            sessionFactory.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteCategory(Long id){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Category cat = (Category) session.load(Category.class, id);
            session.delete(cat);
            session.getTransaction().commit();
            
            session.close();
            sessionFactory.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Object getCategoryById(Long id){
        Session session = null;
        Object queryResult = null;
        //Author author = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("From Category Where id = :id");
            query.setLong("id", id);
            queryResult = query.uniqueResult();
            
            session.close();
            sessionFactory.close();
            return queryResult;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return queryResult;
        }
    }
    
    public void updateCategory(long id,String name, String Note){
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Category cat = (Category) session.get(Category.class, new Long(id));
            cat.setName(name);
            cat.setNote(Note);
            cat.setLast_update(new Date());
            session.update(cat);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void generateBookReport(File file, File fileCompile, String location) throws IOException, SQLException, ClassNotFoundException, JRException{
        FileOutputStream fos = null;
        File file1 = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan_db", "root", "root");
            //File file = new File("PerpustakaanReport.jrxml");
            //File fileCompile = new File("PerpustakaanReport.jasper");

            JasperCompileManager.compileReportToFile(
                    file.getAbsolutePath(),
                    fileCompile.getAbsolutePath());

            
            File outputFile = new File(location);
            
            fos = new FileOutputStream(outputFile);
            JasperPrint jasperPrint = JasperFillManager.fillReport(fileCompile.getAbsolutePath(), null, connection);
            JRAbstractExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,
                    jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
                    fos);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
                    outputFile);
            exporter.exportReport();
            
            fos.close();
            System.out.println("Report berhasil :)");
            //return outputFile;

    }
}
