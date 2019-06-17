//all physical attack scrolls will be initialized in the main method

public class Scroll
{
	private double accuracy; // note: percent change of MISSING, not of hitting
	private int energyCost;
	private int power;
	private String name;

	public Scroll(double a, int e, double p)
	{
		accuracy = a;
		energyCost = e;
		power = p;
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

	public void setPower(double amount)
	{
		power = amount;
	}

	public double getPower()
	{
		return power;
	}

	public String setName(String s)
	{
		name = s;
	}

	public void getName()
	{
		return name;
	}
}