package assignment2;

import java.util.Scanner;

public class Main {
public static void main (String[] args) {
	String password;
	boolean result=false;
	
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter your password: ");
	password=sc.next();
	
	UserMainCode uc= new UserMainCode();
    result = uc.checkPassword(password);
    if(result==true) {
    	System.out.println("Valid Password!");
    }else {
    	System.out.println("Invalid Password!");
    }
}
}
