/**
 * Class: CardDeck
 * @author Karlos Dao
 * @version 1.0
 * Course: ITEC 2150 Fall 2018
 * Written October 29, 2018
 * 
 * This class will contain methods to handle the deck of cards.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CardDeck 
{

	private String[] suit = {"S", "H", "D", "C"};
	private String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	private ArrayList<Card> deck = new ArrayList<Card>();
	private Hand discardPile;
	
	/**
	 * Method name: CardDeck()
	 * Note: Create and initialize the instance of CardDeck
	 * @param n/a
	 * @return n/a
	 */
	public CardDeck()
	{
		discardPile = null;
		for (int i = 0; i < suit.length; i++) 
        {
			for(int j = 0; j < value.length; j++)
			{
				Card newCard = new Card(value[j], suit[i] );
				deck.add(newCard);
			}
        }
	}
	
	public ArrayList<Card> getDeck()
	{
		return deck;
	}


	/**
	 * 
	 * Method name: shuffle()
	 * Note: This method will take the constructed deck and randomize the cards and store the new ordering of all cards.
	 * @param n/a
	 * @return n/a
	 */
	public void shuffle()
	{
		Collections.shuffle(deck);
	}
	
	/**
	 * 
	 * Method name: deal()
	 * Note: This method will “deal” the next card in the deck.
	 * @param n/a
	 * @return null
	 * @return deck.get(0)
	 * 
	 */
	public Card deal()
	{
		return deck.remove(deck.size() -1);
	}
	
//	public Card discard()
//	{
//		Stack discardPile = new Stack();
//		Card top;
//		top = discardPile.peek();
//	}
}
