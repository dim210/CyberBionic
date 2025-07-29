<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dz3_1 form</title>
</head>
<body>
<p>Please, input some data</p>
<form id="input-form" action="form" method="post" modelAttribute = ${form-record}>
    <p>Some number: <input type="number" name="id"></p>
    <p>Some text: <input type="text" name="text"></p>
    <input type="submit" value="save data to file">
</form>
</body>
</html>
