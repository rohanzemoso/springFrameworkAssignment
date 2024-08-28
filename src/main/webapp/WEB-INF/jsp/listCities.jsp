<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title> Places You have Travelled </title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #ff9a9e, #fad0c4);
            color: #333;
            margin: 0;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h2 {
            font-size: 2.5em;
            margin-bottom: 20px;
            text-align: center;
        }
        ul {
            list-style-type: none;
            padding: 0;
            width: 100%;
            max-width: 600px;
        }
        li {
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 10px;
            margin-bottom: 15px;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: left;
        }
        a {
            text-decoration: none;
            color: #3498db;
            font-weight: bold;
            margin-top: 20px;
            padding: 12px 20px;
            border: 1px solid #3498db;
            border-radius: 15px;
            background-color: #fff;
            transition: all 0.3s;
        }
        a:hover {
            background-color: #3498db;
            color: #fff;
        }
        .actions {
            display: flex;
            justify-content: space-between;
            margin-top: 30px;
            width: 100%;
            max-width: 600px;
        }
    </style>
</head>
<body>
    <h2>Places Travelled In: ${country.name}</h2>
    <ul style="list-style-type: none; padding: 0; margin: 0; font-family: Arial, sans-serif;">
        <c:forEach var="city" items="${cities}">
            <li style="background-color: #f4f4f4; border: 1px solid #ddd; border-radius: 5px; padding: 10px; margin-bottom: 10px; transition: background-color 0.3s ease;"
                onmouseover="this.style.backgroundColor='#e0e0e0';"
                onmouseout="this.style.backgroundColor='#f4f4f4';">
                <span style="font-weight: bold; color: #674188">${city.content}</span> ||
                <span style="color: #C8A1E0;">Time: ${city.createdAt}</span>
            </li>
        </c:forEach>
    </ul>

    <div class="actions">
        <a href="addCityForm?countryId=${country.id}">Add Place</a>
        <a href="list">Go Back</a>
    </div>
</body>
</html>
