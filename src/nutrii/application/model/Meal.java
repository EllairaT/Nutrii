package nutrii.application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * A meal is an object containing an arraylist of food items and information
 * such as when and what time the meal was eaten
 *
 * @author Blake & Ellaira
 */
@Entity
@Table(name = "Meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mealId;

    @Column(name = "mealname")
    private String name;

    @Column
    private int userId;

    @Column
    private LocalDate date;

    @Column
    private LocalDateTime time;

    @Transient
    private ArrayList<FoodItem> thisMeal;

    @Transient
    private Minerals mineralsCount;
    @Transient
    private Vitamins vitaminsCount;
    @Transient
    private Nutrients nutrientsCount;

    public Meal(ArrayList<FoodItem> arr, String n) {
        this.setThisMeal(arr);
        this.setName(n);
        this.date = LocalDate.now();
        this.time = LocalDateTime.now();
    }

    public Meal() {
    }

    public ArrayList<FoodItem> getThisMeal() {
        return thisMeal;
    }

    public void setThisMeal(ArrayList<FoodItem> thisMeal) {
        this.thisMeal = thisMeal;
    }

   
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean addToMeal(FoodItem f) {
        return thisMeal.add(f);
    }

    public int getUserId() {
        return userId;
    }

    public void setUser_id(int id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * this method is called when the meal is ready to be written to file
     *
     * @return String containing details about the meal
     */
    public String writeMeal() {
        String toPrint = date + "," + time + "," + name;

        for (FoodItem m : this.thisMeal) {
            toPrint += "," + m.getFoodName();
        }
        return toPrint;
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        String st = (String) o;
//        st.strip();
//        return name.equals(st);
//    }
}
