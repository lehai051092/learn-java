<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conversion Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .result-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        .result {
            font-size: 24px;
            color: #333;
            margin-top: 20px;
        }

        a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
        }

        a:hover {
            color: #45a049;
        }
    </style>
</head>
<body>
<div class="result-container">
    <h1>Conversion Result</h1>
    <p>Amount in USD: ${{ conversionResult.usd }}</p>
    <p class="result">Converted to VND: ${{ conversionResult.vnd }} VND</p>
    <a href="/">Convert Again</a>
</div>
</body>
</html>
