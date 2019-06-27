//all physical attack scrolls will be initialized in the main method

public class Scroll
{
	private double accuracy; // note: percent change of MISSING, not of hitting
	private int energyCost;
	private int power;
	private String name;
	private int iD; //switch statement in main code to be used for every support type scroll with a special effect
	private boolean isNormalType; // support type scrolls have special effects, like restoring HP

	public Scroll(double a, int e, int p, String s, int d, boolean ia)
	{
		accuracy = a;
		energyCost = e;
		power = p;
		name = s;
		iD = d;
		isNormalType = ia;
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

	public boolean getType()
	{
		return isNormalType;
	}

	public int getID()
	{
		return iD;
	}

}