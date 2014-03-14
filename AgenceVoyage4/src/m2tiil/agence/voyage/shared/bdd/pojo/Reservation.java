package m2tiil.agence.voyage.shared.bdd.pojo;

import javax.persistence.*;

@Entity
public class Reservation 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	//@ManyToMany
	@JoinColumn(name="idUtilisateur")
	private int idUtilisateur;
	//private Utilisateur utilisateur;
	
	//@OneToMany
	@JoinColumn(name="idOffre")
	private int idOffre;
	//private Offre offre;

		public Reservation(int id, int idUtilisateur, int idOffre) {
		super();
		this.id = id;
		this.idUtilisateur = idUtilisateur;
		this.idOffre = idOffre;
	}
	
	public Reservation() {
			super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

	public String toString()
	{
		return "Reservation - id : "+id+" utilisateur : "+idUtilisateur+" offre : "+idOffre;
	}
	
}
