package elias.snap;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    private final List<Card> deckOfCards;
    private final String gameName;

    //Constructor
    public CardGame(String gameName) {
        // Adding the game name variable to make it easier to reuse CardGame for different games
        this.gameName = gameName;
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }

    


}
