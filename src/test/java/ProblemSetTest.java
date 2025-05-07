//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ProblemSetTest {

   //Create your tests here if you want any

   /*

   //Example Test
   
   @Test
   public void exampleTest()
   {
      Cat cat = new Cat();
      assertEquals("whiskers", cat.getName());
   }
   */

   @Test
   public void nullCard() {
      Card nullCard = new Card(null, null, 0);
      Card actualCard = new Card("0", "Nothing", 0);
      assertEquals(true, actualCard.equals(nullCard));
   }

   @Test
   public void falseWhenNull() {
      Card card = new Card("Ace", "Spades", 0);
      assertEquals(false, card.equals(null));
   }

   @Test
   public void cardToString() {
      Card card = new Card("Ace", "Spades", 0);
      assertEquals(true, card.toString().equals("Ace of Spades"));
   }

   @Test
   public void defaultDeck() {
      String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
      String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
      Card[] cards = new Card[suits.length * names.length];
      for (int i = 0; i < suits.length; i++) {
         for (int e = 0; e < names.length; e++) {
               cards[i * names.length + e] = new Card(names[e], suits[i], e);
         }
      }
      Deck defaultDeck = new Deck();
      for (int i = 0; i < suits.length * names.length; i++) {
         Card currCard = defaultDeck.draw();
         assertEquals(true, cards[i].equals(currCard), "Wrong card: " + currCard.toString());
      }
   }

   @Test
   public void actuallyShuffles() {
      String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
      String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
      Card[] cards = new Card[suits.length * names.length];
      for (int i = 0; i < suits.length; i++) {
         for (int e = 0; e < names.length; e++) {
               cards[i * names.length + e] = new Card(names[e], suits[i], e);
         }
      }
      Deck deck = new Deck();
      deck.shuffle();
      Card[] newCards = new Card[suits.length * names.length];
      for (int i = 0; i < suits.length * names.length; i++) {
         newCards[i] = deck.draw();
      }
      assertEquals(false, Arrays.equals(cards, newCards));
   }

   @Test
   public void drawNullCards() {
      Card[] cards = {null, null, new Card("Ace", "Spades", 0)};
      Deck deck = new Deck(cards);
      assertEquals(null, deck.draw());
      assertEquals(null, deck.draw());
      assertEquals(1, deck.size());
      deck.shuffle();
      deck.draw();
      deck.shuffle();
      assertEquals(0, deck.size());
      assertEquals(null, deck.draw());
   }

   @Test
   public void nullDiscardPile() {
      DiscardPile pile = new DiscardPile(null);
      assertEquals(0, pile.size());
   }

   @Test
   public void cardAdding() {
      Deck deck = new Deck();
      deck.addCard(new Card(null, null, 0));
      assertEquals(53, deck.size());
   }
}
