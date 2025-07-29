<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>all records from file</title>
</head>
<body>
<b>File ${fileName} contains:</b>
<%--<br>
${all_rec}--%>
<ul>
    <c:forEach var="rowitem" items="${all_rec}" varStatus="status">
        <li>line #${status.index+1}: ${rowitem}</li>
    </c:forEach>
</ul>
<a href="form">Go to input form</a>
</body>
</html>
