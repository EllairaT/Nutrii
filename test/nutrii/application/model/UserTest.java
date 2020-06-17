package nutrii.application.model;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ellaira
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new UserImpl();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new UserImpl();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new UserImpl();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int i = 0;
        User instance = new UserImpl();
        instance.setId(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLifestyle method, of class User.
     */
    @Test
    public void testGetLifestyle() {
        System.out.println("getLifestyle");
        User instance = new UserImpl();
        String expResult = "";
        String result = instance.getLifestyle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLifestyle method, of class User.
     */
    @Test
    public void testSetLifestyle() {
        System.out.println("setLifestyle");
        String lifestyle = "";
        User instance = new UserImpl();
        instance.setLifestyle(lifestyle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDOB method, of class User.
     */
    @Test
    public void testSetDOB() {
        System.out.println("setDOB");
        LocalDate dob = null;
        User instance = new UserImpl();
        instance.setDOB(dob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCalorieReq method, of class User.
     */
    @Test
    public void testGetCalorieReq() {
        System.out.println("getCalorieReq");
        User instance = new UserImpl();
        float expResult = 0.0F;
        float result = instance.getCalorieReq();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCalorieReq method, of class User.
     */
    @Test
    public void testSetCalorieReq() {
        System.out.println("setCalorieReq");
        float calorieReq = 0.0F;
        User instance = new UserImpl();
        instance.setCalorieReq(calorieReq);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class User.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        LocalDate sd = null;
        User instance = new UserImpl();
        instance.setStartDate(sd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBMR method, of class User.
     */
    @Test
    public void testGetBMR() {
        System.out.println("getBMR");
        User instance = new UserImpl();
        float expResult = 0.0F;
        float result = instance.getBMR();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class User.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        User instance = new UserImpl();
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateBMR method, of class User.
     */
    @Test
    public void testCalculateBMR() {
        System.out.println("calculateBMR");
        User instance = new UserImpl();
        float expResult = 0.0F;
        float result = instance.calculateBMR();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new UserImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toWrite method, of class User.
     */
    @Test
    public void testToWrite() {
        System.out.println("toWrite");
        User instance = new UserImpl();
        String expResult = "";
        String result = instance.toWrite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCalNeeded method, of class User.
     */
    @Test
    public void testCalculateCalNeeded() {
        System.out.println("calculateCalNeeded");
        User instance = new UserImpl();
        float expResult = 0.0F;
        float result = instance.calculateCalNeeded();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class User.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        User instance = new UserImpl();
        float expResult = 0.0F;
        float result = instance.getHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class User.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        float height = 0.0F;
        User instance = new UserImpl();
        instance.setHeight(height);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class User.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        User instance = new UserImpl();
        float expResult = 0.0F;
        float result = instance.getWeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class User.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        float weight = 0.0F;
        User instance = new UserImpl();
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBMR method, of class User.
     */
    @Test
    public void testSetBMR() {
        System.out.println("setBMR");
        float BMR = 0.0F;
        User instance = new UserImpl();
        instance.setBMR(BMR);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new UserImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new UserImpl();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class User.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        User instance = new UserImpl();
        LocalDate expResult = null;
        LocalDate result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGender method, of class User.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        char gender = ' ';
        User instance = new UserImpl();
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class User.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        User instance = new UserImpl();
        char expResult = ' ';
        char result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDOB method, of class User.
     */
    @Test
    public void testGetDOB() {
        System.out.println("getDOB");
        User instance = new UserImpl();
        LocalDate expResult = null;
        LocalDate result = instance.getDOB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        User instance = new UserImpl();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class UserImpl extends User {
    }
    
}
