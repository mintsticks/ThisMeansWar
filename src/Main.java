//Variables used to store the resolution of the computer running this application
import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;

//Java FX Class Imports
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
	
	//Initial dimensions of the computer screen
	private final double dispWidth = getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth(); 
	private final double dispHeight = getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	
	//Instance variables to store the resolution of the player
	private double xResolution;
	private double yResolution;
	
	//Instance variables to store the ratios of the user's desired resolution to the highest resolution possible
	//in order to preserve proper position and size of elements relative to the screen.
	private double widthRatio;
	private double heightRatio;
	private double smallestRatio;
	
	/**Instantiates the desired resolution variables to default values, which is the size of the screen,
	 * as well as the ratio instance variables to fit current screen resolution.
	 */
	public Main()
	{
		setRes(dispWidth, dispHeight);
		updateRatio();
	}
	
	/**Starts the program and creates the introduction UI
	 * @param arg0 the default stage
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		
	}
	
	/**Sets the new x and y resolutions based on given values and updates the ratios.
	 * @param xResolution the new x resolution
	 * @param yResolution the new y resolution
	 */
	public void setRes(double xResolution, double yResolution)
	{
		this.xResolution = xResolution;
		this.yResolution = yResolution;
		updateRatio();
	}
	
	/**Updates the width, height, and smallest ratios.
	 */
	public void updateRatio()
	{
		widthRatio = xResolution / 1920.0;
		heightRatio = yResolution / 1080.0;
		smallestRatio = (widthRatio > heightRatio) ? heightRatio : widthRatio;
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	
}
