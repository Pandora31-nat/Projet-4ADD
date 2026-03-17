package JeuVideo2;

import java.util.List;

public class Chasseur extends Joueur{
	
	protected Grille grille;

	
	public Chasseur(int id, Cellule position, int energie, Grille grille) {
		super(id, position, energie, grille);
		this.grille= grille;
		seDeplacer();
	}

	
	@Override
	public Cellule seDeplacer() {
				// à spécifier 
		//verification des cellules adjacentes 
				List<Cellule> adjacentes = grille.getCasesAdjacentes(position);
				
			  	//décrementer une energie a chaque case
				
			    if (!adjacentes.isEmpty()) {
			    // pour l'instant, se déplacer sur la première cellule adjacente
		        position = adjacentes.get(0);
		        // diminuer l'énergie d'une unité
		        energie -= 1;
			    
		        //effet de l'energie prise sur la case 
		        //si energie non nul on le prend 
		        if (position.getElement() != null) {
		            prendreElement(position.getElement());		           
		            
		    }
		        // on doir verifier si chasseur est vivant 
		        if (!this.isVivant()) {
		            System.out.println("Le chasseur est mort");
		           
			    }
			    }
			    
				return position;
	}
}
