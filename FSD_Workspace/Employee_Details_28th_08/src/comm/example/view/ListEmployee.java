package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.EmployeeDao;
import comm.example.dao.EmployeeDaoImpl;
import comm.example.model.Employee;

@WebServlet("/list_emp.view")
public class ListEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}

   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}
   	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

   		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		EmployeeDao ed=new EmployeeDaoImpl();
   		List<Employee> eList=new ArrayList<Employee>();
   		eList=ed.getAllEmployees();
   		out.println("<table>");
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
   		for(Employee l:eList) {
   		
		out.println("<tr><td>"+l.getId()+"</td><td>"+l.getName()+"</td><td>"+l.getEmail()+"</td><td>"+l.getPassword()+"</td><td>"+l.getCountry()+"</td><td><a href=\"edit_emp.view?id="+l.getId()+"\">Edit</a></td><td><a href=\"delete_emp.view?id="+l.getId()+"\">Delete</a></td>");
		
   		}
   		out.println("</tr></table>");
		out.println("</br><a href=\"main_page.html\"><button>Back</button></a>");
   		
   		
   	}
}
