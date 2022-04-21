package view;


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

import service.LoginDialog;
import service.MyConnexion;

import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		
		frame = new MyFrame(); //modify class MyFrame.java if you want
		
			/**
			 * Tab Menu
			 */
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(128, 128, 128));
		tabbedPane.setBounds(0, 115, 800, 657);
		tabbedPane.setVisible(false);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelProduits = new JPanel();
		tabbedPane.addTab("Produits", null, panelProduits, "CRUD Produits");
		panelProduits.setLayout(null);
		/**
		 * Tab Produits
		 */
		JLabel produitLabel = new JLabel("Cet onglet permet de renseigner des articles/ des utensiles");
		produitLabel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		produitLabel.setBounds(24, 6, 602, 38);
		panelProduits.add(produitLabel);
		
		JPanel panelProduitsSaisir = new JPanel();
		panelProduitsSaisir.setBackground(new Color(255, 255, 255));
		panelProduitsSaisir.setBounds(22, 56, 377, 477);
		panelProduits.add(panelProduitsSaisir);
		panelProduitsSaisir.setLayout(null);
		
		JButton btnProduitSubmit = new JButton("Submit");
		btnProduitSubmit.setBackground(new Color(255, 228, 225));
		btnProduitSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduitSubmit.setBounds(49, 430, 117, 29);
		panelProduitsSaisir.add(btnProduitSubmit);
		
		JButton btnProduitEffacer = new JButton("Effacer");
		btnProduitEffacer.setBackground(new Color(255, 228, 225));
		btnProduitEffacer.setBounds(201, 430, 117, 29);
		panelProduitsSaisir.add(btnProduitEffacer);
		
		
		//**************************************************//
		// Label Type
		JLabel produitTypeLabel = new JLabel("Type");
		produitTypeLabel.setBounds(19, 27, 61, 16);
		panelProduitsSaisir.add(produitTypeLabel);
		// List of product types 
        String s1_TypeProduits[] = {"Article", "Utensile"}; 
		JComboBox produitTypeComboBox = new JComboBox(s1_TypeProduits);
		produitTypeComboBox.setBounds(154, 23, 217, 30);
		panelProduitsSaisir.add(produitTypeComboBox);
		//**************************************************//
		
		
		//**************************************************//
		// Label Nom
		JLabel produitNom = new JLabel("Nom");
		produitNom.setBounds(19, 73, 61, 16);
		panelProduitsSaisir.add(produitNom);
		//**************************************************//
		
		
		//**************************************************//
		// Label Etat
		JLabel produitEtat = new JLabel("Etat");
		produitEtat.setBounds(19, 127, 61, 16);
		panelProduitsSaisir.add(produitEtat);
		//**************************************************//
		
		
		JLabel produitDateDeCreation = new JLabel("Date de creation");
		produitDateDeCreation.setBounds(19, 180, 147, 16);
		//setEnabled(false);
		panelProduitsSaisir.add(produitDateDeCreation);
		
		
		JLabel produitDateDeConsommation = new JLabel("Date de consommation");
		produitDateDeConsommation.setBounds(19, 233, 163, 16);
		panelProduitsSaisir.add(produitDateDeConsommation);
		
		JLabel produitMarque = new JLabel("Marque");
		produitMarque.setBounds(19, 285, 61, 16);
		panelProduitsSaisir.add(produitMarque);
		
		JLabel produitFournisseur = new JLabel("Fournisseur");
		produitFournisseur.setBounds(19, 342, 97, 16);
		panelProduitsSaisir.add(produitFournisseur);
		

		
		/**
		 * Tab Recherche
		 */
		JPanel panelRecherche = new JPanel();
		panelRecherche.setBackground(new Color(255, 255, 255));
		panelRecherche.setBounds(411, 56, 351, 45);
		panelProduits.add(panelRecherche);
		panelRecherche.setLayout(null);
		
		JButton btnProduitRecherche = new JButton("Recherche");
		btnProduitRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduitRecherche.setBounds(237, 6, 108, 29);
		btnProduitRecherche.setBackground(new Color(255, 228, 225));
		panelRecherche.add(btnProduitRecherche);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(407, 152, 355, 382);
		panelProduits.add(panel);
		
		JLabel listeArticle = new JLabel("Liste d'articles");
		listeArticle.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		listeArticle.setBounds(411, 112, 352, 38);
		panelProduits.add(listeArticle);
		
		JButton btnProduitCreer = new JButton("Creer");
		btnProduitCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduitCreer.setBackground(new Color(255, 228, 225));
		btnProduitCreer.setBounds(32, 545, 121, 45);
		panelProduits.add(btnProduitCreer);
		
		JButton btnProduitModifier = new JButton("Modifier");
		btnProduitModifier.setBackground(new Color(255, 228, 225));
		btnProduitModifier.setBounds(165, 545, 129, 45);
		panelProduits.add(btnProduitModifier);
		
		JButton btnProduitSupprimer = new JButton("Supprimer");
		btnProduitSupprimer.setBackground(new Color(255, 228, 225));
		btnProduitSupprimer.setBounds(303, 545, 129, 45);
		panelProduits.add(btnProduitSupprimer);
		
		JButton btnProduitMisAJours = new JButton("Mis à jours");
		btnProduitMisAJours.setBackground(new Color(255, 228, 225));
		btnProduitMisAJours.setBounds(534, 545, 129, 45);
		panelProduits.add(btnProduitMisAJours);
		/**
		 * Tab Fournisseurs
		 */
		JPanel panelFournisseurs = new JPanel();
		tabbedPane.addTab("Fournisseurs", null, panelFournisseurs, "CRUD Fournisseurs");
		panelFournisseurs.setLayout(null);
		
		JLabel FournissieursLabel_1 = new JLabel("Cet onglet permet de renseigner des fournissieurs");
		FournissieursLabel_1.setBounds(6, 6, 779, 40);
		panelFournisseurs.add(FournissieursLabel_1);
		FournissieursLabel_1.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		/**
		 * Tab Commandes
		 */
		JPanel panelCommandes = new JPanel();
		tabbedPane.addTab("Commandes", null, panelCommandes, "CRUD Commandes");
		panelCommandes.setLayout(null);
		
		JLabel CommandesLabel = new JLabel("Cet onglet permet de renseigner des commandes");
		CommandesLabel.setBounds(6, 6, 456, 24);
		panelCommandes.add(CommandesLabel);
		CommandesLabel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		
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
                           // connect DB
                            //MyConnexion conn = new MyConnexion();
                            MyConnexion.openConnection();
                            // display All tabs
                            tabbedPane.setVisible(true);
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
                    	//System.exit(0);
                        // display All tabs
                        tabbedPane.setVisible(false);
                        btnLogin.setText("Login");
                    }
                });
	
			
		// // JOptionPane = pop up a standard dialog box that prompts users for a value or informs them of something
			//			JOptionPane.showMessageDialog(null, "This is some useless info","NestiStockJava",JOptionPane.PLAIN_MESSAGE);
			//			JOptionPane.showMessageDialog(null, "Here is more useless info","NestiStockJava",JOptionPane.INFORMATION_MESSAGE);
			//			JOptionPane.showMessageDialog(null, "Are you sure?","NestiStockJava",JOptionPane.QUESTION_MESSAGE);
			//			JOptionPane.showMessageDialog(null, "Problem service!!","NestiStockJava",JOptionPane.WARNING_MESSAGE);
			//			JOptionPane.showMessageDialog(null, "Contact me to get tech support","NestiStockJava",JOptionPane.ERROR_MESSAGE);
			
//			// answer = 0,1,-1 yes/no/cancel
//						int answer = JOptionPane.showConfirmDialog(null, "Fini votre travail?","NestiStockJava",JOptionPane.YES_NO_CANCEL_OPTION);
//						System.out.println(answer);
			
					
	}

}
