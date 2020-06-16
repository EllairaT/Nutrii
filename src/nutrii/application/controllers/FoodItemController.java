package nutrii.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nutrii.application.gui.NutriiGUI;
import nutrii.application.model.Nutrii;

/**
 *
 * @author Ellaira
 */
public class FoodItemController {

    private static Nutrii model;
    private static NutriiGUI view;
    
    public FoodItemController(Nutrii model, NutriiGUI view) {
        this.model = model;
        this.view = view;
        
        view.getMenuPanel().addFoodItemListener(new AddFoodItemListener());
        view.getAddPanel().addBackBtnListener(new BackBtnListener());
    }

    private static class AddFoodItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getMenuPanel().setVisible(false);
            view.add(view.getAddPanel());
            view.getAddPanel().setVisible(true);
        }

    }

    private static class BackBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getAddPanel().setVisible(false);
            view.getMenuPanel().setVisible(true);
        }
    }
    
}
