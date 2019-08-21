package assignment1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBO {
 public static void printEmployee() {
	 
	 List<Employee> list = new ArrayList<Employee>();
	 int count=1;
		for(Employee o:list) {
		    
			System.out.printf("%-15s %-30s %-30s %-10s %-10s\n",count,o.getName(),o.getDepartment(),o.getAge(),o.getSalary());
		count++;
		}
 }
}
