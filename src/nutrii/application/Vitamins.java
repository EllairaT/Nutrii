package nutrii.application;

/**
 *
 * @author Ellaira
 */
public class Vitamins extends Compounds {

    public Vitamins() {
        compounds = new String[]{
            "Vitamin A",
            "Vitamin B1 (Thiamine)",
            "Vitamin B2 (Riboflavin)",
            "Vitamin B3 (Niacin)",
            "Vitamin B5 (Pantothenic acid)",
            "Vitamin B6 (Pyridoxine)",
            "Vitamin B7 (Biotin)",
            "Vitamin B9 (Folate)",
            "Vitamin B12 (cobalamin)",
            "Vitamin C",
            "Vitamin D",
            "Vitamin E",
            "Vitamin K",};

        addComponents(compounds);

    }

    //print useful information about vitamins 
    @Override
    public void printInformation() {
        System.out.println("");
    }

}
