package JeuVideo2;

import JeuVideo.Joueur;

public class Predateur {
	
		private Joueur joueur;
		private int predateurValue;
		private Cellule position;
		
		public Predateur(int predateurValue, Cellule position) {
			super();
			this.predateurValue = predateurValue;
			this.position= position;
		}


		public int getPredateurValue() {
			return predateurValue;
		}

		public void setPredateurValue(int predateurValue) {
			this.predateurValue = predateurValue;
		}
		
		public int perteEnergie(int predateurValue) {
			
			joueur.setEnergie(joueur.getEnergie()- predateurValue);
			return -predateurValue;
		}


		public Cellule getPosition() {
			return position;
		}


		public void setPosition(Cellule position) {
			this.position = position;
		}

}
