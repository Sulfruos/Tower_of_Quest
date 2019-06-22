import java.util.ArrayList;

public class scrollInventory
{
	private ArrayList<Scroll> inv;

	public scrollInventory(Scroll x)
	{
		ArrayList<Scroll> list = new ArrayList<Scroll>();
		list.add(x);
		inv = list;
	}

	public void addScroll(Scroll x)
	{
		inv.add(x);
	}

	public void printScrolls()
	{
		int count = 0;
		for (Scroll item : inv)
		{
			System.out.println("(" + count + ")" + " : " + item.getName());
		}
	}

	public Scroll chooseScroll(int n)
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