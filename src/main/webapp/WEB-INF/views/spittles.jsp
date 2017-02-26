<%--
  Created by IntelliJ IDEA.
  User: yudequan
  Date: 23/02/2017
  Time: 14:21
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
    <h1>Recent Spittles</h1>
    <c:forEach items="${spittleList}" var = "spittle">
        <li id="spittle_<c:out value="spittle.id"/> ">
            <div class ="spittleMessage">
                <c:out value="${spittle.message}"></c:out>
            </div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}"></c:out> </span>
                <span class="spittleLocation">(<c:out value="${spittle.latitude}"></c:out>, <c:out value="${spittle.longitude}"></c:out>)</span>
            </div>
        </li>
    </c:forEach>
</body>
</html>
