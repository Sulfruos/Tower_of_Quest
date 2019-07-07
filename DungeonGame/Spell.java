import java.lang.Math;

public class Spell
{
	private double accuracy; // note: percent change of MISSING, not of hitting
	private int manaCost;
	private String name;
	private double power;
	private String description;
	private int iD; //switch statement in main code to be used for every spell effect

	public Spell(double a, int m, double p, String s, int d)
	{
		accuracy = a;
		manaCost = m;
		name = s;
		power = p;
		iD = d;
	}

	public void setAccuracy(double amount)
	{
		accuracy = amount;
	}

	public double getAccuracy()
	{
		return accuracy;
	}

	public void setManaCost(int amount)
	{
		manaCost = amount;
	}

	public int getManaCost()
	{
		return manaCost;
	}

	public void setPower(double amount)
	{
		power = amount;
	}

	public double getPower()
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
		System.out.println("-------- Mana Cost: " + manaCost + " -------");
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