package elias.snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardGame {
    private final List<Card> deck;
    private final String gameName;

    // Constructor
    public CardGame(String gameName) {
        this.gameName = gameName;
        this.deck = new ArrayList<>();
        initialiseDeck();
    }

    // Getter for game name
    public String getGameName() {
        return gameName;
    }

    // Getter for deck
    public List<Card> getDeck() {
        return deck;
    }

    // Initializes a full deck of 52 cards
    protected void initialiseDeck() {
        deck.clear(); // Ensures no duplicate cards on re-initialization
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deck.add(new Card(suit.getSymbol(), value.getSymbol(), value.getRank()));
            }
        }
    }

    // Prints all cards in the deck
    public void printDeck() {
        deck.forEach(System.out::println);
    }

    // Deals the top card from the deck
    public Card dealCard() {
        return deck.isEmpty() ? null : deck.remove(0);
    }

    // Shuffles the deck
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    // Sorts deck by card value
    public void sortDeckByValue() {
        deck.sort(Comparator.comparingInt(Card::getValue));
    }

    // Sorts deck by suit and then by value
    public void sortDeckBySuit() {
        deck.sort(Comparator.comparing(Card::getSuit).thenComparingInt(Card::getValue));
    }
}
