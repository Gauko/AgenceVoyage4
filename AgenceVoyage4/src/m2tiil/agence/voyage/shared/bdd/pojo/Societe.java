package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class Societe 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;

	public Societe(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Societe() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString()
	{
		return "Societe - id : "+id+" nom : "+nom;
	}
}
