package JeuVideo2;

import JeuVideo.Joueur;

public class Fruit {
	private Joueur joueur;
	private int fv;
	
	private Cellule position;
	
	public Fruit(int fv, Cellule position) {
		super();
		this.fv = fv;
		this.position= position;
	}

	

	public int getFv() {
		return fv;
	}

	public void setFv(int fv) {
		this.fv = fv;
	}
	
	public int gainEnergie(int fv) {
	
		joueur.setEnergie(joueur.getEnergie() + fv);
		
		return fv;
	}



	public Cellule getPosition() {
		return position;
	}



	public void setPosition(Cellule position) {
		this.position = position;
	}

	
}
