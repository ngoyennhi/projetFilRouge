package NestiStockJava.scr.conn;

import java.awt.Color;

import javax.swing.JFrame;

//Jframe is parent of Myframe
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	//Construction 
	MyFrame() {
	this.setTitle("NestiStockJava V.1"); // sets title of this
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
	this.setResizable(false); // prevent this from being resized
	this.setVisible(true); // make this visible
	this.setSize(800,800); // sets the x-dimension, and  y-dimension of this
	this.getContentPane().setBackground(new Color(0xCDC9C9)); // change color of background	
}
}