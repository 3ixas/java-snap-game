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
        System.out.println("Welcopme to " + super.gameName + "! Press ENTER to draw a card from the deck.");
        shuffleDeck(); // Shuffle deck at the start

        
    }
}
