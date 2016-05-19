/**A class which provides the blueprint for an obstacle in the GameUI, whether
 * a base or a solid obstacle. It contains a boolean whether it can be walked
 * through or shot through
 * @author Daniel Wong
 * @author Shishir Jessu
 * @author Corey Rogan
 * Period: 3
 * Date: 05-19-16
 */

public class Obstacle extends UIElement
{
	// Variable to store if the object is a base or a solid object
	private boolean isBase;

	// Variables to determine whether the objects are able to be walked through
	// or shot through
	private boolean isWalkable;
	private boolean isShootable;

	/**
	 * Creates an obstacle that is either a base or a solid object
	 * @param isBase boolean that determines if the object is a base or not. If
	 * it is a base, it can be walked through; if it is a solid object it cannot
	 * be walked through. Both cannot be shot through.
	 */
	public Obstacle(boolean isBase)
	{
		this.isBase = isBase;

		isWalkable = isBase;
		isShootable = false;
	}

	/**
	 * Returns whether the obstacle is a base
	 * @return whether the obstacle is a base
	 */
	public boolean isBase()
	{
		return isBase;
	}

	/**
	 * Returns whether the obstacle can be shot through
	 * @return whether the obstacle can be shot through
	 */
	public boolean isShootable()
	{
		return isShootable;
	}

	/**
	 * Returns whether the obstacle can be walked through
	 * @return whether the obstacle can be walked through
	 */
	public boolean isWalkable()
	{
		return isWalkable;
	}
}
