//JavaFx Imports
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Tools {
	//static initializer which runs when the class is initialized, loads different types of fonts for the whole class
	//Site used to learn initializer : https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
	static
	{
		
	}
	
	/**Creates a font based on desired font type, font weight, and size. 
	 * @param font type of font to create
	 * @param weight weight of the font; if null, creates font with default weight (regular)
	 * @param size size of the font
	 * @param smallestRatio ratio to resize font to the dimensions of the screen
	 * @return font created with input preferences
	 */
	public static Font createFont(String font, FontWeight weight, double size, double smallestRatio)
	{
		if(weight != null)
			return Font.font(font, weight, size * smallestRatio);
		else
			return Font.font(font, size * smallestRatio);	
	}
	
	/**Generates text on the screen in a given location with a given font and message
	 * @param xLoc the x-coordinate of the text
	 * @param yLoc the y-coordinate of the text
	 * @param widthRatio the ratio of the user's screen width to the highest possible screen width
	 * @param heightRatio the ratio of the user's screen height to the highest possible screen height
	 * @param content the context of the text 
	 * @param col the text color
	 * @param eff any visual effect 
	 * @param f the text font
	 * @return the text with all the aforementioned settings
	 */
	public static Text createText(double xLoc, double yLoc, double widthRatio, double heightRatio, 
			String content, Color col, Effect eff, Font f) 
	{
		Text text = new Text(content);
		
		text.setFill(col);
		text.setFont(f);
		text.setEffect(eff);
		
		AnchorPane.setTopAnchor(text, yLoc * heightRatio);
		AnchorPane.setLeftAnchor(text, xLoc * widthRatio);
	
		return text;
	}
	
	/**Loads an image and returns it based on a given string
	 * Uses ClassLoader to load the class and get its resources
	 * Site used to learn how to load images: http://stackoverflow.com/questions/14089146/file-loading-by-getclass-getresource
	 * @param name name of the image file, ex: "image.png"
	 * @return image that is at the given location
	 */
	public static Image createImage(String name)
	{
		return new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("res/" + name));
	}
}
