
package comm.example;

public class Calculator {
	
	private int x;
	private int y;
	private int result;
	public Calculator(int x,int y) {
		super();
		this.x=x;
		this.y=y;
	}

	public int addMethod() {
		return x+y;
	}
	
	public int greaterThan(){
		if(x>y) {
			return 1;
		}else {
			return -1;
		}
	}
}
