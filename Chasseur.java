package JeuVideo;

import java.util.List;

public class Chasseur extends Joueur{
	
	protected Grille grille;
	private Cellule position;
	private Bonhomme bonhomme;

	
	public Chasseur(int id, Cellule position, int energie, Grille grille) {
		super(id, position, energie, grille);
		this.grille= grille;
	}

	
	@Override
	public Cellule seDeplacer() {
				// à spécifier 
		//verification des cellules adjacentes 
		List<Cellule> adjacentes = grille.getCasesAdjacentes(position);
		
	  	//verifier s'il y a case adjacentes sinon bouge pas 
		
		
	    if (!adjacentes.isEmpty()) {
	    	
	    //verifier si le bohnomme est dans une case adjacente
	    	 for (Cellule c : adjacentes) {
	    		 if (c.equals(bonhomme.getPosition())) {
	    			  position = c;
	                  System.out.println("Le chasseur a trouvé le bonhomme ! Partie terminée pour lui.");
					 	bonhomme== null;
	                  // Energie diminue quand même
	                  energie -= 1;
	                  return position;
	    			 
	    	 }
	    	
	    	 }
	    	 
	    	 //sinon choisir la case adjacente la plus proche de la cible
	    	  Cellule cible = grille.getCible();
	          Cellule meilleureCase = adjacentes.get(0);
	          int distanceMin = Math.abs(meilleureCase.getX() - cible.getX())
	                          + Math.abs(meilleureCase.getY() - cible.getY());

	          for (Cellule c : adjacentes) {
	              int distance = Math.abs(c.getX() - cible.getX()) 
	                           + Math.abs(c.getY() - cible.getY());
	              if (distance < distanceMin) {
	                  distanceMin = distance;
	                  meilleureCase = c;
	              }
	          }
	    	

	          //  Déplacer le chasseur sur la meilleure case
	          position = meilleureCase;

	          // Décrémenter l'énergie
	          energie -= 1;

	          // Vérifier s'il y a un élément bonus ou malus
	          if (position.getElement() != null) {
	              prendreElement(position.getElement());
	          }

	          //verifier si le chasseur est toujours vivant
	          if (!isVivant()) {
	              System.out.println("Le chasseur est mort, il ne peut plus se déplacer.");
	          }
	    }
	    
		return position;
	}
		
	}
}
