package nutrii.application.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.persistence.*;

/**
 * This class is the superclass for Vitamins and Minerals. Contains the methods
 * used by both the subclasses.
 *
 * @author Blake & Ellaira
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Compounds {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    protected int id;

    @Transient
    protected String[] compounds;

    @Transient
    protected Set<String> compoundSet;

    @Transient
    protected HashMap<String, Float> compoundHashMap;

    @Column(name = "Value")
    private float value;

    @Transient
    protected String compoundName;

    @Column(name = "name")
    private String keyname;

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public Compounds() {
        compoundHashMap = new HashMap<>();
        compoundName = getClass().getSimpleName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    /**
     * Adds the list from the subclass into the compounds array attribute, this
     * enables the subclass to use the methods in the superclass with their
     * appropriate compound list.
     *
     * @param s the string array to be passed.
     */
    public void addComponents(String[] s) {

        compoundSet = new HashSet<>(Arrays.asList(s)); //ensures there are no duplicates
        Iterator<String> itr = compoundSet.iterator();

        //initial float values for each key is null. 
        //This will be updated as files containing food items are read or user manually enters values.
        while (itr.hasNext()) {
            compoundHashMap.put(itr.next(), 0.0f);
        }
    }

    /**
     *
     * @param v value String name for the compound
     * @param f float float value for the compound
     */
    public void update(String v, float f) {
        if (compoundSet.contains(v)) {
            compoundHashMap.put(v, f);
        } else {
            throw new NoSuchElementException("There are no " + compoundName.toLowerCase() + " of that name.");
        }
    }

    /**
     *
     * @return compoundHashMap
     */
    public HashMap<String, Float> returnList() {
        return compoundHashMap;
    }

    @Override
    public String toString() {
        System.out.println(compoundName);
        compoundHashMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        return "";
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public abstract void printInformation();
}
