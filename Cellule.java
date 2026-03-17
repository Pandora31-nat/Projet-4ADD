package JeuVideo;

public class Cellule {
	// c'est une classe métier une classe qui ne bouge pas

	private int x;
	private int y;
	private Element element;
	
	
	public Cellule(int x, int y) { // la cellule represente la position du joueur 
		//donc pour avoir la position on a juste besoin de savoir sur quelle cellule le joueur est
		this.x= x;
		this.y= y;
		//System.out.println("x: "+x+ "y: "+ y);
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

	public void setElement(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}
	
	
	public int getValue() { // prendre la valeur de l'element dans la cellule
		if (element==null) return 0;
		return element.getEnergie();
	}

	 @Override // pour avoir la position en x et y
	    public String toString() {
	        return "(" + x + ", " + y + ")";
	    }
	 
	 @Override // pour faire marcher la methode eliminer de chasseur car on compare des positions
	 public boolean equals(Object obj) {
	     if(this == obj) return true;           // même référence
	     if(obj == null || getClass() != obj.getClass()) return false;

	     Cellule other = (Cellule) obj;
	     return this.x == other.x && this.y == other.y;
	 }

	 @Override
	 public int hashCode() {
	     return 31 * x + y;
	 }
	
	public void removeElement() { // enlever l'element une fois que son energie à été prise par le joueur
		element= null;
	}
	
	
	
}
