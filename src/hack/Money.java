package hack;

public class Money {
	final private int TAXPERPERSON = 2;
	int cash;

	public Money(int startingCash) {
		cash = startingCash;
	}

	public void Taxes(int population) {
		cash = population * TAXPERPERSON; 
	}

	public void Purchase(int cost) {
		cash = cash - cost;
	}
}