import java.awt.Color;
import java.util.ArrayList;

import ecs100.UI;

public class BlackJackHand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private boolean containsAce = false;
	private String name;
	private boolean call;
	private int x;
	private int y;
	
	public BlackJackHand(Deck gameDeck, String name, int x, int y) {
		Card firstCard = gameDeck.dealCard();
		Card secondCard = gameDeck.dealCard();
		cards.add(firstCard);
		cards.add(secondCard);
		this.name = name;
		this.call = false;
		this.x = x;
		this.y = y;
	}
	
	public int getSum() {
		int sum = 0;
		for (Card c: cards) {
			sum = sum + c.getRank();
		}
		return sum;
	}
	
	public int getSumHighAce() {
		int sum = 0;
		for (Card c: cards) {
			if(c.getSymbol().equals("A")) {
				containsAce = true;
				sum = sum + 11;
			} else {
				sum = sum + c.getRank();
			}
		}
		return sum;
	}
	
	public void displayHand() {
		
		// print cards
		UI.println(this.name);
		for (Card c: cards) {
			UI.print(c.getSymbol() + " " + c.getSuit() + ", ");
		}
		UI.println("\n");
		
		// print total
		if(containsAce) {
			UI.println("Total: " + getSum() + " / " + getSumHighAce());
		} else {
			UI.println("Total: " + getSum());
		}
		
	}
	
	public boolean isBust() {
		return (getSum() > 21);
	}
	
	public boolean shouldIPlay(int i) {
		
		if (i>20) {
			return false;
		} else if (i >19) {
			return (getRandom100() > 95);
		} else if (i >18) {
			return (getRandom100() > 90);
		} else if (i >17) {
			return (getRandom100() > 85);
		} else if (i >16) {
			return (getRandom100() > 70);
		} else if (i >15) {
			return (getRandom100() > 60);
		} else if (i >14) {
			return (getRandom100() > 40);
		} else if (i >13) {
			return (getRandom100() > 20);
		} else if (i >12) {
			return (getRandom100() > 10);
		} else if (i >11) {
			return (getRandom100() > 5);
		} else {
			return true;
		}
		
	}
	
	public int getRandom100() {
		return (int) (1 + Math.random()*100);
	}
	
	public boolean autoPlay() {
		boolean shouldIPlay;
		
		if (getSumHighAce()==21 || getSum()==21) { // if we can make 21, call
			shouldIPlay = false;
		} else if (getSumHighAce() > 21) { // if the high ace is over 21, check whether we should play using ace = 1;
			shouldIPlay = shouldIPlay(getSum());
		} else { // if the high ace is less than 21, check whether we should play using low A;
			shouldIPlay = shouldIPlay(getSumHighAce());
		} 
		
		if (shouldIPlay) {
			
		} else {
			this.call = true;
		}
		
		return shouldIPlay;
	}

	// getters and setters
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public boolean isContainsAce() {
		return containsAce;
	}

	public void setContainsAce(boolean containsAce) {
		this.containsAce = containsAce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getCall() {
		return call;
	}

	public void setCall(boolean call) {
		this.call = call;
	}
	
	public void drawHand() {
		UI.drawString(this.name, x, y);
		for (int i = 0; i < cards.size(); i++) {
			Card c = cards.get(i);
			if (c.getSuit() == Suit.Diamonds || c.getSuit() == Suit.Hearts ) {
				UI.setColor(Color.red);
			} else {
				UI.setColor(Color.black);
			}
			UI.drawString(c.getSymbol(), x, y+(i+1)*40);
			UI.drawString(c.getSuit().toString(), x+30, y+(i+1)*40);
		}
	}
	
}
