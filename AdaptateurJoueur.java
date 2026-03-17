package JeuVideo.Observer;

import JeuVideo2.*;
public class AdaptateurJoueur implements Observateur{
	private Cellule cible;
	private Grille grille;
	
	public AdaptateurJoueur(Grille grille) {
		this.grille= grille;
	}
	
	@Override
	public void updateJoueur(Joueur joueur, Element element) {
		System.out.println("Energie actuelle du joueur : " + joueur.getEnergie()); //energie
		if(joueur.isVivant()) { // etat mort ou pas
            System.out.println("Le joueur est toujours vivant");
        }
        else {
            System.out.println("Le joueur est mort");
        }
		
		System.out.println("La position du joueur est "+ joueur.getPosition()); // position du joueur
		
		// on cree et verifie que la cible existe 
		 Cellule cible = grille.getCible();
	        if (cible != null && joueur.atteinte_cible(cible)) {
	            System.out.println("Le joueur a atteint la cible. La partie est finie");
	        }
	        else {
	        	 System.out.println("Le joueur n'a pas atteint la cible. La partie continue");
	        }
	        
	        
	        if(element != null) {
	            System.out.println("Le joueur a pris un élément !");
	            System.out.println("Type : " + element.TypeElement());
	            System.out.println("Valeur : " + element.getValue());
	        }
		
	}
}
