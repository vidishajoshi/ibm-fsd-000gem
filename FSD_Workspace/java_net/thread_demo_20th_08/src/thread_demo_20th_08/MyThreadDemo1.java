package thread_demo_20th_08;

public class MyThreadDemo1 implements Runnable {

	public static void main(String[] args) {
		
		
		
		MyThreadDemo1 myThread1=new MyThreadDemo1();
		MyThreadDemo2 myThreadDemo2=new MyThreadDemo2();
		Thread t1=new Thread(myThread1);
		Thread t2=new Thread(myThreadDemo2);
		t1.start();
		System.out.println(t1.isAlive());
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t2.isAlive());

	}

	@Override
	public void run() {
		try {
			for(int i=0;i<20;i++)
			{
				System.out.println("i==>: "+i);
				
				if(i==10)
				{
					Thread.sleep(2000);
					
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
