package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class Offre 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="prix")
	private double prix;
	
	@Column(name="placesTotales")
	private int placesTotales;
	
	@Column(name="placesDisponibles")
	private int placesDisponibles;
	
	@JoinColumn(name="idTrajet")
	private int idTrajet;
	//private Trajet trajet;
	
	public Offre(int id, String libelle, double prix, int placesTotales,
			int placesDisponibles, int idTrajet) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.placesTotales = placesTotales;
		this.placesDisponibles = placesDisponibles;
		this.idTrajet = idTrajet;
	}
	
	public Offre() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getPlacesTotales() {
		return placesTotales;
	}

	public void setPlacesTotales(int placesTotales) {
		this.placesTotales = placesTotales;
	}

	public int getPlacesDisponibles() {
		return placesDisponibles;
	}

	public void setPlacesDisponibles(int placesDisponibles) {
		this.placesDisponibles = placesDisponibles;
	}

	public int getIdTrajet() {
		return idTrajet;
	}

	public void setIdTrajet(int trajet) {
		this.idTrajet = trajet;
	}
	
	public String toString()
	{
		return "Offre - id : "+id+" libelle : "+libelle+" prix : "+prix+" placesTotales : "+placesTotales+" placesDisponibles : "+placesDisponibles+" id Trajet : "+idTrajet;
	}
		
}
