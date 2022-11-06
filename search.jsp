<%@page errorPage="error.jsp" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="MyPack.*" %>
<html>
    <head>
        <link href="style.css" rel="stylesheet"></link>
        <link href="newCss.css" rel="stylesheet"></link>
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
    <h3>Job Found!</h3>
    <table class="center">
      <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Salary</th>
        <th>Type</th>
        <th>Description</th>
      </tr>
      </table>
    <% 
            ArrayList jobList = (ArrayList)request.getAttribute("list");
            JobInfo job = null;
            for(int i=0; i<jobList.size(); i++){
                job = (JobInfo)jobList.get(i);
            %>
            <table class="center">
            <tr>
              <td><%=job.getId()%></td>
              <td><%=job.getTitle()%></td>
              <td><%=job.getSalary()%></td>
              <td><%=job.getType()%></td>
              <td><%=job.getDescription()%></td>
            </tr>
          </table>
            <%
            }
            %>  
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