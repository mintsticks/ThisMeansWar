
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
