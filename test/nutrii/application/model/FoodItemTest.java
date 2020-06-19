package nutrii.application.model;

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
public class FoodItemTest {
    
    public FoodItemTest() {
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
     * Test of setClassName method, of class FoodItem.
     */
    @Test
    public void testSetClassName() {
        System.out.println("setClassName");
        String className = "";
        FoodItem instance = new FoodItem();
        instance.setClassName(className);
    }

    /**
     * Test of setIsEaten method, of class FoodItem.
     */
    @Test
    public void testSetIsEaten() {
        System.out.println("setIsEaten");
        boolean isEaten = true;
        FoodItem instance = new FoodItem();
        instance.setIsEaten(isEaten);
    }

    /**
     * Test of isConsumed method, of class FoodItem.
     */
    @Test
    public void testIsConsumed() {
        System.out.println("isConsumed");
        boolean b = false;
        FoodItem instance = new FoodItem();
        boolean expResult = false;
        boolean result = instance.isConsumed(b);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFoodName method, of class FoodItem.
     */
    @Test
    public void testGetFoodName() {
        System.out.println("getFoodName");
        FoodItem instance = new FoodItem("");
        String expResult = "";
        String result = instance.getFoodName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class FoodItem.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        FoodItem instance = new FoodItem();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class FoodItem.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        FoodItem instance = new FoodItem();
        instance.setId(id);
    }

    /**
     * Test of setFoodName method, of class FoodItem.
     */
    @Test
    public void testSetFoodName() {
        System.out.println("setFoodName");
        String foodName = "";
        FoodItem instance = new FoodItem();
        instance.setFoodName(foodName);
    }

    /**
     * Test of getMinerals method, of class FoodItem.
     */
    @Test
    public void testGetMinerals() {
        System.out.println("getMinerals");
        FoodItem instance = new FoodItem();
        Minerals expResult = null;
        Minerals result = instance.getMinerals();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinerals method, of class FoodItem.
     */
    @Test
    public void testSetMinerals() {
        System.out.println("setMinerals");
        Minerals c = null;
        FoodItem instance = new FoodItem();
        instance.setMinerals(c);
    }

    /**
     * Test of getNutrients method, of class FoodItem.
     */
    @Test
    public void testGetNutrients() {
        System.out.println("getNutrients");
        FoodItem instance = new FoodItem();
        Nutrients expResult = null;
        Nutrients result = instance.getNutrients();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNutrients method, of class FoodItem.
     */
    @Test
    public void testSetNutrients() {
        System.out.println("setNutrients");
        Nutrients c = null;
        FoodItem instance = new FoodItem();
        instance.setNutrients(c);
    }

    /**
     * Test of getVitamins method, of class FoodItem.
     */
    @Test
    public void testGetVitamins() {
        System.out.println("getVitamins");
        FoodItem instance = new FoodItem();
        Vitamins expResult = null;
        Vitamins result = instance.getVitamins();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVitamins method, of class FoodItem.
     */
    @Test
    public void testSetVitamins() {
        System.out.println("setVitamins");
        Vitamins c = null;
        FoodItem instance = new FoodItem();
        instance.setVitamins(c);
    }

    /**
     * Test of toString method, of class FoodItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FoodItem instance = new FoodItem("");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of printNutritionInfo method, of class FoodItem.
     */
    @Test
    public void testPrintNutritionInfo() {
        System.out.println("printNutritionInfo");
        FoodItem instance = new FoodItem();
        instance.printNutritionInfo();
    }

    /**
     * Test of equals method, of class FoodItem.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String f = "Apple";
        FoodItem instance = new FoodItem("");
        boolean expResult = false;
        boolean result = instance.equals(f);
        assertEquals(expResult, result);
    }
    
}
