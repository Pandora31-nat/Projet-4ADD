package JeuVideo2.strat;
import JeuVideo2.*;

public class StrategieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		Strategie s1= new StrategieConcrete1();
		Strategie s2= new StrategieConcrete2();
		
		Joueur j1= new Joueur();
		j1.setStrategie(s1);
		j1.seDeplacer();
		j1.setStrategie(s2);
		j1.seDeplacer();
		*/

		// Créer une grille et une cellule de départ
		  Grille grille = new Grille(5,5);
		  Cellule depart = grille.getCellule(0,0);

		 // Créer le Bonhomme
		  Bonhomme j1 = new Bonhomme(1, depart, 20, grille);

		 // Créer les stratégies
		 Strategie s1 = new StrategieConcrete1();
		 Strategie s2 = new StrategieConcrete2();

		 // Tester le déplacement
		 j1.setStrategie(s1);
		 j1.seDeplacer(); // Bonhomme utilise s1

		 j1.setStrategie(s2);
		 j1.seDeplacer(); // Bonhomme utilise s2
	
	}

}
