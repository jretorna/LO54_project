package fr.utbm.service;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class UserServiceTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UserServiceTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(UserServiceTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testCreateUser() {
        assertTrue(true);
    }
}
