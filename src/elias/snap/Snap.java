package elias.snap;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
    public void playSnap() throws IOException {
        System.out.println("\n🎮 Welcome to " + getGameName() + "! 🎮");
        System.out.println("\n🔴 Player 1 and 🔵 Player 2 take turns.");
        System.out.println("🎴 Press ENTER to draw a card. Be ready for a SNAP chance! ⚡");
        shuffleDeck(); // Shuffle deck at the start

        boolean firstTurn = true;

        while (!getDeckOfCards().isEmpty()) {
            if (firstTurn) {
                System.out.println("\n➡️ Player " + currentPlayer + ", press ENTER to draw a card...");
                firstTurn = false;
            }
            scanner.nextLine(); // Wait for the player to press enter

            Card currentCard = dealCard(); // Draw a card
            if (currentCard != null) {
                System.out.println("\n🃏 Player " + currentPlayer + " drew: " + currentCard);

                if (previousCard != null && previousCard.getSymbol().equals(currentCard.getSymbol())) {
                    System.out.println("\n⚡⚡ SNAP CHANCE! Type 'snap' within 2 seconds to win! ⚡⚡");
                    System.out.println("⌛ You have 2 seconds... GO!");

                    if (snapReaction()) {
                        System.out.println("\n🎉🎉 SNAP! PLAYER " + currentPlayer + " WINS!** 🎉🎉");
                        return; // Ends the game
                    } else {
                        System.out.println("\n⏳ Too slow! The game continues...");
                    }
                }

                previousCard = currentCard; // Updates the previous card if there is no SNAP
                switchPlayer();
            }
        }

        System.out.println("\n📦 No more cards left. **Game Over!**");
    }

    // Handles reaction timing for snap
    private boolean snapReaction() throws IOException {
        snapCalled = false;
        long startTime = System.currentTimeMillis(); // Start time tracking

        System.out.println("You have 2 seconds to type 'snap'...");

        // Keep checking input, but only for 2 seconds
        while (System.currentTimeMillis() - startTime < 2000) {
            if (System.in.available() > 0) { // Check if there is input ready to be read
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("snap")) {
                    snapCalled = true;
                    break;
                }
            }
        }

        if (!snapCalled) {
            System.out.println("Too slow! Game continues...");
        }

        return snapCalled;
    }


    // Switch turns between players
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }
}
