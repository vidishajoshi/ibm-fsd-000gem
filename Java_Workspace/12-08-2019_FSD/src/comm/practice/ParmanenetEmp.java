package comm.practice;

public class ParmanenetEmp extends Employee {

	private int salary;
	
	public ParmanenetEmp() {
		
	}
	
	public ParmanenetEmp(int sal) {
		super("1","Div","ken","Adminstration");
		this.salary=sal;
   
	}
	

	@Override
	protected String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails()+"salary: "+salary;
	}
	
	
}
