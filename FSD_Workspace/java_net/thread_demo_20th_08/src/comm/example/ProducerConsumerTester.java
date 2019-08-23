package comm.example;

public class ProducerConsumerTester {
	
	private static MyStack myStack=new MyStack();

	public static void main(String[] args) {
		
		StackProducer producer=new StackProducer(myStack);
		StackConsumer consumer=new StackConsumer(myStack);
		Thread t1=new Thread(producer,"-producer-");
		Thread t2=new Thread(consumer,"-consumer-");
		t1.start();
		t2.start();
		

	}

}
