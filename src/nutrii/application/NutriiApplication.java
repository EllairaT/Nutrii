package nutrii.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * the entry point of the application
 * 
 * @author Blake & Ellaira
 */
public class NutriiApplication {

    private static FoodItemDatabase fdb;
    private static final String USER_FILE = "NUTRII_USERS.txt";
    public static CLIView cli;
    public static Nutrii nutrii;
    
    public static void main(String[] args) { 
        try {
            fdb = new FoodItemDatabase("Foods.csv", "Drinks.csv");

            ArrayList<User> users = readUserFile();
         
            nutrii = new Nutrii(users, fdb, USER_FILE);
       
            cli = new CLIView(nutrii);
            
            cli.CLIStartPoint(); //start the program
            
        } catch (Exception e){
            System.err.println(e);
        }
    }     

    //user stuff

    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static ArrayList<User> readUserFile() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException{
        ArrayList<User> userList = new ArrayList<>();
        try{
            String line;
            
            BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
            
            while((line = reader.readLine()) != null){
                String[] s = line.split(","); 
                //find the classname, which is the last item in each line
                Class<?> className = Class.forName(s[s.length-1]);
                Constructor con = className.getConstructor(String.class);
                
                Object userObj = con.newInstance(line);

                userList.add((User) userObj);
            }  
            
        } catch (FileNotFoundException e){
           createEmptyFile();
        } catch (IOException e) {
            System.err.println("Something went wrong.");
            e.printStackTrace();
        }
        return userList;
    }
    
    public static void createEmptyFile(){
         File file = new File(USER_FILE);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.err.println("Something went wrong.");
            ex.printStackTrace();
        }
    }
    
    
}
