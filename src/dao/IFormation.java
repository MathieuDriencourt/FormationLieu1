package dao;

import java.util.List;

import model.Formation;
import model.Lieu;



public interface IFormation {

	
	public int ajoutFormation(Formation form);
	public List<Formation> afficheFormations();
	public List<Formation> getFormations(Lieu lieu);
}
