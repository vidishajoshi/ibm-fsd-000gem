package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.EmployeeDao;
import comm.example.dao.EmployeeDaoImpl;
import comm.example.model.Employee;

/**
 * Servlet implementation class EditEmployee
 */

@WebServlet(
		urlPatterns = { "/edit_emp.view" }, 
		initParams = { 
				@WebInitParam(name = "country_list", value = "Select,USA,UK,India,France,SA")
		})
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String sList;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		sList=config.getInitParameter("country_list");
	}
       
    public EditEmployee() {
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
   		List<Employee> eList=new ArrayList<Employee>();
   		EmployeeDao de=new EmployeeDaoImpl();
   		String newid=request.getParameter("id");
   		int id=Integer.parseInt(newid);
   		eList=de.getEmployeeById(id);
   		out.println("<html><head>");
   		out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n" + 
   				"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n" + 
   				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
   				"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n" + 
   				"");
   		out.println("</head>");
   		
   		out.println("<body>");
   		out.println("<a href=\"list_emp.view\">List Employees</a>");
   		for(Employee l:eList) {
   		
   		out.println("<form action='edit_employee.do' method='post'>");
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"id\">Id :</label>");
   		out.println("<input type=\"number\" class=\"form-control\" name=\"id\" value="+l.getId()+" placeholder=\"Enter ID\">");
   		out.println("</div>");
   		
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"Name\">Name :</label>");
   		out.println("<input type=\"text\" class=\"form-control\" name=\"name\" value="+l.getName()+" placeholder=\"Enter Name\">");
   		out.println("</div>");
   		
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"Email\">Email :</label>");
   		out.println("<input type=\"email\" class=\"form-control\" name=\"email\" aria-describedby=\"emailHelp\" value="+l.getEmail()+" placeholder=\"Enter Email\">");
   		out.println("</div>");
   		
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"Password\">Password :</label>");   
   		out.println("<input type=\"password\" class=\"form-control\" name=\"password\" value="+l.getPassword()+" placeholder=\"Enter password\">");
   		out.println("</div>");
   		//String sList=getServletConfig().getInitParameter("season-list");
   		String arrSList[]=sList.split(",");
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"Country\">Country :</label>");
   		out.println("<select name='country'><option value='select'>"+l.getCountry()+"</option>");
   		for(String str:arrSList)
   		{
   			out.println("<option value='"+str+"'"+">"+str+"</option>");
   		}
   		out.println("</div>");
   		out.print("<div><input type=\"submit\" class=\"btn btn-primary\" value=\"Submit\"></form></div>");
   		out.println("</br><a href=\"main_page.html\"><button>Back</button></a>");
   		out.println("</body></html>");
   		}
}
}