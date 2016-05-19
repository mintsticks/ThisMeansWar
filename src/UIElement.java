
//JavaFx Imports
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public abstract class UIElement extends ImageView {
	// Shape of UIElement used to check for intersection
	private Shape collisionShape;

	/**
	 * Checks the current shape with another given shape and checks for
	 * intersection. This method uses the intersect method in Shape, which
	 * returns a shape representing the intersection of the two shapes given. It
	 * then converts the intersection shape into a path. If there are more than
	 * zero elements in the path then there is an intersection.
	 * @param other other UI element which is checked for intersection
	 * @return whether the two shapes intersect
	 */
	public boolean checkCollision(UIElement other) {
		return ((Path) Shape.intersect(this.collisionShape,
				other.getCollShape())).getElements().size() > 0;
	}

	/**
	 * Creates the collision shape for the UIElement
	 */
	protected void createCollShape() {
		setCollShape(new Rectangle(0, 0, 1, 1));
		collisionShape.setFill(Tools.TRANSPARENT);
	}

	/**
	 * Retrieves the collision shape for the element
	 * @return collision shape of the element used to check for intersections
	 */
	public Shape getCollShape() {
		return collisionShape;
	}

	/**
	 * Sets the collision shape for the element to the given shape
	 * @param collisionShape collision shape of the element used to check
	 * intersections
	 */
	public void setCollShape(Shape collisionShape) {
		this.collisionShape = collisionShape;
	}

	/**
	 * Updates the collision shape to a new size or position
	 * @param height desired height of shape
	 * @param width desired width of shape
	 * @param angle desired angle of shape
	 * @param xLoc the x-coordinate of the shape
	 * @param yLoc the y-coordinate of the shape
	 * @param widthRatio the ratio of the user's desired width resolution to the
	 * highest possible screen width
	 * @param heightRatio the ratio of the user's desired height resolution to
	 * the highest possible screen height
	 * @param smallestRatio smallest of the two ratios, used to resize the image
	 */
	public void updateCollShape(double height, double width, double angle,
			double xLoc, double yLoc, double widthRatio, double heightRatio,
			double smallestRatio) {
		if (collisionShape == null) {
			createCollShape();
		}
		collisionShape.setLayoutX(xLoc * widthRatio);
		collisionShape.setLayoutY(yLoc * heightRatio);
		collisionShape.setScaleX(width * smallestRatio);
		collisionShape.setScaleY(height * smallestRatio);
		collisionShape.setRotate(angle);
	}

}
