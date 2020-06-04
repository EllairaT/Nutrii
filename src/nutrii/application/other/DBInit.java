package nutrii.application.other;

import java.util.ArrayList;
import nutrii.application.model.*;
import nutrii.application.services.CompoundService;

/**
 *
 * @author Ellaira
 */
public class DBInit {

    private static CompoundService cs;

    public DBInit() {

    }

    public void initCompounds() {
        cs = new CompoundService();
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
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + th[i]);
        }

        for (Compounds c : comp) {
            System.out.println("!!!!!!!!!!COMPOUND: " + c.getCompoundName());
            for (String key : c.returnList().keySet()) {
                cs.addCompound(c, key, 0f);
            }
        }
        //cs.getbyid(39);
        
        cs.getAllRows(Nutrients.class);
        cs.getAllRows(Vitamins.class);
        cs.getAllRows(Minerals.class);
    }

}
