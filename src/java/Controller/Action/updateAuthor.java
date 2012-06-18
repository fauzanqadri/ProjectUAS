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
public class updateAuthor extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String note = req.getParameter("note");
        Long id = Long.parseLong(req.getParameter("id"));
        Post post = new Post();
        post.updateAuthor(id, name, note);
        RequestDispatcher view = req.getRequestDispatcher("viewAuthor.jsp");
        view.forward(req, resp);
    }
    
    
}
