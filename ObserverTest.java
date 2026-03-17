package JeuVideo.Observer;

import JeuVideo2.*;

public class ObserverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  // Crée la grille et le joueur
        Grille grille = new Grille(20,20);
        
        System.out.println();
        
        grille.placeElement();
        
        Cellule posInitiale = grille.getCellule(5,5);
        Joueur joueur = new Chasseur(1, posInitiale, 100, grille);
        
        
        Element element= grille.getCellule(5, 10).getElement();

        // Crée et attache l'observateur
        AdaptateurJoueur adaptateur = new AdaptateurJoueur(grille);
        joueur.addObserver(adaptateur);

        joueur.prendreElement(element);
        // Modifie l'état du joueur et observe les messages
        System.out.println("----- Test 1 : changement d'énergie -----");
        joueur.setEnergie(80);

        System.out.println("\n----- Test 2 : déplacement -----");
        joueur.seDeplacer();

        System.out.println("\n----- Test 3 : énergie à 0 (mort) -----");
        joueur.setEnergie(0);
        
        
        Cellule cible= grille.getCellule(5,5);
        grille.setCible(cible);
        
        System.out.println("\n----- Test 4 : avec une cible -----");
        joueur.atteinte_cible(cible);
        
        grille.isJeu_en_cours(joueur, cible);
	}

}
