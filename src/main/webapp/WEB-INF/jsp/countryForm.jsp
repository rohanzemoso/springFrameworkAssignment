<html>
<head>
    <title>User Form</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #a18cd1, #fbc2eb);
            color: #333;
            margin: 0;
            padding: 40px;
            display: flex;
            flex-direction:column;
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
            background-color: #F7EFE5;
            padding: 30px;
            border-radius: 40px;
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
            border-radius: 15px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 12px 20px;
            border: none;
            border-radius: 20px;
            background-color: #674188;
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
        #h2{
            margin-left:20px;
        }

        #backToList{
            left-margin:30px;
            color:#674188;
            text-decoration:none;
        }
    </style>
</head>
<body>
    <div id="container">
        <h2 id="h2"> &nbsp; &nbsp;Travelling Journal</h2>
            <form action="save" method="post">
                <input type="hidden" name="id" value="${country.id}"/>
                <label for="name">Country Name:</label>
                <input type="text" id="name" name="name" value="${country.name}" required/>
                <label for="travelledFrom">Travelled From:</label>
                <input type="text" id="travelledFrom" name="travelledFrom" value="${country.travelledFrom}" required/>
                <input type="submit" value="Add Country"/>
            </form>

            <a href="list" id="backToList">Back to List</a>
    </div>
</body>
</html>
