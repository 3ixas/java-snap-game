package elias.snap;

public class Main {
    public static void main(String[] args) {

        // Creates a new game instance
        CardGame snapGame = new CardGame("Snap");

        // Prints the game name
        snapGame.printGameInfo();

        // Print the deck before shuffling
        System.out.println("\nThe deck before shuffling:");
        snapGame.getDeck();

        // Shuffle the deck
        snapGame.shuffleDeck();
        System.out.println("\nThe deck after shuffling:");
        snapGame.getDeck();

        // Sort the deck by number
        snapGame.sortDeckInNumberOrder();
        System.out.println("\nThe deck sorted by number order:");
        snapGame.getDeck();

        // Sort the deck by suit
        snapGame.sortDeckIntoSuits();
        System.out.println("\nThe deck sorted by suit:");
        snapGame.getDeck();

        Snap snapGame = new Snap("Snap");
        snapGame.playSnap();
    }
}
