package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyConnectionFactory;
import comm.example.model.League;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete_servlet.view")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResultSet resultSet = null;
       
    
 /**
  * @see HttpServlet#HttpServlet()
  */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		String id=request.getParameter("id");
		int nid=Integer.parseInt(id);
		//out.println(League.serialVersionUID);
	    Connection connection = MyConnectionFactory.getMySqlConnectionForHr();
	    PreparedStatement stmt=connection.prepareStatement("delete from league where uid=?");
	    stmt.setInt(1,nid);
	    stmt.executeUpdate();
	    
	    RequestDispatcher  view=request.getRequestDispatcher("add_league.do");
		view.forward(request, response);
	            	    
	
	}

}
