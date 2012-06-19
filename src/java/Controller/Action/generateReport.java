/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import Controller.Post;
import java.io.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author fauzan
 */
public class generateReport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post post = new Post();
//        File file = new File(req.getServletContext().getResourceAsStream("/WEB-INF") +"/PerpustakaanReport.jrxml");
//        File fileCompile = new File(req.getServletContext().getResourceAsStream("/WEB-INF")+"/PerpustakaanReport.jasper");
//        String location = req.getServletContext().getResourceAsStream("/WEB-INF")+"/daftar_buku_" + (new java.util.Date()) + ".pdf";
        
        //InputStream is = req.getServletContext().getResourceAsStream("/WEB-INF/templatez/myfile.txt");
        File file = new File("/Users/fauzan/NetBeansProjects/ProjectUAS/web/WEB-INF/PerpustakaanReport.jrxml");
        File fileCompile = new File("/Users/fauzan/NetBeansProjects/ProjectUAS/web/WEB-INF/PerpustakaanReport.jasper");
        String fileName = "daftarBuku.pdf";
        String Location = "/Users/fauzan/NetBeansProjects/ProjectUAS/web/"+fileName;
        try {
            post.generateBookReport(file, fileCompile, Location);
            
            OutputStream outStream = resp.getOutputStream();
            File f = new File(Location);
            resp.setContentLength((int)f.length());
            resp.setHeader("Content-Disposition","attachment; filename=\"daftarBuku.pdf\"");
            resp.setHeader("Cache-Control", "no-cache");
            byte[] buf = new byte[8192];
            FileInputStream inStream = new FileInputStream(f);
            int sizeRead = 0;
            while ((sizeRead = inStream.read(buf, 0, buf.length)) > 0) {
                //log.debug("size:"+sizeRead);
                outStream.write(buf, 0, sizeRead);
            }
        inStream.close();
        outStream.close();
        } catch (SQLException ex) {
            Logger.getLogger(generateReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(generateReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(generateReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
