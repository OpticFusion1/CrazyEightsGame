/**
 * Class: CardDriver
 * @author Karlos Dao
 * @version 1.0
 * Course: ITEC 2150 Fall 2018
 * Written October 29, 2018
 * 
 * This class will allow the user to play a game against computers.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class CardDriver
{
	public static final int numOfCards = 7;
	private Scanner in;
	
	public static void main(String[] args) throws InvalidCardException
	{
		String decision = null;
		do
		{
			CardDeck cardDeck = new CardDeck();
			CardDriver cardOutput = new CardDriver();
			cardOutput.in = new Scanner(System.in);
			
			cardDeck.shuffle();
			
			//Create 3 computer players
			Hand computer1 = new Hand();
			computer1.setName("Computer 1 hand:");
			Hand computer2 = new Hand();
			computer2.setName("Computer 2 hand:");
			Hand computer3 = new Hand();
			computer3.setName("Computer 3 hand:");
			Hand player = new Hand();
			player.setName("Player hand:");
			
			LinkedList<Hand> hand = new LinkedList<Hand>();
			hand.add(computer1);
			hand.add(computer2);
			hand.add(computer3);
			hand.add(player);
			
			//Deal each player 7 cards, must be stored in LinkedList and must use an iterator to traverse this list when printing the entire list.
			for(int i = 0; i < numOfCards; i++)
			{
				computer1.addCard(cardDeck.deal());
				computer2.addCard(cardDeck.deal());
				computer3.addCard(cardDeck.deal());
				player.addCard(cardDeck.deal());
			}
			
			//Cards values should be displayed
			//Display each hand one at a time. User's last
			cardOutput.print(hand);
			
			//Allow the player to select a card to play.  
			//split the value into 2
			Scanner input = new Scanner(System.in);
			String value = null;
			String suit = null;
			Card playerCard = null;
			boolean valid = true;
			do
			{
				try
				{
					System.out.println("Please select the card you would like to play, enter the card as shown above.");
					String userSelect = input.nextLine();
					
					if(userSelect.length() == 2) 
					{
						value = ("" + userSelect.toUpperCase().charAt(0));
				    		suit = ("" + userSelect.toUpperCase().charAt(1));
					}
					else if(userSelect.length() == 3) 
				    {
				        value = ("" + userSelect.toUpperCase().substring(0,2));
				        suit = ("" + userSelect.toUpperCase().charAt(2));
				    }
					
					playerCard = player.play(value, suit); 
				
					System.out.println("Player plays " + playerCard);
				}
				catch(InvalidCardException ice)
				{
					valid = false;
					System.out.println(ice.getMessage());
				}
			}while(!valid);
			
			//Each computer should randomly select a card to play.  
			//Display the cards played as text, should display the name/computer that played each card.  
//			for(int i = 0; i < 7; i++)
//			{
//				computer1.play(value, suit);
//			}
			
//			int random;
//			random = (int)(Math.random() * 7);
//			Card computer1Select;
//			System.out.println("Computer 1 hand" + computer1Select);
//			Card computer2Select;
//			System.out.println("Computer 2 hand" + computer2Select);			
//			Card computer3Select;
//			System.out.println("Computer 3 hand" + computer3Select);
			
			ArrayList<Card> list = new ArrayList<Card>();
			list.add(playerCard);
//			list.add(computer1Select);
//			list.add(computer2Select);
//			list.add(computer3Select);

	        
			//If the user plays the high card, they win. 
			
			Collections.sort(list);
			
			System.out.println(list);
			
			//Display an appropriate message that they win.  
			//Ask them if they want to try again.(This should be determined using the Comparable implementation in Card.)
			
			System.out.println("Would you like to play again? (Y/N)");
			decision = input.nextLine();
		}while(decision.equalsIgnoreCase("y"));
		
	}
	
	/**
	 * Method name: print()
	 * Note: Used to print the elements of a linked list.
	 * @param LinkedList<Hand> hand
	 * @return n/a
	 */
	public void print(LinkedList<Hand> hand)
	{
		 ListIterator<Hand> iter = hand.listIterator();
	     while(iter.hasNext())
	     {
	         System.out.print(iter.next() + "\n");
	     }
	}
}
