public class Game {

    private int maxGuesses;
	private String selectedWord;
    private char[] maskedWord;
    private int remainingGuesses;
    private String guessedLetters;

    public Game(int maxGuesses) {
    	this.maxGuesses = maxGuesses;
        initialize();
    }

    private void initialize() {
        selectedWord = WordList.getRandomWord().toUpperCase();
        maskedWord = getHiddenWord(selectedWord);
        remainingGuesses = maxGuesses;
        guessedLetters = "";
    }
    
    private char[] getHiddenWord(String word) {
    	char[] hiddenWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
        	hiddenWord[i] = '-';
        }
        return hiddenWord;
    }

    public void startGame() {
    	UI ui = new UI();
        ui.printGreeting();

        while (remainingGuesses > 0) {

            ui.printResult(maskedWord, guessedLetters, remainingGuesses);
            char guessedLetter = ui.getValidatedLetterFromPlayer(guessedLetters);
            guessedLetters += guessedLetter;
            
            boolean isCorrectGuess = checkGuess(guessedLetter);
            if (!isCorrectGuess) {
                remainingGuesses--;
                ui.printIncorrectGuess();
            }

            if (isGameWon()) {
                ui.printGameWon(selectedWord);
                break;
            }
        }

        if (isGameOver(ui)) {
            ui.printGameOver(selectedWord);
        }
        ui.closeScanner();
    }

    private boolean checkGuess(char guessedLetter) {
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == guessedLetter) {
                maskedWord[i] = guessedLetter; // Reveal the letter
                return true;
            }
        }
        return false;
    }

    private boolean isGameWon() {
        return new String(maskedWord).equals(selectedWord);
    }

    private boolean isGameOver(UI ui) {
        if (remainingGuesses == 0) {
            ui.printResult(maskedWord, guessedLetters, remainingGuesses);
            return true;
        } else {
            return false;
        }
    }
}
