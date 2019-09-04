package tester;

import java.util.Scanner;

import crud_operation.CreateDetails;
import crud_operation.DeleteDetails;


public class Tester {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to this Instructor crud portal!!");
		System.out.println("1. Add new Instructor");
		System.out.println("2. Delete an Instructor");
        int i=sc.nextInt();
		switch(i) {
		case 1:{
			CreateDetails cd=new CreateDetails();
			cd.create();
		       break;
		       }
		case 2:{
			 DeleteDetails dd=new DeleteDetails();
			 dd.delete();
			   			   break;
		       }
		default:
		       {
			    System.out.println("Choose a valid option!! ");
			    System.out.println("Thank you");
			    
		       }
		}
	}

	}


