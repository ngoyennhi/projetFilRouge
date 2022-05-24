package main;
//ctrl+shift+C : commentaire

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.LoginDialog;
import service.MyConnexion;
import view.MyFrame;


import javax.swing.JButton;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




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
	private JTextField txtFNomEntreprise;
	private JTextField txtFAdresse;
	private JTextField txtFNomContact;
	private JTextField txtFPrenomContact;
	private JTextField txtFTelephone;
	private JTextField txtFArticles;
	private JTextField textField_6;
	private JTable table;
	private JComboBox<String> produitIdRecherche;
	
//	Connection con;
//	PreparedStatement pst;
//	ResultSet rs;
	
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

//		/**
//		 * Tab Menu
//		 */
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(169, 126, 1395, 826);
	tabbedPane.setBackground(new Color(128, 128, 128));
	tabbedPane.setVisible(false);
	frame.getContentPane().setLayout(null);
	frame.getContentPane().add(tabbedPane);

	
	JPanel panelProduits = new JPanel();
	tabbedPane.addTab("Produits", null, panelProduits, "CRUD Produits");
	panelProduits.setLayout(null);
	
//		//**************************************************//
//		//**************************************************//
		
		
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
                            MyConnexion.openConnection();
                            MyConnexion.testConnection();
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

//		//**************************************************//
//		//**************************************************//

		
		/**
		 * Tab Produits
		 */
		
		JPanel panelProduitsSaisir = new JPanel();
		panelProduitsSaisir.setBackground(new Color(255, 255, 255));
		panelProduitsSaisir.setBounds(22, 56, 377, 477);
		panelProduits.add(panelProduitsSaisir);
		panelProduitsSaisir.setLayout(null);
		
//		//**************************************************//
//		//**************************************************//
		/**
		 * btn Effacer
		 */
		JButton btnProduitEffacer = new JButton("Effacer");
		btnProduitEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produitNomText.setText(null);
				produitEtatText.setText(null);
				//produitDateConsomText.setText(null);
				produitMarqueText.setText(null);
				produitFournisseurText.setText(null);
			}	
		});
		btnProduitEffacer.setBackground(new Color(255, 228, 225));
		btnProduitEffacer.setBounds(201, 430, 117, 29);
		panelProduitsSaisir.add(btnProduitEffacer);
//		//**************************************************//
//		//**************************************************//
		
		// Label Type
		JLabel produitTypeLabel = new JLabel("Type");
		produitTypeLabel.setBounds(19, 27, 61, 16);
		panelProduitsSaisir.add(produitTypeLabel);
		// List of product types 
		//Indices start at 1 - Article , 2- Ustensile
        Object[] s1_TypeProduits = new Object[]{"-------","Ingrédient", "Ustensile"}; 
		JComboBox<String> produitTypeComboBox = new JComboBox(s1_TypeProduits);
		
		//text field invisible, just get value
		JTextField produitTypeText = new JTextField();
		produitTypeText.setVisible(false);
		
		produitTypeComboBox.addActionListener(produitTypeComboBox);
		produitTypeComboBox.setBounds(154, 23, 217, 30);
		produitTypeComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				e.getSource();
				String s =(String) produitTypeComboBox.getSelectedItem();
				produitTypeText.setText(s);
			}
		});
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
		
		
//		JLabel produitDateDeCreation = new JLabel("Date de creation");
//		produitDateDeCreation.setBounds(19, 180, 147, 16);
//		//setEnabled(false);
//		panelProduitsSaisir.add(produitDateDeCreation);
		
		
//		JLabel produitDateDeConsommation = new JLabel("Date de consommation");
//		produitDateDeConsommation.setBounds(19, 233, 163, 16);
//		panelProduitsSaisir.add(produitDateDeConsommation);
		
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
		
//		produitDateCreationText = new JTextField();
//		produitDateCreationText.setBackground(SystemColor.window);
//		produitDateCreationText.setBounds(168, 175, 203, 26);
//		produitDateCreationText.setEnabled(false);
//		panelProduitsSaisir.add(produitDateCreationText);
//		produitDateCreationText.setColumns(10);
		
//		produitDateConsomText = new JTextField();
//		produitDateConsomText.setBackground(SystemColor.window);
//		produitDateConsomText.setBounds(168, 228, 203, 26);
//		panelProduitsSaisir.add(produitDateConsomText);
//		produitDateConsomText.setColumns(10);

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
		JPanel panelRecherche = new JPanel();
		panelRecherche.setBackground(new Color(255, 255, 255));
		panelRecherche.setBounds(411, 56, 351, 45);
		panelProduits.add(panelRecherche);
		panelRecherche.setLayout(null);
		
//		JButton btnProduitRecherche = new JButton("Recherche");
//		btnProduitRecherche.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnProduitRecherche.setBounds(243, 9, 108, 29);
//		btnProduitRecherche.setBackground(new Color(255, 228, 225));
//		panelRecherche.add(btnProduitRecherche);
		
		JLabel produitRechercheLabel = new JLabel("Produit id:");
		produitRechercheLabel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		produitRechercheLabel.setBounds(6, 9, 127, 28);
		panelRecherche.add(produitRechercheLabel);
		
		//**************************************************//
		//text field to get id
		JTextField produitFIdText = new JTextField();
		produitFIdText.setVisible(true);
		produitFIdText.setBounds(113, 10, 127, 27);
		panelRecherche.add(produitFIdText);
		//**************************************************//
		/**
		 * btn "Creer" - Produits
		 */
			JButton btnProduitCreer = new JButton("Creer");
			btnProduitCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String ptypeString = produitTypeText.getText();
					String pnomString =	produitNomText.getText();
					String pEtatString = produitEtatText.getText();
					String pMarqueString = 	produitMarqueText.getText();
					String pfournisseurString = produitFournisseurText.getText();
					//String pDateConsomString = produitDateConsomText.getText();
	                try {
	        			// query to insert your info into table article
	        			//String query = "INSERT INTO `article` (`type`,`nom`,`etat`,`marque`,`fournisseur`) VALUES(?,?,?,?,?)";
	        			
	        			String query = "INSERT INTO `article` (`type`,`nom`,`etat`,`marque`,`fournisseur`) values('" +ptypeString+ "','" + pnomString + "','" + pEtatString + "','" + pMarqueString + "','" + pfournisseurString+ "')";
	        			// prepare statement for a query
	        			PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
	        			//declaration.setString(1, ptypeString);
	        			//declaration.setString(2, pnomString);
	        			//declaration.setString(3, pEtatString);
	    				//declaration.setString(4, pMarqueString);
	    				//declaration.setString(5, pfournisseurString);
	        			
	        			// notice dialog box to show : success or not 
	                    int x = declaration.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnProduitCreer,"Please check your information");
	                    } else {
	                        JOptionPane.showMessageDialog(btnProduitCreer,"Produit is sucessfully created");
	                       //clear Text
	                        produitNomText.setText(null);
	        				produitEtatText.setText(null);
	        				//produitDateConsomText.setText(null);
	        				produitMarqueText.setText(null);
	        				produitFournisseurText.setText(null);
	                    }
	                    
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
			}
		});
			btnProduitCreer.setBackground(new Color(255, 228, 225));
			btnProduitCreer.setBounds(32, 545, 121, 45);
			panelProduits.add(btnProduitCreer);
			
			//**************************************************//
			/**
			 * btn Modifier
			 */
			JButton btnProduitModifier = new JButton("Modifier");
			btnProduitModifier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String ptypeString = produitTypeText.getText();
					String pnomString =	produitNomText.getText();
					String pEtatString = produitEtatText.getText();
					String pMarqueString = 	produitMarqueText.getText();
					String pfournisseurString = produitFournisseurText.getText();
					//Converting String into int using Integer.parseInt()  
					int idProduit = Integer.parseInt(produitFIdText.getText());
					// query SQL
					String query = "UPDATE `article` SET `type`= '" + ptypeString +  "', `nom`= '" + pnomString + "', `etat`= '" + pEtatString+"', `marque`= '" + pMarqueString + "', `fournisseur`= '" + pfournisseurString + "' WHERE `id_article` = " + idProduit;
					PreparedStatement declaration;
					try {
						declaration = MyConnexion.accessDataBase.prepareStatement(query);
						// notice dialog box to show : success or not 
	                    int x = declaration.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnProduitModifier,"Please check your information");
	                    } else {
	                        JOptionPane.showMessageDialog(btnProduitModifier,"Produit is sucessfully modified");
	                       //clear Text
	                        produitNomText.setText(null);
	        				produitEtatText.setText(null);
	        				//produitDateConsomText.setText(null);
	        				produitMarqueText.setText(null);
	        				produitFournisseurText.setText(null);
	                    }
					} catch (Exception exception) {
					    exception.printStackTrace();
					}
			

				}
			});
			btnProduitModifier.setBackground(new Color(255, 228, 225));
			btnProduitModifier.setBounds(165, 545, 129, 45);
			panelProduits.add(btnProduitModifier);

			
		//**************************************************//
		/**
		 * btn Delete
		 */
		JButton btnProduitSupprimer = new JButton("Supprimer");
		btnProduitSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Converting String into int using Integer.parseInt()  
				int idProduit = Integer.parseInt(produitFIdText.getText());
				// SQL query to delete an article by id ( which was selected by user)
				String query = "DELETE FROM `article` WHERE `id_article` = " + idProduit;
				// prepare statement for a query
    			PreparedStatement declaration;
				try {
					declaration = MyConnexion.accessDataBase.prepareStatement(query);
					int executeUpdateRS = declaration.executeUpdate(query);
					System.out.println(executeUpdateRS);
					if(executeUpdateRS == 0) { JOptionPane.showMessageDialog(btnProduitSupprimer,"Produit is not exit");}
					else { JOptionPane.showMessageDialog(btnProduitSupprimer,"Produit is sucessfully deleted");} 
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				//clear Text
                produitNomText.setText(null);
				produitEtatText.setText(null);
				produitFIdText.setText(null);
				produitMarqueText.setText(null);
				produitFournisseurText.setText(null);
				};
			}
		);
		btnProduitSupprimer.setBackground(new Color(255, 228, 225));
		btnProduitSupprimer.setBounds(303, 545, 129, 45);
		panelProduits.add(btnProduitSupprimer);
		//**************************************************//
		/**
		 * btn Mise à jour
		 */
      	JPanel panelListArticles2 = new JPanel();
		panelListArticles2.setBackground(new Color(255, 255, 255));
		panelListArticles2.setBounds(411, 143, 911, 384);
		panelProduits.add(panelListArticles2);
		panelListArticles2.setVisible(true);
		


		JButton btnProduitMisAJours = new JButton("Mis à jours");
		try 
		  { 
			// Connect DB
			MyConnexion.openConnection();
	      String query = "SELECT `id_article`,`type`,`nom`,`etat`,`marque`,`fournisseur` FROM article";
	      PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
	      ResultSet res = declaration.executeQuery(query);

	      String columns[] = { "id_article","type", "nom", "etat", "marque","fournisseur"};
	      String data[][] = new String[20][6];

	      int i = 0;
	      while (res.next()) {
	        int id_article = res.getInt("id_article");
	        String nomString = res.getString("nom");
	        String etatString = res.getString("etat");
	        String marqueString = res.getString("marque");
	        String typeString = res.getString("type");
	        String fournisseurString = res.getString("fournisseur");
	        data[i][0] = id_article + "";
	        data[i][1] = nomString;
	        data[i][2] = etatString;
	        data[i][3] = marqueString;
	        data[i][4] = typeString;
	        data[i][5] = fournisseurString;
	        i++;
	      }

		      	DefaultTableModel model = new DefaultTableModel(data, columns);
		      	// add header in table model     
		      	model.setColumnIdentifiers(columns);
		      	JPanel panelListArticles1 = new JPanel();
				panelListArticles1.setBackground(new Color(255, 255, 255));
				panelListArticles1.setBounds(411, 143, 911, 384);
				panelProduits.add(panelListArticles1);
				panelListArticles1.setLayout(null);

				tableListArticle = new JTable(model);
				//tableListArticle.setColumnSelectionAllowed(true);
				//tableListArticle.setCellSelectionEnabled(true);
				tableListArticle.setRowSelectionAllowed(true);
				tableListArticle.setShowVerticalLines(true);					
				JScrollPane scrollPane = new JScrollPane(tableListArticle);
				scrollPane.setBounds(6, 5, 911, 384);
				scrollPane.setEnabled(false);
				panelListArticles1.add(scrollPane);
				// Article List Panel
	 		      JPanel panelListArticles = new JPanel();
	 		      scrollPane.setRowHeaderView(panelListArticles);
	 		      panelListArticles.setBackground(new Color(255, 255, 255));
	 		      panelListArticles.setLayout(null);
				  panelListArticles1.setVisible(true);
				 
		    } catch(SQLException e3) {
		      e3.printStackTrace();
		    }
 		btnProduitMisAJours.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				try 
 				  { 
 					// Connect DB
					MyConnexion.openConnection();
			      String query = "SELECT `id_article`,`type`,`nom`,`etat`,`marque`,`fournisseur` FROM article";
			      PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
			      ResultSet res = declaration.executeQuery(query);

			      String columns[] = { "id_article","type", "nom", "etat", "marque","fournisseur"};
			      String data[][] = new String[20][6];

			      int i = 0;
			      while (res.next()) {
			        int id_article = res.getInt("id_article");
			        String nomString = res.getString("nom");
			        String etatString = res.getString("etat");
			        String marqueString = res.getString("marque");
			        String typeString = res.getString("type");
			        String fournisseurString = res.getString("fournisseur");
			        data[i][0] = id_article + "";
			        data[i][1] = nomString;
			        data[i][2] = etatString;
			        data[i][3] = marqueString;
			        data[i][4] = typeString;
			        data[i][5] = fournisseurString;
			        i++;
			      }

 				      	DefaultTableModel model = new DefaultTableModel(data, columns);
 				      	// add header in table model     
 				      	model.setColumnIdentifiers(columns);
 				      	JPanel panelListArticles1 = new JPanel();
 						panelListArticles1.setBackground(new Color(255, 255, 255));
 						panelListArticles1.setBounds(411, 143, 911, 384);
 						panelProduits.add(panelListArticles1);
 						panelListArticles1.setLayout(null);

 						tableListArticle = new JTable(model);
 						//tableListArticle.setColumnSelectionAllowed(true);
 						//tableListArticle.setCellSelectionEnabled(true);
 						tableListArticle.setRowSelectionAllowed(true);
 						tableListArticle.setShowVerticalLines(true);					
 						JScrollPane scrollPane = new JScrollPane(tableListArticle);
 						scrollPane.setBounds(6, 5, 911, 384);
 						scrollPane.setEnabled(false);
 						panelListArticles1.add(scrollPane);
 						// Article List Panel
			 		      JPanel panelListArticles = new JPanel();
			 		      scrollPane.setRowHeaderView(panelListArticles);
			 		      panelListArticles.setBackground(new Color(255, 255, 255));
			 		      panelListArticles.setLayout(null);
 						  panelListArticles1.setVisible(true);
 						 
 				    } catch(SQLException e3) {
 				      e3.printStackTrace();
 				    }
			}
 		});
 		btnProduitMisAJours.setBackground(new Color(255, 228, 225));
 		btnProduitMisAJours.setBounds(793, 541, 129, 45);
 		panelProduits.add(btnProduitMisAJours);
 		//**************************************************//
 		/**
 		 * title 
 		 */
		JLabel listeArticle = new JLabel("Liste d'articles");
		listeArticle.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		listeArticle.setBounds(411, 112, 352, 38);
		panelProduits.add(listeArticle);
		JLabel produitLabel = new JLabel("Cet onglet permet de renseigner des articles/ des utensiles");
		produitLabel.setBounds(22, 6, 695, 38);
		panelProduits.add(produitLabel);
		produitLabel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238));
		panel.setBounds(411, 143, 911, 384);
		panelProduits.add(panel);
		//**************************************************//
		//**************************************************//
		
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
//		
//		JLabel fournisseurArticle = new JLabel("Articles");
//		fournisseurArticle.setBounds(22, 342, 97, 16);
//		panelFournisseursSaisir.add(fournisseurArticle);
		//**************************************************//
		txtFNomEntreprise = new JTextField();
		fournisseurNomEntreprise.setLabelFor(txtFNomEntreprise);
		txtFNomEntreprise.setColumns(10);
		txtFNomEntreprise.setBackground(SystemColor.window);
		txtFNomEntreprise.setBounds(168, 68, 203, 26);
		panelFournisseursSaisir.add(txtFNomEntreprise);
		
		txtFAdresse = new JTextField();
		fournisseurAdresse.setLabelFor(txtFAdresse);
		txtFAdresse.setColumns(10);
		txtFAdresse.setBackground(SystemColor.window);
		txtFAdresse.setBounds(168, 122, 203, 26);
		panelFournisseursSaisir.add(txtFAdresse);
		
		txtFNomContact = new JTextField();
		fournisseurNom.setLabelFor(txtFNomContact);
		txtFNomContact.setColumns(10);
		txtFNomContact.setBackground(SystemColor.window);
		txtFNomContact.setBounds(168, 175, 203, 26);
		panelFournisseursSaisir.add(txtFNomContact);
	
		txtFPrenomContact = new JTextField();
		fournisseurPrenom.setLabelFor(txtFPrenomContact);
		txtFPrenomContact.setColumns(10);
		txtFPrenomContact.setBackground(SystemColor.window);
		txtFPrenomContact.setBounds(168, 228, 203, 26);
		panelFournisseursSaisir.add(txtFPrenomContact);

		txtFTelephone = new JTextField();
		fournisseurTelephone.setLabelFor(txtFTelephone);
		txtFTelephone.setColumns(10);
		txtFTelephone.setBackground(SystemColor.window);
		txtFTelephone.setBounds(168, 280, 203, 26);
		panelFournisseursSaisir.add(txtFTelephone);
		
//		txtFArticles = new JTextField();
//		fournisseurArticle.setLabelFor(txtFArticles);
//		txtFArticles.setColumns(10);
//		txtFArticles.setBackground(SystemColor.window);
//		txtFArticles.setBounds(168, 337, 203, 26);
//		panelFournisseursSaisir.add(txtFArticles);
	
		//**************************************************//

		JButton btnFournisseursEffacer = new JButton("Effacer");
		btnFournisseursEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFNomEntreprise.setText(null);
				txtFAdresse.setText(null);
				txtFNomContact.setText(null);
				txtFPrenomContact.setText(null);
				txtFTelephone.setText(null);
			}	
		});
		btnFournisseursEffacer.setBackground(new Color(255, 228, 225));
		btnFournisseursEffacer.setBounds(181, 414, 137, 45);
		panelFournisseursSaisir.add(btnFournisseursEffacer);
		
		//**************************************************//
		
		JButton btnFournisseursCreer = new JButton("Creer");
		btnFournisseursCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtFNomEntrepriseString = txtFNomEntreprise.getText();
				String txtFAdresseString = txtFAdresse.getText();
				String txtFNomContactString = txtFNomContact.getText();
				String txtFPrenomContactString = txtFPrenomContact.getText();
				String txtFTelephoneString = txtFTelephone.getText();
				
                try {
        			
        			String query = "INSERT INTO `fournisseur` (`nomEntreprise`,`adresse`,`nomContact`,`prenomContact`,`telephone`) values('" +txtFNomEntrepriseString+ "','" + txtFAdresseString + "','" + txtFNomContactString + "','" + txtFPrenomContactString + "','" + txtFTelephoneString + "')";
        			// prepare statement for a query
        			PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);

        			// notice dialog box to show : success or not 
                    int x = declaration.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnFournisseursCreer,"Please check your information");
                    } else {
                        JOptionPane.showMessageDialog(btnFournisseursCreer,"Produit is sucessfully created");
                       //clear Text
                		txtFNomEntreprise.setText(null);
        				txtFAdresse.setText(null);
        				txtFNomContact.setText(null);
        				txtFPrenomContact.setText(null);
        				txtFTelephone.setText(null);
                    }
                    
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
			}
		});
		btnFournisseursCreer.setBackground(new Color(255, 228, 225));
		btnFournisseursCreer.setBounds(32, 533, 121, 45);
		panelFournisseurs.add(btnFournisseursCreer);
		
		//**************************************************//
		
		JButton btnFournisseursModifier = new JButton("Modifier");
		btnFournisseursModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String txtFNomEntrepriseString = txtFNomEntreprise.getText();
				String txtFAdresseString = txtFAdresse.getText();
				String txtFNomContactString = txtFNomContact.getText();
				String txtFPrenomContactString = txtFPrenomContact.getText();
				String txtFTelephoneString = txtFTelephone.getText();
				
				//Converting String into int using Integer.parseInt()  
				int idProduit = Integer.parseInt(produitFIdText.getText());
				// query SQL
				String query = "UPDATE `article` SET `nomEntreprise`= '" + txtFNomEntrepriseString +  "', `adresse`= '" + txtFAdresseString + "', `nomContact`= '" + txtFNomContactString+"', `prenomContact`= '" + txtFPrenomContactString + "', `telephone`= '" + txtFTelephoneString + "' WHERE `id_fournisseur` = " + idProduit;
				PreparedStatement declaration;
				try {
					declaration = MyConnexion.accessDataBase.prepareStatement(query);
					// notice dialog box to show : success or not 
                    int x = declaration.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnFournisseursModifier,"Please check your information");
                    } else {
                        JOptionPane.showMessageDialog(btnFournisseursModifier,"Produit is sucessfully modified");
                        //clear Text
                    		txtFNomEntreprise.setText(null);
            				txtFAdresse.setText(null);
            				txtFNomContact.setText(null);
            				txtFPrenomContact.setText(null);
            				txtFTelephone.setText(null);
                    }
				} catch (Exception exception) {
				    exception.printStackTrace();
				}
			}
		});
		btnFournisseursModifier.setBackground(new Color(255, 228, 225));
		btnFournisseursModifier.setBounds(165, 533, 129, 45);
		panelFournisseurs.add(btnFournisseursModifier);
//		//**************************************************//
//		JButton btnFournisseursSupprimer = new JButton("Supprimer");
//		btnFournisseursSupprimer.setBackground(new Color(255, 228, 225));
//		btnFournisseursSupprimer.setBounds(324, 533, 129, 45);
//		panelFournisseurs.add(btnFournisseursSupprimer);
//		//**************************************************//
//		JButton btnFournisseursMisAJours = new JButton("Mis à jours");
//		btnFournisseursMisAJours.setBackground(new Color(255, 228, 225));
//		btnFournisseursMisAJours.setBounds(538, 529, 129, 45);
//		panelFournisseurs.add(btnFournisseursMisAJours);
//		//**************************************************//
		JLabel lblListeDfournisseurs = new JLabel("Liste de fournisseurs");
		lblListeDfournisseurs.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		lblListeDfournisseurs.setBounds(417, 89, 352, 38);
		panelFournisseurs.add(lblListeDfournisseurs);

		JPanel panelFournisseurRecherche_1 = new JPanel();
		panelFournisseurRecherche_1.setLayout(null);
		panelFournisseurRecherche_1.setBackground(Color.WHITE);
		panelFournisseurRecherche_1.setBounds(418, 44, 351, 45);
		panelFournisseurs.add(panelFournisseurRecherche_1);
//		
//		JButton btnFournisseurRecherche_1 = new JButton("Recherche");
//		btnFournisseurRecherche_1.setBackground(new Color(255, 228, 225));
//		btnFournisseurRecherche_1.setBounds(243, 9, 108, 29);
//		panelFournisseurRecherche_1.add(btnFournisseurRecherche_1);
		//text to write out id
		textField_6 = new JTextField();
		textField_6.setToolTipText("Saisir Text");
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.window);
		textField_6.setBounds(99, 9, 140, 26);
		panelFournisseurRecherche_1.add(textField_6);
		
		JPanel panelListFournisseurs = new JPanel();
		panelListFournisseurs.setBackground(Color.WHITE);
		panelListFournisseurs.setBounds(417, 121, 881, 400);
		panelFournisseurs.add(panelListFournisseurs);
		panelListFournisseurs.setLayout(null);
		
//		//**************************************************//
//		//**************************************************//
//		/**
//		 * Tab Commandes
//		 */
//		JPanel panelCommandes = new JPanel();
//		tabbedPane.addTab("Commandes", null, panelCommandes, "CRUD Commandes");
//		panelCommandes.setLayout(null);
//		
//		JLabel CommandesLabel = new JLabel("Cet onglet permet de renseigner des commandes");
//		CommandesLabel.setBounds(6, 6, 456, 24);
//		panelCommandes.add(CommandesLabel);
//		CommandesLabel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
				
	}  // close initialize()
	
} //close Class

