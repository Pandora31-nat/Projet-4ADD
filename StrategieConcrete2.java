package JeuVideo2.strat;

import JeuVideo2.Bonhomme;
import JeuVideo2.Cellule;
import java.util.List;

public class StrategieConcrete2 implements Strategie {

    @Override
    public Cellule choisirProchaineCellule(Bonhomme bonhomme, List<Cellule> adjacentes) {
    	// parcourt toutes cases adjacentes
    	//verificatrion que le bonhomme na pas visiuter encore ces cellules 
        for (Cellule c : adjacentes) {
            if (!bonhomme.aVisite(c)) {
                return c;
                //des quon voit une cellule non visirter on la sort de la boucle 
            }
        }
        return adjacentes.get(0); //si toutes cellules ont deja ete visiter on prend la premiere cellule et pas null
    }

	@Override
	public void seDeplacer() {
		// TODO Auto-generated method stub
		
	}
}
