package penny;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Penny> pennies = new ArrayList<Penny>();
		pennies.add(new Penny("p1"));
		pennies.add(new Penny("p2"));
		pennies.add(new Penny("p3"));
		pennies.add(new Penny("p4"));
		pennies.add(new Penny("p5"));
		pennies.add(new Penny("p6"));
		
		double totalTries = 64;	// out of 6 pennies, there's a 1/64 chance for all heads
		double multiplier = 1;	// how many multiples of 64
		double average = 0;
		double headCount = 0;
		
		totalTries *= multiplier;
		for(int i = 0; i < totalTries; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				pennies.get(j).flip();
				
				if(pennies.get(0).getSide().equalsIgnoreCase("heads") && pennies.get(1).getSide().equalsIgnoreCase("heads")
						&& pennies.get(2).getSide().equalsIgnoreCase("heads") && pennies.get(3).getSide().equalsIgnoreCase("heads")
						 && pennies.get(4).getSide().equalsIgnoreCase("heads") && pennies.get(5).getSide().equalsIgnoreCase("heads"))
				{
					headCount++;
					//System.out.println(pennies.get(j).getName() + " is " + pennies.get(j).getSide());
					//System.out.println("<====================================== ALL HEADS");
				}
				//else
					//System.out.println(pennies.get(j).getName() + " is " + pennies.get(j).getSide());
				
			}
			for (Penny penny : pennies) {
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
}
