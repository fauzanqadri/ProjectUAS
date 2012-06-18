/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import Controller.Post;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fauzan
 */
public class PublisherController extends HttpServlet {

    @Override    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String action = req.getParameter("action");
        Post post = new Post();
        if (action.equals("delete")) {
            
            post.deletePublisher(id);
            RequestDispatcher view = req.getRequestDispatcher("viewPublisher.jsp");
            view.forward(req, resp);
        }else if(action.equals("update")){
            req.setAttribute("publisher", post.getPublisherById(id));
            RequestDispatcher view = req.getRequestDispatcher("updatePublisher.jsp");
            view.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String note = req.getParameter("note");
        String submit = req.getParameter("submit");
        Post post = new Post();
        if (submit.equals("insert")) {
           //Long id = Long.parseLong(req.getParameter("id"));
           post.insertPublisher(name, note);
           RequestDispatcher view = req.getRequestDispatcher("viewPublisher.jsp");
           view.forward(req, resp);
        }else if(submit.equals("update")){
            Long id = Long.parseLong(req.getParameter("id"));
            post.updatePublisher(id, name, note);
            RequestDispatcher view = req.getRequestDispatcher("viewPublisher.jsp");
            view.forward(req, resp);
        }
    }
    
    
    
}
