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

    
}
