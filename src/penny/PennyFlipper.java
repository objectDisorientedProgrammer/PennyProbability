/* created October 6, 2013
 * 
 * Flips pennies.
 */

package penny;

import java.util.ArrayList;

public class PennyFlipper
{
	private ArrayList<Penny> pennies;
	// add variables to store user input

	public PennyFlipper()
	{
		super();
		// get user input
		//getUserInput();
		createPennies(6);
		
		double totalTries = 64;	// out of 6 pennies, there's a 1/64 chance for all heads
		double multiplier = 1;	// how many multiples of 64
		double average = 0;
		double headCount = 0;
		
		totalTries *= multiplier;
		for(int i = 0; i < totalTries; i++)
		{
			// Flip all pennies
			for(int j = 0; j < 6; j++)
			{
				pennies.get(j).flip();
				
				if(pennies.get(0).getSide().equalsIgnoreCase("heads") && pennies.get(1).getSide().equalsIgnoreCase("heads")
						&& pennies.get(2).getSide().equalsIgnoreCase("heads") && pennies.get(3).getSide().equalsIgnoreCase("heads")
						 && pennies.get(4).getSide().equalsIgnoreCase("heads") && pennies.get(5).getSide().equalsIgnoreCase("heads"))
				{
					headCount++;
				}
			}
			
			for (Penny penny : pennies)
			{
				penny.resetSide();
			}
		}
		average = headCount/totalTries;
		
		System.out.print("Out of " + totalTries + " tries on " + pennies.size() + " pennies, ");
		// display proper string if only one head was flipped
		if(headCount == 1)
			System.out.println("you got all heads " + headCount +" time.");
		else
			System.out.println("you got all heads " + headCount +" times.");
		System.out.println();
		System.out.println("Average: " + average);
		System.out.println("Flipped all heads " + average*100 +"% of the time.");
	}
	
	private void getUserInput()
	{
		// set up buffer
		// prompt user
		// store values
	}	
		
	/**
	 * Adds pennies to an ArrayList for future use.
	 * @param numberOfPennies - the number of pennies to add.
	 */
	private void createPennies(int numberOfPennies)
	{
		pennies = new ArrayList<Penny>();
		for(int i = 1; i <= numberOfPennies; i++)
			pennies.add(new Penny("p"+i));
	}
}
