<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Information</title>
</head>
<body>
<h1>Customer Information</h1>
<form action="/customers/${customer.id}" method="post">
    <input type="hidden" name="id" value="${customer.id}">
    <p>Name: <input type="text" name="name" value="${customer.name}"></p>
    <p>Email: <input type="text" name="email" value="${customer.email}"></p>
    <p>Address: <input type="text" name="address" value="${customer.address}"></p>
    <p><input type="submit" value="Update"></p>
</form>
</body>
</html>
