package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import org.hibernate.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Trajet;

public class TrajetDAO 
{
	
	public static ArrayList<Trajet> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("select new "+HibernateUtil.locatePojo+".Trajet(t.id, t.date, t.idDepart,t.idArrivee, t.idMoyenTransport) from Trajet t");
		
		ArrayList<Trajet> Trajets = new ArrayList<Trajet>();
		
		List<?> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Trajet a = (Trajet)res.get(i);
			Trajet t = new Trajet();
			t.setId(a.getId());
			t.setDate(a.getDate());
			t.setIdArrivee(a.getIdArrivee());
			t.setIdDepart(a.getIdDepart());
			t.setIdMoyenTransport(a.getIdMoyenTransport());
			
			Trajets.add(t);
		}

		tx.commit();
		s.close();
		return Trajets;
	}
	
	public static Trajet findById(int id)
	{
		ArrayList<Trajet> Trajets = selectAll();
		Iterator<Trajet> i = Trajets.iterator();
		Trajet t = new Trajet();
		for(;i.hasNext() ; t = i.next())
		{
			if (t.getId() == id)
			{
				return t;
			}
		}
		return new Trajet();
	}
	
	public static boolean delete(Trajet t)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Trajet where id="+t.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean save(Trajet t)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Trajet(date, idDepart, idArrivee, idMoyenTransport) values ("+t.getDate()+","+t.getIdDepart()+","+t.getIdArrivee()+","+t.getIdMoyenTransport()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean update(Trajet origine, Trajet modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Trajet set date=\'"+modif.getDate()+"\', idDepart="+modif.getIdDepart()+"\', idArrivee="+modif.getIdArrivee()+"\', idMoyenTransport="+modif.getIdMoyenTransport()+" where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}

