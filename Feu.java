package JeuVideo2;

public class Feu {
	private Joueur joueur;
	private Cellule position;

	public Feu(int v, Cellule position) {
		super();
		this.v = v;
		this.position= position;
	}

	private int v;

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
	
	public int energieMoins(int v) {
		
		joueur.setEnergie(joueur.getEnergie() - v);
		
		return v;
	}

	public Cellule getPosition() {
		return position;
	}

	public void setPosition(Cellule position) {
		this.position = position;
	}
}
	