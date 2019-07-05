//all physical attack scrolls will be initialized in the main method

public class Scroll
{
	private double accuracy; // note: percent change of MISSING, not of hitting
	private int energyCost;
	private int power;
	private String name;
	private String description;
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

	public void setDesc(String s)
	{
		description = s;
	}

	public void getDesc()
	{
		int length = name.length();
		int numberDash = 30 - length;
		int sideDash = numberDash / 2;
		int remainder = numberDash % 2;
		System.out.println("");
		for (int i = 0; i < sideDash; i++)
		{
			System.out.print("-");
		}
		System.out.print(name);
		for (int j = 0; j < sideDash; j++)
		{
			System.out.print("-");
		}
		for (int k = 0; k < remainder; k++)
		{
			System.out.print("-");
		}
		System.out.println("");
		System.out.println("-------- Accuracy: " + (100 - (100 * accuracy)) + "%-----");	
		System.out.println("-------- Energy Cost: " + energyCost + " -----");
		char[] mumbo = description.toCharArray();
		for (int k = 0; k < description.length(); k++)
		{
			if (k % 30 == 0 && k != 0)
			{
				System.out.println(mumbo[k]);
			}
			else
			{
				System.out.print(mumbo[k]);
			}
		}
		System.out.println("");
	}

}