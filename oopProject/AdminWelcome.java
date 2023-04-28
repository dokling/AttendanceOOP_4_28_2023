package oopProject;

import java.awt.Font;

import javax.swing.*;

public class AdminWelcome extends JFrame {
	 public AdminWelcome() {
	        setTitle("Welcome Page");
	        setSize(350, 200);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setResizable(false);
	        
	        JPanel panel = new JPanel(null);
			
	        add(panel);
	        
	        JLabel Message = new JLabel("Welcome to NU Library System");
	        Message.setSize(700, 70);
	        Message.setLocation(30,45);
	        Message.setFont(new Font("Arial", Font.PLAIN, 20));
	        
	        panel.add(Message);
	        setVisible(true);
	    }
	 
}
