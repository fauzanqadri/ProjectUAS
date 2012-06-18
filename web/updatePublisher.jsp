
<%@page import="Model.Publisher"%>

<%@include file="header.jsp" %>
<% 
Publisher pub = (Publisher) request.getAttribute("publisher");
%>
<div class ="container">
    <div class="row-fluid">
        <div class="span3">
            <div class="well">
            <h2>Edit Publisher</h2>
            <form method="POST" action="publisher.do">
                <input type="hidden" name="id" value="<%= pub.getId() %>">
                <label>Author Name</label>
                <input type="text" name="name" value="<%= pub.getName() %>" >
                <label>Note</label>
                <textarea name="note"><%= pub.getNote() %></textarea>
                <div class="span1">
                    <input type="submit" class="btn btn-primary" class="pull-right" name="submit" value="update">
                </div>
            </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>