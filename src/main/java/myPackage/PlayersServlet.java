package myPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/PlayersServlet")
public class PlayersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PlayersServlet() {
        super();
    }
    
    @Override
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
    	String name = request.getParameter("player_name");
    	String team = request.getParameter("team_name");
    	Connection conn = DBConnection.getConnection();
    	
    	
    	
    	Player newPlayer = new Player(name, team);
    	PlayerDAO.insertPlayer(conn, newPlayer);
    	try {
    		conn.close();
    		System.out.println("Connection Closed.");
    		
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    	
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view_player.jsp");
    	requestDispatcher.forward(request, response);
    	
    	
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	service(request, response);
    	
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
        
    }
}