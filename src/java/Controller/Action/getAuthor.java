/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import Controller.Controller;
import Controller.Post;
import Model.Author;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author fauzan
 */
public class getAuthor extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Long id = Long.parseLong(req.getParameter("id"));
            String action = req.getParameter("action");
            System.out.println(action);
            System.out.println(id);
            Post post = new Post();
            Controller cont = new Controller();
            
            if (action.equals("delete")) {
                post.deleteAuthor(id);
                RequestDispatcher view = req.getRequestDispatcher("viewAuthor.jsp");
                view.forward(req, resp);
            }else if(action.equals("update")){  
                
                
                req.setAttribute("author", post.getAuthorById(id));
                RequestDispatcher view = req.getRequestDispatcher("editAuthor.jsp");
                view.forward(req, resp);
                //cont.CloseSession();
            }
 
           // cont.CloseSession();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String note = req.getParameter("note");
        Post post = new Post();
        post.insertAuthor(name, note);
        RequestDispatcher view = req.getRequestDispatcher("viewAuthor.jsp");
        view.forward(req, resp);
    }
    
    
    
    
    
}
