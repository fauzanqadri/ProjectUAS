/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import java.io.IOException;
import java.util.Date;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.Post;
import javax.servlet.RequestDispatcher;




/**
 *
 * @author fauzan
 */
public class InsertNewBook extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String isbn_issn = request.getParameter("isbn_issn");
        String note = request.getParameter("note");
        Long publisher_id = Long.parseLong(request.getParameter("publisher"));
        Long author_id = Long.parseLong(request.getParameter("author"));
        String image_path = "";//request.getAttribute("image_path").toString();
        Date input_date = new Date();
        Date last_data_update = new Date();
        int stock = Integer.parseInt(request.getParameter("stock"));
        String book_location = request.getParameter("location");
        String[] cat =  request.getParameterValues("categories");
        int[] catId = new int[cat.length];
        for (int i = 0; i < cat.length; i++) {
            catId[i] = Integer.parseInt(cat[i]);
            //System.out.println(catId[i]);
        }
        
        Post post = new Post();
        post.saveBook(title, isbn_issn, note, image_path, input_date, last_data_update, stock, book_location, publisher_id, author_id, catId);
        
        Object message = "Your Data Successfully add";
        request.setAttribute("message",message);
        //response.sendRedirect("index.jsp");
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response); 
    }
    
}
