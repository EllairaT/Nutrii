package nutrii.application.model;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.*;

/**
 *
 * @author Ellaira & Blake
 */
//to make use of the polymorphism, we're using single_table to access
//only one table when making a query. 
@Entity(name = "Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Lifestyle", discriminatorType = DiscriminatorType.STRING)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "gender")
    private char gender;

    @Column(name = "password")
    private String password;

    @Transient
    protected float modifier;

    @Column
    private LocalDate DOB;

    @Column
    private LocalDate START_DATE;

    @Column(name = "height")
    private float height;

    @Column(name = "weight")
    private float weight;

    @Column(name = "BMR")
    private float BMR;

    @Column(name = "Calorie_req")
    private float calorieReq;

    @Column(name = "Lifestyle", updatable = false, nullable = false, insertable = false)
    private String lifestyle;

    public User() {
    }

    public User(String n, String p, char g, LocalDate d, float h, float w) {
        this.setName(n);
        this.setPassword(p);
        this.setGender(g);
        this.setHeight(h);
        this.setWeight(w);
        this.setStartDate(LocalDate.now());
        this.setDOB(d);
        this.setBMR(calculateBMR());
        this.setCalorieReq(calculateCalNeeded());
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getLifestyle() {
        return this.lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public void setDOB(LocalDate dob) {
        this.DOB = dob;
    }

    public float getCalorieReq() {
        return calorieReq;
    }

    public void setCalorieReq(float calorieReq) {
        this.calorieReq = calorieReq;
    }

    public void setStartDate(LocalDate sd) {
        this.START_DATE = sd;
    }


    public float getBMR() {
        return this.BMR;
    }

    /**
     * @return the user's age in years.
     */
    public int getAge() {
        Period p;
        p = Period.between(DOB, LocalDate.now());
        int years = p.getYears();

        return years;
    }

    /**
     * This class calculates the BMR (Basal Metabolic Rate) of the user, - i.e.
     * the minimum amount of calories they require per day. - uses the Revised
     * Harris-Benedict Equation.
     *
     * @return total BMR of user.
     */
    protected float calculateBMR() {

        switch (gender) {
            case 'm':
                BMR = (13.397f * weight) + (4.799f * height) - (5.677f * getAge()) + 88.362f;
                break;
            case 'f':
                BMR = (9.247f * weight) + (3.098f * height) - (4.330f * getAge()) + 447.593f;
                break;
            default:
                break;
        }
        return BMR;
    }

    @Override
    public String toString() {
        return name + ", DOB: " + DOB + " (" + getAge() + ")" + "\nBMR: " + BMR
                + "\nLifestyle: " + getClass().getSimpleName()
                + "\nTotal Calories needed for lifestyle: "
                + calorieReq + "\nAccount created on: " + START_DATE;
    }

    /**
     * calculates the total calories needed by the user
     *
     * @return the calories recommended for the user
     */
    public float calculateCalNeeded() {
        return BMR * modifier;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * @param height the height to set
     */
    public final void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return this.weight;
    }

    /**
     * @param weight the weight to set
     */
    public final void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @param BMR the BMR to set
     */
    public final void setBMR(float BMR) {
        this.BMR = BMR;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return this.START_DATE;
    }

    /**
     * @param gender the gender to set
     */
    public final void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * @return the gender
     */
    public char getGender() {
        return this.gender;
    }

    /**
     * @return the DOB
     */
    public LocalDate getDOB() {
        return DOB;
    }

    @Override
    public boolean equals(Object o) {
        String st = (String) o;
        return name.equals(st);
    }
}
