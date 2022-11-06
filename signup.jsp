<%@page errorPage="error.jsp" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="style.css" rel="stylesheet"></link>
        <script>
        function validate(){
            if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.account.email.value))){
                alert("Please enter a valid email address.");
                return false;
            }
            else if(document.account.password.value != document.account.confirm_password.value){
                alert("Password and Confirm Password doesn't match");
                return false;
            }
		    else
			    return true;		
            }
        </script>
    </head>
    <body>
        <form name="account" action="ControllerServlet" onsubmit="return validate()">
            <div class="container">
            <h1><b>Create an Account</b></h1>
            <img src="avatar.png" alt="AVATAR"><br>
            <input type="text" placeholder = "Email" name="email" required/><br>
            <input type="text" placeholder = "Username" name="username" required/><br>
            <input type="password" placeholder = "Password" name="password" required/><br>
            <input type="password" placeholder="Confirm Password" name="confirm_password" required/><br>
            <input type="text" placeholder = "Phone" name="phone" /><br>
            <input type="radio" id="admin" name="user_type" value="Admin" required>
	        <label for="admin">Admin</label><br>
            <input type="radio" id="user" name="user_type" value="User" required>
            <label for="user">User</label><br>
            <button type="submit" value="signup" name="action">Sign Up</button>
            </div>
        </form>
    </body>
</html>