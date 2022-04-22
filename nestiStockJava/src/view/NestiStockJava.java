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
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class NestiStockJava {

	private JFrame frame;
	private JTextField produitNomText;
	private JTextField produitEtatText;
	private JTextField produitDateCreationText;
	private JTextField produitDateConsomText;
	private JTextField produitMarqueText;
	private JTextField produitFournisseurText;
	private JTable tableListArticle;
	private JTextField produitSaisirTextRecherche;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

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
		
		
//		//**************************************************//
//		// Label Type
//		JLabel produitTypeLabel = new JLabel("Type");
//		produitTypeLabel.setBounds(19, 27, 61, 16);
//		panelProduitsSaisir.add(produitTypeLabel);
//		// List of product types 
//		//Indices start at 0 - Article , 1- Ustensile
//        String s1_TypeProduits[] = {"Article", "Ustensile"}; 
//		JComboBox produitTypeComboBox = new JComboBox(s1_TypeProduits);
//		produitTypeComboBox.addActionListener(produitTypeComboBox);
//		produitTypeComboBox.setBounds(154, 23, 217, 30);
//		
//		panelProduitsSaisir.add(produitTypeComboBox);
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
		
		produitNomText = new JTextField();
		produitNomText.setBackground(SystemColor.window);
		produitNomText.setBounds(168, 68, 203, 26);
		panelProduitsSaisir.add(produitNomText);
		produitNomText.setColumns(10);
		
		produitEtatText = new JTextField();
		produitEtatText.setBackground(SystemColor.window);
		produitEtatText.setBounds(168, 122, 203, 26);
		panelProduitsSaisir.add(produitEtatText);
		produitEtatText.setColumns(10);
		
		produitDateCreationText = new JTextField();
		produitDateCreationText.setBackground(SystemColor.window);
		produitDateCreationText.setBounds(168, 175, 203, 26);
		panelProduitsSaisir.add(produitDateCreationText);
		produitDateCreationText.setColumns(10);
		
		produitDateConsomText = new JTextField();
		produitDateConsomText.setBackground(SystemColor.window);
		produitDateConsomText.setBounds(168, 228, 203, 26);
		panelProduitsSaisir.add(produitDateConsomText);
		produitDateConsomText.setColumns(10);
		
		produitMarqueText = new JTextField();
		produitMarqueText.setBackground(SystemColor.window);
		produitMarqueText.setBounds(168, 280, 203, 26);
		panelProduitsSaisir.add(produitMarqueText);
		produitMarqueText.setColumns(10);
		
		produitFournisseurText = new JTextField();
		produitFournisseurText.setBackground(SystemColor.window);
		produitFournisseurText.setBounds(168, 337, 203, 26);
		panelProduitsSaisir.add(produitFournisseurText);
		produitFournisseurText.setColumns(10);
		
		/**
		 * Tab Recherche
		 */
		JLabel produitLabel = new JLabel("Cet onglet permet de renseigner des articles/ des utensiles");
		produitLabel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		produitLabel.setBounds(24, 6, 602, 38);
		panelProduits.add(produitLabel);
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
		btnProduitRecherche.setBounds(243, 9, 108, 29);
		btnProduitRecherche.setBackground(new Color(255, 228, 225));
		panelRecherche.add(btnProduitRecherche);
		
//		JComboBox nomColProduitList = new JComboBox();
//		nomColProduitList.setBounds(6, 9, 127, 28);
//		panelRecherche.add(nomColProduitList);
		
		produitSaisirTextRecherche = new JTextField();
		produitSaisirTextRecherche.setBackground(SystemColor.window);
		produitSaisirTextRecherche.setBounds(131, 9, 108, 26);
		panelRecherche.add(produitSaisirTextRecherche);
		produitSaisirTextRecherche.setColumns(10);
	
		
		JPanel panelListArticles = new JPanel();
		panelListArticles.setBackground(new Color(255, 255, 255));
		panelListArticles.setBounds(407, 152, 355, 382);
		panelProduits.add(panelListArticles);
		
		tableListArticle = new JTable();
		tableListArticle.setBorder(new LineBorder(SystemColor.activeCaptionText));
		panelListArticles.add(tableListArticle);
		
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
		
		JLabel FournisseursLabel_1 = new JLabel("Cet onglet permet de renseigner des fournisseurs");
		FournisseursLabel_1.setBounds(6, 6, 779, 40);
		panelFournisseurs.add(FournisseursLabel_1);
		FournisseursLabel_1.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		
		JPanel panelFournisseursSaisir = new JPanel();
		panelFournisseursSaisir.setLayout(null);
		panelFournisseursSaisir.setBackground(Color.WHITE);
		panelFournisseursSaisir.setBounds(28, 44, 377, 477);
		panelFournisseurs.add(panelFournisseursSaisir);
		
		JButton btnFournisseursSubmit = new JButton("Submit");
		btnFournisseursSubmit.setBackground(new Color(255, 228, 225));
		btnFournisseursSubmit.setBounds(49, 430, 117, 29);
		panelFournisseursSaisir.add(btnFournisseursSubmit);
		
		JButton btnFournisseursEffacer = new JButton("Effacer");
		btnFournisseursEffacer.setBackground(new Color(255, 228, 225));
		btnFournisseursEffacer.setBounds(201, 430, 117, 29);
		panelFournisseursSaisir.add(btnFournisseursEffacer);
		
		JLabel fournisseurNomEntreprise = new JLabel("Nom d'entreprise");
		fournisseurNomEntreprise.setBounds(19, 73, 117, 16);
		panelFournisseursSaisir.add(fournisseurNomEntreprise);
		
		JLabel fournisseurAdresse = new JLabel("Adresse");
		fournisseurAdresse.setBounds(19, 127, 61, 16);
		panelFournisseursSaisir.add(fournisseurAdresse);
		
		JLabel fournisseurNom = new JLabel("Nom de contact");
		fournisseurNom.setBounds(19, 180, 147, 16);
		panelFournisseursSaisir.add(fournisseurNom);
		
		JLabel fournisseurPrenom = new JLabel("Prénom de contact");
		fournisseurPrenom.setBounds(19, 233, 163, 16);
		panelFournisseursSaisir.add(fournisseurPrenom);
		
		JLabel fournisseurTelephone = new JLabel("Téléphone");
		fournisseurTelephone.setBounds(19, 285, 100, 16);
		panelFournisseursSaisir.add(fournisseurTelephone);
		
		JLabel fournisseurArticle = new JLabel("Articles");
		fournisseurArticle.setBounds(22, 342, 97, 16);
		panelFournisseursSaisir.add(fournisseurArticle);
		
		textField = new JTextField();
		fournisseurNomEntreprise.setLabelFor(textField);
		textField.setColumns(10);
		textField.setBackground(SystemColor.window);
		textField.setBounds(168, 68, 203, 26);
		panelFournisseursSaisir.add(textField);
		
		textField_1 = new JTextField();
		fournisseurAdresse.setLabelFor(textField_1);
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.window);
		textField_1.setBounds(168, 122, 203, 26);
		panelFournisseursSaisir.add(textField_1);
		
		textField_2 = new JTextField();
		fournisseurNom.setLabelFor(textField_2);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.window);
		textField_2.setBounds(168, 175, 203, 26);
		panelFournisseursSaisir.add(textField_2);
		
		textField_3 = new JTextField();
		fournisseurPrenom.setLabelFor(textField_3);
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.window);
		textField_3.setBounds(168, 228, 203, 26);
		panelFournisseursSaisir.add(textField_3);
		
		textField_4 = new JTextField();
		fournisseurTelephone.setLabelFor(textField_4);
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.window);
		textField_4.setBounds(168, 280, 203, 26);
		panelFournisseursSaisir.add(textField_4);
		
		textField_5 = new JTextField();
		fournisseurArticle.setLabelFor(textField_5);
		textField_5.setColumns(10);
		textField_5.setBackground(SystemColor.window);
		textField_5.setBounds(168, 337, 203, 26);
		panelFournisseursSaisir.add(textField_5);
		
		JButton btnProduitCreer_1 = new JButton("Creer");
		btnProduitCreer_1.setBackground(new Color(255, 228, 225));
		btnProduitCreer_1.setBounds(32, 533, 121, 45);
		panelFournisseurs.add(btnProduitCreer_1);
		
		JButton btnProduitModifier_1 = new JButton("Modifier");
		btnProduitModifier_1.setBackground(new Color(255, 228, 225));
		btnProduitModifier_1.setBounds(176, 534, 129, 45);
		panelFournisseurs.add(btnProduitModifier_1);
		
		JButton btnProduitSupprimer_1 = new JButton("Supprimer");
		btnProduitSupprimer_1.setBackground(new Color(255, 228, 225));
		btnProduitSupprimer_1.setBounds(324, 533, 129, 45);
		panelFournisseurs.add(btnProduitSupprimer_1);
		
		JButton btnProduitMisAJours_1 = new JButton("Mis à jours");
		btnProduitMisAJours_1.setBackground(new Color(255, 228, 225));
		btnProduitMisAJours_1.setBounds(538, 529, 129, 45);
		panelFournisseurs.add(btnProduitMisAJours_1);
		
		JLabel lblListeDfournisseurs = new JLabel("Liste d'fournisseurs");
		lblListeDfournisseurs.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		lblListeDfournisseurs.setBounds(417, 89, 352, 38);
		panelFournisseurs.add(lblListeDfournisseurs);
		
		JPanel panelFournisseurRecherche_1 = new JPanel();
		panelFournisseurRecherche_1.setLayout(null);
		panelFournisseurRecherche_1.setBackground(Color.WHITE);
		panelFournisseurRecherche_1.setBounds(418, 44, 351, 45);
		panelFournisseurs.add(panelFournisseurRecherche_1);
		
		JButton btnFournisseurRecherche_1 = new JButton("Recherche");
		btnFournisseurRecherche_1.setBackground(new Color(255, 228, 225));
		btnFournisseurRecherche_1.setBounds(243, 9, 108, 29);
		panelFournisseurRecherche_1.add(btnFournisseurRecherche_1);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Saisir Text");
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.window);
		textField_6.setBounds(131, 9, 108, 26);
		panelFournisseurRecherche_1.add(textField_6);
		
//		JComboBox comboBox_1 = new JComboBox();
//		comboBox_1.setBounds(6, 10, 125, 29);
//		panelRecherche_1.add(comboBox_1);
		
		JPanel panelListFournisseurs = new JPanel();
		panelListFournisseurs.setBackground(Color.WHITE);
		panelListFournisseurs.setBounds(417, 121, 355, 382);
		panelFournisseurs.add(panelListFournisseurs);
		panelListFournisseurs.setLayout(null);
		
		table = new JTable();
		table.setBounds(177, 5, 0, 0);
		table.setBorder(new LineBorder(SystemColor.activeCaptionText));
		panelListFournisseurs.add(table);
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
