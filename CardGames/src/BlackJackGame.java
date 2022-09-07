import ecs100.UI;

public class BlackJackGame {
	
	private boolean gameOver = false;
	private Deck gameDeck;
	private BlackJackHand playerHand;
	private BlackJackHand houseHand;
	private BlackJackHand winner = null;
	private BlackJackGameState gameState;
	
	
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
		UI.addButton("New Game", this::play);
		// resetValues
		gameOver = false;
		gameState = BlackJackGameState.player1Turn;
		
		// create deck of cards
		gameDeck = new BlackJackDeck();
		gameDeck.shuffle();
		
		// create playerHand
		playerHand = new BlackJackHand(this.gameDeck, "Player 1", 50, 40);
		houseHand = new BlackJackHand(this.gameDeck, "House", 250, 40);
		UI.setFontSize(20);
		playerHand.drawHand();
		
		while (gameState != BlackJackGameState.gameOver) {
			// if the player hasn't called yet, they get a turn
			if (playerHand.getCall() == false && !houseHand.isBust()) {
				player1Turn();
			}
			
			// if the house hasn't called yet, they get a turn
			if (houseHand.getCall() == false && !playerHand.isBust()) {
				houseTurn();
			}
			
			// if both have called, update gameState to gameOver
			if (playerHand.getCall() && houseHand.getCall()) {
				gameState = BlackJackGameState.gameOver;
			}
		}
		
		// return results
		printResults();
	}
	
	public void player1Turn() {
		UI.clearText();
		if (houseHand.getCall()) {
			UI.println("House has called");
		}
		UI.println("Your Turn");
		boolean validInput = false;
		while (!validInput) {
			String choice = UI.askString("Hit or Call?");
			if (choice.equalsIgnoreCase("hit")) {
				hit();
				validInput = true;
			} else if (choice.equalsIgnoreCase("call")) {
				call();
				validInput = true;
			} else {
				UI.println("Try again...");
			}
		}
	}
	
	public void hit() {
		playerHand.getCards().add(gameDeck.dealCard());
		UI.clearGraphics();
		playerHand.drawHand();
		if (playerHand.isBust()) {
			UI.println("You Lose");
			gameState = BlackJackGameState.gameOver;
		}	
	}
	
	public void call() {
		playerHand.setCall(true);
	}
	
	public void houseTurn() {
		UI.clearText();
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
				gameState = BlackJackGameState.gameOver;
			}
		} else { // if the house doesn't take a card
			UI.println("House calls...");
		}
	}
	
	// get and print results
	public void printResults() {
		houseHand.drawHand();
		
		if (!playerHand.isBust() && !houseHand.isBust()) {
			if (houseHand.compareTo(playerHand) > 1) {
				UI.println("You Lose");
			} else if (houseHand.compareTo(playerHand) < 1) {
				UI.println("You Win");
			} else {
				UI.println("Draw");
			}
		} else if (playerHand.isBust()) {
			UI.println("You went bust: You Lose");
		} else if (houseHand.isBust()) {
			UI.println("House went bust: You Win");
		}
			

	}
	
}
