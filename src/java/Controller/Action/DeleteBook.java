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
public class DeleteBook extends HttpServlet{

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("yay");
        Long book_id = Long.parseLong(request.getParameter("id"));
        System.out.println(book_id);
        Post post = new Post();
        String message = "";
        int status = post.deleteBook(book_id);
        System.out.println(status);
        if (status == 200) {
            message = "Data Succsessfuly Remove";
        }else{
            message = "Something Error";
        }
//        request.setAttribute("message",message);
//        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//        view.forward(request, response);
    }

    
    
    
}
