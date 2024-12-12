import java.util.Scanner;

public class UI {	
	
	Scanner scanner = new Scanner(System.in);
	
	public void printGreeting() {
		System.out.println("Welcome to Hangman game. Guess the letters of masked word and don't get hanged. Good luck commander!");
	}
	
	public void printIncorrectGuess() {
		System.out.println("Incorrect guess!");
	}
	
	public void printGameWon(String selectedWord) {
		System.out.println("GAME WON! Good job, commander. You guessed the word: " + selectedWord);
	}
	
	public void printGameOver(String selectedWord) {
		System.out.println("Sorry, you ran out of guesses and got HANGED, commander. The correct word was: " + selectedWord);
	}
	
	public void closeScanner() {
		if (scanner != null) {
            scanner.close();
        }
	}
	
	public char getValidatedLetterFromPlayer(String guessedLetters) {
		char validatedLetter;
		
		while(true) {
			System.out.print("Enter a letter: ");
	        String input = scanner.nextLine().toUpperCase();
	        
	        if (!Utils.validateInput(input)) {
	            System.out.println("Please enter a valid letter.");
	            continue;
	        }

	        char guessedLetter = input.charAt(0);
	        
	        if (!Utils.isNewLetter(guessedLetters, guessedLetter)) {
	            System.out.println("You already guessed that letter.");
	            continue;
	        }
	        
	        validatedLetter = guessedLetter;
	        break;
		}
		
		return validatedLetter;
	}
	
	public void printResult(char[] maskedWord, String guessedLetters, int remainingGuesses) {
		System.out.println("*".repeat(20));
        System.out.println("Word: " + new String(maskedWord));
        System.out.println("Guessed letters: " + guessedLetters);
        
        switch (remainingGuesses) {
            case 0 -> printGameOver();
            case 1 -> printOneGuessLeft();
            case 2 -> printTwoGuessesLeft();
            case 3 -> printThreeGuessesLeft();
            case 4 -> printFourGuessesLeft();
            case 5 -> printFiveGuessesLeft();
            default -> printFullHealth();
        }
    }
	
	private void printGameOver() {
	        System.out.println("""
	                 _______
	                |       |
	                |       O
	                |      /|\\
	                |      / \\
	                |
	                |___ GAME OVER
	                """);
	}

    private void printOneGuessLeft() {
	        System.out.println("""
	                 _______
	                |       |
	                |       O
	                |      /|\\
	                |      /
	                |
	                |___ 1 GUESS LEFT
	                """);
	}

    private void printTwoGuessesLeft() {
        System.out.println("""
                 _______
                |       |
                |       O
                |      /|\\
                |      
                |
                |___ 2 GUESSES LEFT
                """);
    }

    private void printThreeGuessesLeft() {
        System.out.println("""
                 _______
                |       |
                |       O
                |      /|
                |      
                |
                |___ 3 GUESSES LEFT
                """);
    }

	   
    private void printFourGuessesLeft() {
        System.out.println("""
                 _______
                |       |
                |       O
                |       |
                |      
                |
                |___ 4 GUESSES LEFT
                """);
    }

    private void printFiveGuessesLeft() {
        System.out.println("""
                 _______
                |       |
                |       O
                |      
                |      
                |
                |___ 5 GUESSES LEFT
                """);
    }

	 private void printFullHealth() {
	        System.out.println("""
	                 _______
	                |       |
	                |
	                |
	                |
	                |
	                |___ FULL HEALTH
	                """);
    }
}