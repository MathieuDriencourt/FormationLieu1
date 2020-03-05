package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Formation;
import model.Lieu;

public class Lieudao implements ILieu{

	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	@Override
	public int createLieu(Lieu lieu) {
		try {
			Session s = factory.openSession();
			s.beginTransaction();
			s.saveOrUpdate(lieu);
			s.getTransaction().commit();
			s.close();
			System.out.println("Insertion lieu réussie");
			return 1;
			} 
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Insertion lieu ratée");
				return 0;
			}
			}
		
		public List<Lieu> afficheLieux() {
			List<Lieu> listel = new ArrayList<Lieu>();
			try { 
				Session s = factory.openSession();
				s.beginTransaction();
				String requete = "Select * from lieu";
				SQLQuery query = s.createSQLQuery(requete);
				query.addEntity(Lieu.class);
				listel = query.list();
				System.out.println("La liste est faite");
				return listel;
				} catch (HibernateException e) {
					e.printStackTrace();
					System.out.println("la liste ne peut pas être faite");
				return null;
				}
	}
	
	
}
