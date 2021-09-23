<%@ page import="java.util.List" %>
<%@ page import="spg.pre.microservices.calendar.todoNote.NoteServiceImp" %>
<%@ page import="spg.pre.microservices.calendar.todoNote.NoteDto" %>
<%@ page import="spg.pre.microservices.calendar.todoNote.NoteService" %>
<%@ page import="spg.pre.microservices.calendar.fileAccess.Note" %>
<%@ page import="java.util.UUID" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
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
<div style="display: grid; justify-content: center;font-family: 'Calibri Light'">
        <div style="margin: auto; grid-row: 1;">
            <div style="margin: 1px;">
                <form action="/Predjeskovic_Microservice_Calendar_war/create" method="post">
                    <span>Datum</span>
                    <input name="date" id="datepicker" placeholder="MM/dd/yyyy" type="text"><p><p/>
                    <span>Title</span>
                    <input name="title" placeholder="title example"><p></p>
                    <span>Todo</span>
                    <input name="description" placeholder="Todo example"><p></p>

                    <button type="submit">create note</button>
                </form>
            </div>
        </div>
        <div style="margin: 10%; grid-row: 2; border:2px solid; border-radius: 10px ">
            <h2>Notes</h2>
            <div style="display: flex; flex-wrap:wrap;margin: 1px;">
                <c:forEach items="${notes}" var="item">
                <div style="margin: 1px">
                    <table style="width:100%; border: 1px solid">
                        <tr>
                            <td style="border-bottom: 1px solid">${item.title()}</td>
                            <td style="border-bottom: 1px solid">${item.calendarDate()}</td>
                        </tr>
                        <tr>
                            <td style="overflow-x:auto;">${item.description()}</td>
                        </tr>
                        <tr>
                            <a href="/Predjeskovic_Microservice_Calendar_war/deleteNote/${item.id()}">delete</a>
                        </tr>
                    </table>
                </div>
                </c:forEach>
            </div>
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
</body>
</html>
