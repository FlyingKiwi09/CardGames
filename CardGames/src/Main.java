import java.util.HashMap;
import java.util.Set;

public class Main {
	
	public static HashMap<Integer, String> symbols = new HashMap<>();
	

	public static void main(String[] args) {
		storeValueSymbolPairs();
		Deck newDeck = new Deck();
		
		for (Card c: newDeck.getCards()) {
			System.out.println(c.toString());
		}
		
		newDeck.shuffle();
		
		System.out.println("Post Shuffle");
		for (Card c: newDeck.getCards()) {
			System.out.println(c.toString());
		}
		
		HigherLowerGame newGame = new HigherLowerGame();
		newGame.play();
	}
	
	public static void storeValueSymbolPairs() {
		symbols.put(1, "A");
		for (int i = 2; i < 11; i++) {
			Integer symbol = i;
			symbols.put(symbol, symbol.toString());
		}
		symbols.put(11, "J");
		symbols.put(12, "Q");
		symbols.put(13, "K");
	}
}
