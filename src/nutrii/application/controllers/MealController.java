package nutrii.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import nutrii.application.gui.CreateMeal;
import nutrii.application.gui.NutriiGUI;
import nutrii.application.gui.ViewMeals;
import nutrii.application.model.Food;
import nutrii.application.model.Drink;
import nutrii.application.model.FoodItem;
import nutrii.application.model.Meal;
import nutrii.application.model.Nutrii;
import nutrii.application.services.FoodItemService;
import nutrii.application.services.MealService;
import org.hibernate.HibernateException;

/**
 * Meal controller controls the interactions between Adding food to meal and
 * viewing food in a meal and the model
 *
 * @author Ellaira
 */
public class MealController {

    private static Nutrii model;
    private static NutriiGUI view;
    private static FoodItemService fs;
    private static MealService ms;
    private static CreateMeal cm;
    private static ViewMeals vm;
    private static DefaultListModel mealModel;
    private static ArrayList<FoodItem> list;
    private static List<Meal> meals;
    private static DefaultListModel foodModel;

    public MealController(Nutrii model, NutriiGUI view) {
        this.model = model;
        this.view = view;
        this.cm = view.getCm();
        this.fs = new FoodItemService();
        this.ms = new MealService();
        this.mealModel = new DefaultListModel();
        this.foodModel = new DefaultListModel();
        this.list = new ArrayList<>();
        this.vm = view.getVm();


        vm.addMealSelectListener(new GetFoodFromMeal());

        view.getMenuPanel().addViewMealListener(new ViewMealListener());
        view.getMenuPanel().calculateFoodListener(new CalculateFoodListener());

        cm.addFoodListener(new AddFoodToMeal());
        cm.addDrinkListener(new AddFoodToMeal());
        cm.addConfirmListener(new ConfirmMeal());
        cm.addBackBtnListener(new ReturnToMenu());
        vm.addBackBtnListener(new ReturnToMenu());
    }

    private static class CalculateFoodListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<FoodItem> foods = fs.searchByType(Food.class);
            List<FoodItem> drinks = fs.searchByType(Drink.class);
            DefaultComboBoxModel foodModel = new DefaultComboBoxModel(foods.toArray());
            DefaultComboBoxModel drinkModel = new DefaultComboBoxModel(drinks.toArray());

            cm.getMealList().setModel(mealModel);
            cm.setComboBoxValues(foodModel, drinkModel);

            view.getMenuPanel().setVisible(false);
            view.add(cm);
            view.setSize(cm.getPreferredSize());
            cm.setVisible(true);
        }
    }

    private static class AddFoodToMeal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FoodItem selection = null;

            if (e.getSource().equals(cm.getAddFoodBtn())) {
                selection = (FoodItem) cm.getFoodCmb().getSelectedItem();
            } else {
                selection = (FoodItem) cm.getDrinkCmb().getSelectedItem();
            }
            list.add(selection);
            mealModel.addElement(selection);
        }
    }

    private static class ConfirmMeal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String mealName = cm.getMealNameField().getText();

                if (!mealName.isEmpty() && !list.isEmpty()) {
                    Meal newMeal = new Meal(list, mealName);
                    newMeal.setUser_id(model.getCurrentUser().getId());

                    ms.addMeal(newMeal);
                    JOptionPane.showMessageDialog(cm, "Meal successfully added!", "Warning", JOptionPane.PLAIN_MESSAGE);
                    mealModel.removeAllElements();
                    cm.getMealNameField().setText("");
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showConfirmDialog(cm, "The meal needs a name and some food!", "Warning", JOptionPane.WARNING_MESSAGE);
            } catch (HibernateException he) {
                JOptionPane.showConfirmDialog(cm, "Could not enter meal!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static class ViewMealListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            meals = ms.getByUser(model.getCurrentUser().getId());
            DefaultComboBoxModel mealModel = new DefaultComboBoxModel(meals.toArray());

            vm.getMealSelect().setModel(mealModel);

            view.getMenuPanel().setVisible(false);
            view.add(vm);
            view.setSize(vm.getPreferredSize());
            vm.setVisible(true);
        }
    }

    private static class ReturnToMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vm.setVisible(false);
            cm.setVisible(false);

            view.setSize(view.getPreferredSize());
            view.getMenuPanel().setVisible(true);
        }
    }

    private static class GetFoodFromMeal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            foodModel.removeAllElements();
            Meal selected = (Meal) vm.getMealSelect().getSelectedItem();

            List<FoodItem> foods = ms.getFoodFromMeal(selected);

            for (FoodItem f : foods) {
                foodModel.addElement(f);
            }

            vm.getFoodList().setModel(foodModel);
        }
    }
}
