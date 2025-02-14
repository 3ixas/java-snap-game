package elias.snap;

import java.util.Scanner;

public class Snap extends CardGame {
    private Card previousCard;
    private final Scanner scanner;

    // Constructor
    public Snap(String gameName) {
        super(gameName); // Calls the constructor of CardGame
        this.previousCard = null;
        this.scanner = new Scanner(System.in);
    }

    // Method to play Snap
    public void playSnap() {
        System.out.println("Welcome to " + super.gameName + "! Press ENTER to draw a card from the deck.");
        shuffleDeck(); // Shuffle deck at the start

        while (!deckOfCards.isEmpty()) {
            scanner.nextLine(); // Wait for the user to press enter
            Card currentCard = dealCard(); // Draw a card
        }
    }
}
