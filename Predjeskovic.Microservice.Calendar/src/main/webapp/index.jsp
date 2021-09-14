<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: Zeljko Predjeskovic
  Date: 14.09.2021
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giraffobot</title>
</head>
<body>
<div>
    <form action="/Predjeskovic_Microservice_Calendar_war/" method="post">
        <input id="date" type="date">
        <button type="submit">new note</button>
    </form>
</div>
</body>
</html>
