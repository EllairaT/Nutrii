package nutrii.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
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
public class MealTest {
    
    public MealTest() {
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
     * Test of getThisMeal method, of class Meal.
     */
    @Test
    public void testGetThisMeal() {
        System.out.println("getThisMeal");
        Meal instance = new Meal();
        ArrayList<FoodItem> expResult = null;
        ArrayList<FoodItem> result = instance.getThisMeal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setThisMeal method, of class Meal.
     */
    @Test
    public void testSetThisMeal() {
        System.out.println("setThisMeal");
        ArrayList<FoodItem> thisMeal = null;
        Meal instance = new Meal();
        instance.setThisMeal(thisMeal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMealId method, of class Meal.
     */
    @Test
    public void testGetMealId() {
        System.out.println("getMealId");
        Meal instance = new Meal();
        int expResult = 0;
        int result = instance.getMealId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMealId method, of class Meal.
     */
    @Test
    public void testSetMealId() {
        System.out.println("setMealId");
        int mealId = 0;
        Meal instance = new Meal();
        instance.setMealId(mealId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Meal.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Meal instance = new Meal();
        LocalDate expResult = null;
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToMeal method, of class Meal.
     */
    @Test
    public void testAddToMeal() {
        System.out.println("addToMeal");
        FoodItem f = null;
        Meal instance = new Meal();
        boolean expResult = false;
        boolean result = instance.addToMeal(f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class Meal.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Meal instance = new Meal();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser_id method, of class Meal.
     */
    @Test
    public void testSetUser_id() {
        System.out.println("setUser_id");
        int id = 0;
        Meal instance = new Meal();
        instance.setUser_id(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Meal.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Meal instance = new Meal();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Meal.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Meal instance = new Meal();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeMeal method, of class Meal.
     */
    @Test
    public void testWriteMeal() {
        System.out.println("writeMeal");
        Meal instance = new Meal();
        String expResult = "";
        String result = instance.writeMeal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Meal.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Meal instance = new Meal();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Meal.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Meal instance = new Meal();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
