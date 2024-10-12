<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UEFA Champions League - Player Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            color: #0a328e;
        }
        form {
            background-color: #f0f0f0;
            padding: 20px;
            border-radius: 5px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #0a328e;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0b4cb3;
        }
    </style>
</head>
<body>
    <h1>UEFA Champions League</h1>
    <h2>Player Registration</h2>

    <form action="PlayersServlet" >
        <label for="player_name">Player Name:</label>
        <input type="text" id="player_name" name="player_name" required>

        <label for="team_name">Team Name:</label>
        <input type="text" id="team_name" name="team_name" required>

        <input type="submit" value="Submit Player Details">
    </form>

    <p><a href="view_player.jsp">View Registered Players</a></p>
</body>
</html>