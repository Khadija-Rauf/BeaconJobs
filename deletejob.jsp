<%@page errorPage="error.jsp" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="style.css" rel="stylesheet"></link>
    </head>
    <body>
        <%
            if((String)session.getAttribute("username")==null){%>
                <jsp:forward page='login.jsp?action=login'/>
            
           <% }
           else if((int)session.getAttribute("user_type")==1){
        %>
        <ul>
                <li><a href="home.jsp"><b>Home</b></a></li>
                <li><a href="addjob.jsp"><b>Add Job</b></a></li>
                <li><a href="updatejob.jsp"><b>Update Job</b></a></li>
                <li class="active"><a href="deletejob.jsp"><b>Delete Job</b></a></li>
                <li id="logout"><a href="ControllerServlet?action=logout"><b>Log Out</b></a></li>
        </ul>
        <form action="ControllerServlet">
            <div class="container">
            <h2>Delete Job</h2>
            <input type="text" name="id" placeholder="Job Id" required>
            <br>
            <button type="submit" value="delete" name="action">Delete</button>
            </div>
        </form>
        <%
        }
        else{
        %>
        <jsp:forward page='login.jsp?action=login'/>
        <%
        }
        %>
    </body>
</html>