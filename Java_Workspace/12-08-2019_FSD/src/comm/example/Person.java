package comm.example;

public class Person {
	private String name;
	private String address;
	
	public Person() {
		
	}
	
	public Person(String name , String address) {
		this.name=name;
		this.address=address;
		
	}

	
	protected String getDetails() {
		return "name :"+name+", address:"+address;
	}
}
