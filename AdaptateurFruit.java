package JeuVideo2;

public class AdaptateurFruit implements Element{
	
	private Fruit fruit;
		
	public AdaptateurFruit(Fruit fruit) {
		super();
		this.fruit = fruit;
	}

	@Override
	public int getValue() {
		return fruit.getFv();
	}
	
	@Override 
	public Cellule getPosition() {
		return fruit.getPosition();
	}

	@Override
	public String TypeElement() {
		return "Fruit";
	}
}
