package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyConnectionFactory;


/**
 * Servlet implementation class ListAllLeague
 */
@WebServlet("/list_all_league.view")
public class ListAllLeague extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResultSet resultSet = null;
       
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
	Connection connection = MyConnectionFactory.getMySqlConnectionForHr();
    Statement stmt=connection.createStatement();
	resultSet = stmt.executeQuery("select * from league");
	while(resultSet.next()) {
		out.println(resultSet.getObject(1).toString()+","+resultSet.getObject(2).toString()+","+resultSet.getObject(3)+","+resultSet.getObject(4));
	}
		
	}


}
