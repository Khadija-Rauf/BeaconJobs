<%@page errorPage="error.jsp" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="style.css" rel="stylesheet"></link>
    </head>
    <body>
        <% String value = (String)request.getAttribute("key");%>
        <form action="ControllerServlet">
            <h4 style="color:red ;"><%=value%></h4>
            <div class="container">
            <h1><b>Welcome</b></h1>
            <img src="avatar.png" alt="AVATAR"><br>
            <input type="text" placeholder = "Username" name="username" required/><br>
            <input type="password" placeholder="Password" name="password" required/><br>
            <button type="submit" value="login" name="action">Login</button>
            <span class="txt1">Don't have an account?</span>
            <a href="signup.jsp" class="txt2">Sign up</a>
            </div>
        </form>
    </body>
</html>