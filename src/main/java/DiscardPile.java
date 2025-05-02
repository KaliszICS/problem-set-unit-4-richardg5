/**
 * Class representing a discard pile. Stores cards in the pile through an array of Cards.
 * @author Richard Gao
 * @version 1.0.0
 */
public class DiscardPile {
    private Card[] discardPile;

    /**
     * Creates a discard pile with the specified array of cards.<br><br>
     * 
     * If null is specified for the array, an empty discard pile is created instead.
     * @param discardPile an array of Cards representing the cards in the pile
     */
    public DiscardPile(Card[] discardPile) {
        if (discardPile == null) {
            this.discardPile = new Card[0];
        } else {
            this.discardPile = discardPile;
        }
    }

    /**
     * Creates an empty array of Cards to act as a discard pile.
     */
    public DiscardPile() {
        this.discardPile = new Card[0];
    }

    /**
     * Gets the discard pile.
     * @return an array of Cards representing the discard pile.
     */
    public Card[] getDiscardPile() {
        return this.discardPile;
    }

    /**
     * Gets the size of the discard pile.
     * @return an int representing the number of cards in the discard pile
     */
    public int size() {
        return getDiscardPile().length;
    }

    /**
     * Adds a card to the discard pile.
     */
    public void addCard(Card card) {
        Card[] newDiscardPile = new Card[size() + 1];
        for (int i = 0; i < size(); i++) {
            newDiscardPile[i] = getDiscardPile()[i];
        }
        newDiscardPile[newDiscardPile.length - 1] = card;
        this.discardPile = newDiscardPile;
    }

    /**
     * Removes the card from the discard pile and returns it.
     * @return the Card specified if it exists, or null if it doesn't
     */
    public Card removeCard(Card card) {
        boolean result = CardUtilities.removeCard(card, getDiscardPile());
        if (!result) {
            return null;
        }
        return card;
    }

    /**
     * Empties the entire discard pile and returns it.
     * @return an array of cards representing the discard pile
     */
    public Card[] removeAll() {
        Card[] oldPile = getDiscardPile();
        this.discardPile = new Card[0];
        return oldPile;
    }

    /**
     * Gets a String representation of the discard pile.<br><br>
     * 
     * This String will be formatted as the String representation of each card separated by commas ended by a period.<br><br>
     * 
     * If a card in the pile is null, it will be represented with "0 of Nothing".
     * @return a String representing the discard pile
     */
    @Override
    public String toString() {
        return CardUtilities.convertToString(getDiscardPile());
    }
}
