public class WordList {
    public static final String[] WORDS = {
        "Berlin", "Paris", "London", "Madrid", "Rome",
        "Vienna", "Prague", "Warsaw", "Brussels", "Oslo",
        "Athens", "Zurich", "Lisbon", "Dublin", "Riga",
        "Tallinn", "Vilnius", "Sofia", "Zagreb", "Belgrade",
        "Monaco", "Andorra", "Stockholm", "Helsinki", "Budapest",
        "Geneva", "Milan", "Turin", "Lyon", "Bordeaux",
        "Marseille", "Valencia", "Seville", "Granada", "Cologne",
        "Hamburg", "Dresden", "Munich", "Salzburg", "Krakow",
        "Gdansk", "Poznan", "Split", "Skopje", "Sarajevo",
        "Tirana", "Podgorica", "Reykjavik", "Copenhagen", "Bratislava"
    };

    // Method to get a random word from the list
    public static String getRandomWord() {
        int index = (int) (Math.random() * WORDS.length);
        return WORDS[index];
    }
}