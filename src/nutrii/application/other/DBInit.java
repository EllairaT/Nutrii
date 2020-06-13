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

        for (Compounds c : comp) {
            System.out.println("COMPOUND: " + c.getCompoundName());
            for (String key : c.returnList().keySet()) {
                cs.addCompound(c, key, 0f);
            }
        }
        cs.getAllRows(Compounds.class);
    }

    public void initUsers() {

        User user1 = new LightlyActive("Blake", "password", 'm', LocalDate.of(2000, Month.AUGUST, 13), 180f, 52f);
        User user2 = new ExtraActive("Test User: EA", "big boi", 'm', LocalDate.of(2000, Month.JANUARY, 1), 160f, 60f);
        User user3 = new Sedentary("Ellaira", "password", 'f', LocalDate.of(2000, Month.MAY, 23), 150f, 48f);

        us.addUser(user1);
        us.addUser(user2);
        us.addUser(user3);

    }

    public void initMeals() {

    }
}
