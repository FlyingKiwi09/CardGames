import java.awt.Color;

import ecs100.UI;

public class HigherLowerGame {
	
	private boolean guessHigher;
	private Deck gameDeck;
	private Card lastCard = null;
	private Card nextCard = null;

	public HigherLowerGame() {
		
	}
	
	public void play() {
		UI.initialise();
		UI.addButton("Play Higher or Lower", this::playGame);
	}
	
	public void playGame() {
		
		gameDeck = new Deck();
		gameDeck.shuffle();
		this.lastCard = gameDeck.getCards().get(gameDeck.getCards().size()-1);
		UI.setFontSize(40);
		drawCard(lastCard);
		gameDeck.getCards().remove(gameDeck.getCards().size()-1);
		UI.addButton("Higher", this::setHigher);
		UI.addButton("Lower", this::setLower);
//		UI.addButton("Go", this::go);
	}
	
	public void setHigher() {
		this.guessHigher = true;
		go();
	}
	
	public void setLower() {
		this.guessHigher = false;
		go();
	}
	
	public void go() {
		nextCard = gameDeck.getCards().get(gameDeck.getCards().size()-1);
		gameDeck.getCards().remove(gameDeck.getCards().size()-1);
		
		int compared = lastCard.compareTo(nextCard);
		
		if (guessHigher) {
			if (compared > 0) {
				UI.println("Nope");
			} else {
				UI.println("Yip");
			}
		} else {
			if (compared < 0) {
				UI.println("Nope");
			} else {
				UI.println("Yip");
			}
		}
		
		this.lastCard = this.nextCard;
		drawCard(lastCard);
	}
	
	public void turnCard() {
		
	}
	
	// draws a card to the UK
	public void drawCard(Card c) {
		UI.clearGraphics();
		if (c.getSuit() == Suit.Diamonds || c.getSuit() == Suit.Hearts ) {
			UI.setColor(Color.red);
		} else {
			UI.setColor(Color.black);
		}
		UI.drawString(c.getSymbol(), 100, 100);
		UI.drawString(c.getSuit().toString(), 100, 150);
	}
}
