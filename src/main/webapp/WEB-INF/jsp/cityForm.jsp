<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Add Note</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #ffecd2, #fcb69f);
            color: #333;
            margin: 0;
            padding: 40px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        #container{
            display:flex;
            flex-direction: row;
            gap: 40px;
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
        textarea {
            width: calc(100% - 16px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            resize: vertical;
            font-family: inherit;
            font-size: 1em;
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

        #country_span{
            color: #A2CA71;
        }
    </style>
</head>
<body>
    <div id="container">
        <h2>Cities Travelled In: <span id="country_span">${city.country.name}</span></h2>
            <form action="saveCity" method="post">
                <textarea name="content" placeholder="Enter cities or places you travelled." rows="5">${city.content}</textarea><br>
                <input type="hidden" name="country.id" value="${city.country.id}" />
                <input type="submit" value="Save Place" />
            </form>
    </div>
</body>
</html>
