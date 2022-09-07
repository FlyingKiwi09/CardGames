import ecs100.UI;

public class UserInterface {

	public UserInterface() {
		
	}
	
	public void load() {
		UI.initialise();
		UI.addButton("Higher or Lower", this::playHigherLower);
		UI.addButton("Black Jack", this::playBlackJack);
	}
	
	public void reload() {
		UI.initialise();
		UI.addButton("Play Higher or Lower", this::playHigherLower);
		UI.addButton("Play Black Jack", this::playBlackJack);
	}

	
	public void playHigherLower() {
		HigherLowerGame newGame = new HigherLowerGame();
		newGame.play();
	}
	
	public void playBlackJack() {
		BlackJackGame newGame = new BlackJackGame();
		newGame.play();
	}
}
