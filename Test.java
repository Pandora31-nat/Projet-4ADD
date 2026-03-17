package JeuVideo2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Grille grille;
		Joueur joueur1, joueur2, joueur3, joueur4;
		Cellule depart, arrive, position1, position2;
		
		grille= new Grille(20,20);
		System.out.println("On a une grille de "+ grille.getNbLignes()+" lignes et "+ grille.getNbColonnes()+ " colonnes");
		System.out.println();
		grille.placeElement();
		
				
		
		depart= grille.getCellule(4,5);
		arrive= grille.getCellule(2,18);
		
		position1= grille.getCellule(5,10);
		position2= grille.getCellule(4,11);

		Element e1= new AdaptateurFeu(new Feu(-30, position1));
		Cellule c1= new Cellule(e1);
		
		//System.out.println(e1.getPosition());
		
		
		
		
		/**positionElement1= grille.getCellule(5, 15);
		positionElement2= grille.getCellule(2, 18);
		System.out.println(positionElement1.getElement());
		ce n'est pas la bonne idée c'est pourquoi on decide de passer à autre chose
		**/
		
		joueur1= new Chasseur(1, depart,3, grille); // je ne peux pas instancier avec Joueur car c'est une classe abstraite
		joueur2= new Chasseur(2,arrive, 15, grille);// je peux utiliser Bonhomme ou chasseur
		
		joueur3= new Bonhomme(3, position1, 20, grille);
		joueur4= new Bonhomme(4, position1, 20, grille);
		
		Cellule cible= grille.getCellule(4,5); // on prend une cellule qui appartient à la grille
		grille.setCible(cible);
		
		joueur1.isVivant();
		System.out.println();
		joueur1.atteinte_cible(cible);
		System.out.println();
		joueur2.atteinte_cible(cible);
		
		
		Element element1, element2;
		
		element1= depart.getElement();
		element2= arrive.getElement();
		
		//System.out.println(element1.getPosition());
		joueur1.prendreElement(element1);
		System.out.println();
		joueur2.prendreElement(element2);
		//joueur2.recupererEnergie(); methode obsolete maintenant
		System.out.println("L'energie du joueur 1 est de "+ joueur1.getEnergie());
		System.out.println("L'energie du joueur 2 est de "+ joueur2.getEnergie());
		
		grille.isJeu_en_cours(joueur4, cible);
		grille.isJeu_en_cours(joueur2, cible);
		/**joueur1.seDeplacer();
		
		joueur3.seDeplacer();
		joueur2.seDeplacer();
		 On a mis la methode seDeplacer dans le constructeur
		  du bonhomme et du joueur car c'est une methode qui leur sont propre
		 **/
	}

}
