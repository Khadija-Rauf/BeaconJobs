<%@page isErrorPage="true" %> 
<%@page import = "java.sql.SQLException" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="style.css" rel="stylesheet"></link>
    </head>
    <body>
        <% String value = (String)request.getAttribute("key");%>
        <ul>    
            <li><a href="home.jsp"><b>Home</b></a></li>
            <li><a href="addjob.jsp"><b>Add Job</b></a></li>
            <li><a href="updatejob.jsp"><b>Update Job</b></a></li>
            <li><a href="deletejob.jsp"><b>Delete Job</b></a></li>
            <li id="logout"><a href="ControllerServlet?action=logout"><b>Log Out</b></a></li>
        </ul>
        <form>
            <div class="container">
            <h2>Error Page</h2>
            <h2 style="color:red ;"><%=value%></h2>
            </div>
        </form>
    </body>
</html>