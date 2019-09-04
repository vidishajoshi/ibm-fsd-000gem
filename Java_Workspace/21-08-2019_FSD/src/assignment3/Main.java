package assignment3;

import java.util.Scanner;

public class Main {
public static void main (String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter no of contacts:");
	int count= sc.nextInt();
	for(int i=1;i<=count;i++) {
		System.out.println("enter contact"+i+"details:");
		System.out.println("enter name:");
		String name=sc.next();
		System.out.println("enter address:");
		String address=sc.next();
		System.out.println("enter email:");
		String email=sc.next();
		System.out.println("enter mobile:");
		Long mobile=sc.nextLong();
	}
	
	Contact co = new Contact();
	int res = co.compareTo(co);
	if(res==0) {
		System.out.println("numbers are equal");
	}else if(res=1)
}
}
