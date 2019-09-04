package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.Employee;


@WebServlet("/success.view")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println("<body>");
        out.println("<a href=\"list_emp.view\">List Employees</a>");
		Employee e = (Employee) request.getAttribute("SUCCESS");
		out.println("<table>");
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		out.println("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+"</td><td>"+e.getCountry()+"</td><td><a href=\"#\">Edit</a></td><td><a href=\"#\">Delete</a></td>");
		out.println("</tr></table>");
		
		out.println("</br><a href=\"add_employee.view\"><button>Back</button></a>");
		out.println("</body></html>");
		

	}
}