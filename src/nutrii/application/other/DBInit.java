package nutrii.application.other;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import nutrii.application.model.*;
import nutrii.application.services.CompoundService;
import nutrii.application.services.UserService;

/**
 *
 * @author Ellaira
 */
public class DBInit {

    private static CompoundService cs;
    private static UserService us;
    
    public DBInit() {
        cs = new CompoundService();
        us = new UserService();
      //  initCompounds();
        initUsers();
    }

    public void initCompounds() {    
        Compounds vitamins = new Vitamins();
        Compounds minerals = new Minerals();
        Compounds nutrients = new Nutrients();

        ArrayList<Compounds> comp = new ArrayList<>();
        comp.add(minerals);
        comp.add(vitamins);
        comp.add(nutrients);

        System.out.println("Number of active threads from the given thread: " + Thread.activeCount());
        System.out.println(Thread.currentThread());

        //check that only one thread is using session
        //otherwise problems can occur
        int count = Thread.activeCount();

        Thread th[] = new Thread[count];
        // returns the number of threads put into the array 
        Thread.enumerate(th);
        for (int i = 0; i < count; i++) { //show all threads
            System.out.println(i + ": " + th[i]);
        }

        for (Compounds c : comp) {
            System.out.println("!!!!!!!!!!COMPOUND: " + c.getCompoundName());
            for (String key : c.returnList().keySet()) {
                cs.addCompound(c, key, 0f);
            }
        }
//        cs.getbyid(39);
//        
//        cs.getAllRows(Nutrients.class);
          cs.getAllRows(Compounds.class);
//        cs.getAllRows(Minerals.class);
    }
    
    public void initUsers(){
        System.out.println(LocalDate.of(2000, Month.AUGUST, 13));
        User user1 = new LightlyActive("Blake", "password", 'm', LocalDate.of(2000, Month.AUGUST, 13), 180f, 52f);
//        User user2 = new ExtraActive("Test User: EA", "big boi", 'm', LocalDate.of(2000, Month.JANUARY, 1), 160f, 60f);
//        User user3 = new Sedentary("Ellaira", "password", 'f', LocalDate.of(2000, Month.MAY, 23), 150f, 48f);    
        user1.setDOB(LocalDate.of(2000, Month.AUGUST, 13));
        user1.setStartDate(LocalDate.now());
        us.addUser(user1);
//        us.addUser(user2);
//        us.addUser(user3);
        
//        us.addUser(new VeryActive("Test", "big boi", 'm', LocalDate.of(2000, Month.JANUARY, 1), 160f, 60f));
       // System.out.println("SEDENTARY------------------------------------");
        us.printAllRows(User.class); //print all types of users 
        
     
    }
}
