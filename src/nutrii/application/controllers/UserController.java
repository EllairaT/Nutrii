package nutrii.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import nutrii.application.gui.CreateAccountFrame;
import nutrii.application.gui.CreateAccountPnl;
import nutrii.application.gui.MenuPanel;
import nutrii.application.gui.NutriiGUI;
import nutrii.application.gui.NutriiLoginGUI;
import nutrii.application.gui.UserFrame;
import nutrii.application.model.ExtraActive;
import nutrii.application.model.LightlyActive;
import nutrii.application.model.ModeratelyActive;
import nutrii.application.model.Nutrii;
import nutrii.application.model.Sedentary;
import nutrii.application.model.User;
import nutrii.application.model.VeryActive;
import nutrii.application.services.UserService;

/**
 * Controls the interactions between 
 * User login / main panel / User Account panels and the model. 
 * @author Ellaira
 */
public class UserController {

    private static Nutrii model;
    private static NutriiGUI view;
    private static MenuPanel menuView;
    private static NutriiLoginGUI loginView;
    private static CreateAccountPnl caPanel;
    private static UserService us;
    private static CreateAccountFrame caFrame;
    private static UserFrame frame;

    public UserController(NutriiGUI view, NutriiLoginGUI login, Nutrii model) {
        this.model = model;
        this.view = view;
        this.loginView = login;
        this.us = new UserService();
        this.menuView = view.getMenuPanel();
        this.frame = new UserFrame();

        newLogIn();
        menuView.addLogOutListener(new LogOutListener());
       
        menuView.viewAccntListener(new AccountListener());
        frame.userTxtListener(new EditUserListener());
        frame.passTxtListener(new EditPasswordListener());
        frame.addSaveListener(new SaveChanges());
    }

    public static void newLogIn() {
        loginView.addUserListener(new LogInListener());
        loginView.addPasswordListener(new LogInListener());
        loginView.addLogInListener(new LogInListener());
        loginView.createAccntListener(new CreateAccountListener());
    }

    /**
     * the usertextfield, passwordfield, and login button have the same listener
     * so it would not matter if the user presses the login button or presses
     * enter.
     *
     */
    private static class LogInListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            char[] password;
            try {
                userInput = loginView.getUserName();
                password = loginView.getPassword();

                User u = us.userLogIn(userInput, new String(password));
                model.setCurrentUser(u);
                loginView.dispose();

                view.setVisible(true);
                menuView.adduserLabelListener(this, model.getCurrentUser().getName());
                
            } catch (IllegalArgumentException ex) {
                loginView.getLabel().setVisible(true);
                loginView.clearUserInput();
                loginView.clearPasswodInput();             
            }
        }
    }
    /**
     * Logs the user out.
     * No need to set the current User back to null
     * as the current user is set when the User logs in.
     * 
     */
    private static class LogOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();

            loginView = new NutriiLoginGUI();
            newLogIn();
            loginView.setVisible(true);
        }
    }

    private static class CreateAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            caFrame = new CreateAccountFrame();
            caFrame.setVisible(true);
            caPanel = caFrame.getCreateAccountPnl();
            caPanel.addCreateBtnListener(new CreateNewAccount());
        }
    }
    
    private static class CreateNewAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User newUser = null;
            String msg = "";
            try {
                String password = null;
                String username = caPanel.getUserField().getText();

                if (us.doesUserExist(username)) {
                    msg = "There is already a user with that name!";
                    throw new IllegalArgumentException();
                }

                JPasswordField[] passwords = caPanel.getpasswordField();

                char gender = caPanel.getGenderSelection().charAt(0);
                String date = caPanel.getDateField().getText();
                LocalDate parsedDate = LocalDate.parse(date);

                String selection = caPanel.getLifestyleSelection();

                float height = Float.parseFloat(caPanel.getHeightField());
                float weight = Float.parseFloat(caPanel.getWeightField());

                String pass1 = new String(passwords[0].getPassword());
                String pass2 = new String(passwords[1].getPassword());

                //check if passwords match
                if (pass1.equals(pass2)) {
                    password = new String(passwords[0].getPassword());
                } else {
                    msg = "The passwords do not match!";
                    throw new IllegalArgumentException();
                }

                if (selection.equals("sedentary")) {
                    newUser = new Sedentary(username, password, gender, parsedDate, height, weight);

                } else if (selection.equals("light")) {
                    newUser = new LightlyActive(username, password, gender, parsedDate, height, weight);

                } else if (selection.equals("moderate")) {
                    newUser = new ModeratelyActive(username, password, gender, parsedDate, height, weight);

                } else if (selection.equals("very")) {
                    newUser = new VeryActive(username, password, gender, parsedDate, height, weight);

                } else {
                    newUser = new ExtraActive(username, password, gender, parsedDate, height, weight);
                }

                us.addUser(newUser);
                caFrame.dispose();

            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(caPanel, "Invalid input", "Warning", JOptionPane.WARNING_MESSAGE);
            } catch (DateTimeParseException d) {
                JOptionPane.showMessageDialog(caPanel, "Please enter a valid date", "Warning", JOptionPane.WARNING_MESSAGE);
            } catch (IllegalArgumentException i) {
                JOptionPane.showMessageDialog(caPanel, msg, "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static class AccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            User currentUser = model.getCurrentUser();

            frame.setVisible(true);
            frame.getUserTxtField().setText(currentUser.getName());
            frame.getPasswordField().setText(currentUser.getPassword());
            frame.getConfirmField().setText(currentUser.getPassword());

            frame.getAgeLbl().setText(String.valueOf(currentUser.getAge()));
            frame.getBmrLbl1().setText(String.valueOf(currentUser.getBMR()));
            frame.getLifestyleLbl().setText(currentUser.getLifestyle());
            frame.getGenderLbl().setText(String.valueOf(currentUser.getGender()));
            frame.getDobLable().setText(currentUser.getDOB().toString());
            
            frame.getDescriptionLbl().setText("To maintain your weight, you need to consume at least "
                    + currentUser.getCalorieReq()
                    + " calories a day.");
        }
    }

    private static class EditUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!frame.getUserTxtField().isEnabled()) {
                frame.getUserTxtField().setEnabled(true);
            } else {
                frame.getUserTxtField().setEnabled(false);
            }
        }
    }

    private static class EditPasswordListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!frame.getPasswordField().isEnabled()) {
                frame.getPasswordField().setEnabled(true);
                frame.getConfirmField().setEnabled(true);

            } else {
                frame.getPasswordField().setEnabled(false);
                frame.getConfirmField().setEnabled(false);
            }
        }
    }

    private static class SaveChanges implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String msg = "";
            try {
                User current = model.getCurrentUser();
                 String currentName = model.getCurrentUser().getName();
                String newName = frame.getUserTxtField().getText();

                String newPwd = new String(frame.getPasswordField().getPassword());
                String conPwd = new String(frame.getConfirmField().getPassword());

                if (!frame.getUserTxtField().getText().isEmpty()) {
                    if (newName.equals(currentName)) {
                        //do nothing
                    } else if (us.doesUserExist(newName)) {
                        msg = "This username is already taken!";
                        frame.getUserTxtField().setText(currentName);
                        throw new IllegalArgumentException();
                        
                    } else {
                        current.setName(newName);
                    }
                } else {
                    msg = "You need to have a username!";
                    frame.getUserTxtField().setText(currentName);
                    throw new IllegalArgumentException();
                }
                
                //check if passwords match
                if(newPwd.equals(conPwd)){
                    current.setPassword(newPwd);
                } else {
                    msg = "passwords must match!";
                    throw new IllegalArgumentException();
                }
                
                us.updateUser(current);
                
                JOptionPane.showMessageDialog(frame, "User details successfully updated!");
                
                frame.dispose();
                
                menuView.adduserLabelListener(this, model.getCurrentUser().getName());
                
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(caPanel, msg, "Warning", JOptionPane.WARNING_MESSAGE);
            } 
        }
    }
}
