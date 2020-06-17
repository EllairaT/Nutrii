package nutrii.application.services;

import java.util.List;
import nutrii.application.model.User;
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
public class UserServiceTest {
    
    public UserServiceTest() {
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
     * Test of userLogIn method, of class UserService.
     */
    @Test
    public void testUserLogIn() {
        System.out.println("userLogIn");
        String uname = "";
        String pass = "";
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.userLogIn(uname, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UserService.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User u = null;
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.addUser(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadUser method, of class UserService.
     */
    @Test
    public void testLoadUser() {
        System.out.println("loadUser");
        int id = 0;
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.loadUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of browseAll method, of class UserService.
     */
    @Test
    public void testBrowseAll() {
        System.out.println("browseAll");
        Class user = null;
        UserService instance = new UserService();
        List<User> expResult = null;
        List<User> result = instance.browseAll(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserService.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        User u = null;
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.deleteUser(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserService.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User u = null;
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.updateUser(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByName method, of class UserService.
     */
    @Test
    public void testSearchByName() {
        System.out.println("searchByName");
        String uname = "";
        UserService instance = new UserService();
        List<User> expResult = null;
        List<User> result = instance.searchByName(uname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doesUserExist method, of class UserService.
     */
    @Test
    public void testDoesUserExist() {
        System.out.println("doesUserExist");
        String uname = "";
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.doesUserExist(uname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByLifeStyle method, of class UserService.
     */
    @Test
    public void testSearchByLifeStyle() {
        System.out.println("searchByLifeStyle");
        String lifestyle = "";
        UserService instance = new UserService();
        List<User> expResult = null;
        List<User> result = instance.searchByLifeStyle(lifestyle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
