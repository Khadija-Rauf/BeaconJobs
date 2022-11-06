<%@page isErrorPage="true" %> 
<%@page import = "java.sql.SQLException" %> 
<%@page import = "java.lang.*" %> 
<html><head>
    <title>Error</title>
    <link href="style.css" rel="stylesheet"></link>
</head>
<body> 
    <form>
    <h2>Error Page</h2> 

    <h3 style="color: red;"> 
    <% if (exception instanceof SQLException) { %> 

    An SQL Exception 

    <% } else if (exception instanceof ClassNotFoundException){ %> 

    A Class Not Found Exception 

    <%} else { %> 
    A Exception 

    <% } %> 
    occured while interacting with the database</h3> 
    <h3 > Please Try Again Later! </h3> 

    </form>
</body>
</html> 