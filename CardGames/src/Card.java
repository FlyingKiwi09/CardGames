
public class Card implements Comparable<Card>{
	private Suit suit;
	private int rank;
	private String symbol;
	
	// constructor
	public Card(Suit suit, String symbol, int rank) {
		this.suit = suit;
		this.rank = rank;
		this.symbol = symbol;
	}

	// getters and setters
	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String toString() {
		return (this.suit + " " + this.rank + " " + this.symbol);
	}

	@Override
	public int compareTo(Card c) {
		return this.getRank() - c.getRank();
	}

}
