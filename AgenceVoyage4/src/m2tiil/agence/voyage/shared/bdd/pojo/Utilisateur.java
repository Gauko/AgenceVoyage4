package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class Utilisateur 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="mail")
	private String mail;

	@Column(name="password")
	private String password;
	
	public Utilisateur(int id, String nom, String prenom, String mail,
			String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
	}

	public Utilisateur() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String toString()
	{
		return "Utilisateur - id : "+id+" nom : "+nom+" prenom : "+prenom+" mail : "+mail;
	}
}
