package oopProject;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class AdminOrLibrarian extends JFrame implements ActionListener {
private JButton adminLogin, librarianLogin;
private JLabel Welcome;

public AdminOrLibrarian(){
	setTitle("Account Type");
	setSize(500,350);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
    setResizable(false);

	
	adminLogin = new JButton("Admin Login");
	librarianLogin = new JButton ("Librarian Login");
	
	adminLogin.setSize(150, 50);
	adminLogin.setLocation(150,80);
	
	librarianLogin.setSize(150,50);
	librarianLogin.setLocation(150, 170);
	
	Welcome = new JLabel("Library Management - JavaTPoint");
	Color foregroundColor = Welcome.getForeground();
	float Opacity = 0.5f;
	foregroundColor = new Color(foregroundColor.getRed(),foregroundColor.getBlue(),foregroundColor.getGreen(),(int)(255 * Opacity));
	Welcome.setForeground(foregroundColor);
	Welcome.setSize(700, 70);
	Welcome.setLocation(90, 20);
	Welcome.setFont(new Font("Arial", Font.PLAIN, 20));
	
	JPanel panel = new JPanel(null);
		
	panel.add(adminLogin);
	panel.add(librarianLogin);
	panel.add(Welcome);
	adminLogin.addActionListener(this);
	librarianLogin.addActionListener(this);
	
	add(panel);
	setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == adminLogin) {
        dispose();
        new AdminLog();
    } else if (e.getSource() == librarianLogin) {
    	dispose();
        new LibrarianLog();
    }
}

}
