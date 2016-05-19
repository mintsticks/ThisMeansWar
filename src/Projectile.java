/**A class that represents a bullet in the game field, with an amount of damage
 * @author Daniel Wong
 * @author Shishir Jessu
 * @author Corey Rogan
 * Period: 3
 * Date: 05-19-16
 */
public class Projectile extends UIElement {
	private double damage;

	/**
	 * Creates a projectile that has a certain damage
	 * @param damage the amount of damage the bullet will inflict to a unit if
	 * it hits it
	 */
	public Projectile(double damage) {
		this.damage = damage;
	}

}
