<%-- 
    Document   : index
    Created on : Jun 15, 2012, 9:58:19 PM
    Author     : fauzan
--%>



<%@page import="Model.Book"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controller.GetController" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! </h1>
        <%
        GetController getController = new GetController();
        Iterator iterator = getController.getAllBook();
            while(iterator.hasNext()){ 
                Book book = (Book) iterator.next(); %>
                out.print("<br>Title: " + book.getTitle());
                
            <%}%>
    </body>
</html>
