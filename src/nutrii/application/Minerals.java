package nutrii.application;

/**
 *
 * @author Ellaira
 */
public class Minerals extends Compounds{

    public Minerals(){
        compounds = new String[]{ // Elements with '*' indicates a Trace Mineral 
            "Calcium",
            "Phosphorus",
            "Potassium",
            "Sodium",
            "Magnesium",
            "*Sulfur",
            "*Iron",
            "*Chromium",
            "*Cobolt",
            "*Copper",
            "*Zinc",
            "*Manganese",
            "*Molybdenum",
            "*Iodine",
            "*Selenium",
            "*Fluoride",
        };
        
        addComponents(compounds);
  }     

    //print useful information about minerals
    @Override
    public void printInformation() {
        System.out.println("");
    }
}
