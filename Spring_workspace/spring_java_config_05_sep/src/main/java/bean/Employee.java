package bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

private int id;
@Value("dev")
private String fname;
@Value("singh")
private String lname;
@Value("devd@g.com")
private String email;

public Employee() {
	super();
}

public Employee(String fname, String lname, String email) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.email = email;
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
	return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
}




}
