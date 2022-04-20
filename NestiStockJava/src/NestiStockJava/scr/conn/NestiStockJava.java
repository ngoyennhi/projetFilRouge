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
import javax.swing.JButton;
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
		label.setBounds(0, 0, 800, 90);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("GESTION DE STOCK NESTI"); //set text of label
		label.setHorizontalTextPosition(SwingConstants.CENTER); //set text CENTER 
		label.setVerticalTextPosition(SwingConstants.TOP); //set text TOP 
		label.setForeground(new Color(0xCDC9C9));
		label.setBackground(new Color(0, 86, 98));;	
		label.setOpaque(true); //display background color
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
		
		
		//Une boite de dialogue pour configurer les informations de connexion à la base de données.

		//Il s'agit d'une boîte de dialogue permettant de saisir les deux informations nécessaires à une connexion JDBC : 
		//le login et le mot de passe.
		JLayeredPane dialogue_conn = new JLayeredPane();
		dialogue_conn.setForeground(Color.WHITE);
		dialogue_conn.setBackground(Color.WHITE);
		dialogue_conn.setBounds(106, 218, 606, 302);
		frame.getContentPane().add(dialogue_conn);
		dialogue_conn.setLayout(null);
		
		JLabel dialogue_cnn_label = new JLabel("Connexion Base de Donnée");
		dialogue_cnn_label.setBounds(0, 0, 500, 50);
		dialogue_cnn_label.setVerticalAlignment(SwingConstants.CENTER);
		dialogue_cnn_label.setHorizontalAlignment(SwingConstants.CENTER);
		dialogue_cnn_label.setHorizontalTextPosition(SwingConstants.CENTER); //set text CENTER 
		dialogue_cnn_label.setVerticalTextPosition(SwingConstants.CENTER); //set text TOP 
		dialogue_cnn_label.setForeground(new Color(0xCDC9C9));
		dialogue_cnn_label.setBackground(new Color(0, 86, 98));;	
		dialogue_cnn_label.setOpaque(true); //display background color
		dialogue_cnn_label.setFont(new Font("Rockwell", Font.BOLD, 20));
		dialogue_conn.add(dialogue_cnn_label);

	}
}
