package nutrii.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import nutrii.application.gui.MngRecordAddPnl;
import nutrii.application.gui.MngRecordRemovePnl;
import nutrii.application.gui.NutriiGUI;
import nutrii.application.model.Compounds;
import nutrii.application.model.Food;
import nutrii.application.model.Drink;
import nutrii.application.model.FoodItem;
import nutrii.application.model.Nutrii;
import nutrii.application.services.CompoundService;
import nutrii.application.services.FoodItemService;

/**
 *
 * @author Ellaira
 */
public class FoodItemController {

    private static Nutrii model;
    private static NutriiGUI view;
    private static MngRecordAddPnl addPanel;
    private static MngRecordRemovePnl removePanel;
    private static FoodItemService fs;
    private static CompoundService cs;

    public FoodItemController(Nutrii model, NutriiGUI view) {
        this.model = model;
        this.view = view;
        this.addPanel = view.getAddPanel();
        this.removePanel = view.getRemovePanel();
        this.fs = new FoodItemService();
        this.cs = new CompoundService();

        view.getMenuPanel().addFoodItemListener(new AddFoodItemListener());
        addPanel.addBackBtnListener(new BackBtnListener());
        addPanel.textFieldListener(new TextListener());
        addPanel.addAddBtnListener(new TextListener());
        view.getMenuPanel().removeFoodItemListener(new RemoveFoodItemListener());
        removePanel.addRecordListener(new RecordListener());
    }

    private static class AddFoodItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getMenuPanel().setVisible(false);
            view.add(addPanel);
            addPanel.setVisible(true);
        }
    }

    private static class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addPanel.setVisible(false);
            view.getMenuPanel().setVisible(true);
        }
    }

    private static class RemoveFoodItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getMenuPanel().setVisible(false);
            view.add(removePanel);
            view.setSize(removePanel.getSize());
            removePanel.setVisible(true);
        }
    }

    private static class TextListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Compounds> cmp = new ArrayList<>();
            try {
                int op = JOptionPane.showConfirmDialog(view, "Are you sure you want to save new item?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                if (op == 0) {
                    if (addPanel.getItemName().isEmpty()) {
                        JOptionPane.showMessageDialog(view, "The food item must have a name!", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {

                        FoodItem newItem = null;
                        String msg = "";

                        for (JTextField t : view.getAddPanel().getTextFields()) {
                            if (addPanel.getItemType().equals("Food")) {
                                newItem = new Food(t.getText());
                            } else {
                                newItem = new Drink(t.getText());
                            }

                            Compounds c = cs.getByString(t.getName());
                            c.setValue(Float.parseFloat(t.getText()));

                            cmp.add(c);
                            msg = addPanel.getItemName() + " added successfully!";
                        }
                        newItem.setFoodName(addPanel.getItemName());
                        System.out.println(Arrays.asList(cmp));
                        fs.addFoodItem(newItem, cmp);
                        addPanel.setInitValues();
                        JOptionPane.showMessageDialog(view, msg, "Success!", JOptionPane.PLAIN_MESSAGE);
                    }

                } else if (op == 2) {
                    addPanel.setInitValues();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Invalid input.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static class RecordListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println(removePanel.getSelectRecordComboBox().getSelectedItem());
            int index = removePanel.getSelectRecordComboBox().getSelectedIndex();
            List<FoodItem> model = null;
            if (index == 1) {
                model = fs.searchByType(Food.class);
            } else if (index == 2){
                model = fs.searchByType(Drink.class);
            }
            DefaultComboBoxModel newModel = new DefaultComboBoxModel(model.toArray());
            removePanel.getSelectItemComboBox().setModel(newModel);
        
        }
    }
}
