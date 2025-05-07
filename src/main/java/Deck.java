import java.util.Random;

/**
 * Class representing a deck of cards. Stores the deck of cards as an array of Cards.
 * @author Richard Gao
 * @version 1.0.0
 */
public class Deck {
    private Card[] deck;
    
    /**
     * Creates a deck of cards. The deck with be a standard 52 playing card deck with suits Hearts, Clubs, Diamonds, and Spades.<br><br>
     * 
     * The deck will be in order of Ace through King of Hearts, Ace through King of Clubs, Ace through King of Diamonds, and Ace through King of Spades. Ace is considered the lowest card.
     */
    public Deck() {
        // put all 4 suits into an array to iterate through instead of making separate for loops for each
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        // put all 13 names into an array to iterate through instead of hardcoding several lines
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        this.deck = new Card[suits.length * names.length];
        for (int i = 0; i < suits.length; i++) {
            for (int e = 0; e < names.length; e++) {
                this.deck[i * names.length + e] = new Card(names[e], suits[i], e);
            }
        }
    }

    /**
     * Creates a deck of cards from the specified array of Cards.<br><br>
     * 
     * If null is specified for the array, then an empty deck is created instead.
     * @param cards an array of Cards to create a Deck from
     */
    public Deck(Card[] cards) {
        if (cards == null) {
            this.deck = new Card[0];
        } else {
            this.deck = cards;
        }
    }

    /**
     * Gets the size of the deck.
     * @return an int representing how many cards are in the deck
     */
    public int size() {
        return this.deck.length;
    }

    /**
     * Draws the top card of the deck, then removes it.<br><br>
     * 
     * The top card is defined as the card at index 0 of the deck.
     * @return the Card at index 0.
     */
    public Card draw() {
        if (size() == 0) {
            return null;
        }
        Card topCard = this.deck[0];
        deck = CardUtilities.removeCard(topCard, deck);
        return topCard;
    }

    /**
     * Shuffles the deck by randomizing the array of Cards.<br><br>
     * 
     * This method uses the Fisher-Yates algorithm to randomize.
     */
    public void shuffle() {
        Random random = new Random();
        for (int e = 1; e < size(); e++) {
            int randomIndex = random.nextInt(e + 1);
            Card tempCard = this.deck[e];
            this.deck[e] = this.deck[randomIndex];
            this.deck[randomIndex] = tempCard;
        }
    }

    /**
     * Adds the specified card to the deck. Will not add if specified Card is null.
     * @param card the Card to be added to the deck
     */
    public void addCard(Card card) {
        this.deck = CardUtilities.addCard(this.deck, card);
    }

    /**
     * Adds the specified array of Cards into the deck and shuffles the Deck afterwards.
     * @param cards the array of Cards to be added to the Deck
     */
    public void reshuffle(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            addCard(cards[i]);
        }
        shuffle();
    }
}
