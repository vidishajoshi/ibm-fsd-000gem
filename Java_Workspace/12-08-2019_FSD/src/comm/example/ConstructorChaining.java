package comm.example;

public class ConstructorChaining {
	private int d;
	private int m;
	private int y;
	
	public ConstructorChaining() {
		this(10);
	}

	public ConstructorChaining(int d) {
		this(d,20);
	}
	public ConstructorChaining(int d,int m) {
		this(d,m,30);
	}
	public ConstructorChaining(int d, int m, int y) {
		this.d=d;
		this.m=m;
		this.y=y;
	}
	
	public int getValues() {
		return d+m+y;
	}


}
