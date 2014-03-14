package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import org.hibernate.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.MoyenDeTransport;

public class MoyenDeTransportDAO 
{
	
	public static ArrayList<MoyenDeTransport> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("select new "+HibernateUtil.locatePojo+".MoyenDeTransport(m.id,m.nom,m.type,m.societe) from MoyenDeTransport m");
		
		ArrayList<MoyenDeTransport> MoyenDeTransports = new ArrayList<MoyenDeTransport>();
		
		List<?> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			MoyenDeTransport a = (MoyenDeTransport)res.get(i);
			MoyenDeTransport m = new MoyenDeTransport();
			m.setId(m.getId());
			m.setNom(a.getNom());
			m.setSociete(a.getSociete());
			m.setType(m.getType());

			
			MoyenDeTransports.add(m);
		}

		tx.commit();
		s.close();
		return MoyenDeTransports;
	}
	
	public static MoyenDeTransport findById(int id)
	{
		ArrayList<MoyenDeTransport> MoyenDeTransports = selectAll();
		Iterator<MoyenDeTransport> i = MoyenDeTransports.iterator();
		MoyenDeTransport m = new MoyenDeTransport();
		for(;i.hasNext() ; m = i.next())
		{
			if (m.getId() == id)
			{
				return m;
			}
		}
		return new MoyenDeTransport();
	}
	
	public static boolean delete(MoyenDeTransport m)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from MoyenDeTransport where id="+m.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean save(MoyenDeTransport m)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into MoyenDeTransport(nom,type,societe) values (\'"+m.getNom()+"\',"+m.getType()+","+m.getSociete()+")");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean update(MoyenDeTransport origine, MoyenDeTransport modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update MoyenDeTransport set nom=\'"+modif.getNom()+"\', type="+modif.getType()+",societe="+modif.getSociete()+" where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}