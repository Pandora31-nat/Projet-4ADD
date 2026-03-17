package JeuVideo2.strat;

import java.util.List;

import JeuVideo2.Bonhomme;
import JeuVideo2.Cellule;

public class StrategieConcrete1 implements Strategie { 

    @Override
    //choisir case bonhomme
    public Cellule choisirProchaineCellule(Bonhomme bonhomme, List<Cellule> adjacentes) {
        
    	
    	//initialisation aucune cellule selectionner
        Cellule meilleure = null;
        
        //pour commencer valeur tres basse pour comparer les differents bonus
        
        int maxEnergie = Integer.MIN_VALUE;

        //parcourt de toutes les cellules adjacentes possibles 
        for (Cellule c : adjacentes) {
        	
        	//c une cellule de la grille
        	//getElement me retourne element de la grille feu fruit ou preda
        	// e variable qui stocke energie 
        	// initialise cette var au debut elle a 0
        	
            int e = 0;
            //si la cellule pas element on renvoie null
            if (c.getElement() != null) {
            	//on prend element de la celulle si non null 
                e = c.getElement().getValue();
                //on parcourt toutes les cellules adjhacentes a cote du bonhomme 
                //on a gardé en memoir le plus grand bonus avec la variable maxEnergie
                
            }
            if (e > maxEnergie) {
            	// e plus grand que celle quon a vu avant
                maxEnergie = e;
                //jusqua mtn meilleure bonus e 
                meilleure = c;
                //  if (e > maxEnergie) {
                maxEnergie = e;
                meilleure = c;
            }
        }
//si jai trouver un element je retourne le mllr sinon le 0 du debut 
        return (meilleure != null) ? meilleure : adjacentes.get(0);
    }

	@Override
	public void seDeplacer() {
		// TODO Auto-generated method stub
		
	}
}