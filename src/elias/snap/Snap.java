package elias.snap;

import java.util.Scanner;

public class Snap extends CardGame {
    private Card previousCard;
    private final Scanner scanner;
    private boolean snapCalled;
    private int currentPlayer;

    // Constructor
    public Snap(String gameName) {
        super(gameName); // Calls the constructor of CardGame
        this.previousCard = null;
        this.scanner = new Scanner(System.in);
        this.snapCalled = false;
        this.currentPlayer = 1; // Player 1 starts the game
    }

    // Method to play Snap with two players
    public void playSnap() {
        System.out.println("Welcome to " + getGameName() + "!");
        System.out.println("Player 1 and Player 2 take turns. Press ENTER to draw a card.");
        shuffleDeck(); // Shuffle deck at the start

        while (!getDeckOfCards().isEmpty()) {
            System.out.println("\nPlayer " + currentPlayer + ", press ENTER to draw a card.");
            scanner.nextLine(); // Wait for the player to press enter
            Card currentCard = dealCard(); // Draw a card

            if (currentCard != null) {
                System.out.println("Player " + currentPlayer + "drew: " + currentCard);

                if (previousCard != null && previousCard.getSymbol().equals(currentCard.getSymbol())) {
                    System.out.println("\nSNAP CHANCE! Type 'snap' within 2 seconds to win!");

                    if (snapReaction()) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        return; // Ends the game
                    } else {
                        System.out.println("Too slow! Game continues...");
                    }
                }

                previousCard = currentCard; // Updates the previous card if there is no SNAP
                switchPlayer();
            }
        }

        System.out.println("There are no more cards left. Game over!");
    }
}
