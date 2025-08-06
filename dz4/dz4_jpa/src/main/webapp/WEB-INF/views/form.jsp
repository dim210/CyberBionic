<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dz4_1 form</title>
</head>
<body>
<p>Form for save new car data</p>
<form id="input-form" action="addform" method="post" modelAttribute = ${form-record}>
    <p>Brand name: <input type="text" name="fBrandName"></p>
    <p>Model name: <input type="text" name="fModelName"></p>
    <p>Price: <input type="" name="fPrice"></p>

    <input type="submit" value="save new car data">
</form>
-----
<p>find Cars By BrandName</p>
<form id="input-form" action="findByBrandName" method="post" modelAttribute = ${form-record}>
    <p>Brand name: <input type="text" name="fBrandName"></p>
    <input type="submit" value="find Cars">
</form>
-----
<p>find Cars By BrandName & ModelName</p>
<form id="input-form" action="findByBrandNameAndModelName" method="post" modelAttribute = ${form-record}>
    <p>Brand name: <input type="text" name="fBrandName"></p>
    <p>Model name: <input type="text" name="fModelName"></p>
    <input type="submit" value="find Cars">
</form>
-----
<p>find Cars By price range</p>
<form id="input-form" action="findByPriceRange" method="post" modelAttribute = ${form-record}>
    <p>price from: <input type="" name="fFromPrice"></p>
    <p>price to: <input type="" name="fToPrice"></p>
    <input type="submit" value="find Cars">
</form>
-----
<p>delete Cars By id with @Query</p>
<form id="input-form" action="delById" method="post" modelAttribute = ${form-record}>
    <p>id for delete: <input type="number" name="fDelById"></p>
    <input type="submit" value="delete Car">
</form>
<a href="show-all">show all cars</a>
<br>
<a href="./">go to root</a>
</body>
</html>
