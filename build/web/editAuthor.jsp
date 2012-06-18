
<%@page import="Model.Author"%>
<%@include file="header.jsp" %>
<% 
Author auth = (Author) request.getAttribute("author");
%>
<div class ="container">
    <div class="row-fluid">
        <div class="span3">
            <div class="well">
            <h2>Edit Author</h2>
            <form method="POST" action="updateAuthor.do">
                <input type="hidden" name="id" value="<%= auth.getId() %>">
                <label>Author Name</label>
                <input type="text" name="name" value="<%= auth.getName() %>" >
                <label>Note</label>
                <textarea name="note"><%= auth.getNote() %></textarea>
                <div class="span1">
                    <input type="submit" class="btn btn-primary" class="pull-right">
                </div>
            </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>