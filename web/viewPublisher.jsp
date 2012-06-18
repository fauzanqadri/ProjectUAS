<%@page import="Model.Publisher"%>
<%@page import="Controller.Controller"%>
<%@page import="java.util.Iterator"%>
<%@include file="header.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="container">
                <h1>Publisher</h1>
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
                            Iterator iter = getController.getAllPublisher();
                            int i = 1;
                            while(iter.hasNext()){
                                Publisher pub = (Publisher) iter.next();
                        %>
                                <tr>
                                    <td>
                                        <%= i %>
                                    </td>
                                    <td>
                                        <%= pub.getName() %>
                                    </td>
                                    <td>
                                        <%= pub.getNote() %>
                                    </td>
                                    <td>
                                        <%= pub.getLast_update() %>
                                    </td>
                                    
                                    <td>
                                        <a class="btn btn-mini btn-danger" href="publisher.do?id=<%= pub.getId() %>&action=delete"><i class="icon icon-trash icon-white"></i></a>                                                         
                                        <a class="btn btn-mini btn-primary" href="publisher.do?id=<%= pub.getId() %>&action=update"><i class="icon icon-edit icon-white"></i></a>
                                    </td>
                                </tr>
                                <% i++; } %>
                    </tbody>
                </table>
                         
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>