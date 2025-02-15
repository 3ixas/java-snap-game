package elias.snap;

import org.w3c.dom.ls.LSOutput;

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
        System.out.println("Welcome to " + getGameName() + "! Press ENTER to draw a card from the deck.");
        shuffleDeck(); // Shuffle deck at the start

        while (!deckOfCards.isEmpty()) {
            scanner.nextLine(); // Wait for the user to press enter
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
