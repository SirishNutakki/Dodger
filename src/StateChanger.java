
public class StateChanger {
	
	private static State current = null;
	//sets the current state of screen
	public static void setState(State state) {
		current = state;
	}
	//gets current state of screen
	public static State getState() {
		return current;
	}
}
