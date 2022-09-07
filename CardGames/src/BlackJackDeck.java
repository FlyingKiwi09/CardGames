import java.util.HashMap;
import java.util.Map.Entry;

public class BlackJackDeck extends Deck {
	public static HashMap<String, Integer> symbols = new HashMap<>();
	
	public BlackJackDeck() {
		storeValueSymbolPairs();
		for (Suit s: Suit.values()) {
			for (Entry<String, Integer> e: symbols.entrySet()) {
				cards.add(new Card(s, e.getKey(), (int)e.getValue()));
			}
		}
	}
	
	public static void storeValueSymbolPairs() {
		symbols.put("A", 1);
		for (int i = 2; i < 11; i++) {
			Integer rank = i;
			symbols.put(rank.toString(), rank);
		}
		symbols.put("J", 10);
		symbols.put("Q", 10);
		symbols.put("K", 10);
	}
}
