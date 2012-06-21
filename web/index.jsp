<%-- 
    Document   : index
    Created on : Jun 15, 2012, 9:58:19 PM
    Author     : fauzan
--%>



<%@page import="Model.Book"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controller.Controller" %>
<%@page import="Model.Category" %>
<%@include file="header.jsp" %>
    <div class="container">
        
        <div class="row">
            <div class="span12">
            <div class="container">
                <%if (request.getAttribute("message") != null){ %>
                    <div class="alert alert-info">
                        <a class="close" data-dismiss="alert">×</a> 
                        <strong>Info!</strong>${message} 
                    </div>
                <%}%>
                
                <h1>Dafar Buku</h1>
                <table class="table table-striped table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Title</th>
                            <th>ISSN</th>
                            <th>Publisher</th>
                            <th>Author</th>
                            <th>Stock</th>
                            <th>Note</th>
                            <th>Category</th>
                            <th>Last Update</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Controller getController = new Controller();
                            Iterator iterator = getController.getAllBook();
                            int i = 1;
                            while(iterator.hasNext()){
                              Book book = (Book) iterator.next(); %>
                              <tr>
                                  <td><%= i %></td>
                                  <td><%= book.getTitle() %></td>
                                  <td><%= book.getIsbn_issn() %></td>
                                  <td><%= book.getPublisher().getName() %></td>
                                  <td><%= book.getAuthor().getName() %></td>
                                  <td><%= book.getStock() %></td>
                                  <td><%= book.getNote() %></td>
                                  <td>
                                      <% for(Category categories :  book.getCategories()){ %>
                                      <%= categories.getName().concat(",") %>
                                      <% } %>
                                  </td>
                                  <td><%= book.getLast_data_update().toString() %></td>
                                  <td class="span2">
                                      <a class="btn btn-mini btn-danger" href="book.do?id=<%= book.getId() %>&action=delete"><i class="icon icon-trash icon-white"></i></a>                                                         
                                      <a class="btn btn-mini btn-primary" href="book.do?id=<%= book.getId() %>&action=update"><i class="icon icon-edit icon-white"></i></a>
                                  </td>
                              </tr>
                                
                            <%
                            i++; 
                            }
                            getController.CloseSession();   
                            %>
                        
                    </tbody>
                    
                </table>
            </div>

        </div>
        </div>
    </div>
    
<%@include file="footer.jsp" %>