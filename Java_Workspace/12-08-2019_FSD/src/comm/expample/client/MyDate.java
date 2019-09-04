package comm.expample.client;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
	
		return day;
	}
	
	public int getMonth() {
		
		return month;
	}
	
	public int getYear() {
		
		return year;
	}
	
	public boolean setDay(int d) {
		if(d>30) {
			System.out.println("Day can't be greater than 30");
			System.exit(0);
		}
		day=d;
		return true;
	}
	public boolean setMonth(int m) {
		if(m>12) {
			System.out.println("month can't be greater than 12");
			System.exit(0);
		}
		month=m;
		return true;
	}
	public boolean setYear(int y) {
		if(y>2019 && y<1990) {
			System.out.println("wrong year");
			System.exit(0);
		}
		year=y;
		return true;
	}
	

}
