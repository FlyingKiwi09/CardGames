import java.util.HashMap;
import java.util.Map.Entry;

public class HigherLowerDeck extends Deck{
	
	public static HashMap<String, Integer> symbols = new HashMap<>();
	
	public HigherLowerDeck() {
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
		symbols.put("J", 11 );
		symbols.put("Q", 12);
		symbols.put("K", 13);
	}
}
