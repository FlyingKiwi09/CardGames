import java.util.HashMap;
import java.util.Map.Entry;

public class BlackJackDeck extends Deck {
	public static HashMap<String, Integer> symbols = new HashMap<>();
	
	public BlackJackDeck() {
		storeValueSymbolPairs();
		for (Suit s: Suit.values()) {
			for (Entry e: symbols.entrySet()) {
				cards.add(new Card(s, (int)e.getKey(), e.getValue().toString()));
			}
		}
	}
	
	public static void storeValueSymbolPairs() {
		symbols.put("A", 1);
		for (int i = 2; i < 11; i++) {
			Integer symbol = i;
			symbols.put(symbol.toString(), symbol);
		}
		symbols.put("J", 10);
		symbols.put("Q", 10);
		symbols.put("K", 10);
	}
}
