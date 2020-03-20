package nutrii.application;

import java.util.Comparator;

/**
 *
 * @author Ellaira
 */
public abstract class FoodItem implements Comparator<FoodItem>, ItemActions {
    public FoodItem(){
        //TODO: 
     
    }
    
    @Override
    public boolean isConsumed(){
      return false;  
    }
    
    @Override
    public boolean isDiscarded(){
        return false;
    }
    
    
    @Override
    public int compare(FoodItem f1, FoodItem f2){
        return 0;
    }
}
