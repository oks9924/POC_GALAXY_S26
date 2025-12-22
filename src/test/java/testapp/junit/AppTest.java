package testapp.junit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    int a = 1;
    int b = 1;
	int c = 0;
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testAdd()
    {
        assertTrue( a+b==2 );
    }
    
    public void testSubtract()
    {
        assertTrue( a-b==0 );
    }
    
    public void testMultiply()
    {
        assertTrue( a*b==1 );
    }
    
    public void testDivide()
    {
        assertTrue( a/b==1 );
    }
    public void testFailure()
    {
    	assertTrue( a-c==11 );
    }
}
