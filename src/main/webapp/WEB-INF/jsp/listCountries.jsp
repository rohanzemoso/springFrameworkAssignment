<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Country List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #a18cd1, #fbc2eb);
            color: #333;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h2 {
            font-size: 2.5em;
            margin-bottom: 20px;
        }
        table {
            width: 90%;
            max-width: 800px;
            border-collapse: collapse;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
        }
        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #6a89cc;
            color: #fff;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        a {
            color: #2980b9;
            font-weight: bold;
            transition: color 0.3s;
            text-decoration:none;
        }
        a:hover {
            color: #1abc9c;
        }
        form {
            display: inline-block;
        }
        input[type="submit"] {
            background-color: #674188;
            color: #fff;
            border: none;
            padding: 8px 12px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #c0392b;
        }
        .add-new {
            margin-top: 20px;
            font-size: 1.2em;
            text-decoration: none;
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .add-new:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h2>Countries Travelled</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Travelled On</th>
            <th>From</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="country" items="${countries}">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
                <td>${country.formattedCreatedAt}</td>
                <td>${country.travelledFrom}</td>
                <td>
                    <a href="updateForm?countryId=${country.id}">Update</a>
                    |
                    <a href="listCities?countryId=${country.id}">View Cities</a>
                    |
                    <form action="delete" method="post">
                        <input type="hidden" name="countryId" value="${country.id}"/>
                        <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this Country?');"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="form" class="add-new">Add New Country</a>
</body>
</html>
