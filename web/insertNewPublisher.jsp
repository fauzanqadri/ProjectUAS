<%@include file="header.jsp" %>
<div class ="container">
    <div class="row-fluid">
        <div class="span3">
            <div class="well">
            <h2>Insert New Publisher</h2>
            <form method="POST" action="publisher.do">
                <label>Publisher Name</label>
                <input type="text" name="name" value="" >
                <label>Note</label>
                <textarea name="note"></textarea>
                <div class="span1">
                    <input type="submit" class="btn btn-primary" class="pull-right" name="submit" value="insert">
                </div>
            </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>