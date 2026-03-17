package JeuVideo;

	// cette interface ne change pas. On est dans une interface

public class Element {

	private int id;
	private int energie;
	private Cellule position;
	protected Grille grille;
	
	public Element(int id, int energie, Cellule position) {
		this.id= id;
		this.energie= energie;
		this.position=position;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public Cellule getPosition() {
		return this.position;
	}

	public void setPosition(Cellule position) {
		this.position = position;
	}
	
	
}
