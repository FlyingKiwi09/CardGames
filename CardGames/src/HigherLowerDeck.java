import java.util.HashMap;
import java.util.Map.Entry;

public class HigherLowerDeck extends Deck{
	
	public static HashMap<Integer, String> symbols = new HashMap<>();
	
	public HigherLowerDeck() {
		storeValueSymbolPairs();
		for (Suit s: Suit.values()) {
			for (Entry e: symbols.entrySet()) {
				cards.add(new Card(s, (int)e.getKey(), e.getValue().toString()));
			}
		}
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
