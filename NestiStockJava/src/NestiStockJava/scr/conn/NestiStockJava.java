package NestiStockJava.scr.conn;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;

public class NestiStockJava {

	private JFrame frame;

	/**
	 * Launch the application.
	 * 
	 * Méthode main qui est lancer pour l'éxécution du programme
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NestiStockJava window = new NestiStockJava();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * Constructeur qui est appelé dans le main
	 */
	public NestiStockJava() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * Méthode initialize qui est applelé dans le constructeur
	 */
	private void initialize() {
		frame = new JFrame();
		
		JLabel label = new JLabel();
		label.setBounds(0, 19, 800, 34);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("GESTION DE STOCK NESTI"); //set text of label
		label.setHorizontalTextPosition(SwingConstants.CENTER); //set text CENTER 
		label.setVerticalTextPosition(SwingConstants.TOP); //set text TOP 
		label.setForeground(new Color(0, 128, 128));
		label.setBackground(new Color(0, 86, 98));;	
		label.setFont(new Font("Rockwell", Font.BOLD, 40));
		
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("NestiStockJava V.1"); // sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setResizable(false); // prevent frame from being resized
		frame.setVisible(true); // make frame visible
		frame.setSize(800,800); // sets the x-dimension, and  y-dimension of frame
		frame.getContentPane().setBackground(new Color(0xCDC9C9)); // change color of background
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(460, 65, 4, 4);
		frame.getContentPane().add(scrollPane);
		
		
	}
}
