<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result (form-action)</title>
</head>
<body>
received record: <b>id:</b> ${out_rec.id}, <b>text:</b> ${out_rec.text}
<p>${mess}!</p>
<%--<a href="form">add new row</a>--%>
<form id="addnew-form" action="form" method="get">
    <input type="submit" value="add new data">
</form>
<form id="showall-form" action="show-all" method="get">
    <input type="submit" value="show saved data">
</form>
</body>
</html>
