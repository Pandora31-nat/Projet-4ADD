package JeuVideo2;

public class Cellule {
	private Element element;
	private int x;
	private int y;
	
	public Cellule(int x, int y) { 
		this.x= x;
		this.y= y;
	}
	
	public Cellule (Element element) {// un deuxieme constructueur
		this.element= element;
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
	
	public int getEnergie() {
		return element.getValue();
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}
	
	public void removeElement() { // enlever l'element une fois que son energie à été prise par le joueur
		element= null;
	}
	
	 @Override // pour avoir la position en x et y
	    public String toString() {
	        return "(" + x + ", " + y + ")";
	    }


}
