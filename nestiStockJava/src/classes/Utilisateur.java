package classes;

public class Utilisateur {

	private int id_utilisateur;
	private String login;
	private String mot_de_passe;
	
	public Utilisateur (int id_utilisateur, String login,String mot_de_passe
) {
		this.id_utilisateur =id_utilisateur;
		this.login =login;
		this.mot_de_passe = mot_de_passe;
		
	}
	
	public Utilisateur (String login,String mot_de_passe) {
		this.login =login;
		this.mot_de_passe = mot_de_passe;
	}
	
	public Utilisateur () {
		this.login ="admin";
		this.mot_de_passe = "admin";
	}
	
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
}
