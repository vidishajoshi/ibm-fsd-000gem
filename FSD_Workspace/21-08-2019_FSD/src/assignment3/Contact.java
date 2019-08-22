package assignment3;

public class Contact implements Comparable<Object> {
private String name;
private String email;
private String address;
private Long mobile;
public Contact(){
	super();
}
public Contact(String name, String email, String address, Long mobile) {
	super();
	this.name = name;
	this.email = email;
	this.address = address;
	this.mobile = mobile;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Long getMobile() {
	return mobile;
}
public void setMobile(Long mobile) {
	this.mobile = mobile;
}
@Override
public int compareTo(Object o) {
	Contact con= (Contact)o;
	if(this.mobile==con.mobile) {
		return 0;
	}else if(this.mobile>con.mobile){
		return 1;
		
	}else {
		return -1;
}
}
}
