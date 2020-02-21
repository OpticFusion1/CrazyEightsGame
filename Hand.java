/**
 * Class: Hand
 * @author Karlos Dao
 * @version 1.0
 * Course: ITEC 2150 Fall 2018
 * Written October 29, 2018
 * 
 * This class will be used to hold the cards in a linked list.
 */
import java.util.LinkedList;

public class Hand
{
	private LinkedList<Card> hand; 
	private String name;
	
	public Hand()
	{
		hand = new LinkedList<Card>();
		name = "";
	}
	
	public Hand(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * 
	 * Method: addCard
	 * @note This method will add a card to the hand.
	 * @param card
	 * @return n/a
	 * 
	 */
	public void addCard(Card card)
	{
		hand.add(card);
	}
	/**
	 * 
	 * Method: play
	 * @note This method will remove a card from the hand to be played.
	 * @param value
	 * @param suit
	 * @return card
	 * @throws InvalidCardException 
	 */
	public Card play(String value, String suit) throws InvalidCardException
	{
		Card playCard = new Card(value, suit); 
		//Contains method check if String contains another substring or not. 
		//Returns boolean value so it can use directly inside if statements. 
		//Equals method is used to determine logical equivalence between object instances. (Used for comparing)
		//Need an equals method to go with the contains method.
		for (Card card: hand)
		{
			if (playCard.getSuit().equalsIgnoreCase(card.getSuit()) && 
					playCard.getValue().equalsIgnoreCase(card.getValue())) 
			{
				hand.remove(card);
				return card;
			}
		}
		 throw new InvalidCardException("Card not in hand");
	}
	
//	public Card compPlay(Card card)
//	{
//		Card random;
//		for(int i = 0; i < 7; i++)
//		{
//			
//		}
//		return random;
//		
//	}
	

	@Override
	public String toString()
	{
		return "" + name + "\n" + hand + "";
	}
}
