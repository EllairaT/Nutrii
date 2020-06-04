package nutrii.application;

import nutrii.application.model.Nutrii;
import nutrii.application.other.FoodItemDatabase;
import nutrii.application.other.HibernateUtil;
import nutrii.application.model.*;
import nutrii.application.other.CLIView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.*;
import nutrii.application.other.DBInit;

/**
 * the entry point of the application
 *
 * @author Blake & Ellaira
 */
public class NutriiApplication {

    private static DBConnect dbconn;
    private static FoodItemDatabase fdb;
    private static final String USER_FILE = "NUTRII_USERS.txt";
    public static CLIView cli;
    public static Nutrii nutrii;
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    private static DBInit db;
    private static ArrayList<User> tempUserList;

    public static void main(String[] args) {
        initialize();

        System.out.println("hi?");
        System.exit(0);
    }

    public static void initialize() {
        Configuration config = new Configuration().configure();

        /**
         * Read Hibernate XML File Initialize Database
         */
        try {
            SchemaExport export = new SchemaExport(config);
            db = new DBInit();
            System.out.println("--------INITIALISE ALL COMPOUNDS");
            db.initCompounds();
            System.out.println("--------END INITIALISATION");
            export.create(true, true);
            //printing the SQL queries to file to make sure everything works
            export.setOutputFile("out.txt");
            export.execute(true, false, false, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        HibernateUtil.shutdown();
        System.out.println("out");
        
    }
    //user stuff

    /**
     *
     * @return @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static ArrayList<User> readUserFile() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        ArrayList<User> userList = new ArrayList<>();
        try {
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));

            while ((line = reader.readLine()) != null) {
                String[] s = line.split(",");
                //find the classname, which is the last item in each line
                Class<?> className = Class.forName(s[s.length - 1]);
                Constructor con = className.getConstructor(String.class);

                Object userObj = con.newInstance(line);

                userList.add((User) userObj);
            }

        } catch (FileNotFoundException e) {
            createEmptyFile();
        } catch (IOException e) {
            System.err.println("Something went wrong.");
            e.printStackTrace();
        }
        return userList;
    }

    public static void createEmptyFile() {
        File file = new File(USER_FILE);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.err.println("Something went wrong.");
            ex.printStackTrace();
        }
    }
}
