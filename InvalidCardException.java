/**
 * Class: InvalidCardException
 * @author Karlos Dao
 * @version 1.0
 * Course: ITEC 2150 Fall 2018
 * Written October 18, 2018
 * 
 * This class is a custom exception to be used when a Card is found to be invalid.
 */
public class InvalidCardException extends Exception
{
	public InvalidCardException()
	{
		super();
	}
	public InvalidCardException(String msg)
	{
		super(msg);
	}

}
