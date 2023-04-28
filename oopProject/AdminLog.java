package oopProject;
import javax.swing.*;
import java.awt.event.*;


public class AdminLog extends JFrame implements ActionListener{
	private JLabel User, Password;
	private JTextField UserTxt;
	private JPasswordField PasswordTxt;
	private JButton LoginBtn;
	private Account[] accounts = {new Account("Admin_01","AdminOne"),new Account("Admin_02","AdminTwo"), new Account("Admin_03","AdminThree") };
	
	public AdminLog(){
		setTitle("Administrator Login");
		setSize(400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	    setResizable(false);

	
	Password = new JLabel("Password");
	Password.setSize(500,350);
	Password.setLocation(50,-70);
	
	User = new JLabel("Username");
	User.setSize(500,350);
	User.setLocation(50,-100);

	UserTxt = new JTextField();
	UserTxt.setSize(200, 20);
	UserTxt.setLocation(119, 65);
	
	PasswordTxt = new JPasswordField();
	PasswordTxt.setSize(200, 20);
	PasswordTxt.setLocation(119, 95);
	
	LoginBtn = new JButton("Log in");
	LoginBtn.setSize(75,25);
	LoginBtn.setLocation(140, 130);;
	
		
		JPanel panel = new JPanel(null);
		
		panel.add(UserTxt);
		panel.add(PasswordTxt);
		panel.add(User);
		panel.add(Password);
		panel.add(LoginBtn);
		add(panel);
		setVisible(true);
		
		LoginBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
        String user = UserTxt.getText();
        String pass = new String(PasswordTxt.getPassword());
        boolean valid = false;
        boolean userAndPass = false;
        boolean userOnly = false;
        boolean passOnly = false;
        
        
        for (Account account : accounts) {
            if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                valid = true;
                break;
            }
            else if(!account.getUsername().equals(user)&& !account.getPassword().equals(pass)) {
            	userAndPass = true;
            	break;
            	}
            else if(!account.getUsername().equals(user)&& account.getPassword().equals(pass)) {
            	userOnly = true;
            	break;
            	}
            else if(account.getUsername().equals(user)&& !account.getPassword().equals(pass)) {
            	passOnly = true;
            	break;
            }
        }
        
        if (valid) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose();
            new AdminWelcome();
        } else if (userAndPass){
            JOptionPane.showMessageDialog(this, "Incorrect username and password");
        }else if (userOnly){
            JOptionPane.showMessageDialog(this, "Incorrect username");
        }else if (passOnly){
            JOptionPane.showMessageDialog(this, "Incorrect password");
        }
    }
    }
		
