package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import org.hibernate.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Reservation;

public class ReservationDAO 
{
	
	public static ArrayList<Reservation> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("select new "+HibernateUtil.locatePojo+".Reservation(r.id,r.idUtilisateur, r.idOffre) from Reservation r");
		
		ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
		
		List<?> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Reservation a = (Reservation)res.get(i);
			Reservation r = new Reservation();
			r.setId(a.getId());
			r.setIdUtilisateur(a.getIdUtilisateur());
			r.setIdOffre(a.getIdOffre());

			
			Reservations.add(r);
		}

		tx.commit();
		s.close();
		return Reservations;
	}
	
	public static Reservation findById(int id)
	{
		ArrayList<Reservation> Reservations = selectAll();
		Iterator<Reservation> i = Reservations.iterator();
		Reservation r = new Reservation();
		for(;i.hasNext() ; r = i.next())
		{
			if (r.getId() == id)
			{
				return r;
			}
		}
		return new Reservation();
	}
	
	public static boolean delete(Reservation r)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Reservation where id="+r.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean save(Reservation r)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Reservation(idUtilisateur, idOffre) values ("+r.getIdUtilisateur()+","+r.getIdOffre()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean update(Reservation origine, Reservation modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Reservation set idUtilisateur=\'"+modif.getIdUtilisateur()+"\', idOffre="+modif.getIdOffre()+" where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}

