/**
 * Class: InvalidDeckException
 * @author Karlos Dao
 * @version 1.0
 * Course: ITEC 2150 Fall 2018
 * Written October 18, 2018
 * 
 * This class is a custom exception to be used when a CardDeck is found to be invalid.
 */
public class InvalidDeckException extends Exception
{
	public InvalidDeckException()
	{
		super();
	}
	public InvalidDeckException(String msg)
	{
		super(msg);
	}

}
