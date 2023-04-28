package oopProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryPage extends JFrame implements KeyListener {

	private JPanel panel;
	private JLabel Header, Instruction;
	private Books[] book = {new Books("The Gunslinger","Stephen E. King", 4 ),new Books("Leviathan Wakes","James S.A. Corey", 2 ), new Books("Maus","Art Spiegelman", 2 ) };
    private JLabel[] bookLabels = new JLabel[book.length];


	public LibraryPage(){
		
		
		setTitle("Library Selection");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	    setResizable(false);
	    
		panel = new JPanel(null);
		
		add(panel);

		
		Header = new JLabel("Library System");
		Color foregroundColor = Header.getForeground();
		float Opacity = 0.8f;
		foregroundColor = new Color(foregroundColor.getRed(),foregroundColor.getBlue(),foregroundColor.getGreen(),(int)(255 * Opacity));
		Header.setForeground(foregroundColor);
		Header.setSize(400, 70);
		Header.setLocation(157, 0);
		Header.setFont(new Font("Arial", Font.BOLD, 20));
		
		Instruction = new JLabel("Choose a book by pressing 0, 1 or 2");
		Instruction.setSize(400,70);
		Instruction.setLocation(115,200);
		Instruction.setFont(new Font("Arial", Font.BOLD, 14));
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 70, 1000, 10);
		
		panel.add(Header);
		panel.add(Instruction);
		panel.add(separator);
		
		setVisible(true);

	     int separatorY = 120;
	     int separatorHeight = 10;
	     
	     
	     for (int i = 0; i < book.length; i++){
	         Books currentBook = book[i];
	         JLabel bookLabel = new JLabel(i +" " + currentBook.getTitle() + " by " + currentBook.getAuthor() + ", Copies: " + currentBook.getCopies());   
	         bookLabel.setFont(new Font("Arial", Font.BOLD, 16));
	         bookLabel.setSize(400, 30);
	         bookLabel.setLocation(50, 90 + i * 35);
	         bookLabels[i] = bookLabel;
	         JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
	         separator2.setBackground(Color.BLACK);
	         separator2.setBounds(30, separatorY, 420, separatorHeight);
	         panel.add(separator2);
	         panel.add(bookLabel);
	         separatorY += 35;
	     }
	        addKeyListener(this);
	        setFocusable(true);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    char keyChar = e.getKeyChar();
	    if (keyChar >= '0' && keyChar <= '2') {
	        int bookIndex = keyChar - '0';
	        Books selectedBook = book[bookIndex];
	        if (selectedBook.getCopies() > 0) {
	            selectedBook.available();
	            JLabel message = new JLabel("<html>You have checked out the book: " + selectedBook.getTitle() + "<br>" + "Copies left: " + selectedBook.getCopies() +"<br>" +
	            "Choose another book? (Y/N)</html>");
	            message.setFont(new Font("Arial", Font.PLAIN, 14));
	            JDialog dialog = new JDialog(this, "Book Checked Out", true);
	            dialog.setLayout(new BorderLayout());
	            dialog.add(message, BorderLayout.CENTER);
	            dialog.setSize(300, 150);
	            dialog.setLocationRelativeTo(null);
	            dialog.addKeyListener(new KeyAdapter() {
	                @Override
	                public void keyPressed(KeyEvent e) {
	            	    char keyChar = e.getKeyChar();
	           	    if (keyChar == 'y'){
	           	    	dialog.dispose();
	           	    }
	           	    else if(keyChar == 'n'){
	           	    	dispose();	
	           	    }
	           	    else if(keyChar !='y'|| keyChar !='n'){
			            JOptionPane.showMessageDialog(dialog,"index chosen not available.");
	           	    }
	                }
	            });
	            dialog.setVisible(true);
	            JLabel selectedBookLabel = bookLabels[bookIndex];
	            selectedBookLabel.setText(bookIndex +" " + selectedBook.getTitle() + " by " + selectedBook.getAuthor() + ", Copies: " + selectedBook.getCopies());
	           
	        }
	        
	        	else {
	            JOptionPane.showMessageDialog(this, "Sorry, no copies of this book are available.");
	        }
	    }
	    else if  (keyChar != '0' || keyChar != '1' ||keyChar != '2' ){
            JOptionPane.showMessageDialog(this, "Please choose one of the options.");

        }
	    
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
