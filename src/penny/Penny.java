package penny;

import java.util.Random;

public class Penny {
	private String name = "no name";
	private String side = "default";
	public Penny()
	{
		super();
	}
	
	public Penny(String name)
	{
		this.name = name;
		resetSide();
	}
	
	public void flip()
	{
		Random rand = new Random();
		if(rand.nextInt(2) > .5)	// random number 0 <= r <= 1
			side = "heads";
		else
			side = "tails";
	}
	public void resetSide()
	{
		side = "null";
	}
	
	public String getSide()
	{
		return side;
	}

	public String getName() {
		return name;
	}
}
