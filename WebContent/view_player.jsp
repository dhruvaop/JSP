<%@ page import="myPackage.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Champions League Top Players</title>
</head>
<body>
    <h1>Champions League Top Players</h1>
    <%
    	Connection conn = DBConnection.getConnection();
    	ArrayList<Player> myPlayers = PlayerDAO.getPlayers(conn);
    	for(int player: myPlayers)
    	{
    		out.println(player.getName() + " - " + player.getTeam());
    	}
    %>
    
    <% if (!myPlayers.isEmpty()) { %>
        <ul>
        <% for (Player player : myPlayers) { %>
            <li><%= player.getName() %> - <%= player.getTeam() %></li>
        <% } %>
        </ul>
    <% } else { %>
        <p>No players found.</p>
    <% } %>
</body>
</html>