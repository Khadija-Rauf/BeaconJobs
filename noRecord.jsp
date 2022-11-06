<%@page isErrorPage="true" %> 
<%@page import = "java.sql.SQLException" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="style.css" rel="stylesheet"></link>
    </head>
    <body>
        <ul>    
            <li><a href="homeUser.jsp"><b>Home</b></a></li>
            <li><a href="ControllerServlet?action=view"><b>View Job</b></a></li>
            <li><a href="searchjob.jsp"><b>Search Job</b></a></li>
            <li><a href="applyjob.jsp"><b>Apply Job</b></a></li>
            <li id="logout"><a href="ControllerServlet?action=logout"><b>Log Out</b></a></li>
            <li style="float: right;" id="profile"><a href="ControllerServlet?action=show"><b>Profile<b></a></li>
    </ul>
        <form>
            <div class="container">
            <h2>Error Page</h2>
            <h2 style="color:red;">No Record Found!</h2>
            </div>
        </form>
    </body>
</html>