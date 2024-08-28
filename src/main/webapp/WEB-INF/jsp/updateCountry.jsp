<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Update Country</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f093fb, #f5576c);
            color: #333;
            margin: 0;
            padding: 40px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h2 {
            font-size: 2.5em;
            margin-bottom: 20px;
            text-align: center;
        }
        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"] {
            width: calc(100% - 16px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            background-color: #3498db;
            color: #fff;
            font-size: 1em;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s;
            margin-top: 20px;
        }
        input[type="submit"]:hover {
            background-color: #2980b9;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #3498db;
            font-weight: bold;
            transition: color 0.3s;
        }
        a:hover {
            color: #1abc9c;
        }
    </style>
</head>
<body>
    <h2>Update Country</h2>
    <form action="save" method="post">
        <input type="hidden" name="id" value="${country.id}" placeholder="ID" readonly/>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${country.name}" required/>
        <label for="travelledFrom">travelledFrom:</label>
        <input type="text" id="travelledFrom" name="travelledFrom" value="${country.travelledFrom}" required/>
        <input type="submit" value="Update"/>
    </form>
    <a href="list">Back to List</a>
</body>
</html>
