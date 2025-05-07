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
     * @param array the array of Cards card should be removed from
     * @return true if the card exists and was removed, false otherwise
     */
    public static Card[] removeCard(Card card, Card[] array) {
        int removeIndex = -1;
        for (int i = 0; i < array.length && removeIndex == -1; i++) {
            if (array[i].equals(card)) {
                removeIndex = i;
            }
        }
        if (removeIndex == -1) {
            return array;
        }
        Card[] newArray = new Card[array.length - 1];
        for (int i = 0; i < removeIndex; i++) {
            newArray[i] = array[i];
        }
        for (int i = removeIndex; i < array.length - 1; i++) {
            newArray[i] = array[i + 1];
        }
        return newArray;
    }

    /**
     * Gets a String representation of the array of cards.<br><br>
     * 
     * This String will be formatted as the String representation of each card separated by commas ended by a period.<br><br>
     * 
     * If a card in the pile is null, it will be represented with "0 of Nothing".
     * @param array an array of Cards to get a String representation of
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

    /**
     * Adds the specified Card to the specified array of Cards.
     * @param arr an array of Cards the Card should be added to
     * @param card the Card to be added to the array of Cards
     */
    public static Card[] addCard(Card[] arr, Card card) {
        if (card != null) {
            Card[] newCardArr = new Card[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                newCardArr[i] = arr[i];
            }
            newCardArr[newCardArr.length - 1] = card;
            return newCardArr;
        }
        return arr;
    }
}