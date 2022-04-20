package NestiStockJava.scr.conn;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// JFrame = a GUI window to add components to 
		
		JFrame frame = new JFrame() ; // creates a frame 
		frame.setTitle("NestiStockJava V.1"); // sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setResizable(false); // prevent frame from being resized
		frame.setVisible(true); // make frame visible
		frame.setSize(800,800); // sets the x-dimension, and  y-dimension of frame
		frame.getContentPane().setBackground(new Color(205, 201, 201)); // change color of background	
	}

}
