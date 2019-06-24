//all physical attack scrolls will be initialized in the main method

public class Scroll
{
	private double accuracy; // note: percent change of MISSING, not of hitting
	private int energyCost;
	private int power;
	private String name;
	private boolean isOwned;

	public Scroll(double a, int e, int p, String s)
	{
		accuracy = a;
		energyCost = e;
		power = p;
		name = s;
	}

	public void setAccuracy(double amount)
	{
		accuracy = amount;
	}

	public double getAccuracy()
	{
		return accuracy;
	}

	public void setEnergyCost(int amount)
	{
		energyCost = amount;
	}

	public int getEnergyCost()
	{
		return energyCost;
	}

	public void setPower(int amount)
	{
		power = amount;
	}

	public int getPower()
	{
		return power;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String getName()
	{
		return name;
	}

	public void acquire()
	{
		isOwned = true;
	}

}