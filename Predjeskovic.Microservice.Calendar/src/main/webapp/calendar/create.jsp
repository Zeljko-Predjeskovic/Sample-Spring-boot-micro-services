<%@ page import="java.util.List" %>
<%@ page import="spg.pre.microservices.calendar.todoNote.NoteServiceImp" %>
<%@ page import="spg.pre.microservices.calendar.todoNote.NoteDto" %><%--
  Created by IntelliJ IDEA.
  User: Zeljko Predjeskovic
  Date: 14.09.2021
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giraffobot - Calendar</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src=https://code.jquery.com/jquery-1.12.4.js></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<div>
    <div style="display: flex">
        <div>
            <h1>Datum</h1>
            <form action="/Predjeskovic_Microservice_Calendar_war/create" method="post">
                <h4>Date</h4>
                <input name="date" id="datepicker" type="text">

                <input name="title" placeholder="title example"><p/>

                <input name="description" placeholder="Todo example"><p/>

                <button type="submit">create note</button>
            </form>
        </div>
        <div>
            <p>Notes</p>
            <c:forEach items="${notes}" var="item">
            <p>--------------Service--------------</p>
                ${item.id()}<p>
                ${item.description()}<p>
                ${item.title()}<p>
            </c:forEach>
        </div>


    </div>
    <script>
    $( function() {
        $.datepicker.setDefaults({
        onClose:function(date, inst){
            $("#selectedDateVal").html(date);
        }
    });

    $("#datepicker").datepicker();
    });</script>
</div>
</body>
</html>
