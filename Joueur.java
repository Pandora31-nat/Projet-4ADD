package JeuVideo;
import java.util.ArrayList;
import java.util.List;

import JeuVideo.Observer.*;

public abstract class Joueur {
	
	protected int id;
	public int energie;
	protected Cellule position;
	protected boolean vivant;
	private Grille grille;
	
	public Joueur(int id,Cellule position, int energie, Grille grille) {
		this.id=id;
		this.position= position;
		this.energie= energie;
		this.grille= grille;
	}
	
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
	}
	
	/**public int recupererEnergie() {// redondant donc on va supprimer
		return energie += position.getValue(); // pour recevoir l'energie de l'objet de la cellule
	}**/
	
	public Cellule getPosition() {
		return position;
	}
	public void setPosition(Cellule position) {
		this.position = position;
	}
	
	public boolean isVivant() {
		 if (energie>0) {// c'est une methode qui a besoin de l'energie
			 System.out.println("Vous etes toujours vivant, vous pouvez continue de joueur");
			 return true;
		 }
		 else {
			 System.out.println("Vous avez perdu toute votre energie, vous etes morts. La partie est finie");
			 return false;
		 }
		
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}
	
	public abstract Cellule seDeplacer(); // methode abstraite à spécifier dans les methodes de bonhomme et chasseur
	
	/**public boolean atteinte_cible(Cellule cible) {
		if(cible.equals(position)) { // le joueur atteint la cible si il est sur la meme position
			System.out.println("Le joueur a atteint la cible, bien joué");
			return true;
		}
		else {
			System.out.println("Vous etes encore loin de la cible");
			return false;
		}
	}
	**/
	
	public boolean atteinte_cible(Cellule cible) {
	    return cible.equals(position);
	}
	
	public Element prendreElement(Element element) {
		if(element== null) {
			System.out.println("Il n'y a pas d'element dans la case sur laquelle tu te trouves");
			return null; //pour stopper la methode
			} 
		if (position.equals(element.getPosition())){ // on fait une condition sinon il peut prendre un element qui n'existe pas
			if(element.getEnergie() >0) {
			System.out.println("Tu as pu prendre l'element avec succes, tu gagnes "+ element.getEnergie()+ " points d'energie");
			
			energie += element.getEnergie();
			System.out.println("Energie gagnée : " + element.getEnergie());
		    System.out.println("Nouvelle energie : " + energie);
			
			position.removeElement();
			
			}
			else {
				System.out.println("Tu as pu prendre l'element avec succes, mais c'était un malus tu perds donc "+ element.getEnergie()+ " points d'energie");
				
				energie += element.getEnergie();
				System.out.println("Energie gagnée : " + element.getEnergie());
			    System.out.println("Nouvelle energie : " + energie);
			    
				position.removeElement();
			}
		}
		else {
	        System.out.println("L'élément n'est pas sur ta position, impossible de le prendre !");
	    }
		
		return element;	

	}
	
	
}
