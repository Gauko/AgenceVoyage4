package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import org.hibernate.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Societe;

public class SocieteDAO 
{
	
	public static ArrayList<Societe> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("select new "+HibernateUtil.locatePojo+".Societe(s.id,s.nom) from Societe s");
		
		ArrayList<Societe> Societes = new ArrayList<Societe>();
		
		List<?> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Societe a = (Societe)res.get(i);
			Societe so = new Societe();
			so.setId(a.getId());
			so.setNom(a.getNom());

			
			Societes.add(so);
		}

		tx.commit();
		s.close();
		return Societes;
	}
	
	public static Societe findById(int id)
	{
		ArrayList<Societe> Societes = selectAll();
		Iterator<Societe> i = Societes.iterator();
		Societe so = new Societe();
		for(;i.hasNext() ; so = i.next())
		{
			if (so.getId() == id)
			{
				return so;
			}
		}
		return new Societe();
	}
	
	public static boolean delete(Societe so)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Societe where id="+so.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean save(Societe so)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Societe(nom) values (\'"+so.getNom()+"\')");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean update(Societe origine, Societe modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Societe set nom=\'"+modif.getNom()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}