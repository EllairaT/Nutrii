package nutrii.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * This class is the superclass for Vitamins and Minerals.
 * Contains the methods used by both the subclasses.
 * @author Blake & Ellaira
 */
public abstract class Compounds {
    
    protected String[] compounds;
    protected Set<String> compoundSet;
    protected HashMap<String, Float> compoundHashMap;
    protected String compoundName;
    
    public Compounds(){        
        compoundHashMap = new HashMap<>();   
        compoundName = getClass().getSimpleName();
    }
    
    /**
     * Adds the list from the subclass into the compounds array attribute, 
     * this enables the subclass to use the methods in the superclass
     * with their appropriate compound list. 
     * 
     * @param s the string array to be passed. 
     */
    public void addComponents(String[] s){
        
        compoundSet = new HashSet<>(Arrays.asList(s)); //ensures there are no duplicates
        Iterator<String> itr = compoundSet.iterator();
    
        //initial float values for each key is null. 
        //This will be updated as files containing food items are read or user manually enters values.
        while(itr.hasNext()){
            compoundHashMap.put(itr.next(), 0.0f);
        }
    }
    
    /**
     * 
     * @param v value String name for the compound
     * @param f float float value for the compound
     */
    public void update(String v, float f){    
        if(compoundSet.contains(v)){
            compoundHashMap.put(v, f);
        }
        else{
            throw new NoSuchElementException("There are no " + compoundName.toLowerCase() + " of that name.");
        }  
    }
    
    /**
     * 
     * @return compoundHashMap
     */
    public HashMap<String, Float> returnList(){
        return compoundHashMap;
    }
   
    
    @Override
    public String toString(){
       System.out.println(compoundName);
       compoundHashMap.forEach((key, value)-> {System.out.println(key + " : " + value);});
       return "";
    }
  
    public abstract  void printInformation();
}
