package myPackage;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class PlayerDAO {
	public static ArrayList<Player> getPlayer(Connection conn)
	{
		ArrayList <Player> playerList = new ArrayList<>();
		String sql = "select * from Players";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Player p = new Player(rs.getString(2), rs.getString(3));
				playerList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return playerList;
	}
	public static void insertPlayer(Connection conn, Player p) {
		try {
			String sql = "insert into Players values(default, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setString(2, p.getName());
			pst.executeUpdate();
			System.out.println("Data Inserted Successfully!");
			
		}
		catch (Exception e) {
			System.out.println("Error in inserting data" +e);
			
			
		}
	}
	
	
}
