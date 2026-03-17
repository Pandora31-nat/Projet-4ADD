package JeuVideo2;

import java.util.ArrayList;

import JeuVideo.Observer.Observateur;

public abstract class Joueur { // la classe joueur va etre l'observable
	
	protected int id;
	public int energie;
	protected Cellule position;
	protected boolean vivant;
	private Grille grille;
	private ArrayList<Observateur> observateurs = new ArrayList<>(); // pour pouvoir utiliser interface observateur
	
	public Joueur(int id,Cellule position, int energie, Grille grille) {
		this.id=id;
		this.position= position;
		this.energie= energie;
		this.grille= grille;
	}
	
	// Getteurs et setteurs
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEnergie() {
		return energie; // pour recevoir l'energie de l'objet de la cellule
	}
	public void setEnergie(int energie) {
		this.energie = energie;
		prevenirObservateur(null);
	}
	
	/**public int recupererEnergie() {// redondant donc on va supprimer
		return energie += position.getValue(); // pour recevoir l'energie de l'objet de la cellule
	}**/
	
	public Cellule getPosition() {
		return position;
	}
	public void setPosition(Cellule position) {
		this.position = position;
		prevenirObservateur(null);
		
	}
	
	/**public boolean isVivant() {
		 if (energie>0) {// c'est une methode qui a besoin de l'energie
			 System.out.println("Joueur: "+ id+ " Vous etes toujours vivant, vous pouvez continue de joueur");
			 return true;
		 }
		 else {
			 System.out.println("Joueur: "+ id+ " Vous avez perdu toute votre energie, vous etes morts. La partie est finie");
			 return false;
		 }
		
	}**/
	
	public boolean isVivant() {
	    boolean vivant = energie > 0;
	    // notifier l'observateur si l'état du joueur a changé
	    prevenirObservateur(null); // on envoie null car pas d'élément associé
	    return vivant;
	}
	
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
		prevenirObservateur(null);
	}
	
	public abstract Cellule seDeplacer(); // methode abstraite à spécifier dans les methodes de bonhomme et chasseur
	
	/** public boolean atteinte_cible(Cellule cible) {
		if(cible.equals(position)) { // le joueur atteint la cible si il est sur la meme position
			System.out.println("Le joueur a atteint la cible, bien joué");
			prevenirObservateur(null);
			return true;
		}
		else {
			System.out.println("Vous etes encore loin de la cible");
			return false;
		}
	}**/
	
	public boolean atteinte_cible(Cellule cible) {
	    boolean atteint = cible.equals(position);
	    // notifier l'observateur si l'état du joueur a changé
	    prevenirObservateur(null); // pas d'élément associé
	    return atteint;
	}
	
	
	public Element prendreElement(Element element) {
		if(element== null) {
			System.out.println("Il n'y a pas d'element dans la case sur laquelle tu te trouves");
			return null;
			
			} //pour stopper la methode
		
		if (position.equals(element.getPosition())){ // on fait une condition sinon il peut prendre un element qui n'existe pas
			if(element.getValue() >0) {
				
			//System.out.println ("L'élément que tu as pris est de type "+ element.TypeElement());
			//System.out.println("Tu as pu prendre l'element avec succes, tu gagnes "+ element.getValue()+ " points d'energie");
			
			energie += element.getValue();
			//System.out.println("Energie gagnée : " + element.getValue());
		    //System.out.println("Nouvelle energie : " + energie);
			
			position.removeElement();
			prevenirObservateur(element);
			}
			else {
				//System.out.println ("L'élément que tu as pris est de type "+ element.TypeElement());
				//System.out.println("Tu as pu prendre l'element avec succes, mais c'était un malus tu perds donc "+ element.getValue()+ " points d'energie");
				
				energie += element.getValue();
				//System.out.println("Energie gagnée : " + element.getValue());
			    //System.out.println("Nouvelle energie : " + energie);
			    
				position.removeElement();
				prevenirObservateur(element);
			}
		}
		
		return element;	

	}
	
	// partie du jeu avec Observateur
	
	public void addObserver(Observateur observe) {// ajouter les observer dans la liste
	    observateurs.add(observe);
	}

	public void prevenirObservateur(Element element) { // a utiliser à chaque changement d'etat pour le joueur
	    for(Observateur observateur : observateurs) {
	        observateur.updateJoueur(this, element);
	    }
	}

	
}

