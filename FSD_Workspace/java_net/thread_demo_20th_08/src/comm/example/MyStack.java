package comm.example;

public class MyStack {
	
	private int index=-1;
	private static final int MAX=26;
	private char[] info=new char[MAX];
	
	public synchronized void push(char item) throws InterruptedException
	{
		if(index==MAX)
		{
			System.out.println("stack ovrerflow");
			
			wait();
			
		}
		info[++index]=item;
		System.out.println("pushed: "+item);
		notify();
	}
	
	public synchronized char pop() throws InterruptedException
	{
		if(index==-1)
		{
			System.out.println("stack underflow.");
			wait();
		}
		
		notifyAll();
		return info[index--];
		
	}

}
