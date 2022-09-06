import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Deck {
	private HashSet<Card> cards = new HashSet<Card>();
	
	public Deck() {
		for (Suit s: Suit.values()) {
			for (Entry e: Main.symbols.entrySet()) {
				cards.add(new Card(s, (int)e.getKey(), e.getValue().toString()));
			}
		}
	}

	public HashSet<Card> getCards() {
		return cards;
	}

	public void setCards(HashSet<Card> cards) {
		this.cards = cards;
	}
	
	
}
