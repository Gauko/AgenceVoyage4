package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import org.hibernate.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Ville;

public class VilleDAO 
{
	
	public static ArrayList<Ville> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("select new "+HibernateUtil.locatePojo+".Ville(v.id, v.nom) from Ville v");
		
		ArrayList<Ville> Villes = new ArrayList<Ville>();
		
		List<?> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Ville a = (Ville)res.get(i);
			Ville v = new Ville();
			v.setNom(a.getNom());

			
			Villes.add(v);
		}

		tx.commit();
		s.close();
		return Villes;
	}
	
	public static Ville findById(int id)
	{
		ArrayList<Ville> Villes = selectAll();
		Iterator<Ville> i = Villes.iterator();
		Ville v = new Ville();
		for(;i.hasNext() ; v = i.next())
		{
			if (v.getId() == id)
			{
				return v;
			}
		}
		return new Ville();
	}
	
	public static boolean delete(Ville v)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Ville where id="+v.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean save(Ville v)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Ville(nom) values (\'"+v.getNom()+"\')");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean update(Ville origine, Ville modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Ville set nom=\'"+modif.getNom()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}