package JeuVideo2.strat;

import JeuVideo2.Bonhomme;
import JeuVideo2.Cellule;
import java.util.List;
//une interface donc juste signature d'une methode 
public interface Strategie {
    // Cette méthode retourne la cellule vers laquelle le Bonhomme va se déplacer
    Cellule choisirProchaineCellule(Bonhomme bonhomme, List<Cellule> adjacentes);

	void seDeplacer();
}