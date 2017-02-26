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
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spittle List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />"/>
</head>
<body>
    <h1>Find One</h1>
    <div class = "spittleView">
    <div class ="spittleMessage">
        <c:out value="${spittle.message}"></c:out>
    </div>
    <div>
        <span class="spittleTime"><c:out value="${spittle.time}"></c:out> </span>
        <span class="spittleLocation">(<c:out value="${spittle.latitude}"></c:out>, <c:out value="${spittle.longitude}"></c:out>)</span>
    </div>
    </div>
</body>
</html>
