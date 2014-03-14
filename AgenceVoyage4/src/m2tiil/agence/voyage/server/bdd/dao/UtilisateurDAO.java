package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import org.hibernate.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Utilisateur;

public class UtilisateurDAO 
{
	
	public static ArrayList<Utilisateur> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("select new "+HibernateUtil.locatePojo+".Utilisateur(u.id, u.nom, u.prenom, u.mail, u.password) from Utilisateur u");
		
		ArrayList<Utilisateur> Utilisateurs = new ArrayList<Utilisateur>();
		
		List<?> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Utilisateur a = (Utilisateur)res.get(i);
			Utilisateur u = new Utilisateur();
			u.setId(a.getId());
			u.setNom(a.getNom());
			u.setPassword(a.getPassword());
			u.setPrenom(a.getPrenom());
			u.setMail(a.getMail());
			
			Utilisateurs.add(u);
		}

		tx.commit();
		s.close();
		return Utilisateurs;
	}
	
	public static Utilisateur findById(int id)
	{
		ArrayList<Utilisateur> Utilisateurs = selectAll();
		Iterator<Utilisateur> i = Utilisateurs.iterator();
		Utilisateur u = new Utilisateur();
		for(;i.hasNext() ; u = i.next())
		{
			if (u.getId() == id)
			{
				return u;
			}
		}
		return new Utilisateur();
	}
	
	public static boolean delete(Utilisateur u)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Utilisateur where id="+u.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean save(Utilisateur u)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Utilisateur(nom, prenom, mail, password) values (\'"+u.getNom()+"\',\'"+u.getPrenom()+"\',\'"+u.getMail()+"\',\'"+u.getPassword()+"\')");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean update(Utilisateur origine, Utilisateur modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Utilisateur set nom=\'"+modif.getNom()+"\', prenom=\'"+modif.getPrenom()+"\', mail=\'"+modif.getMail()+"\', password=\'"+modif.getPassword()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}
