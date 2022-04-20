package classesNesti;

import java.sql.Date;

public class Article {
	
	private int id_article;
	private String nom;
	private String etat;
	private String marque;
	private Date date_creation;
	private int prix_article_id_prix;
	private int lot_ref_commande;
	private int utilisateur_id_utilisateur1;
	
    public Article(int id_article,String nom,String etat,String marque, Date date_creation,int prix_article_id_prix, int lot_ref_commande,int utilisateur_id_utilisateur1) {
    	this.id_article=id_article;
    	this.nom=nom;
    	this.etat=etat;
    	this.marque=marque;
    	this.date_creation=date_creation;
    	this.prix_article_id_prix=prix_article_id_prix;
    	this.lot_ref_commande=lot_ref_commande;
    	this.utilisateur_id_utilisateur1=utilisateur_id_utilisateur1;
	}
    
    public Article() {
    	this.nom="default";
    	this.etat="b";
    	this.marque="default";
    }
    
    public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public int getPrix_article_id_prix() {
		return prix_article_id_prix;
	}

	public void setPrix_article_id_prix(int prix_article_id_prix) {
		this.prix_article_id_prix = prix_article_id_prix;
	}

	public int getLot_ref_commande() {
		return lot_ref_commande;
	}

	public void setLot_ref_commande(int lot_ref_commande) {
		this.lot_ref_commande = lot_ref_commande;
	}

	public int getUtilisateur_id_utilisateur1() {
		return utilisateur_id_utilisateur1;
	}

	public void setUtilisateur_id_utilisateur1(int utilisateur_id_utilisateur1) {
		this.utilisateur_id_utilisateur1 = utilisateur_id_utilisateur1;
	}

}
