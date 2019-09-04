package comm.practice;

public class Employee {
   private String empId;
   private String firstName;
   private String lastName;
   private String dept;
   
   public Employee() {
	   
   }
   
   public Employee(String id, String fName, String lName,String dept) {
	   this.empId=id;
	   this.firstName=fName;
	   this.lastName=lName;
	   this.dept=dept;
   }
   
   protected String getDetails() {
	    return "Emp Id: "+empId+", First Name: "+firstName+", Last Name:"+lastName+
	    		"Department: "+dept;
   }
}
