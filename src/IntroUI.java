import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
	
public class IntroUI extends Stage{
	
	public static final int SCENE_WIDTH = 1000;
	public static final int SCENE_HEIGHT = 600;
	public static final int BORDER_WIDTH = 1020;
	public static final int BORDER_HEIGHT = 620;
	public static final int OFFSET = 10;
	
	public static final Image INTRO_BORDER_IMAGE = Tools.createImage("background.jpg");
	public static final BackgroundImage INTRO_BORDER = new BackgroundImage(INTRO_BORDER_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth()/3, INTRO_BORDER_IMAGE.getHeight()/3, false, false, false, false));
	
	public static final Image INTRO_BACK_IMAGE = Tools.createImage("Camo.jpeg");
	public static final BackgroundImage INTRO_BACK = new BackgroundImage(INTRO_BACK_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BACK_IMAGE.getWidth()/3, INTRO_BACK_IMAGE.getHeight()/3, false, false, false, false));
	
	private double widthRatio;
	private double heightRatio;
	private double smallestRatio;
	
	private AnchorPane root;
	private Scene scene;
	private Stage border;
	
	public IntroUI(double widthRatio, double heightRatio, double smallestRatio)
	{
		this.widthRatio = widthRatio;
		this.heightRatio = heightRatio;
		this.smallestRatio = smallestRatio;
		
		this.initStyle(StageStyle.TRANSPARENT);
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, SCENE_WIDTH * widthRatio, SCENE_HEIGHT * heightRatio);
		
		//Editing the root, which is what elements display on
		root.setBackground(new Background(INTRO_BACK));
		root.setEffect(Tools.LARGE_SHADE);
		this.setScene(scene);
		
		//Creates the border
		Stage border = createIntroBorder();
		border.show();
		border.centerOnScreen();
		
		//Connects the intro screen with its border
		this.initOwner(border);
		this.setX(border.getX() + OFFSET * widthRatio);
		this.setY(border.getY() + OFFSET * heightRatio);
		
		
	}
	
	private Stage createIntroBorder() {
		Stage border = new Stage();
		border.initStyle(StageStyle.TRANSPARENT);

		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, BORDER_WIDTH * widthRatio, BORDER_HEIGHT * heightRatio);

		root.setBackground(new Background(INTRO_BORDER));
		border.setScene(scene);

		return border;
	}
	

}
