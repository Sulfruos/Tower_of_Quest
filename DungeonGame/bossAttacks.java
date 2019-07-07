import java.lang.Math;
import java.util.ArrayList;

public class bossAttacks
{
	private ArrayList<Spell> inv;

	public bossAttacks(Spell x)
	{
		ArrayList<Spell> list = new ArrayList<Spell>();
		list.add(x);
		inv = list;
	}

	public void addAttack(Spell x)
	{
		inv.add(x);
	}

	public int getSize()
	{
		return inv.size();
	}

	public Spell chooseAttack(int n)
	{
		for (int i = 0; i < inv.size(); i++)
		{
			if (n == i)
			{
				return inv.get(i);
			}
		}

		return null;
	}
}