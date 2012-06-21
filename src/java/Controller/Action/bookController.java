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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author fauzan
 */
public class bookController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        long id = Long.parseLong(req.getParameter("id"));
        Post post = new Post();
        if (action.equals("update")) {
            req.setAttribute("book",post.getBookById(id));
            RequestDispatcher view = req.getRequestDispatcher("UpdatePage.jsp");
            view.forward(req, resp);
        }else if(action.equals("delete")){
            
            String message = "";
            post.deleteBook(id);

            req.setAttribute("message",message);
            RequestDispatcher view = req.getRequestDispatcher("index.jsp");
            view.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String submit = req.getParameter("submit");
        String title = req.getParameter("title");
        String isbn_issn = req.getParameter("isbn_issn");
        String note = req.getParameter("note");
        Long publisher_id = Long.parseLong(req.getParameter("publisher"));
        Long author_id = Long.parseLong(req.getParameter("author"));
        String image_path = "";
        Date input_date = new Date();
        Date last_data_update = new Date();
        int stock = Integer.parseInt(req.getParameter("stock"));
        String book_location = req.getParameter("location");
        String[] cat =  req.getParameterValues("categories");
        int[] catId = new int[cat.length];
        for (int i = 0; i < cat.length; i++) {
            catId[i] = Integer.parseInt(cat[i]);
        }
        Post post = new Post();
        if (submit.equals("save")) {
            post.saveBook(title, isbn_issn, note, image_path, input_date, last_data_update, stock, book_location, publisher_id, author_id, catId);
            Object message = "Your Data Successfully add";
            req.setAttribute("message",message);
            RequestDispatcher view = req.getRequestDispatcher("index.jsp");
            view.forward(req, resp); 
        }else if(submit.equals("update")){
            Long id = Long.parseLong(req.getParameter("id"));
            post.updateBook(id, title, isbn_issn, note, image_path, stock, book_location, author_id, publisher_id,catId);
            RequestDispatcher view = req.getRequestDispatcher("index.jsp");
            view.forward(req, resp);
        }
    }
    
}
