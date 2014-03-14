package m2tiil.agence.voyage.shared.bdd.pojo;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Trajet 
{
	@Id @GeneratedValue 
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Date date;
	
	//@OneToMany
	@JoinColumn(name="idDepart")
	private int idDepart;
	//private Ville villeDepart;
	
	//@OneToMany
	@JoinColumn(name="idArrivee")
	private int idArrivee;
	//private Ville villeArrivee;
	
	//@OneToMany
	@JoinColumn(name="idMoyenTransport")
	private int idMoyenTransport;
	//private MoyenDeTransport moyen;

	public Trajet(int id, Date date, int idDepart, int idArrivee,
			int idMoyenTransport) {
		super();
		this.id = id;
		this.date = date;
		this.idDepart = idDepart;
		this.idArrivee = idArrivee;
		this.idMoyenTransport = idMoyenTransport;
	}
	
	public Trajet() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdDepart() {
		return idDepart;
	}

	public void setIdDepart(int idDepart) {
		this.idDepart = idDepart;
	}

	public int getIdArrivee() {
		return idArrivee;
	}

	public void setIdArrivee(int idArrivee) {
		this.idArrivee = idArrivee;
	}

	public int getIdMoyenTransport() {
		return idMoyenTransport;
	}

	public void setIdMoyenTransport(int idMoyenTransport) {
		this.idMoyenTransport = idMoyenTransport;
	}

	public String toString()
	{
		return "Trajet - id : "+id+" date : "+date+" depart : "+idDepart+" arrivee : "+idArrivee+" moyen : "+idMoyenTransport;
	}
}
