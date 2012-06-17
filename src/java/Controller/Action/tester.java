/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fauzan
 */
public class tester extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String val = request.getParameter("type");
        System.out.println(val);
    }
    
}
