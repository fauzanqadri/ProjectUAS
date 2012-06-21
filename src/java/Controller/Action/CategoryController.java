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
public class CategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        if (req.getParameter("action") != null) {
            String name = req.getParameter("name");
            String note = req.getParameter("note");
            String action = req.getParameter("action");
            Post post = new Post();
            if (action.equals("delete")) {
                Long id = Long.parseLong(req.getParameter("id"));
                post.deleteCategory(id);
                RequestDispatcher view = req.getRequestDispatcher("viewCategory.jsp");
                view.forward(req, resp);
            }else if(action.equals("update")){
                Long id = Long.parseLong(req.getParameter("id"));
                req.setAttribute("category", post.getCategoryById(id));
                RequestDispatcher view = req.getRequestDispatcher("updateCategory.jsp");
                view.forward(req, resp);
            }
        }else{
            RequestDispatcher view = req.getRequestDispatcher("viewCategory.jsp");
            view.forward(req, resp);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submit = req.getParameter("submit");
        String name = req.getParameter("name");
        String note = req.getParameter("note");
        
        Post post = new Post();
        if (submit.equals("insert")) {
           
            post.insertCategory(name, note);
            RequestDispatcher view = req.getRequestDispatcher("viewCategory.jsp");
            view.forward(req, resp);
        }else if(submit.equals("update")){
            Long id = Long.parseLong(req.getParameter("id"));
            post.updateCategory(id, name, note);
            RequestDispatcher view = req.getRequestDispatcher("viewCategory.jsp");
            view.forward(req, resp);
        }
    }
    
    
    
    
}
