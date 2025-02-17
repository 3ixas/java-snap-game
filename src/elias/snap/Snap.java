package elias.snap;

import java.io.IOException;
import java.util.Scanner;

public class Snap extends CardGame {
    private Card previousCard;
    private final Scanner scanner;
    private int currentPlayer;
    private int player1Score;
    private int player2Score;
    private static final int WINNING_SCORE = 3;

    // Constructor
    public Snap(String gameName) {
        super(gameName);
        this.scanner = new Scanner(System.in);
        resetGame(); // Initializes values
    }

    public void playSnap() throws IOException {
        do {
            resetGame();
            printGameStartMessage();
            playGameLoop();
        } while (askToReplay());

        System.out.println("\n👋 Thanks for playing Snap! See you next time!");
    }

    // Resets game state at the start of a new match
    private void resetGame() {
        player1Score = 0;
        player2Score = 0;
        previousCard = null;
        currentPlayer = 1;
        createDeck();
        shuffleDeck();
    }

    // Prints the game introduction message
    private void printGameStartMessage() {
        System.out.println("\n🎮 Welcome to Snap! 🎮");
        System.out.println("\n🟠 Player 1 and 🔵 Player 2 take turns.");
        System.out.println("👑 First to win " + WINNING_SCORE + " rounds will be crowned the final winner!");
        System.out.println("🎴 Press ENTER to draw a card. Be ready for a SNAP chance! ⚡");
    }

    private void playGameLoop() throws IOException {
        while (!getDeckOfCards().isEmpty()) {
            handlePlayerTurn();

            if (isSnapMatch() && processSnapEvent()) {
                return; // End game if we have a final winner
            }

            switchPlayer();
        }

        printGameOverMessage();
    }

    // Handles a player's turn
    private void handlePlayerTurn() {
        System.out.println("\n➡️ Player " + currentPlayer + ", press ENTER to draw a card...");
        scanner.nextLine(); // Wait for player input

        Card currentCard = dealCard();
        if (currentCard != null) {
            System.out.println("\n" + getPlayerEmoji() + " Player " + currentPlayer + " drew: " + currentCard);
        }
        previousCard = currentCard; // Store current card for next turn
    }

    // Returns player emoji for better UI experience
    private String getPlayerEmoji() {
        return (currentPlayer == 1) ? "🟠" : "🔵";
    }

    // Checks if the last two drawn cards match
    private boolean isSnapMatch() {
        return previousCard != null && !getDeckOfCards().isEmpty() &&
                previousCard.getSymbol().equals(getDeckOfCards().get(0).getSymbol());
    }


    // Processes the SNAP event, updates scores, and resets the game if needed
    private boolean processSnapEvent() throws IOException {
        System.out.println("\n⚡⚡ SNAP CHANCE! Type 'snap' within 2 seconds to win! ⚡⚡");

        if (snapReaction()) {
            updatePlayerScore();
            printSnapWinMessage();

            if (isFinalWinner()) {
                printFinalWinner();
                return true;
            }

            resetRound();
        } else {
            System.out.println("\n⏳ Too slow! The game continues...");
        }
        return false;
    }

    // Updates the score of the current player
    private void updatePlayerScore() {
        if (currentPlayer == 1) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    // Prints the SNAP winner and current score
    private void printSnapWinMessage() {
        System.out.println("\n🎉🎉 SNAP!!! PLAYER " + currentPlayer + " WINS! 🎉🎉");
        System.out.println("📊 SCORE: 🟠 Player 1: " + player1Score + " | 🔵 Player 2: " + player2Score);
    }

    // Checks if a player has reached the winning score
    private boolean isFinalWinner() {
        return player1Score == WINNING_SCORE || player2Score == WINNING_SCORE;
    }

    // Prints the final game winner
    private void printFinalWinner() {
        System.out.println("\n🏆 FINAL WINNER: " + (player1Score == WINNING_SCORE ? "🟠 PLAYER 1" : "🔵 PLAYER 2") + "! 🏆");
    }

    // Resets for the next round
    private void resetRound() {
        System.out.println("\n🎲 Next Round! Resetting deck and shuffling...");
        createDeck();
        shuffleDeck();
        previousCard = null;
    }

    // Prints game over message
    private void printGameOverMessage() {
        System.out.println("\n📦 No more cards left. **GAME OVER!**");
    }

    // Asks if players want to replay the game
    private boolean askToReplay() {
        System.out.print("\n🔄 Do you want to play again? (yes/no): ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    // Handles reaction timing for SNAP
    private boolean snapReaction() throws IOException {

        long startTime = System.currentTimeMillis();
        long timeLimit = startTime + 2000; // 2-second time limit

        while (System.currentTimeMillis() < timeLimit) {
            if (System.in.available() > 0) {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("snap")) {
                    return true; // Player reacted in time
                }
            }
        }
        return false;
    }


    // Switches turn between players
    private void switchPlayer() {
        currentPlayer ^= 3; // Bitwise XOR toggle between 1 and 2
    }
}