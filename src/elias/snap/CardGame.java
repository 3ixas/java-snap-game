package elias.snap;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    private final List<Card> deckOfCards;
    private final String gameName;

    //Constructor
    public CardGame(String gameName) {
        /*Adding the game name variable to make it easier to reuse CardGame for different games if that is something
        I want to add in down the line*/
        this.gameName = gameName;
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
        String[] suits = {"❤\uFE0F Hearts", "♦\uFE0F Diamonds", "♣\uFE0F Clubs", "♠\uFE0F Spades"};
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int i=0; i < symbols.length; i++) {
                deckOfCards.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    public void getDeck() {
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }

    public Card dealCard() {
        if (!deckOfCards.isEmpty()) {
            return deckOfCards.remove(0); // Removes & returns the top card
        }
        return null; // If the deck is empty
    }
}
