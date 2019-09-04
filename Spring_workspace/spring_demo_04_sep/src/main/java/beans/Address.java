package beans;

public class Address {
private String addressline1;
private String addressline2;


public Address() {
	super();
}
public Address(String addressline1, String addressline2) {
	super();
	this.addressline1 = addressline1;
	this.addressline2 = addressline2;
}
@Override
public String toString() {
	return "Address [addressline1=" + addressline1 + ", addressline2=" + addressline2 + "]";
}


}
