package Test;

import JeuVideo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Grille grille, grille2;
		
		grille= new Grille(20,20);
		System.out.println("On a une grille de "+ grille.getNbLignes()+" lignes et "+ grille.getNbColonnes()+ " colonnes");
		System.out.println();
		grille.placeElement();
		
		System.out.println();
		
		
		Joueur joueur1, joueur2, joueur3, joueur4;
		Cellule depart, arrive, position1, position2;
		
		depart= grille.getCellule(4,5);
		arrive= grille.getCellule(2,18);
		position1= grille.getCellule(10, 2);
		position2= grille.getCellule(5,11);
		
		
		/**positionElement1= grille.getCellule(5, 15);
		positionElement2= grille.getCellule(2, 18);
		System.out.println(positionElement1.getElement());
		ce n'est pas la bonne idée c'est pourquoi on decide de passer à autre chose
		**/
		
		joueur1= new Chasseur(1, depart,3, grille); // je ne peux pas instancier avec Joueur car c'est une classe abstraite
		joueur2= new Chasseur(2,arrive, 15, grille);// je peux utiliser Bonhomme ou chasseur
		
		joueur3= new Bonhomme(3, arrive, 20, grille);
		joueur4= new Bonhomme(4, position1, 20, grille);
		
		Cellule cible= grille.getCellule(4,5); // on prend une cellule qui appartient à la grille
		grille.setCible(cible);
		
		joueur1.isVivant();
		joueur1.atteinte_cible(cible);
		
		joueur2.atteinte_cible(cible);
		
		
		Element element1, element2;
		
		element1= depart.getElement();
		element2= arrive.getElement();
		
		//System.out.println(element1.getPosition());
		joueur1.prendreElement(element1);
		
		joueur2.prendreElement(element2);
		
		System.out.println(joueur1.getPosition());
		System.out.println(joueur2.getPosition());
		System.out.println(joueur3.getPosition());
		System.out.println(joueur4.getPosition());
		
		//joueur2.recupererEnergie(); methode obsolete maintenant
		System.out.println("L'energie du joueur est de "+ joueur1.getEnergie());
		System.out.println("L'energie du joueur est de "+ joueur2.getEnergie());
		
		//joueur1.seDeplacer();
		//joueur3.seDeplacer();
		
		((Chasseur) joueur2).eliminer((Bonhomme)joueur3); // OK
		// joueur1.eliminer(); ne fonctionne pas car j'initialise les joueur avec la classe Joueur.
		joueur4.seDeplacer();
		
		grille.isJeu_en_cours(joueur1, cible);

	}

}
