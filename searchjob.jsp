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
       else if((int)session.getAttribute("user_type")==2){
        %>
        <ul>    
                <li><a href="homeUser.jsp"><b>Home</b></a></li>
                <li><a href="ControllerServlet?action=view"><b>View Job</b></a></li>
                <li class="active"><a href="searchjob.jsp"><b>Search Job</b></a></li>
                <li><a href="applyjob.jsp"><b>Apply Job</b></a></li>
                <li id="logout"><a href="ControllerServlet?action=logout"><b>Log Out</b></a></li>
                <li style="float: right;" id="profile"><a href="ControllerServlet?action=show"><b><%= (String)session.getAttribute("username") %><b></a></li>
        </ul>
        <form action="ControllerServlet">
            <div class="container">
            <h2>Search Job</h2>
            <input type="text" name="title" placeholder="Job Title" required>
            <br>
            <button type="submit" value="search" name="action">Search</button>
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