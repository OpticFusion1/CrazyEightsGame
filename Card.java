import java.util.Arrays;

/**
 * Class: Card
 * @author Karlos Dao
 * @version 1.0
 * Course: ITEC 2150 Fall 2018
 * Written October 29, 2018
 * 
 * This class will model a standard playing card.
 */
public class Card implements Comparable<Card>
{
    private String suit;
    private String value;
    
    public Card(String suit, String value) 
    {
        this.suit = suit;
        this.value = value;
    }

	public String getSuit()
	{
		return suit;
	}

	public void setSuit(String suit)
	{
		this.suit = suit;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return suit + value;
	}
	
	/**
	 * 
	 * Method name: compareTo()
	 * Note: Will check the cards values and suit against the suit and value array in this method and return the highest card.
	 * Note: If the value or suit in this method is greater, return 1. Else move the index back one.
	 * @param Card o
	 * @return Will return an index indicating where an object ranks in the list.
	 */

	@Override
	public int compareTo(Card o)
	{
		String[] suit = {"S", "H", "D", "C"};
		String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

		int valueIndex1 = Arrays.asList(value).indexOf(this.getValue());
		int valueIndex2 = Arrays.asList(value).indexOf(o.getValue());
		if (valueIndex1 > valueIndex2) 
		{
			return 1;
		}
		else if (valueIndex1 < valueIndex2) 
		{
			return -1;
		}
		else 
		{
			int suitIndex1 = Arrays.asList(suit).indexOf(this.getSuit());
			int suitIndex2 = Arrays.asList(suit).indexOf(o.getSuit());
			if (suitIndex1 > suitIndex2) 
			{
				return 1;
			}
			else if (suitIndex1 < suitIndex2) 
			{
				return -1;
			}
		}
		return 0;
	}
}