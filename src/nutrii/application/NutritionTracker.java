package nutrii.application;

import java.util.ArrayList;

/**
 * Calculates the total nutrition information for every single meal
 * the user had for the day
 * @author Blake & Ellaira
 */
public class NutritionTracker {    
    private User user;
    private Report rep;
    private Nutrii nutrii;
    
    public NutritionTracker(User u, Nutrii n){
        user = u;
        nutrii = n;
        rep = new Report(n);
    }
    
    public void calcDailyNutrition(ArrayList<Meal> m){
        ArrayList<FoodItem> allfood = new ArrayList<>();
        for(Meal meal : m){
            for(FoodItem f : meal.getMeal()){
                allfood.add(f);
            }
        }
        Meal total = new Meal(allfood, nutrii.getToday().toString());
        printReport(total);
    }
    
    public void readReport(){
        calcDailyNutrition(getTodayMeals());
    }
    
    public ArrayList<Meal> getTodayMeals(){
       return rep.readTodayReport();
    }
    
    public void writeReport(Meal m){
        rep.writeToReport(m);
    }
    
    /**
     * prints a nutrition report for the user 
     * @param m all the meals the user had, put into one meal object
     */
    public void printReport(Meal m){    
        System.out.println("Today, you've consumed: ");
        System.out.println(m.getNutrients().returnList().get("Calories") + " calories");
        System.out.println(m.getNutrients().returnList().get("Sugars") + " sugars");
        System.out.println(m.getNutrients().returnList().get("Total Carbohydrate") + " carbohydrates");
        
        //to gain weight safely and quickly, 700 - 1000 calories over the recommended calories is recommended
        if(m.getNutrients().returnList().get("Calories") > (user.calculateCalNeeded() + 1000.0f)){
            System.out.println("Slow down! Consuming too many calories can lead to unhealthy and unsafe weight gain.");
        } else if (m.getNutrients().returnList().get("Calories") < (user.calculateCalNeeded() - 500.0f)){
            System.out.println("Make sure you consume the right amount of calories per day to avoid unwanted weight loss.");
        } else if(m.getNutrients().returnList().get("Calories") < 1000.0f){
            System.out.println("You need to eat more! Consuming less than 1000 calories per day can lead to malnutrition!");
        } else {
            System.out.println("Keep this up to maintain your weight!");
        }
    }
    
}
