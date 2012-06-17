<%-- 
    Document   : insertBook
    Created on : Jun 17, 2012, 2:06:22 AM
    Author     : fauzan
--%>

<%@page import="Model.Category"%>
<%@page import="Model.Publisher"%>
<%@page import="Model.Author"%>
<%@page import="java.util.Iterator"%>
<%@page import="Controller.Controller" %>
<%@include file="header.jsp" %>
<%
    Controller getController = new Controller();
    Iterator iterator = null;
%>
<div class ="container">
    <div class="row-fluid">
        <div class="span8">
            <div class="well">
            <h1>Insert New Book</h1>
            <div class="row-fluid">
                <form method="POST" action="BookInsert.do" >			
                        <div class="span4">
                            <div class="row-fluid">
                                <label>Book Title</label>
                                <input type="text" name="title" value="" >
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
                                <label>Stock</label>
                                <input type="text" name="stock" value="0" >
                                <label>Note</label>
                                <textarea name="note" ></textarea>
                                
                            </div>
                        </div>
                        <div class="span4">
                            <label>ISBN</label>
                            <input type="text" name="isbn_issn" value="" >
                            <label>Publisher</label>
                            <select name="publisher">
                                <option value="null"></option>
                                <%
                                    iterator = getController.getAllPublisher();
                                    while(iterator.hasNext()){
                                        Publisher publisher = (Publisher) iterator.next(); %>
                                    <option value="<%= publisher.getId() %>"><%= publisher.getName() %></option>
                                    <% } %>
                            </select>
                            <label>Book Location</label>
                            <input type="text" name="location" value="" >
                            <input type="submit" class="btn btn-primary">
                        </div>
                        <div class="span4">
                            <label>Category</label>
                            <%
                                    iterator = getController.getAllCategory();
                                    int i = 0;
                                    while(iterator.hasNext()){
                                        Category category = (Category) iterator.next(); %>
                                        <label class="checkbox"><input type="checkbox" value="<%= category.getId() %>" name="category"><%= category.getName() %> </label>
                                    
                                    <% } %>
                        </div>
                    </form>
            </div>
            </div>
        </div>
    </div>
</div>
<% getController.CloseSession(); %>
<%@include file="footer.jsp" %>