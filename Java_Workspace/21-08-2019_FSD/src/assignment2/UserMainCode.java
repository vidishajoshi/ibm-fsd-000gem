package assignment2;

public class UserMainCode {
private String password;


public UserMainCode() {
	super();
}



public UserMainCode(String password) {
	super();
	this.password = password;
}



public static Boolean checkPassword(String password) {
	if(password.length()>=8) {
		if(password.matches("(.*[A-Z].*)")) {
			if(password.matches("(.*[a-z].*)")) {
				if(password.matches("(.*[0-9].*)")&&password.matches( "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}else {
		return false;
	}
	
}
}
