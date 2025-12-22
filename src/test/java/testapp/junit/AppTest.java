package testapp.junit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    int a = 1;
    int b = 1;
    int c = 0;

    /** {@wi.implements POCG/POCG-1314} */
    public void testApp() {
        assertTrue(true);
    }

    /** {@wi.implements POCG/POCG-1315} */
    public void testAdd() {
        assertTrue(a + b == 2);
    }

    /** {@wi.implements POCG/POCG-1316} */
    public void testSubtract() {
        assertTrue(a - b == 0);
    }

    /** {@wi.implements POCG/POCG-1317} */
    public void testMultiply() {
        assertTrue(a * b == 1);
    }

    /** {@wi.implements POCG/POCG-1318} */
    public void testDivide() {
        assertTrue(a / b == 1);
    }

    /** * POCG-1319 등 추가 ID가 필요하다면 여기에 할당할 수 있습니다.
     */
    public void testFailure() {
        assertTrue(a - c == 11);
    }
     /** {@wi.implements POCG/POCG-1319} */
    public void testApp1() {
        assertTrue(true);
    }

    /** {@wi.implements POCG/POCG-1320} */
    public void testAdd1() {
        assertTrue(a + b == 2);
    }

    /** {@wi.implements POCG/POCG-1321} */
    public void testSubtract1() {
        assertTrue(a - b == 0);
    }

    /** {@wi.implements POCG/POCG-1323} */
    public void testMultiply1() {
        assertTrue(a * b == 1);
    }

    /** {@wi.implements POCG/POCG-1324} */
    public void testDivide1() {
        assertTrue(a / b == 1);
    }
}