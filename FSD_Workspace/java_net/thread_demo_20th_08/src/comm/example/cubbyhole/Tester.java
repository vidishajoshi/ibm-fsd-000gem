package comm.example.cubbyhole;

public class Tester {
	
	public static void main(String args[])
	{
		CubbyHole c=new CubbyHole();
		Thread t1=new Thread(new Producer(c, 1));
		Thread t2=new Thread(new Consumer(c, 1));
		Thread t3=new Thread(new Producer(c, 2));
		Thread t4=new Thread(new Consumer(c, 2));
		t1.start();
		t2.start();
		/*
		 * t3.start(); t4.start();
		 */
	}

}
