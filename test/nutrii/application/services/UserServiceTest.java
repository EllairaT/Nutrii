package nutrii.application.services;

import java.util.List;
import nutrii.application.model.Sedentary;
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
        String uname = "Ellaira";
        String pass = "password";
        UserService instance = new UserService();
        User result = instance.userLogIn(uname, pass);
        assertNotNull(result);
    }

    /**
     * Test of addUser method, of class UserService.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User u = new Sedentary();
        UserService instance = new UserService();
        boolean expResult = true;
        boolean result = instance.addUser(u);
        assertEquals(expResult, result);
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
  
    }

    /**
     * Test of deleteUser method, of class UserService.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        User u = new Sedentary();
        UserService instance = new UserService();
        boolean expResult = true;
        boolean result = instance.deleteUser(u);
        assertEquals(expResult, result);
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
    }

    /**
     * Test of searchByName method, of class UserService.
     */
    @Test
    public void testSearchByName() {
        System.out.println("searchByName");
        String uname = "Ellaira";
        UserService instance = new UserService();
        List<User> expResult = null;
        List<User> result = instance.searchByName(uname);
        assertNotNull(result);
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
    }
}
