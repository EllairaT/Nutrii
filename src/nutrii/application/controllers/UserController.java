package nutrii.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import nutrii.application.gui.CreateAccountFrame;
import nutrii.application.gui.CreateAccountPnl;
import nutrii.application.gui.MenuPanel;
import nutrii.application.gui.NutriiGUI;
import nutrii.application.gui.NutriiLoginGUI;
import nutrii.application.model.Nutrii;
import nutrii.application.model.User;
import nutrii.application.services.UserService;

/**
 *
 * @author Ellaira
 */
public class UserController {

    private static Nutrii model;
    private static NutriiGUI view;
    private static MenuPanel menuView;
    private static NutriiLoginGUI loginView;
    private static CreateAccountPnl caPanel;
    private static UserService us;

    public UserController(NutriiGUI view, NutriiLoginGUI login, Nutrii model) {
        this.model = model;
        this.view = view;
        this.loginView = login;
        this.us = new UserService();
        this.menuView = view.getMenuPanel();
       
        newLogIn();
        menuView.addLogOutListener(new LogOutListener());
        loginView.createAccntListener(new CreateAccountListener());
        
    }

    public static void newLogIn() {
        loginView.addUserListener(new LogInListener());
        loginView.addPasswordListener(new LogInListener());
        loginView.addLogInListener(new LogInListener());
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
            } catch (Exception ex) {
                loginView.getLabel().setVisible(true);
                loginView.clearUserInput();
                loginView.clearPasswodInput();
            }
        }
    }

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
            CreateAccountFrame caFrame = new CreateAccountFrame();
            caFrame.setVisible(true);
            caPanel = caFrame.getCreateAccountPnl();
            caPanel.addCreateBtnListener(new CreateNewAccount());
        }
    }

    private static class CreateNewAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User newUser = null;
            for(JTextField t : caPanel.getTextFields()){
                
            }
        }
    }
}
