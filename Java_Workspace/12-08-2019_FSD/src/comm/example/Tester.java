package comm.example;
import comm.expample.client.MyDate;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyDate myDay = new MyDate();
         myDay.setDay(23);
        myDay.setMonth(4);
        myDay.setYear(1997);
        System.out.println("Day : "+myDay.getDay());
        System.out.println("Day : "+myDay.getMonth());
        System.out.println("Day : "+myDay.getYear());
	}

}
