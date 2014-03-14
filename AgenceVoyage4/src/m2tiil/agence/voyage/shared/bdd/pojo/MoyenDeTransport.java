package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class MoyenDeTransport
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	//@ManyToOne
	@JoinColumn(name="type")
	private int type;
	//private Type type;

	//@ManyToOne
	@JoinColumn(name="societe")
	private int societe;
	//private Societe societe;
	
	public MoyenDeTransport(int id, String nom, int type, int societe) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.societe = societe;
	}
	
	
	public MoyenDeTransport() {
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSociete() {
		return societe;
	}

	public void setSociete(int societe) {
		this.societe = societe;
	}

	public String toString()
	{
		return "MoyenDeTransport - id : "+id+" nom : "+nom+" type : "+type+" societe : "+societe;
	}
}