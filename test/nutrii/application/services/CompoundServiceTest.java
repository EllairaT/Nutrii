package nutrii.application.services;

import java.util.List;
import nutrii.application.model.Compounds;
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
public class CompoundServiceTest {
    
    public CompoundServiceTest() {
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
     * Test of getAllRows method, of class CompoundService.
     */
    @Test
    public void testGetAllRows() {
        System.out.println("getAllRows");
        Class compound = null;
        CompoundService instance = new CompoundService();
        List<Compounds> expResult = null;
        List<Compounds> result = instance.getAllRows(compound);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getbyid method, of class CompoundService.
     */
    @Test
    public void testGetbyid() {
        System.out.println("getbyid");
        int cid = 0;
        CompoundService instance = new CompoundService();
        instance.getbyid(cid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByString method, of class CompoundService.
     */
    @Test
    public void testGetByString() {
        System.out.println("getByString");
        String s = "";
        CompoundService instance = new CompoundService();
        Compounds expResult = null;
        Compounds result = instance.getByString(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCompound method, of class CompoundService.
     */
    @Test
    public void testAddCompound() {
        System.out.println("addCompound");
        Compounds c = null;
        String k = "";
        float v = 0.0F;
        CompoundService instance = new CompoundService();
        instance.addCompound(c, k, v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
