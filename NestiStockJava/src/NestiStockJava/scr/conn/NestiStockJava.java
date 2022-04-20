package NestiStockJava.scr.conn;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		frame = new MyFrame(); //modify classe MyFrame.java if you want
		
		/**
		 * btn login - logout
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(598, 85, 104, 29);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginDialog loginDlg = new LoginDialog(frame);
                        loginDlg.setVisible(true);
                        // if login successfully
                        if(loginDlg.isSucceeded()){
                            btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
                        }
                    }
                });
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(694, 85, 97, 29);
		frame.getContentPane().add(btnLogout);
			btnLogout.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                    	//This just terminates the program.
                    	System.exit(0);
                    }
                });
		
			/**
			 * Grid of 3 btn OPTIONS 
			 */
		JPanel panel_centre = new JPanel();
		panel_centre.setBounds(65, 294, 663, 206);
		frame.getContentPane().add(panel_centre);
		panel_centre.setBackground(new Color(0, 128, 128));
		panel_centre.setLayout(null);
		
		/**
		 * btn Fournisseurs
		 */
		JButton btnFournisseurs = new JButton("Fournisseurs");
		btnFournisseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFournisseurs.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnFournisseurs.setForeground(new Color(0, 128, 128));
		btnFournisseurs.setBackground(new Color(192, 192, 192));
		btnFournisseurs.setBounds(224, 60, 206, 72);
		panel_centre.add(btnFournisseurs);
		
		/**
		 * btn Produits
		 */
		JButton btnProduits = new JButton("Produits");
		btnProduits.setForeground(new Color(0, 128, 128));
		btnProduits.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduits.setBackground(Color.LIGHT_GRAY);
		btnProduits.setBounds(6, 60, 206, 72);
		panel_centre.add(btnProduits);
		
		/**
		 * btn Commandes
		 */
		JButton btnCommandes = new JButton("Commandes");
		btnCommandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCommandes.setForeground(new Color(0, 128, 128));
		btnCommandes.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnCommandes.setBackground(Color.LIGHT_GRAY);
		btnCommandes.setBounds(442, 60, 206, 72);
		panel_centre.add(btnCommandes);
	
		

	}
}
