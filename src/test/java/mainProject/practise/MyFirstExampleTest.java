package mainProject.practise;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MyFirstExampleTest extends TestCase {
	
	public MyFirstExampleTest(String testName){
		super(testName);	
	}
	
	public static Test suite(){
		return new TestSuite(MyFirstExampleTest.class);
	}
	
	public void testmultiply(){
		assertEquals(6, MyFirstExample.multiplyTwoNum(2, 3));		
	}
	
	
	public void testArguments(){
		String args [] = null;
		boolean isExceptionThrown = false;
		try{
			MyFirstExample.main(args);
		}catch(ArrayIndexOutOfBoundsException e){
			isExceptionThrown = true;
		}catch(NullPointerException e){
			isExceptionThrown = true;
		}catch(Exception e){
			isExceptionThrown = true;
		}
		
		assertEquals(true,isExceptionThrown);
	}
}
