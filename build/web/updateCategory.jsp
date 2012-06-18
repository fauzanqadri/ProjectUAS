
<%@page import="Model.Category"%>

<%@include file="header.jsp" %>
<% 
Category cat = (Category) request.getAttribute("category");
%>
<div class ="container">
    <div class="row-fluid">
        <div class="span3">
            <div class="well">
            <h2>Edit Publisher</h2>
            <form method="POST" action="category.do">
                <input type="hidden" name="id" value="<%= cat.getId() %>">
                <label>Author Name</label>
                <input type="text" name="name" value="<%= cat.getName() %>" >
                <label>Note</label>
                <textarea name="note"><%= cat.getNote() %></textarea>
                <div class="span1">
                    <input type="submit" class="btn btn-primary" class="pull-right" name="submit" value="update">
                </div>
            </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>