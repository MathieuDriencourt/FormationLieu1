package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Formation;
import model.Lieu;

public class Formationdao implements IFormation {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();

	@Override
	public int ajoutFormation(Formation form) {
		try {
			session.beginTransaction();
			session.save(form);
			session.getTransaction().commit();
			System.out.println("Formation ajoutéé!");
			return 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("L'ajout d'une formation n'a pas fonctionné!");
			return 0;
		}
		
	}

	@Override
	public List<Formation> afficheFormations() {
		List<Formation> liste = new ArrayList<Formation>();
		try { 
			session.beginTransaction();
			String requete = "Select * from formation";
			SQLQuery query = session.createSQLQuery(requete);
			query.addEntity(Formation.class);
			liste = query.list();
			System.out.println("La liste est faite");
			return liste;
			} catch (HibernateException e) {
				e.printStackTrace();
			return null;
			}
	}

	@Override
	public List<Formation> getFormations(Lieu lieu) {
		List<Formation> liste = new ArrayList<Formation>();
		try {Session s = factory.openSession();
		s.beginTransaction();
		Query query = s.createQuery("from Formation where lieu.id  = :idLieu");
		query.setParameter("idLieu", lieu.getIdLieu());
		liste = query.list();
		System.out.println("formation par lieux réussie");
		return liste;
	}
	catch (HibernateException e) {
		e.printStackTrace();
		System.out.println("Erreur get formation par lieu");
		return null;
	}
	}

}
