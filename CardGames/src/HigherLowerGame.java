import java.awt.Color;

import ecs100.UI;

public class HigherLowerGame {
	
	private boolean guessHigher;
	private Deck gameDeck;
	private Card lastCard = null;
	private Card nextCard = null;
	private int count = 0;
	private boolean correct = true;
	private boolean gameOver = false;

	public HigherLowerGame() {
		
	}
	
	public void play() {
		UI.initialise();
		UI.addButton("Play Higher or Lower", this::playGame);
	}
	
	public void playGame() {
		UI.initialise();
		gameOver = false;
		correct = true;
		count = 0;
		gameDeck = new HigherLowerDeck();
		gameDeck.shuffle();
		this.lastCard = gameDeck.getCards().get(gameDeck.getCards().size()-1);
		UI.setFontSize(40);
		drawCard(lastCard);
		gameDeck.getCards().remove(gameDeck.getCards().size()-1);
		UI.addButton("Higher", this::setHigher);
		UI.addButton("Lower", this::setLower);
		UI.addButton("New Game", this::play);
	}
	
	public void setHigher() {
		if(!gameOver) {
			this.guessHigher = true;
			go();
		}
	}
	
	public void setLower() {
		if(!gameOver) {
			this.guessHigher = false;
			go();
		}
	}
	
	public void go() {
		nextCard = gameDeck.getCards().get(gameDeck.getCards().size()-1);
		gameDeck.getCards().remove(gameDeck.getCards().size()-1);
		
		AceHighOrLow comparator = new AceHighOrLow(guessHigher);
		
		int compared = comparator.compare(lastCard, nextCard);
		
		// update correct if the guess was incorrect
		if (guessHigher) {
			if (compared > 0) {
				correct = false;
			} 
		} else {
			if (compared < 0) {
				correct = false;
			} 
		}
		
		// update last card and draw it
		this.lastCard = this.nextCard;
		drawCard(lastCard);
		
		// update text based on correct / incorrect guess
		UI.clearText();
		if (correct == false) {
			gameOver = true;
			UI.println("Game Over!");
			UI.println("Streak: " + count + " correct guesses!");
		} else {
			count++;
			UI.println("Streak: " + count + " correct guesses!");
		}
	}
	
	public void turnCard() {
		
	}
	
	// draws a card to the UI
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
