package beans;

public class Student {
private int id;
private String fname;
private String lname;
private String email;
private Address add;
public Student() {
	super();
}
public Student(int id, String fname, String lname, String email, Address add) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.email = email;
	this.add = add;
}
@Override
public String toString() {
	return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", add=" + add + "]";
}



}
