<%@page errorPage="error.jsp" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="style.css" rel="stylesheet"></link>
        <link href="newStyle.css" rel="stylesheet"></link>
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
                <li class="active"><a href="updatejob.jsp"><b>Update Job</b></a></li>
                <li><a href="deletejob.jsp"><b>Delete Job</b></a></li>
                <li id="logout"><a href="ControllerServlet?action=logout"><b>Log Out</b></a></li>
        </ul>
        <form action="ControllerServlet">
            <div class="container">
            <h2>Update Existing Job</h2>
            <input type="text" name="id" placeholder="Job Id" required>
            <br>
            <input type="text" name="title" placeholder="Job Title" required>
            <br>
            <input type="text" name="salary" placeholder="Salary" required>
            <br>
            <input type="text" name="type" placeholder="Job Type" required>
            <br>
            <textarea  rows="3"cols= "50" name="description" placeholder="Description" required></textarea>
            <br>
            <button type="submit" value="update" name="action">Update</button>
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
