/* created October 6, 2013
 * 
 * Flips pennies.
 */

package penny;

import java.util.Scanner;

public class PennyFlipper
{
	private double multiplier = 1;		// how many multiples of 64
	private Penny[] pennies;
	private int numberOfPennies = 6;
	
	public PennyFlipper()
	{
		super();
		// get user input
		getUserInput();
		createPennies(numberOfPennies);
		double totalTries = Math.pow(2, numberOfPennies);
		double headCount = 0;
		
		totalTries *= multiplier;
		for(int i = 0; i < totalTries; i++)
		{
			// Flip all pennies
			for(int j = 0; j < numberOfPennies; j++)
			{
				pennies[j].flip();
				
				if(pennies[0].getSide().equalsIgnoreCase("heads") && pennies[1].getSide().equalsIgnoreCase("heads")
						&& pennies[2].getSide().equalsIgnoreCase("heads") && pennies[3].getSide().equalsIgnoreCase("heads")
						 && pennies[4].getSide().equalsIgnoreCase("heads") && pennies[5].getSide().equalsIgnoreCase("heads"))
				{
					++headCount;
				}
			}
			
			for(Penny penny : pennies)
				penny.resetSide();
		}
		
		printStats(totalTries, headCount);
	}

	/**
	 * Display a message with statistics.
	 * @param totalTries - number of times simulation is run.
	 * @param headCount - number of times 'heads' showed up.
	 */
	private void printStats(double totalTries, double headCount)
	{
		double average = headCount/totalTries;
		System.out.print("Out of " + totalTries + " tries on " + pennies.length + " pennies, ");
		// display proper string if only one head was flipped
		if(headCount == 1)
			System.out.println("you got all heads " + headCount +" time.");
		else
			System.out.println("you got all heads " + headCount +" times.");
		System.out.println();
		System.out.println("Average: " + average);
		System.out.println("Flipped all heads " + average*100 +"% of the time.");
	}
	
	/**
	 * Setup simulation.
	 */
	private void getUserInput()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("How many times would you like to run the simulation?");
		multiplier = s.nextDouble();
		s.close();
	}

	/**
	 * Adds pennies to an ArrayList for future use.
	 * @param numberOfPennies - the number of pennies to add.
	 */
	private void createPennies(int numberOfPennies)
	{
		pennies = new Penny[numberOfPennies];
		for(int i = 1; i <= numberOfPennies; i++)
			pennies[i - 1] = new Penny("p" + i);
	}
}
