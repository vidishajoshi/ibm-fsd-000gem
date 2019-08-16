package comm.practice;

public class TesterClass extends ParmanenetEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Employee t=null;
        t= new ParmanenetEmp(9876);
        System.out.println(" details of parmanenet emp :"+t.getDetails());
        
        Employee t1= null;
        t1=new TempEmp(87);
        System.out.println("details of Temperory emp : "+t1.getDetails());
	}

}
