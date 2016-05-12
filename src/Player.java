import java.util.ArrayList;
import java.util.List;

public class Player {
	
	List<Unit> units;
	int money;
	
	public Player()
	{
		units = new ArrayList<Unit>();
		money = 100; //some default value we can change later
	}
	
	public List<Unit> getUnitList()
	{
		return units;
	}
	
	public int getAmountOfMoney()
	{
		return money;
	}
	
	public void addUnit(Unit u)
	{
		units.add(u);
	}
	
	public void removeUnit (Unit u)
	{
		units.remove(u);
	}
	
	public void addMoney(int toAdd)
	{
		money += toAdd;
	}
	
	public void deductMoney (int toDeduct)
	{
		money -= toDeduct;
	}
	

}
