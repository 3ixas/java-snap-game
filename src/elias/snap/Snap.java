package elias.snap;

import java.io.IOException;
import java.util.Scanner;

public class Snap extends CardGame {
    private Card previousCard;
    private final Scanner scanner;
    private boolean snapCalled;
    private int currentPlayer;
    private int player1Score = 0;
    private int player2Score = 0;
    private final int WINNING_SCORE = 3;

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
        boolean playAgain;

        do {
            // Reset game state
            player1Score = 0;
            player2Score = 0;
            previousCard = null;
            currentPlayer = 1; // Player 1 always starts
            createDeck(); // Reset the deck with all 52 cards
            shuffleDeck(); // Shuffle the new deck

            System.out.println("\n🎮 Welcome to Snap! 🎮");
            System.out.println("\n🟠 Player 1 and 🔵 Player 2 take turns.");
            System.out.println("👑 First to win " + WINNING_SCORE + " rounds will be crowned the final winner!");
            System.out.println("🎴 Press ENTER to draw a card. Be ready for a SNAP chance! ⚡");

            boolean firstTurn = true; // Track first turn for instructions

            while (!getDeckOfCards().isEmpty()) {
                if (firstTurn) {
                    System.out.println("\n➡️ Player " + currentPlayer + ", press ENTER to draw a card...");
                    firstTurn = false; // Only show this prompt once
                }
                scanner.nextLine(); // Wait for input

                Card currentCard = dealCard();
                if (currentCard != null) {
                    String playerEmoji = (currentPlayer == 1) ? "🟠" : "🔵"; // Red for Player 1, Blue for Player 2
                    System.out.println("\n" + playerEmoji + " Player " + currentPlayer + " drew: " + currentCard);
                }

                // Check for SNAP
                if (previousCard != null && previousCard.getSymbol().equals(currentCard.getSymbol())) {
                    System.out.println("\n⚡⚡ SNAP CHANCE! Type 'snap' within 2 seconds to win! ⚡⚡");

                    if (snapReaction()) {
                        // Update scores
                        if (currentPlayer == 1) {
                            player1Score++;
                        } else {
                            player2Score++;
                        }

                        // Announce the SNAP winner
                        System.out.println("\n🎉🎉 SNAP!!! PLAYER " + currentPlayer + " WINS! 🎉🎉");
                        System.out.println("📊 SCORE: 🟠 Player 1: " + player1Score + " | 🔵 Player 2: " + player2Score);

                        // Check if a player has won the match
                        if (player1Score == WINNING_SCORE || player2Score == WINNING_SCORE) {
                            System.out.println("\n🏆 FINAL WINNER: " + (player1Score == WINNING_SCORE ? "🟠 PLAYER 1" : "🔵 PLAYER 2") + "! 🏆");
                            break; // Exit game loop after final win
                        }

                        // Reset deck for a new round
                        System.out.println("\n🎲 Next Round! Resetting deck and shuffling...");
                        createDeck(); // Reset the deck with all 52 cards
                        shuffleDeck(); // Shuffle the new deck
                        previousCard = null; // Reset previousCard for the next round
                        firstTurn = true; // Reset firstTurn so "Press ENTER" appears again
                        continue; // Restart the loop for a new round
                    } else {
                        System.out.println("\n⏳ Too slow! The game continues...");
                    }
                }

                previousCard = currentCard; // Store current card for next turn
                switchPlayer();
            }

            // Only ask to replay at the end of the match
            System.out.println("\n📦 No more cards left. GAME OVER!");
            System.out.print("\n🔄 Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain); // Loop the game if players want to replay

        System.out.println("\n👋 Thanks for playing Snap! See you next time!");
    }

    // Handles reaction timing for snap
    private boolean snapReaction() throws IOException {
        snapCalled = false;
        long startTime = System.currentTimeMillis(); // Start time tracking

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

        return snapCalled;
    }


    // Switch turns between players
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }
}
