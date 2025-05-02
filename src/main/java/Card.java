/**
 * Class representing a card. Has variables for name, suit, and actual value.
 * @author Richard Gao
 * @version 1.0.0
 */
public class Card {
    private String name;
    private String suit;
    private int value;

    /**
     * Creates a card with the specified name, suit, and value.<br><br>
     * 
     * If null is specified for name, the name will default to "0". If null is specified for the suit, the suit will default to "Nothing".
     * @param name a String representing the name of the card
     * @param suit a String representing the suit of the card
     * @param value an int representing the value of the card
     */
    public Card(String name, String suit, int value) {
        if (name == null) {
            this.name = "0";
        } else {
            this.name = name;
        }
        if (suit == null) {
            this.suit = "Nothing";
        } else {
            this.suit = suit;
        }
        this.value = value;
    }

    /**
     * Gets the name of the card.
     * @return a String representing the name of the card
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the suit of the card.
     * @return a String representing the suit of the card
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * Gets the value of the card.
     * @return an int representing the value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Gets a String representation of the card.<br><br>
     * 
     * The String will be formatted as "<name> of <suit>".
     * @return a String representation of the card instance
     */
    @Override
    public String toString() {
        return getName() + " of " + getSuit();
    }

    /**
     * Checks if two cards are the same.<br><br>
     * 
     * Two cards are considered the same if they have the same name, suit, and value.
     * @return true if the two cards are the same, false if not or if the object being compared is not a card
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Card card = (Card) obj;
        return getName().equals(card.getName()) && getSuit().equals(card.getSuit()) && getValue() == card.getValue();
    }
}
