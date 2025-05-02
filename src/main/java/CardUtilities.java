/**
 * Utility class storing methods that are reused in multiple classes. Has methods for removing cards from an array and getting a String representation of an array.
 * @author Richard Gao
 * @version 1.0.0
 */
public final class CardUtilities {
    private CardUtilities() {
    }

    /**
     * Removes the specified card from a specified array of Cards.
     * @param card the Card to be removed from hand
     * @param array the array of Cards card should be removed from
     * @return true if the card exists and was removed, false otherwise
     */
    public static boolean removeCard(Card card, Card[] array) {
        int removeIndex = -1;
        for (int i = 0; i < array.length && removeIndex == -1; i++) {
            if (array[i].equals(card)) {
                removeIndex = i;
            }
        }
        if (removeIndex == -1) {
            return false;
        }
        Card[] newArray = new Card[array.length - 1];
        for (int i = 0; i < removeIndex; i++) {
            newArray[i] = array[i];
        }
        for (int i = removeIndex; i < array.length - 1; i++) {
            newArray[i] = array[i + 1];
        }
        array = newArray;
        return true;
    }

    /**
     * Gets a String representation of the array of cards.<br><br>
     * 
     * This String will be formatted as the String representation of each card separated by commas ended by a period.<br><br>
     * 
     * If a card in the pile is null, it will be represented with "0 of Nothing".
     * @return a String representing the array of cards
     */
    public static String convertToString(Card[] array) {
        StringBuilder pileString = new StringBuilder();
        String nullCardString = "0 of Nothing";
        String separator = ", ";
        String endOfList = ".";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                pileString.append(nullCardString);
            } else {
                pileString.append(array[i].toString());
            }
            if (i < array.length - 1) {
                pileString.append(separator);
            } else {
                pileString.append(endOfList);
            }
        }
        return pileString.toString();
    }
}