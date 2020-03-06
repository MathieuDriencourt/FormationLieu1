package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Lieu {
@Override
	public String toString() {
		return "Lieu [idLieu=" + idLieu + ", ville=" + ville + ", adresse=" + adresse + ", formations=" + formations
				+ "]";
	}


public Lieu() {
		super();
		// TODO Auto-generated constructor stub
	}


@Id
@GeneratedValue
	private int idLieu;
	private String ville;
	private String adresse;
	@OneToMany (mappedBy = "lieu")
	List<Formation> formations;
	
	public Lieu(String adresse, String ville) {
		super();
		this.adresse = adresse;
		this.ville = ville;
	}


	public int getIdLieu() {
		return idLieu;
	}


	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public List<Formation> getFormations() {
		return formations;
	}


	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	
	
}
