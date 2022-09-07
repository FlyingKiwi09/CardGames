import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Deck {
	protected ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck() {
	
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			Card thisCard = cards.get(i);
			int randomInt = (int)(1+ Math.random()*cards.size()-1);
			Card randomCard = cards.get(randomInt);
			cards.set(i, randomCard);
			cards.set(randomInt, thisCard);
		}
	}
	
	public Card dealCard() {
		Card nextCard = this.cards.get(0);
		this.cards.remove(0);
		return nextCard;
	}
}
