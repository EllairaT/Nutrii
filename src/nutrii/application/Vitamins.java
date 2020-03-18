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
public class Vitamins extends Compounds{
    
    public Vitamins(){
        compounds = new String[]{
            "Vitamin A",
            "Vitamin B1 (Thiamine)",
            "Vitamin B2 (Riboflavin)",
            "Vitamin B3 (Niacin)",
            "Vitamin B5 (Pantothenic Acid)",
            "Vitamin B6",
            "Vitamin B7(H) (Biotin)",
            "Vitamin B9 (Folic Acid)",
            "Vitamin B12 (Cobalamin)",
            "Vitamin C",
            "Vitamin D",
            "Vitamin E",
            "Vitamin K",
        };
        
        addComponents(compounds);
    
    }

    //print useful information about vitamins 
    @Override
    public void printInformation() {
        System.out.println("");
    }
}
