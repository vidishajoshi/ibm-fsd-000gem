package comm.example;

import comm.example.inter.ArrayDemo;
import comm.example.inter.Dog;
import comm.example.inter.LivingThings;
import comm.example.inter.Messaging;

public class Tester {
	private int val;
	private int temp=0;
	public boolean searchNum(Integer arr[],int i){
		for (int j = 0; j < 5; j++) {
			if(arr[j]==i) {
				val=arr[j];
				System.out.println("value is : "+val);
				return true;
			}
			else {
				System.out.println("sorry not found");
              return false;
			}
		}
	}
		
		public Integer[] sortAr(Integer arr1[]) 
		{
			for(int k=0;k<5;k++) {
			    if(arr1[k]>arr1[k+1]) {
			    	temp=arr1[k];
			    	arr1[k]=arr1[k+1];
			    	arr1[k+1]=temp;
				}else {
					continue;
				}
			}
			
			return arr1;
		}
    	
		
	
	
	public static void main(String[] args) {
		/*Flyer flyer= new Bird();
		flyer.takeOff();
		flyer=new SuperMan();
		flyer.takeOff();*/
	//dynamic method dispatching
	/*
	Model m=new Line(0,20);
	Model m2=new Line(39,49);
	Model m1=new Line(0,20);
	System.out.println("are greater:"+m.isGreater(m, m1));
	System.out.println("are less:"+m.isLess(m, m1));	
	System.out.println("aRe equal :"+m.isEqual(m, m1));
	System.out.println("is greater : "+m2.greater(20));
	*/
	/*
	 * 	LivingThings l = new Dog("tom","dog");
	l.walk();
	Dog d=new Dog("jims","sjlkdj");
	d.createLivingThings();*/
	/*
		Messaging m= Messaging.createMessagingObject();
		Messaging m1=Messaging.createMessagingObject("test");
		String name=m.toString();
		System.out.println(name);
	
	*/
		/*
		ArrayDemo ad = new ArrayDemo();
		ad.createArr(26);
		char [] aar = ad.getArray();
		System.out.println(aar);*/
		
		int arr[]= {
				100,1,-20,30,0};
	
		Tester t=new Tester();
		
		Integer newarr[]=t.sortAr(arr);	}

}
