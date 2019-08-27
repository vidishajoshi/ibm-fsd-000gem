package comm.example;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

class TestCalculator extends TestCase {

	int x=7;
	int y=5;

	
	public TestCalculator() {
		super();
	}


//	public TestCalculator(String name) {
//		super(name);
//		
//	}


	@Override
	protected void setUp() throws Exception {
	    
		super.setUp();
		System.out.println("initialize method");
		x=7;
		y=4;
	}

	
	@Override
	protected void tearDown() throws Exception {
		
		super.tearDown();
	System.out.println("Cleanup Method");
	x=0;
	y=0;
	
	}
	
    @Test
	void testGreaterThan() {
    	Calculator c= new Calculator(x,y);
    	assertEquals(1,c.greaterThan());
		
	}
    
    @Test
    void testAddMethod() {
    	Calculator c=new Calculator(x,y);
    	assertEquals(12,c.addMethod());
    }
    
    public static TestSuite createTestSuit() {
    	TestSuite ts=new TestSuite();
    	ts.addTest(new TestCalculator());
    	ts.addTest(new TestCalculator());
    	return ts;
    }

	public static void main(String args[]) {
		System.out.println("Running the testsuite.");
       //junit.textui.TestRunner.run(createTestSuit());
	}

}
