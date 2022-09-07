import ecs100.UI;

public class BlackJackGame {
	
	private boolean gameOver = false;
	private Deck gameDeck;
	private BlackJackHand playerHand;
	private BlackJackHand houseHand;
	private BlackJackHand winner = null;
	
	
	public BlackJackGame() {
		
	}
	
	public void play() {
		UI.initialise();
		UI.addButton("Play BlackJack", this::newGame);
		UI.addButton("Main Menu", this::reload);
	}
	
	public void reload() {
		Main.user.reload();
	}
	
	public void newGame() {
		UI.initialise();
		gameOver = false;
		
		// create deck of cards
		gameDeck = new BlackJackDeck();
		gameDeck.shuffle();
		
		// create playerHand
		playerHand = new BlackJackHand(this.gameDeck, "Player 1", 50, 40);
		houseHand = new BlackJackHand(this.gameDeck, "House", 250, 40);
		UI.setFontSize(20);
		playerHand.drawHand();
		
		UI.addButton("Call", this::call);
		UI.addButton("Hit", this::hit);
		UI.addButton("New Game", this::play);
	}
	
	public void hit() {
		playerHand.getCards().add(gameDeck.dealCard());
		UI.clearGraphics();
		playerHand.drawHand();
		if (playerHand.isBust()) {
			UI.println("You Lose");
		}
		
		if (houseHand.getCall()==false) { // if the house hasn't already called
			houseTurn();
		}
		
	}
	
	public void call() {
		playerHand.setCall(true);
		while (houseHand.getCall()==false) {
			houseTurn();
		}
		houseHand.drawHand();
	}
	
	public void houseTurn() {
		UI.println("House is playing...");
		UI.sleep(1000);
		UI.println("3... ");
		UI.sleep(1000);
		UI.println("2... ");
		UI.sleep(1000);
		UI.println("1... ");
		
		if (houseHand.autoPlay()) { // if the house wants to play
			houseHand.getCards().add(gameDeck.dealCard()); // deal a card to the house
			if (houseHand.isBust()) {
				UI.println("House goes bust, you win!");
				houseHand.displayHand();
			}
		} else { // if the house doesn't take a card
			UI.println("House calls...");
		}
	}
	
}
