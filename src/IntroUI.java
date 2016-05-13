import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
	
public class IntroUI extends Stage{
	
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 675;
	public static final int BORDER_WIDTH = 1220;
	public static final int BORDER_HEIGHT = 695;
	
	public static final int PLAY_WIDTH = 383;
	public static final int PLAY_HEIGHT = 204;
	public static final int PLAY_X = 933;
	public static final int PLAY_Y = 561;
	public static final int RECT_ARC_SIZE = 30;
	public static final Color TRANSPARENT =  Color.rgb(100, 100, 100, 0);
	
	public static final int OFFSET = 10;
	
	public static final Image INTRO_BORDER_IMAGE = Tools.createImage("background.jpg");
	public static final Image INTRO_BACK_IMAGE = Tools.createImage("IntroBack.png");
	public static final Image INTRO_HELP_CLICK_IMAGE = Tools.createImage("IntroHelpClick.png");
	public static final Image INTRO_HELP_HOVER_IMAGE = Tools.createImage("IntroHelpHover.png");
	public static final Image INTRO_PLAY_CLICK_IMAGE = Tools.createImage("IntroPlayClick.png");
	public static final Image INTRO_PLAY_HOVER_IMAGE = Tools.createImage("IntroPlayHover.png");

	public static final BackgroundImage INTRO_BORDER = new BackgroundImage(INTRO_BORDER_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(), INTRO_BORDER_IMAGE.getHeight(), false, false, false, false));
	public static final BackgroundImage INTRO_BACK = new BackgroundImage(INTRO_BACK_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BACK_IMAGE.getWidth(), INTRO_BACK_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage INTRO_HELP_CLICK = new BackgroundImage(INTRO_HELP_CLICK_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_HELP_CLICK_IMAGE.getWidth(), INTRO_HELP_CLICK_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage INTRO_HELP_HOVER = new BackgroundImage(INTRO_HELP_HOVER_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_HELP_HOVER_IMAGE.getWidth(), INTRO_HELP_HOVER_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage INTRO_PLAY_CLICK = new BackgroundImage(INTRO_PLAY_CLICK_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_PLAY_CLICK_IMAGE.getWidth(), INTRO_PLAY_CLICK_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage INTRO_PLAY_HOVER = new BackgroundImage(INTRO_PLAY_HOVER_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_PLAY_HOVER_IMAGE.getWidth(), INTRO_PLAY_HOVER_IMAGE.getHeight(), false, false, true, false));
	
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
		//Creates the border
		Stage border = createIntroBorder();
				
		//Connects the intro screen with its border
		this.initOwner(border);
		this.setX(border.getX() + OFFSET * widthRatio);
		this.setY(border.getY() + OFFSET * heightRatio);
		
		//Editing the root, which is what elements display on
		root.setBackground(new Background(INTRO_BACK));
		
		Rectangle helpPanel = Tools.createRoundedRectangle(PLAY_WIDTH, PLAY_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, PLAY_X, PLAY_Y, 
				widthRatio, heightRatio, smallestRatio, Color.BLUE, null);
		
		helpPanel.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_HELP_HOVER));
			}
        });
		helpPanel.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_BACK));
			}
        });
		helpPanel.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_HELP_CLICK));
			}
        });
		helpPanel.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_BACK));
			}
        });
		
		root.getChildren().addAll(helpPanel);
		root.setEffect(Tools.XLARGE_SHADE);
		this.setScene(scene);
	}
	
	private Stage createIntroBorder() {
		Stage border = new Stage();
		border.initStyle(StageStyle.TRANSPARENT);

		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, BORDER_WIDTH * widthRatio, BORDER_HEIGHT * heightRatio);

		root.setBackground(new Background(INTRO_BORDER));
		root.setEffect(Tools.LARGE_SHADE);
		border.setScene(scene);
		border.show();
		border.centerOnScreen();
		
		return border;
	}
	
	private void showHelpScreen()
	{
		AnchorPane root = new AnchorPane();
		Scene helpScene = new Scene (root, SCENE_WIDTH * widthRatio, SCENE_HEIGHT * heightRatio);
		root.setBackground(new Background(INTRO_BACK));
		this.setScene(helpScene);	
	}
	

}
