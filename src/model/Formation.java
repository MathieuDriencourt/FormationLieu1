package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Formation {
@Override
	public String toString() {
		return "Formation [idformation=" + idformation + ", theme=" + theme + ", lieu=" + lieu + "]";
	}


@Id
@GeneratedValue
	private int idformation;
	private String theme;
	@JoinColumn(name = "idLieu")
	@ManyToOne
	private Lieu lieu;
	
	public Formation(String theme) {
		super();
		this.theme = theme;
	}


	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getIdformation() {
		return idformation;
	}


	public void setIdformation(int idformation) {
		this.idformation = idformation;
	}





	public Lieu getLieu() {
		return lieu;
	}


	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}
	
}
