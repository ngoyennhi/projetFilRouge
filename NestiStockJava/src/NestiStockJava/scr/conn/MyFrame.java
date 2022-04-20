package NestiStockJava.scr.conn;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//Jframe is parent of MyFrame
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	//Construction 
	MyFrame() {

	JLabel label = new JLabel();
	label.setBounds(0, 0, 800, 80);
	label.setVerticalAlignment(SwingConstants.CENTER);
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setText("GESTION DE STOCK NESTI"); //set text of label
	label.setHorizontalTextPosition(SwingConstants.CENTER); //set text CENTER 
	label.setVerticalTextPosition(SwingConstants.TOP); //set text TOP 
	label.setForeground(new Color(0xCDC9C9));
	label.setBackground(new Color(0, 86, 98));;	
	label.setOpaque(true); //display background color
	label.setFont(new Font("Rockwell", Font.BOLD, 40));
			
	this.setBounds(100, 100, 450, 300); // set (x,y,weight,high) as well as dimension
	this.setTitle("NestiStockJava V.1"); // sets title of this
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
	this.setResizable(false); // prevent this from being resized
	this.setVisible(true); // make this visible
	this.setSize(800,800); // sets the x-dimension, and  y-dimension of this
	this.getContentPane().setBackground(new Color(0xCDC9C9)); // change color of background
	this.getContentPane().setLayout(null);
	this.getContentPane().add(label);
	
}
}