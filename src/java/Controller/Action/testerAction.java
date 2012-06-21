/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import Controller.Controller;
import Model.Book;
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
public class testerAction extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Object message = "Your Data Successfully Update";
        Controller con = new Controller();

        //req.setAttribute("book",con.objectBook());
        RequestDispatcher view = req.getRequestDispatcher("test.jsp");
        view.forward(req, resp);
        con.CloseSession();
    }
    
}
