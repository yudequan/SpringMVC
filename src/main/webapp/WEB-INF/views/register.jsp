<%--
  ~ Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
  ~ Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan. 
  ~ Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna. 
  ~ Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus. 
  ~ Vestibulum commodo. Ut rhoncus gravida arcu. 
  --%>

<%--
  Created by IntelliJ IDEA.
  User: yudequan
  Date: 24/02/2017
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Register</h1>

<form action = "<c:url value="/spitter/register" />" method="POST">
    First Name: <input type="text" name="firstName" /><br/>
    Last Name: <input type="text" name="lastName" /><br/>
    Email: <input type="email" name="email" /><br/>
    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Register" />
</form>
</body>
</html>

