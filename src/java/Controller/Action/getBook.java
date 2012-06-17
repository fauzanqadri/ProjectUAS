/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import Controller.Post;
import Model.Book;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

/**
 *
 * @author fauzan
 */
public class getBook extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Session session = null;
         try{ 
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("From Book Where id = :id");
            query.setLong("id", id);
            Object queryResult = query.uniqueResult();
            Book book = (Book) queryResult;
            req.setAttribute("book",book);
            RequestDispatcher view = req.getRequestDispatcher("UpdatePage.jsp");
            view.forward(req, resp);
            session.close();
            sessionFactory.close();
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String isbn_issn = req.getParameter("isbn");
        String note = req.getParameter("note");
        Long publisher_id = Long.parseLong(req.getParameter("publisher"));
        Long author_id = Long.parseLong(req.getParameter("author"));
        String image_path = "";//request.getAttribute("image_path").toString();
        int stock = Integer.parseInt(req.getParameter("stock"));
        String book_location = req.getParameter("location");
        
        System.out.println(id);
        System.out.println(title);
        System.out.println(isbn_issn);
        System.out.println(note);
        System.out.println(publisher_id);
        System.out.println(author_id);
        System.out.println(stock);
        System.out.println(book_location);
        Post post = new Post();
        post.updateBook(id, title, isbn_issn, note, image_path, stock, book_location, author_id, publisher_id);
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }
    
    
    
}
