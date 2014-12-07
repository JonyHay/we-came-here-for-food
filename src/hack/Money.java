package hack;

public class Money {
	final private int TAXPERPERSON = 2;
	int cash;

	public Money(int startingCash) {
		cash = startingCash;
	}

	public void Taxes(int population) {
		cash += population * TAXPERPERSON;
	}

	public boolean Purchase(int cost) {
		if (cash - cost > 0) {
			cash = cash - cost;
			return true;
		}
		return false;
	}
}