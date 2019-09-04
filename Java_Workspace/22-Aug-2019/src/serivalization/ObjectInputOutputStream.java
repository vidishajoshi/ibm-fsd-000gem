package serivalization;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStream {

	public static void main(String[] args) {
		
		
		Employee emp = new Employee("10","mark",20000,"mumbai");
		//Student stu=new Student(10,"student");
		System.out.println("Employee to write is: "+emp);
		
		try {
			FileOutputStream out= new FileOutputStream("emp.out");
			ObjectOutputStream oos=new ObjectOutputStream(out);
			oos.writeObject(emp);
			oos.flush();
		}catch(Exception e) {
			System.out.println("Problem serializing: "+e);
		}
		
		try {
			FileInputStream in= new FileInputStream("emp.out");
			ObjectInputStream ois=new ObjectInputStream(in);
			emp=(Employee)(ois.readObject());
		}catch(Exception e) {
			System.out.println("Problem serializing: "+e);
		}
		
		System.out.println("Employee read is :"+emp);

	}

}
