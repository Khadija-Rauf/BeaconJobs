<!-- <%@page errorPage="error.jsp" %>  -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="MyPack.*" %><html>
    <head>
        <link href="style.css" rel="stylesheet"></link>
    </head>
    <body>
        <% 
        UserInfo user = (UserInfo)request.getAttribute("list");
        %>
        <ul>    
                <li><a href="homeUser.jsp"><b>Home</b></a></li>
                <li><a href="ControllerServlet?action=view"><b>View Job</b></a></li>
                <li><a href="searchjob.jsp"><b>Search Job</b></a></li>
                <li><a href="applyjob.jsp"><b>Apply Job</b></a></li>
                <li id="logout"><a href="ControllerServlet?action=logout"><b>Log Out</b></a></li>
                <li style="float: right;" class="active"><a href="ControllerServlet?action=show"><b><%=user.getUsername()%><b></a></li>
        </ul>
        <form>
        </div>
            <div>
                <table>
                    <tr>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Username</th><br>
                          <td><%=user.getUsername()%></td><br>
                    </tr>
                    <tr>
                        <th>Email</th><br>
                        <td><%=user.getEmail()%></td><br>
                    </tr>
                    <tr>
                        <th>Phone</th>
                         <td><%=user.getPhone()%></td>
                    </tr>
                    <tr>
                        <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Applied Job&nbsp;&nbsp;</th>
                         <td><%=user.getJobId()%></td>
                    </tr>
                  </table>
                </div>  
        </form>
    </body>
</html>