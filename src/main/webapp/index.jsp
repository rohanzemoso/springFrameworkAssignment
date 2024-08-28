<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wander Log</title>
    <style>
        body {
            background: linear-gradient(135deg,#fbc2eb,#a18cd1);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            color: #fff;
            text-align: center;
        }

        h2 {
            font-size: 2.5rem;
            margin-bottom: 20px;
        }

        a {
            /* Style the link as a button */
            display: inline-block;
            text-decoration: none;
            color: #fff;
            background-color: #333;
            padding: 15px 30px;
            border-radius: 25px;
            font-size: 1.2rem;
            font-weight: bold;
            transition: background-color 0.3s, transform 0.3s;
        }

        a:hover {
            background-color: #555;
            transform: scale(1.05);
        }

        a:active {
            background-color: #777;
            transform: scale(0.95);
        }

        #title{
            color: #674188;
        }
    </style>
</head>
<body>
    <h2><span id="title">Wander Log &nbsp;</span>: Travel Journal</h2>
    <a href="list">Enter the site</a>
</body>
</html>
