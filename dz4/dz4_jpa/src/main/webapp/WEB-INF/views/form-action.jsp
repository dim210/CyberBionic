<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result (form-action)</title>
</head>
<body>
<p>${mess}</p>
id: ${out_rec.id}, <b>${out_rec.toString()}</b>

<form id="addnew-form" action="form" method="get">
    <input type="submit" value="Back to form">
</form>
<form id="showall-form" action="show-all" method="get">
    <input type="submit" value="show all data">
</form>
<a href="./">go to root</a>
</body>
</html>
