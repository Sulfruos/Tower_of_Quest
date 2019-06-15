//all physical attack scrolls will be initialized in the main method

public class Scroll
{
	private double accuracy; // note: percent change of MISSING, not of hitting
	private int energyCost;
	private int power;

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
}