<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>all data</title>
</head>
<body>
<b>${headerLine}</b>
<ul>
    <c:forEach var="rowitem" items="${list_rec}" varStatus="status">
        <li>
        <!--line #${status.index+1}:-->
        ${rowitem} <a href="delete/${rowitem.getId()}">delete by id: ${rowitem.getId()} </a>
        </li>
    </c:forEach>
</ul>
<form id="addnew-form" action="form" method="get">
    <input type="submit" value="To form">
</form>
<br>
<a href="./">go to root</a>
</body>
</html>
