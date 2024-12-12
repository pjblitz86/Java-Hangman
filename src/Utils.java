
public class Utils {
	
	public static boolean validateInput(String input) {
		return input.length() == 1 && Character.isLetter(input.charAt(0));
	}
	
	public static boolean isNewLetter(String guessedLetters, char guessedLetter ) {
		return guessedLetters.indexOf(guessedLetter) == -1;
	}
}
