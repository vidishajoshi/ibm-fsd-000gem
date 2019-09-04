
package beans;

public class Employee {

	private int id;
	private String fname;
	private String lname;
	private String email;
	private String address;
	private int phone;
	private String city;
	private String state;

	
	
	public Employee() {
		super();
	}



	public Employee(int id, String fname, String lname, String email,String address,String city,String state,int phone) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address=address;
		this.city=city;
		this.state=state;
		this.phone=phone;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setPhone(int phone) {
		this.phone = phone;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	



	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", city=" + city + ", state=" + state + "]";
	}



	public String getAddress() {
		
		return address;
	}


	public String getCityState() {
		
		return " city : "+city+ ",State:  "+state;
	}



	public int getPhone() {
		
		return phone;
	}
	
	
	
	
}
