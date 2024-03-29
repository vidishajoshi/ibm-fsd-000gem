package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/add_employee.view" }, 
		initParams = { 
				@WebInitParam(name = "country_list", value = "Select,USA,UK,India,France,SA")
		})
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String sList;       
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		sList=config.getInitParameter("country_list");
	}

    public AddEmployeeServlet() {
        super();
   }

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doProcess(request, response);
   	}

   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   		doProcess(request, response);
   	}
   	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		
   		out.println("<html><head>");
   		out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n" + 
   				"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n" + 
   				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
   				"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n" + 
   				"");
   		out.println("</head>");
   		
   		out.println("<body>");
   		out.println("<a href=\"list_emp.view\">List Employees</a>");
   		
   		@SuppressWarnings("unchecked")
   		List<String> err=(List<String>) request.getAttribute("ERROR");
   		if(err!=null)
   		{
   			for(String s:err)
   			{
   				out.println("<font color='red'>"+s+"</font><br/>");
   			}
   		}
   		
   		out.println("<form action='add_emp.do' method='post'>");
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"id\">Id :</label>");
   		out.println("<input type=\"number\" class=\"form-control\" name=\"id\" placeholder=\"Enter ID\">");
   		out.println("</div>");
   		
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"Name\">Name :</label>");
   		out.println("<input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"Enter Name\">");
   		out.println("</div>");
   		
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"Email\">Email :</label>");
   		out.println("<input type=\"email\" class=\"form-control\" name=\"email\" aria-describedby=\"emailHelp\" placeholder=\"Enter Email\">");
   		out.println("</div>");
   		
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"Password\">Password :</label>");
   		out.println("<input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Enter password\">");
   		out.println("</div>");
   		//String sList=getServletConfig().getInitParameter("season-list");
   		String arrSList[]=sList.split(",");
   		out.println("<div class=\"form-group\">");
   		out.println("<label for=\"Country\">Country :</label>");
   		out.println("<select name='country'><option value='select'>Select</option>");
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
