package JeuVideo2;

import java.util.List;
import java.util.Scanner;

import JeuVideo2.strat.Strategie;

public class Bonhomme extends Joueur {
	
	private Grille grille;
	
	public Bonhomme(int id, Cellule position, int energie, Grille grille) {
		super(id, position, energie, grille);
		this.grille= grille;
		seDeplacer();
		
	}

	@Override
	public Cellule seDeplacer() {
		// à spécifier
		//verification des cellules adjacentes 
				List<Cellule> adjacentes = grille.getCasesAdjacentes(position);
				
				//utilisateur ecrit dans la console 
				 Scanner scanner = new Scanner(System.in);

				    System.out.println("Joueur: "+ id+ " Choisissez une case :");
				    
				    //on parcourt les cases adjacentes et size c cb elements dans la liste 
				    for (int i = 0; i < adjacentes.size(); i++) {
				    	//recuperer une case
				    	Cellule c = adjacentes.get(i);
				    	//afficher position de la case 
				    	System.out.println(i + " -> (" + c.getX() + "," + c.getY() + ")");
				    	//utilisateur choisit un num de la case de son choix
				    }
				    	int choix = scanner.nextInt();
				    	//deplacement du bonhomme 
				    	position = adjacentes.get(choix);
				    	//energie diminue a chaque deplacement 
				    	energie -= 1;
						
				    	//applique le bonus ou malus
				    	if (position.getElement() != null) {
				    	    prendreElement(position.getElement());
				    	}
				    	// Vérifie si le bonhomme est encore vivant
				        if (!this.isVivant()) {
				            System.out.println("Le bonhomme est mort.");
				        }
				   
			    return position;

	}
	
	public boolean aVisite(Cellule c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setStrategie(Strategie s1) {
		// TODO Auto-generated method stub
		
	}

}
