package NestiStockJava.scr.conn;
//First, we develop a login module that authenticate user based on username and password.
//To make it simple, we hard-code the username and password in this module. 
public class Login {
	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
}
