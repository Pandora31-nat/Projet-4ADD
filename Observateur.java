package JeuVideo.Observer;

import JeuVideo2.*;
public interface Observateur {// l'observer celui qui va prendre les infos du changement de l'observateur
	
	public void updateJoueur(Joueur joueur, Element elment);


}
