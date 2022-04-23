package service;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//First, we develop a login module that authenticate user based on username and password.
//To make it simple, we hard-code the username and password in this module. 
public class Login {
	public static boolean authenticate(String username, String password) {
        
		try {
			// Connect DB
			MyConnexion.openConnection();
			MyConnexion.testConnection();
 
			// check login and password
			String query = "Select `login`,`mot_de_passe` from utilisateur where login='"+ username + "' and mot_de_passe='"+ password + "'";
			// prepare statement for a query
			PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
            ResultSet rs = declaration.executeQuery(query);
            if (rs.next()) {
            	return true;
            } else {
            	return false;
            }
			}
		catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		return false;
	  }
//		// hardcoded username and password
//        if (username.equals("admin") && password.equals("admin")) {
//           return true;
//        }
//        return false;
//    }
}
