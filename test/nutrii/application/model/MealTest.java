package nutrii.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    }

    /**
     * Test of addToMeal method, of class Meal.
     */
    @Test
    public void testAddToMeal() {
        System.out.println("addToMeal");
        ArrayList<FoodItem> arr = new ArrayList<>();      
        FoodItem f = new Food("");
        arr.add(f);
        Meal instance = new Meal(arr, "");
        boolean expResult = false;
        boolean result = instance.addToMeal(f);
        assertNotEquals(expResult, result);
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
    }

    /**
     * Test of getName method, of class Meal.
     */
    @Test
    public void testGetName() {
        ArrayList<FoodItem> arr = new ArrayList<>();      
        System.out.println("getName");
        Meal instance = new Meal(arr, "");      
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of writeMeal method, of class Meal.
     */
    @Test
    public void testWriteMeal() {
        ArrayList<FoodItem> arr = new ArrayList<>();  
        System.out.println("writeMeal");
        Meal instance = new Meal(arr, "");
        String expResult = "";
        String result = instance.writeMeal();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Meal.
     */
    @Test
    public void testToString() {
        ArrayList<FoodItem> arr = new ArrayList<>();  
        System.out.println("toString");
        Meal instance = new Meal(arr, "name");
        String expResult = "name";
        String result = instance.toString();
        assertEquals(expResult, result);
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
    }
}
