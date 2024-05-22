/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapp2;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;

public class JavaApp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            UIManager.put("OptionPane.background", Color.PINK);
            UIManager.put("Panel.background", Color.PINK);

            JRadioButton loginRadioButton = new JRadioButton("Login");
            JRadioButton registerRadioButton = new JRadioButton("Register");

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(loginRadioButton);
            buttonGroup.add(registerRadioButton);

            JPanel panel = new JPanel();
            panel.setBackground(Color.PINK);
            panel.add(loginRadioButton);
            panel.add(registerRadioButton);

            JOptionPane.showMessageDialog(null, panel, "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);

            Login login = new Login();
            if (loginRadioButton.isSelected()) {
                login(login);
            } else if (registerRadioButton.isSelected()) {
                register(login);
            }

            TaskManagementSystem taskManagementSystem = new TaskManagementSystem();
            taskManagementSystem.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void register(Login login) {
        try {
            login.setFirstName();
            login.setLastName();

            while (true) {
                String registerUser = login.registerUser();

                if (registerUser.equals("\nThe username and password meet the requirements, and the user has been registered successfully.")) {
                    break;
                }

                JOptionPane.showMessageDialog(null, "Please try again.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void login(Login login) {
        boolean loginSuccessful = false;
        JOptionPane.showMessageDialog(null, "\nPlease enter your login details.");

        while (true) {
            try {
                loginSuccessful = login.getLoginDetails();

                if (loginSuccessful) {
                    return;
                }
                JOptionPane.showMessageDialog(null, "Username or Password is incorrect. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                throw e;
            }
        }
    }
}

