package JeuVideo2.strat;

public class Joueur {
	Strategie strategie;

	public Strategie getStrategie() {
		return strategie;
	}

	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}
	
	public void seDeplacer() {
		this.strategie.seDeplacer();
	}
}