package JeuVideo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grille {

	private int id;
	private int nbLignes;
	private int nbColonnes;
	protected Cellule cible;
	private boolean jeu_en_cours;
	private Cellule[][] grille;
	private int ligne;
	private int colonne;
	private Element element;
	private int nbElement=0;
	private int totalCasesGrille; // on l'utilisera plus tard pour la creation des éléments
	
	public Grille(int nbLignes, int nbColonnes) {
		this.nbColonnes= nbColonnes;
		this.nbLignes= nbLignes;
		grille = new Cellule[nbLignes][nbColonnes];
        initialiser();
        this.totalCasesGrille= nbLignes * nbColonnes;
        implementElement();
	
	}

	
	
	//Setteurs et getteurs 
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public int getNbLignes() {
		return nbLignes;
	}



	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}



	public int getNbColonnes() {
		return nbColonnes;
	}



	public void setNombreColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}

	public Cellule getCible() {
		return cible;
	}

	public void setCible(Cellule cible) {
		this.cible = cible;
	}
	
	public void setJeu_en_cours(boolean jeu_en_cours) {
		this.jeu_en_cours = jeu_en_cours;
	}

	//Methodes
	
	public void initialiser() {
	    for (int i = 0; i < nbLignes; i++) {
	        for (int j = 0; j < nbColonnes; j++) {
	            grille[i][j] = new Cellule(i, j);
	        }
	    }
	}


	public Cellule getCellule( int ligne, int colonne) {// la cellule que l'on va attribuer à un element ou un joueur
		return grille[ligne][colonne];					// soit la position du joueur ou de l'element
	}

	
	public boolean isJeu_en_cours(Joueur j, Cellule cible) {

	    if(!j.isVivant()) {
	        System.out.println("Vous avez perdu toute votre energie, vous etes mort. La partie est finie");
	        return false;
	    }

	    if(j.atteinte_cible(cible)) {
	        System.out.println("Le joueur a atteint la cible, bien joué !");
	        return false;
	    }

	    System.out.println("La partie continue");
	    return true;
	}
	
	//methode cases adjacente pour se deplacer 
		public List<Cellule> getCasesAdjacentes(Cellule c) {
		    List<Cellule> adjacentes = new ArrayList<>();
		    int x = c.getX();
		    int y = c.getY();

		    // vérifier qu'on ne sort pas de la grille
		    if (x > 0) adjacentes.add(grille[x-1][y]);          // haut
		    if (x < nbLignes - 1) adjacentes.add(grille[x+1][y]); // bas
		    if (y > 0) adjacentes.add(grille[x][y-1]);          // gauche
		    if (y < nbColonnes - 1) adjacentes.add(grille[x][y+1]); // droite

		    return adjacentes;
		}
	

	//creer une methode qui implementer des elements dans la grille de maniere aleatoire
	
	 // je veux faire un pourcentage selon le total de la grille
	
	Random random= new Random(); // pour avoir quelque chose d'aleatoire plus tard dans le code
	
	public void implementElement() {// pour la deuxieme parti du jeu avec les divers éléments

		int casesParcourues = 0;
	    int limite = (int)(totalCasesGrille * 0.3); // maximum 30% des cases
	    int i = 0, j = 0;

	    while (casesParcourues < limite) {

	        if (i >= nbLignes) break;

	        if (j >= nbColonnes) {
	            j = 0;
	            i++;
	            if (i >= nbLignes) break;
	        }

	        int lancerDe = random.nextInt(2);

	        if (lancerDe == 1) {

	            nbElement++;
	            Cellule position = grille[i][j];

	            int type = random.nextInt(3); // 3 types d'éléments
	            Element element = null;

	            if (type == 0) {

	                Predateur p = new Predateur(15, position);
	                element = new AdaptateurPredateur(p);

	            } 
	            else if (type == 1) {

	                Feu f = new Feu(3,position);
	                element = new AdaptateurFeu(f);

	            } 
	            else {

	                Fruit fv = new Fruit(10,position);
	                element = new AdaptateurFruit(fv);

	            }

	            position.setElement(element);
	        }

	        casesParcourues++;
	        j++;
	    }

	    System.out.println("Création terminée : " + nbElement + " éléments créés");
	}
	
	public void placeElement() {
		
		for(int i = 0; i < nbLignes; i++){
		    for(int j = 0; j < nbColonnes; j++){

		        Cellule positionElement = grille[i][j];

		        if(positionElement.getElement() != null){
		            System.out.println("Element présent en : " + i + "," + j);
		        }

		    }
		}
		
	}
	
	

	
}
