package nutrii.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author Ellaira
 */
public abstract class Compounds {
    
    protected String[] compounds;
    protected Set<String> compoundSet;
    protected HashMap<String, Float> compoundHashMap;
 
    public Compounds(){        
        compoundHashMap = new HashMap<>();      
    }
    
    public void addComponents(String[] s){
        compoundSet = new HashSet<>(Arrays.asList(s)); //ensures there are no duplicates
        Iterator<String> itr = compoundSet.iterator();
    
        //initial float values for each key is null. 
        //This shall be updated as files containing food items are read or user manually enters values.
        while(itr.hasNext()){
            compoundHashMap.put(itr.next(), null);
        }
    }
    
    public void update(String v, float f){
        if(compoundSet.contains(v)){
            compoundHashMap.put(v, f);
        }
        else{
            String compoundName = getClass().getSimpleName().toLowerCase();
            throw new NoSuchElementException("There are no " + compoundName + " of that name.");
        }  
    }
    
    public HashMap<String, Float> returnList(){
        return compoundHashMap;
    }
    
    public abstract void printInformation();
}
