/**
 * Class representing a player in a card game. Has variables for name, age, and cards in hand.
 * @author Richard Gao
 * @version 1.0.0
 */
public class Player {
    private String name;
    private int age;
    private Card[] hand;

    /**
     * Creates a new player with specified name, age, and hand.<br><br>
     * 
     * If null is specified for name, the name will default to "Anon" instead. If null is specified for the hand, an empty hand is created instead.
     * @param name a String representing the name of the player
     * @param age an int representing the age of the player
     * @param hand an array of Cards representing the hand of the player
     */
    public Player(String name, int age, Card[] hand) {
        if (name == null) {
            this.name = "Anon";
        } else {
            this.name = name;
        }
        this.age = age;
        if (hand == null) {
            this.hand = new Card[0];
        } else {
           this.hand = hand; 
        }
    }
    
    /**
     * Creates a new player with specified name and age with an empty hand.
     * @param name a String representing the name of the player
     * @param age an int representing the age of the player
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new Card[0];
    }

    /**
     * Gets the name of the player.
     * @return a String representing the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the age of the player.
     * @return an int representing the age of the player
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets the current hand of the player.
     * @return an array of Cards representing the cards in the hand of the player
     */
    public Card[] getHand() {
        return this.hand;
    }

    /**
     * Gets the size of the current hand of the player.
     * @return an int representing the number of cards in the hand of the player
     */
    public int size() {
        return getHand().length;
    }

    /**
     * Draws a card from the specified deck and adds it to the player's hand.<br><br>
     * 
     * If the drawn card is null, it is replaced with a card with name "0", suit "Nothing", and value 0.
     * @param deck the Deck the card should be drawn from
     */
    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card == null) {
            card = new Card("0", "Nothing", 0);
        }
        Card[] newHand = new Card[size() + 1];
        for (int i = 0; i < size(); i++) {
            newHand[i] = getHand()[i];
        }
        newHand[newHand.length - 1] = card;
        this.hand = newHand;
    }

    /**
     * Removes the specified card from hand and adds it to the given discard pile.
     * @param card the Card to be removed from hand
     * @param discardPile the DiscardPile card should be added to
     * @return true if the card exists in hand and was successfully moved, false otherwise
     */
    public boolean returnCard(Card card, DiscardPile discardPile) {
        boolean result = removeFromHand(card);
        if (result) {
            discardPile.addCard(card);
        }
        return result;
    } 

    /**
     * Removes the specified card from hand and returns it to the given deck. The deck is shuffled once the process is complete.
     * @param card the Card to be removed from hand
     * @param deck the Deck the card should be returned to
     * @return true if the card exists in hand and was successfully moved, false otherwise
     */
    public boolean returnCard(Card card, Deck deck) {
        boolean result = removeFromHand(card);
        if (result) {
            Card[] newDeck = new Card[deck.size() + 1];
            for (int i = 0; i < newDeck.length - 1; i++) {
                newDeck[i] = deck.draw();
            }
            newDeck[newDeck.length - 1] = card;
            deck = new Deck(newDeck);
            deck.shuffle();
        }
        return result;
    }

    /**
     * Gets a string representation of the player.<br><br>
     * 
     * The string will be formatted as "Name, Age, String representation of each card in hand separated by commas ended by a period".<br><br>
     * 
     * If a card is null, it will be represented by "0 of Nothing".
     * @return a String representing the player.
     */
    @Override
    public String toString() {
        StringBuilder playerString = new StringBuilder(getName() + ", " + getAge() + ", ");
        String nullCardString = "0 of Nothing";
        String separator = ", ";
        String endOfList = ".";
        for (int i = 0; i < size(); i++) {
            if (getHand()[i] == null) {
                playerString.append(nullCardString);
            } else {
                playerString.append(getHand()[i].toString());
            }
            if (i < size() - 1) {
                playerString.append(separator);
            } else {
                playerString.append(endOfList);
            }
        }
        return playerString.toString();
    }

    /**
     * Removes the specified card from hand.
     * @param card the Card to be removed from hand
     * @return true if the card exists and was removed, false otherwise
     */
    private boolean removeFromHand(Card card) {
        int removeIndex = -1;
        for (int i = 0; i < size() && removeIndex == -1; i++) {
            if (getHand()[i].equals(card)) {
                removeIndex = i;
            }
        }
        if (removeIndex == -1) {
            return false;
        }
        Card[] newHand = new Card[size() - 1];
        for (int i = 0; i < removeIndex; i++) {
            newHand[i] = getHand()[i];
        }
        for (int i = removeIndex; i < size() - 1; i++) {
            newHand[i] = getHand()[i + 1];
        }
        this.hand = newHand;
        return true;
    }
}
