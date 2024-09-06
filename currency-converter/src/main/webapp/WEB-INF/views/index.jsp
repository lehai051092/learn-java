<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USD to VND Converter</title>
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

        .converter-container {
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

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            background-color: #45a049;
        }

        .result {
            margin-top: 20px;
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>
<div class="converter-container">
    <h1>USD to VND Converter</h1>
    <form action="/convert" method="post">
        <label for="rate">Exchange Rate (VND per 1 USD):</label>
        <input type="number" id="rate" name="rate" placeholder="Enter exchange rate" required>

        <label for="usd">Amount in USD:</label>
        <input type="number" id="usd" name="usd" placeholder="Enter amount in USD" required>

        <button type="submit">Convert</button>
    </form>
</div>
</body>
</html>
