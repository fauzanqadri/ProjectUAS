<%-- 
    Document   : UpdatePage
    Created on : Jun 18, 2012, 1:28:19 AM
    Author     : fauzan
--%>


<%@page import="Model.Category"%>
<%@page import="Model.Publisher"%>
<%@page import="Model.Author"%>
<%@page import="java.util.Iterator"%>
<%@page import="Controller.Controller"%>
<%@page import="Model.Book"%>
<%@include file="header.jsp" %>
<% 
    Book book = (Book) request.getAttribute("book");
    Controller getController = new Controller();
    Iterator iterator = null;
    String state1 = "";
    String state2 = "";
%>
<div class="container">
    <div class="row-fluid">
        <div class="span8">
            <div class="well">
                <div class="row-fluid">
                    <h1>Edit Book</h1>
                    <form method="POST" action="getBook.do">
                        <div class="span4">
                            <label>Book Title</label>
                            <input type="text" name="title" value="<%= book.getTitle() %>" >
                            <label>Stock</label>
                            <input type="text" name="stock" value="<%= book.getStock() %>" >
                            <label>Author</label>
                            <select name="author">
                                    <option value="null"></option>
                                    <%
                                    
                                    iterator = getController.getAllAuthor();
                                    while(iterator.hasNext()){
                                        Author author = (Author) iterator.next(); %>
                                    <option value="<%= author.getId() %>"><%= author.getName() %></option>
                                    <% } %>
                                        
                           </select>
                           <label>Note</label>
                           <textarea name="note" ><%= book.getNote() %></textarea>
                        </div>
                        <div class="span4">
                            <label>ISBN</label>
                            <input type="text" name="isbn" value="<%= book.getIsbn_issn() %>" >
                            <label>Book Location</label>
                            <input type="text" name="location" value="<%= book.getBook_location() %>" >
                            <label>Publisher</label>
                            <select name="publisher">
                            
                                <option value="null"></option>
                                <%
                                    long num = book.getPublisher().getId();
                                    iterator = getController.getAllPublisher();
                                    while(iterator.hasNext()){
                                    Publisher publisher = (Publisher) iterator.next();
                                %>
                                        
                                 <option value="<%= publisher.getId() %>"><%= publisher.getName() %> </option>
                                 
                                 <% } %>
                            </select>
                            <input type="submit" class="btn btn-primary">
                        </div>
                        <div class="span4">
                         `<label>Category</label>
                            <%
                                    iterator = getController.getAllCategory();
                                    int i = 0;
                                    while(iterator.hasNext()){
                                        Category category = (Category) iterator.next(); %>
                                        <label class="checkbox"><input type="checkbox" value="<%= category.getId() %>" name="category"><%= category.getName() %> </label>
                                    
                             <% } %>
                        </div>
                        <input type="hidden" name="id" value="<%= book.getId() %>">
                    </form>
                </div>
            </div>
            
        </div>
    </div>
</div>
<% getController.CloseSession(); %>                                    
<%@include file="footer.jsp" %>