package elias.snap;

public class Main {
    public static void main(String[] args) {

        // Creates a new game instance
        CardGame snapGame = new CardGame("Snap");

        // Prints the game name
        snapGame.printGameInfo();

        System.out.println("\nThe deck before shuffling:");
        snapGame.getDeck();
    }
}
