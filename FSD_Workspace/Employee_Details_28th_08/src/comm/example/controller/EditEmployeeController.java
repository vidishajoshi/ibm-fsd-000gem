package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.EmployeeDao;
import comm.example.dao.EmployeeDaoImpl;
import comm.example.model.Employee;

/**
 * Servlet implementation class EditEmployeeController
 */
@WebServlet("/edit_employee.do")
public class EditEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name,email,password,country;
	private int id;
	private List<String> errMsgs;
    
    public EditEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		EmployeeDao ed=new EmployeeDaoImpl();
		errMsgs=new LinkedList<String>();
		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
		country=request.getParameter("country");
		if(country.equals("Unknown"))
		{
			errMsgs.add("please select a valid season.");
		}
		
		String uid=request.getParameter("id");
		try {
			id=Integer.parseInt(uid);
			
		} catch (Exception e) {
			// TODO: handle exception
			errMsgs.add("id must be numeric");
		}
		
		
		name=request.getParameter("name");
		if(name.toString().length()<5)
		{
			errMsgs.add("name is too short.");
		}
		email=request.getParameter("email");
		password=request.getParameter("password");
		System.out.println(""+country+","+id+","+name+","+email+","+password);
		if(errMsgs.isEmpty())
		{
			Employee emp=new Employee(id, name,email,password,country);
			request.setAttribute("SUCCESS",emp );
			ed.editEmployee(new Employee(id, name,email,password,country));
			
			RequestDispatcher  view=request.getRequestDispatcher("success.view");
			view.forward(request, response);
		}
		else {
			request.setAttribute("ERROR", errMsgs);
			RequestDispatcher view=request.getRequestDispatcher("/add_employee.view");
			view.forward(request, response);
		}
		
	}
	}