package JeuVideo2;

public class AdaptateurFeu implements Element{ // si on implements Element, il devient de type Element
	private Feu feu;
	
	public AdaptateurFeu(Feu feu) {
		super();
		this.feu = feu;
	}
	@Override
	public int getValue() {
		return -feu.getV(); // car perte d'energie
	}
	
	@Override
	public Cellule getPosition() {
		return feu.getPosition();
	}
	
	@Override
	public String TypeElement() {
		return "Feu";
	}


}
