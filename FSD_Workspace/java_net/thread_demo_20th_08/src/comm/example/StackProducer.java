package comm.example;

public class StackProducer implements Runnable {
	
	private MyStack myStack;

	public StackProducer(MyStack myStack) {
		super();
		this.myStack = myStack;
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++)
		{
			try {
				char c=(char)i;
				myStack.push((char) ('A'+i));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
