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
     * Test of getClassName method, of class FoodItem.
     */
    @Test
    public void testGetClassName() {
        System.out.println("getClassName");
        FoodItem instance = new FoodItem();
        String expResult = "";
        String result = instance.getClassName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsEaten method, of class FoodItem.
     */
    @Test
    public void testIsIsEaten() {
        System.out.println("isIsEaten");
        FoodItem instance = new FoodItem();
        boolean expResult = false;
        boolean result = instance.isIsEaten();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsEaten method, of class FoodItem.
     */
    @Test
    public void testSetIsEaten() {
        System.out.println("setIsEaten");
        boolean isEaten = false;
        FoodItem instance = new FoodItem();
        instance.setIsEaten(isEaten);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class FoodItem.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        FoodItem f1 = null;
        FoodItem instance = new FoodItem();
        int expResult = 0;
        int result = instance.compareTo(f1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoodName method, of class FoodItem.
     */
    @Test
    public void testGetFoodName() {
        System.out.println("getFoodName");
        FoodItem instance = new FoodItem();
        String expResult = "";
        String result = instance.getFoodName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class FoodItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FoodItem instance = new FoodItem();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printNutritionInfo method, of class FoodItem.
     */
    @Test
    public void testPrintNutritionInfo() {
        System.out.println("printNutritionInfo");
        FoodItem instance = new FoodItem();
        instance.printNutritionInfo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class FoodItem.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String f = "";
        FoodItem instance = new FoodItem();
        boolean expResult = false;
        boolean result = instance.equals(f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
