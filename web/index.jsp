<%-- 
    Document   : index.jsp
    Created on : Jun 11, 2012, 12:41:12 AM
    Author     : fauzan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="test.testing" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="" >
            <input type="text" name="username" value="">
            <input type="submit" name="submit" value="submit">
        </form>
        <% if(request.getAttribute("username") != null){
            testing test = new testing();
            test.test();
        } %>
        
    </body>
</html>
