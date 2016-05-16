import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Unit extends UIElement{
	
	//Instance variables for the unit to store its statistics
	private int health;
	private int maxHealth;
	private double attackRange;
	private int damage;
	private double moveRange;
	private int cost;
	private Image icon;
	private Image appearance;
	private String type;
	private int team;
	//Stores whether the unit has attacked or moved this turn. If both are true, then the unit cannot be selected anymore
	private boolean attacked;
	private boolean moved;
	
	/**Creates a unit with the given statistics of health, attack/movement ranges, damage, cost, and appearance
	 * @param team number team the unit belongs to
	 * @param health the health value that the unit has
	 * @param attackRange the distance that a bullet fired by this unit can travel
	 * @param damage damage that a bullet fired by this unit will do to an enemy unit
	 * @param moveRange the distance that this unit can travel in one turn
	 * @param cost the amount of money that it takes for a Player to purchase this unit
	 * @param icon the icon to display on the side of the screen
	 * @param appearance the image that this unit will display on the UI screen
	 * @param type type of the unit
	 */
	public Unit (int team, int health, double attackRange, int damage, double moveRange, int cost, Image icon, Image appearance, String type)
	{
		this.team = team;
		this.health = health;
		maxHealth = health;
		
		this.attackRange = attackRange;
		this.damage = damage;
		this.moveRange = moveRange;
		this.cost = cost;
		this.icon = icon;
		this.type = type;

		this.appearance = appearance;
		this.setImage(appearance);
		
		refreshAction();
	}
	
	/**Changes the units attack variable to true
	 */
	public void attack()
	{
		attacked = true;
	}
	
	/**Returns the appearance of this unit in an ImageView
	 * @return the image that this unit will display on the UI screen
	 */
	public Image getAppearance()
	{
		return appearance;
	}
	
	/**Returns the team of this unit
	 * @return the team of this unit
	 */
	public int getTeam()
	{
		return team;
	}
	/**Returns the attack range of the unit
	 * @return the distance that a bullet fired by this unit can travel
	 */
	public double getAttackRange()
	{
		return attackRange;
	}
	
	/**Returns the cost of the unit
	 * @return the amount of money that it takes for a Player to purchase this unit
	 */
	public int getCost()
	{
		return cost;
	}
	
	/**Returns the damage of the unit
	 * @return damage that a bullet fired by this unit will do to the health of an enemy unit
	 */
	public int getDamage()
	{
		return damage;
	}
	
	/**Returns the health of the unit
	 * @return the health value that the unit has
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**Return the max health of the unit
	 * @return the max health of the unit
	 */
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	/**Returns the icon of the unit
	 * @return the icon of the unit to display on the side of the screen
	 */
	public Image getIcon()
	{
		return icon;
	}
	
	/**Return the type of the unit
	 * @return type of the unit
	 */
	public String getType()
	{
		return type;
	}
	
	/**Returns the movement range of the unit
	 * @return the distance that this unit can travel in one turn
	 */
	public double getMovementRange()
	{
		return moveRange;
	}
	
	/**Returns boolean based on if the unit has attacked this turn
	 * @return whether the unit has attacked this turn
	 */
	public boolean hasAttacked()
	{
		return attacked;
	}
	
	/**Returns boolean based on if the unit has moved this turn
	 * @return whether the unit has moved this turn
	 */
	public boolean hasMoved()
	{
		return moved;
	}
	
	/**Changes the unit's move variable to true
	 */
	public void move()
	{
		moved = true;
	}
	
	/**Refreshes the variables for moving and attacking 
	 * to allow the actions to be done again
	 */
	public void refreshAction()
	{
		attacked = false;
		moved = false;
	}
	
	/**Sets the appearance of this unit
	 * @param Image that the unit will be changed to
	 */
	public void setAppearance(Image picture)
	{
		appearance = picture;
		this.setImage(appearance);
	}
	
	/**Sets the new health of the unit
	 * @param the health value that the unit has
	 */
	public void setHealth(int newHealth)
	{
		health = newHealth;
	}
	
	/**Changes the unit's attack and move variables to true
	 */
	public void skip()
	{
		attacked = true;
		moved = true;
	}
}
