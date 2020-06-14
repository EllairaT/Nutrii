package nutrii.application.other;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import nutrii.application.model.*;
import nutrii.application.services.CompoundService;
import nutrii.application.services.FoodItemService;
import nutrii.application.services.MealService;
import nutrii.application.services.UserService;

/**
 *
 * @author Ellaira
 */
public class DBInit {

    private static CompoundService cs;
    private static UserService us;
    private static FoodItemService fs;
    private static MealService ms;

    public DBInit() {
        cs = new CompoundService();
        us = new UserService();
        fs = new FoodItemService();
        ms = new MealService();
        //  initCompounds();
        //initUsers();
        //initFood();
        initMeals();
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
        User user4 = new ModeratelyActive("Ellaira", "password", 'f', LocalDate.of(2000, Month.MAY, 23), 150f, 48f);
        User user5 = new VeryActive("Ellaira", "password", 'f', LocalDate.of(2000, Month.MAY, 23), 150f, 48f);

        us.addUser(user1);
        us.addUser(user2);
        us.addUser(user3);
        us.addUser(user4);
        us.addUser(user5);

    }

    public void initMeals() {
        ArrayList<FoodItem> meal1 = new ArrayList<>();
        meal1.add(fs.searchByName("Apple").get(0));
        meal1.add(fs.searchByName("Banana").get(0));
        meal1.add(fs.searchByName("Pear").get(0));
        meal1.add(fs.searchByName("Fried Eggs").get(0));
        
        for(FoodItem f: meal1){
            System.out.println(f);
        }
       // meal1.add(fs.searchByName("Sprite").get(0));
        Meal breakfast = new Meal(meal1, "Breakfast");
        int userId = us.searchByName("Blake").get(0).getId();
        breakfast.setUser_id(userId);
        
        for(FoodItem fi : breakfast.getThisMeal()){
            System.out.println(fi);
        }
        ms.addMeal(breakfast);
        
        
  
    }

    public void initFood() {
        Food newFood;
        Drink newDrink;
        String[] food = {"Apple", "Orange", "Banana", "Pear", "Tomato",
            "FrozenBlue Berries 100g", "Peanuts 100g", "Cucumber 70g",
            "Carrots", "Fried Eggs", "Peas", "Corn", "Brocolli", "Cauliflower",
            "Scotch Fillet Steak"};

        String[] drinks = {"V Energy Drink(can)", "Sprite (can)", "Coca Cola (can)", "Glaceau Vita Water", "Coffee 1 cup"};

        for (String f : food) {
            newFood = new Food(f);
            fs.addFoodItem(newFood);
        }

        for (String d : drinks) {
            newDrink = new Drink(d);
            fs.addFoodItem(newDrink);
        }

    }

}
