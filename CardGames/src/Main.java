import java.util.HashMap;
import java.util.Set;

import ecs100.UI;

public class Main {
	
	public static UserInterface user;

	public static void main(String[] args) {
		user = new UserInterface();
		user.load();

	}
}
