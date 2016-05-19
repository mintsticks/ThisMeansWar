/**An class which provides the blueprints for a player, which can hold a list of
 * units, has a name and an amount of money. Used in Game UI to play the game.
 * @author Daniel Wong
 * @author Shishir Jessu
 * @author Corey Rogan
 * Period: 3
 * Date: 05-19-16
 */
import java.util.*;

public class Player
{
	//Instance variables for each player
	private String name;
	private List<Unit> units;
	private int money;

	/**
	 * Creates a player with a name, an empty unit list and the default money.
	 * @param name the given name for the player
	 */
	public Player(String name)
	{
		this.name = name;
		units = new ArrayList<Unit>();
		money = 400;
	}
	
	/**
	 * Adds money to the player's money amount
	 * @param toAdd amount of money to add
	 */
	public void addMoney(int toAdd)
	{
		money += toAdd;
	}
	
	/**
	 * Adds a unit to the player's unit list
	 * @param unit the unit to add to this player's unit list
	 */
	public void addUnit(Unit unit)
	{
		units.add(unit);
	}
	/**
	 * Subtracts an amount of money from the player
	 * @param toDeduct amount of money to subtract from the player
	 */
	public void deductMoney(int toDeduct)
	{
		money -= toDeduct;
	}

	/**
	 * Gets the amount of money for the player
	 * @return the amount of money for the player
	 */
	public int getAmountOfMoney()
	{
		return money;
	}

	/**
	 * Gets the name of the player
	 * @return the name of the player
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the unit list of the player
	 * @return the unit list of player
	 */
	public List<Unit> getUnitList()
	{
		return units;
	}

	/**
	 * Returns whether the player's unit list is empty
	 * @return whether the player's unit list is empty
	 */
	public boolean isEmpty()
	{
		return units.size() == 0;
	}

	/** 
	 * Removes a given unit from the player list
	 * @param unit the given unit to remove from the player list
	 */
	public void removeUnit(Unit unit)
	{
		units.remove(unit);
	}

}
