package dao;

import java.util.List;

import model.Lieu;

public interface ILieu {

	public int createLieu (Lieu lieu);
	public List<Lieu> afficheLieux();
}
