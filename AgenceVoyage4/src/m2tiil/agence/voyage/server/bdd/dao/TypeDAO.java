package m2tiil.agence.voyage.server.bdd.dao;

import java.util.*;

import org.hibernate.*;

import m2tiil.agence.voyage.server.bdd.HibernateUtil;
import m2tiil.agence.voyage.shared.bdd.pojo.Type;

public class TypeDAO 
{
	
	public static ArrayList<Type> selectAll()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query select = s.createQuery("select new "+HibernateUtil.locatePojo+".Type(t.id, t.libelle) from Type t");
		
		ArrayList<Type> Types = new ArrayList<Type>();
		
		List<?> res = select.list();

		for(int i=0;i<res.size();i++)
		{
			Type a = (Type)res.get(i);
			Type t = new Type();
			t.setId(a.getId());
			t.setLibelle(a.getLibelle());

			
			Types.add(t);
		}

		tx.commit();
		s.close();
		return Types;
	}
	
	public static Type findById(int id)
	{
		ArrayList<Type> Types = selectAll();
		Iterator<Type> i = Types.iterator();
		Type v = new Type();
		for(;i.hasNext() ; v = i.next())
		{
			if (v.getId() == id)
			{
				return v;
			}
		}
		return new Type();
	}
	
	public static boolean delete(Type t)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("delete from Type where id="+t.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean save(Type t)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("insert into Type(libelle) values (\'"+t.getLibelle()+"\')");
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
	
	public static boolean update(Type origine, Type modif)
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createSQLQuery("update Type set libelle=\'"+modif.getLibelle()+"\' where id="+origine.getId());
		
		q.executeUpdate();
		tx.commit();
		
		s.close();
		return true;
	}
}