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
                System.out.println("you drew: " + currentCard);

                if (previousCard != null && previousCard.getSymbol().equals(currentCard.getSymbol())) {
                    System.out.println("SNAP! You win!");
                    return; // Ends the game when SNAP happens
                }

                previousCard = currentCard; // Updates the previous card if there is no SNAP
            }
        }

        System.out.println("There are no more cards left. Game over!");
    }
}
