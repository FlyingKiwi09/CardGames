import java.util.Comparator;

public class AceHighOrLow implements Comparator<Card> {

	boolean descision;
	
	public AceHighOrLow(boolean userDescision) {
		
		descision = userDescision;
	}
	
	@Override
	public int compare(Card card1, Card card2) { // card1 = lastCard, card2 = nextCard
		
		/* returns +ve where next is lower than the last card
		 * returns -ve where next is higher than the last card
		 * forces a +ve (next is lower) where the last card was an Ace (Ace is high as well as low)
		 * forces a -ve (next is high) where the next card is an Ace (Ace is high as well as low)*/
		if (descision == false) {// user has selected lower
			if (card1.getRank() == 1) { // last card is an ace and would normally return -ve i.e next is higher but next can be lower if Ace is considered high
				return 1;	// therefore return next was lower because next "WAS" lower than a high Ace
			}
		}
		
		if (descision == true) { // user has selected higher
			if (card2.getRank() == 1) { // the next card is an ace would normally return +ve i.e. next is lower, but nest can be higher if Ace is considered high
				return -1; // therefore return next was higher because next "WAS" a high Ace
			}
		}
		
		return card1.getRank()- card2.getRank(); 
	}
}

