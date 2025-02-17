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

    public Snap(String gameName) {
        super(gameName);
        this.scanner = new Scanner(System.in);
        resetGame();
    }

    public void playSnap() throws IOException {
        do {
            resetGame();
            printGameStartMessage();
            playGameLoop();
        } while (askToReplay());

        System.out.println("\n👋 Thanks for playing Snap! See you next time!");
    }

    private void resetGame() {
        player1Score = 0;
        player2Score = 0;
        previousCard = null;
        currentPlayer = 1;
        initialiseDeck();
        shuffleDeck();
    }

    private void printGameStartMessage() {
        System.out.println("\n🎮 Welcome to Snap! 🎮");
        System.out.println("\n🟠 Player 1 and 🔵 Player 2 take turns.");
        System.out.println("👑 First to win " + WINNING_SCORE + " rounds will be crowned the final winner!");
        System.out.println("🎴 Press ENTER to draw a card. Be ready for a SNAP chance! ⚡");
    }

    private void playGameLoop() throws IOException {
        while (!getDeck().isEmpty()) {
            handlePlayerTurn();

            if (isSnapMatch() && processSnapEvent()) {
                return;
            }

            switchPlayer();
        }

        printGameOverMessage();
    }

    private void handlePlayerTurn() {
        System.out.println("\n➡️ Player " + currentPlayer + ", press ENTER to draw a card...");
        scanner.nextLine();

        Card currentCard = dealCard();
        if (currentCard != null) {
            System.out.println("\n" + getPlayerEmoji() + " Player " + currentPlayer + " drew: " + currentCard);
        }
        previousCard = currentCard;
    }

    private String getPlayerEmoji() {
        return (currentPlayer == 1) ? "🟠" : "🔵";
    }

    private boolean isSnapMatch() {
        return previousCard != null && !getDeck().isEmpty() &&
                previousCard.getSymbol().equals(getDeck().get(0).getSymbol());
    }

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

    private void updatePlayerScore() {
        if (currentPlayer == 1) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    private void printSnapWinMessage() {
        System.out.println("\n🎉🎉 SNAP!!! PLAYER " + currentPlayer + " WINS! 🎉🎉");
        System.out.println("📊 SCORE: 🟠 Player 1: " + player1Score + " | 🔵 Player 2: " + player2Score);
    }

    private boolean isFinalWinner() {
        return player1Score == WINNING_SCORE || player2Score == WINNING_SCORE;
    }

    private void printFinalWinner() {
        System.out.println("\n🏆 FINAL WINNER: " + (player1Score == WINNING_SCORE ? "🟠 PLAYER 1" : "🔵 PLAYER 2") + "! 🏆");
    }

    private void resetRound() {
        System.out.println("\n🎲 Next Round! Resetting deck and shuffling...");
        initialiseDeck();
        shuffleDeck();
        previousCard = null;
    }

    private void printGameOverMessage() {
        System.out.println("\n📦 No more cards left. **GAME OVER!**");
    }

    private boolean askToReplay() {
        System.out.print("\n🔄 Do you want to play again? (yes/no): ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    private boolean snapReaction() throws IOException {

        long startTime = System.currentTimeMillis();
        long timeLimit = startTime + 2000;

        while (System.currentTimeMillis() < timeLimit) {
            if (System.in.available() > 0) {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("snap")) {
                    return true;
                }
            }
        }
        return false;
    }



    private void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }
}