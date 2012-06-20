<%@page import="Controller.Controller"%>
<%@page import="Model.Author"%>
<%@page import="java.util.Iterator"%>
<%@include file="header.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="container">
                <h1>Author</h1>
                <table class="table table-striped table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Note</th>
                            <th>Last Update</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Controller getController = new Controller();
                            Iterator iter = getController.getAllAuthor();
                            int i = 1;
                            while(iter.hasNext()){
                                Author auth = (Author) iter.next(); %>
                                <tr>
                                    <td>
                                        <%= i %>
                                    </td>
                                    <td>
                                        <%= auth.getName() %>
                                    </td>
                                    <td>
                                        <%= auth.getNote() %>
                                    </td>
                                    <td>
                                        <%= auth.getLast_update() %>
                                    </td>
                                    <td>
                                        <a class="btn btn-mini btn-danger" href="author.do?id=<%= auth.getId() %>&action=delete"><i class="icon icon-trash icon-white"></i></a>                                                         
                                        <a class="btn btn-mini btn-primary" href="author.do?id=<%= auth.getId() %>&action=update""><i class="icon icon-edit icon-white"></i></a>
                                    </td>
                                </tr>
                                
                          <% i++; }%>
                        
                    </tbody>
                </table>
                         
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>