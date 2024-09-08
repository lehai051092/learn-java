<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Sandwich Condiments</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f7f7f7;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .container {
      background-color: #fff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      width: 100%;
    }

    h1 {
      font-size: 24px;
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }

    .checkbox-group {
      display: flex;
      justify-content: space-around;
      margin-bottom: 20px;
    }

    .checkbox-group label {
      font-size: 16px;
      color: #555;
      display: flex;
      align-items: center;
      cursor: pointer;
    }

    .checkbox-group input[type="checkbox"] {
      margin-right: 10px;
      transform: scale(1.2);
    }

    button {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      display: block;
      width: 100%;
      font-size: 16px;
    }

    button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Sandwich Condiments</h1>
  <form action="/save" method="POST">
    <div class="checkbox-group">
      <c:forEach var="condiment" items="${allCondiments}">
        <label>
          <input type="checkbox" name="condiment" value="${condiment}"
           <c:if test="${selectedCondiments != null && selectedCondiments.contains(condiment)}">checked</c:if> />
          ${condiment}
        </label>
      </c:forEach>
    </div>
    <button type="submit">Save</button>
  </form>

  <c:if test="${not empty selectedCondiments}">
    <h3>You selected:</h3>
    <ul>
      <c:forEach var="selected" items="${selectedCondiments}">
        <li>${selected}</li>
      </c:forEach>
    </ul>
  </c:if>
</div>
</body>
</html>
