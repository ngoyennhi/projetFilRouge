package classesNesti;

public class Fournisseur {

	private int id_fournisseur;
	private String adresse;
	private String nom;
	
	public Fournisseur (int id_fournisseur, String adresse,String nom) {
					this.id_fournisseur =id_fournisseur;
					this.adresse =adresse;
					this.nom = nom;
					
				}
	public Fournisseur (String adresse,String nom) {
		this.adresse =adresse;
		this.nom = nom;
		
	}
	public Fournisseur () {
		this.adresse ="104 avenue Vert Bois";
		this.nom = "Toto";
		
	}
	
	public int getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(int id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
