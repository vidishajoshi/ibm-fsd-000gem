package comm.example.inter;

public class ArrayDemo {

	private int arr[]; //auto boxing
	//private Integer a =new Integer(value:10);
	private Integer a= 10;
	//int b=a.intValue();
	int b=a;//auto unboxing
	
	
	public ArrayDemo() {
		
	}
	
	public void createArray(int length) {
		arr = new int[length];
	}
	
	private char aar[];
	
	public void createArr(int length) {
		aar=new char[length];
		for(int i=0;i<aar.length;i++) {
			aar[i]=(char)('A'+i);
		}
	}
	
	public char[] getArray() {
		return aar;
	}
}
