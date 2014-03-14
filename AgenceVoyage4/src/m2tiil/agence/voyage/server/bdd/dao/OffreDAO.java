package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import org.hibernate.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Offre;

public class OffreDAO 
{
	
	public static ArrayList<Offre> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("select new "+HibernateUtil.locatePojo+".Offre(o.id,o.libelle,o.prix,o.placesTotales,o.placesDisponibles,o.idTrajet) from Offre o");
		
		ArrayList<Offre> offres = new ArrayList<Offre>();
		
		//System.out.println(select.list().get(0).getClass().toString());
		List<?> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Offre a = (Offre)res.get(i);
			Offre o = new Offre();
			o.setId(a.getId());
			o.setLibelle(a.getLibelle());
			o.setPlacesDisponibles(a.getPlacesDisponibles());
			o.setPlacesTotales(a.getPlacesTotales());
			o.setPrix(a.getPrix());
			o.setIdTrajet(a.getIdTrajet());
			
			offres.add(o);
			
			//System.out.println(o.toString());
		}

		tx.commit();
		s.close();
		return offres;
	}
	
	public static Offre findById(int id)
	{
		ArrayList<Offre> offres = selectAll();
		Iterator<Offre> i = offres.iterator();
		Offre o = new Offre();
		for(;i.hasNext() ; o = i.next())
		{
			if (o.getId() == id)
			{
				return o;
			}
		}
		return new Offre();
	}
	
	public static boolean delete(Offre o)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Offre where id="+o.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean save(Offre o)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Offre(libelle, placesDisponibles, placesTotales, prix, idTrajet) values (\'"+o.getLibelle()+"\',"+o.getPlacesDisponibles()+","+o.getPlacesTotales()+","+o.getPrix()+","+o.getIdTrajet()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean update(Offre origine, Offre modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Offre set libelle=\'"+modif.getLibelle()+"\', placesDisponibles="+modif.getPlacesDisponibles()+", placesTotales="+modif.getPlacesTotales()+",prix="+modif.getPrix()+", idTrajet="+modif.getIdTrajet()+" where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}
