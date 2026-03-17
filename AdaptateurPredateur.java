package JeuVideo2;

public class AdaptateurPredateur implements Element{
	private Predateur predateur;
	
	public AdaptateurPredateur(Predateur predateur) {
		super();
		this.predateur = predateur;
	}
	@Override
	public int getValue() {
		return -predateur.getPredateurValue();// car energie negative 
	}
	
	@Override
	public Cellule getPosition() {
		return predateur.getPosition();
	}

	@Override
	public String TypeElement() {
		return "Prédateur";
	}

}
