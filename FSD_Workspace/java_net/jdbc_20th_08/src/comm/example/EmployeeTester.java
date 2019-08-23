package comm.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

public class EmployeeTester {
private static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		EmployeeService service=new EmployeeServiceImpl();
		
		  int choice=0; do { System.out.println("\n1.create employee.");
		  System.out.println("2.display all employee"); System.out.println("0:exit");
		  System.out.print("Your Choice: "); choice=scanner.nextInt(); switch (choice)
		  { case 1: System.out.print("EMployee ID: "); int id = scanner.nextInt();
		  System.out.print("Employee First Name: "); String firstName = scanner.next();
		  System.out.print("Employee Last Name: "); String lastName = scanner.next();
		  System.out.print("Employee Email: "); String email = scanner.next();
		  service.createEmployee(new Employee(id, firstName, lastName, email)); break;
		  case 2: List<Employee> list=service.getAllEmployees();
		  System.out.println("ID F_AME L_NAME EMAIL\n================="); for(Employee
		  e:list) {
		  System.out.printf("\n%d %s %s %s",e.getId(),e.getFirstName(),e.getLastName()
		  ,e.getEmail()); } System.out.println("\n"); break; case 0:
		  System.out.println("Bye!"); System.exit(0); break;
		  
		  default: System.out.println("Invalid choice."); break; }
		  
		  } while (choice!=0);
		  
		  
		 
		//service.getMetadata();
	}

}
