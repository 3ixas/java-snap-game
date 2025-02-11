# Pseudocode for Java Snap Game

## **Card Class**

-   **Attributes:**
    -   `suit` (String) -> Suit of the card (Hearts, Diamonds, Clubs, Spades)
    -   `symbol` (String) -> Card representation (2,3,4,...,10,J,Q,K,A)
    -   `value` (int) -> Numeric value of the card (2-14)
-   **Methods:**
    -   `toString()`: Returns a string representation of the card.

## **CardGame Class**

-   **Attributes:**
    -   `deckOfCards` (ArrayList<Card>) -> Contains 52 cards
    -   `gameName` (String) -> Name of the game
-   **Methods:**
    -   `getDeck()`: Displays all cards in the deck.
    -   `dealCard()`: Removes and returns the top card.
    -   `shuffleDeck()`: Shuffles the deck.
    -   `sortDeckInNumberOrder()`: Sorts the deck by value.
    -   `sortDeckIntoSuits()`: Sorts the deck by suit.

## **Snap Class (Extends CardGame)**

-   **Methods:**
    -   `playSnap()`: Runs the game loop.
        -   While deck is not empty:
            -   Player presses **Enter** to draw a card.
            -   Display drawn card.
            -   Compare with the previous card.
            -   If cards match, declare a **win** and exit game.
    -   `checkForSnap()`: Compares last two drawn cards.
        -   If the symbols match, return **true**.
        -   Else, return **false**.

## **Player Class (For Two-Player Mode)**

-   **Attributes:**
    -   `name` (String) -> Player's name
-   **Methods:**
    -   `takeTurn()`: Allows the player to draw a card.

## **Enhancements for Two-Player Mode**

-   Modify `playSnap()` to alternate between two players.
-   Add a **2-second timer** for typing **“snap”**.
-   If correct within **2 seconds**, the player wins.
-   If not, the opponent wins.
