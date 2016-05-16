
public class Obstacle extends UIElement{
	//Variable to store if the object is a base or a solid object
	private boolean isBase;
	
	//Variables to determine whether the objects are able to be walked through or shot through
	private boolean isWalkable;
	private boolean isShootable;
	
	/**Creates an obstacle that is either a base or a solid object 
	 * @param isBase boolean that determines if the object is a base or not. If it is a base, it can be walked through; if it is a solid object
	 * it cannot be walked through. Both cannot be shot through.
	 */
	public Obstacle(boolean isBase) {
		this.isBase = isBase;
		
		isWalkable = isBase;
		isShootable = false;
	}
	
	/**
	 * @return
	 */
	public boolean isBase() {
		return isBase;
	}
	
	/**
	 * @return
	 */
	public boolean isShootable() {
		return isShootable;
	}
	
	/**
	 * @return
	 */
	public boolean isWalkable() {
		return isWalkable;
	}
	
	
	
	
}
