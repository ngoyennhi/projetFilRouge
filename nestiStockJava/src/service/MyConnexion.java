package service;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnexion {
	public static Connection accessDataBase = null;
//	/**
//	 * Let's test the connection
//	 * 
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		openConnection();
//		//testConnection();
//		//closeConnection();
//	}
	/**
	 * Connection to my projetFilRouge database Opening the connection
	 * 
	 * @throws SQLException
	 */
	public static void openConnection() {
		/* Connection parameters*/
	//  //for window
	//  String url = "jdbc:mysql://127.0.0.1/projetFilRouge";
	//  // crudDRAGON = name of database
	//  String utilisateur = "root";
	//  String motDePasse = "";
		
		//for Mac
		String url = "jdbc:mysql://localhost:8889/projetFilRouge";
		// projetFilRouge = name of database
		String utilisateur = "root";
		String motDePasse = "root";
		
		try {
			System.out.println("try to connect");
			// we add our parameters 
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException ex) {
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	/**
	 * True if the connection is OK 
	 * 
	 * @return
	 */
	public static boolean testConnection() {
		boolean flag = false;
		try {
			if (accessDataBase != null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("Connexion au serveur... OK");
					flag = true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return flag;
	}

	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.err.println("Erreur fermreture: " + e.getMessage());
			}
		}
	}
}
