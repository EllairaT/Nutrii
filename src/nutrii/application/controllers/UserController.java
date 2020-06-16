package nutrii.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private static UserService us;

    public UserController(NutriiGUI view, NutriiLoginGUI login, Nutrii model) {
        this.model = model;
        this.view = view;
        this.loginView = login;
        this.us = new UserService();
        this.menuView = view.getMenuPanel();  
        
        loginView.addUserListener(new LogInListener());
        loginView.addPasswordListener(new LogInListener());
        loginView.addLogInListener(new LogInListener());      
        
        menuView.addLogOutListener(new LogOutListener());
       
    }

    /**
     * the usertextfield, passwordfield, and login button have the same listener
     * so it would not matter if the user presses the login button
     * or presses enter.
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

                User u = us.userLogIn("Blake", "password");
                model.setCurrentUser(u);
                //System.out.println(model.getCurrentUser());
                loginView.dispose();
                
                view.setVisible(true);
                menuView.adduserLabelListener(this, model.getCurrentUser().getName());
            } catch (Exception ex) {
                loginView.clearUserInput();
                loginView.clearPasswodInput();
            }
        }
    }

    private static class LogOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            loginView.setVisible(true);
        }
    }
}
