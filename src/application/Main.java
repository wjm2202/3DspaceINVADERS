package application;

import java.util.ArrayList;
import java.util.Random;
import gameValues.SpawnEnemies;
import gameValues.LevelValues;
import gameValues.Movement;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Point3D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.stage.Stage;
import operations.BoundsClamp;
import operations.CreateBox;
import operations.CreateCamera;
import operations.Enemy;
import operations.LightingElements;
import operations.RotateElements;
import operations.ScaleElements;
import operations.WorldCoOrdinates;
/**
 * This is where the control logic goes for the main flow of the Model Veiw Controller
 * most of this code is to set up the environment 
 * you will need to talk to glen before making changes in this class
 * EXCEPT for the HANDLE method, you can add code where you see your name commented
 * @author Liandri
 *
 */
public class Main extends Application{
	
	Group root;                                                  //array that holds all objects on screen
	Label tfs;                                                   //label on tool bar that displays score
	Label tfh;                                                   //label on tool bar that displays health
	Rectangle2D screen = Screen.getPrimary().getVisualBounds();  //get screen size
	PickResult selectedNode;                                     //mouse has clicked this object
	Node node;                                                   //a single 3D object
	ToolBar toolBar;                                             //the button bar at the bottom of scene
	static Group invaderGroup = new Group();                     //a group of 3D objects of type invader
	static Group boarderGroup = new Group();                     //a group of 3D objects that make up the world box
	static Group cameraGroup = new Group();                      //a group of view objects that give you a scene to look at
	static Group tankGroup = new Group();                        //a group of tanks 
	static Group bulletGroup = new Group();                      //a group of bullets
	static Group bombGroup = new Group();                        //a group of bombs
	static boolean picked;                                       //is an object selected
	double centX = screen.getMaxX()/2;                           //location of center of the screen width
	double centY = screen.getMaxY()/2;                           //location of center of the screem height
	int translocateX = (int)centX;                               //center X
	int translocateY = (int)centY;                               //center Y 
	double sW = screen.getMaxX();
	double sH = screen.getMaxY();
	double cx= 483;                                                      //camera start location X
	double cy= -36;                                                      //camera start location Y
	double cz= 0.0;                                                      //camera start location Z
	double cRoll = 0;                                                    //camera start roll amount
	private double mousePosX, mousePosY;                                 //mouse drag position
	private double mouseOldX, mouseOldY;                                 //mouse drag position
	private final Rotate rotateX = new Rotate(0, Rotate.X_AXIS);         //rotate transform X
	private final Rotate rotateY = new Rotate(20, Rotate.Y_AXIS);        //rotate transform Y
	private final Rotate rotateZ = new Rotate(0, Rotate.Z_AXIS);         //rotate transform Z
	LightingElements lightEle = new LightingElements();                  //lighting
	CreateCamera perCamera = new CreateCamera();                         //camera
	CreateBox boxOP = new CreateBox();                                   //box factory
	PerspectiveCamera camera;                                            //camera variable
	SpawnEnemies sUpInvader = new SpawnEnemies();                        //set up invader variables
	LevelValues gvg = new LevelValues();                                 //get gameVariable for invader game
	WorldCoOrdinates loc3D = new WorldCoOrdinates();                     //get preset points important for gaem
	ArrayList<Point3D> bounds = new ArrayList<>();                       //get the 3D world corner points
	ArrayList<Enemy> enemy = new ArrayList<>();                          //array of current enemies
	ArrayList<Point3D> startP3d = new ArrayList<>();                     //get pre generated start locations for enemies

	BoundsClamp bc = new BoundsClamp();                                  //contain the 3D objects inside the 3D world box
	Random rand = new Random();                                          //random value used for testing
	RotateElements re = new RotateElements();                            //rotate transform for 3D objects
	ScaleElements scale = new ScaleElements();                           //scale transform for 3D objects
	Movement facing = Movement.forwards;
	Point3D bulletStart;                                                 //the location of the start of the bullet
	Point3D bombStart;                                                   //the location of the start of the bomb
	int trigger=0;                                                       //the limiter to the number of bombs dropped
	int score=0;                                                         //the player score
	int health=100;                                                      //the player health
	boolean gameIsRunning = false;                                       //game state started or stoped
	int currHitsOnTank =0;                                               //the amount of hits on the tank since last update

	public static void main(String[] args)//DO NOT CODE HERE
	{                                     //DO NOT CODE HERE
		Application.launch(args);         //DO NOT CODE HERE
	}                                     //DO NOT CODE HERE
	@Override
	public void start(Stage stage)        //TREAT THIS AS MAIN
	{		
		bounds = loc3D.getBounds();
		Platform.setImplicitExit(true);                           //close down clean up
		System.out.println(
				  "3D supported? " + 
				  Platform.isSupported(ConditionalFeature.SCENE3D)        //3d effects supported check
				);
		root = lightEle.getLights();                                       //add the lights
		// Create a Camera to view the 3D Shapes
		camera = perCamera.getCamera();                                    //add the camera
		camera.getTransforms().addAll (rotateX, rotateY, rotateZ);  //add transforms to camera
		camera.setTranslateX(cx);                              
		camera.setTranslateY(cy);
		camera.setTranslateZ(cz);
		camera.setRotate(cRoll);
		camera.setNearClip(0.4);
		camera.setFarClip(4000.0);
		camera.setFieldOfView(45);

		//create 3d invader
		int zCount = 1200;
		int dSize = 10;
		//loop that creates multiple invader of the same type but moves along Z axis to create the 3D affect
		for(int i = 0; i < 9; i++){
			if(i == 0){
				root.getChildren().add(boxOP.invader(root, dSize, 0, 30, zCount));
			}
			else if (i > 0 && i < 5){
				zCount = zCount + 10; //move back on the axis and creating another replica of the invader to create 3D affect
				dSize = dSize + 3;
				root.getChildren().add(boxOP.invader(root, dSize, 0, 30, zCount));
			}
			else{
				zCount = zCount + 10;
				dSize = dSize - 3;
				root.getChildren().add(boxOP.invader(root, dSize, 0, 30, zCount));
			}
		}
		zCount = 1200; //Goes back to where it started
		for(int i = 0; i < 9; i++){
			if(i == 0){
				root.getChildren().add(boxOP.invader2(root, dSize, 150, 30, zCount));
			}
			else if (i > 0 && i < 5){
				zCount = zCount + 10;
				dSize = dSize + 3;
				root.getChildren().add(boxOP.invader2(root, dSize, 150, 30, zCount));
			}
			else{
				zCount = zCount + 10;
				dSize = dSize - 3;
				root.getChildren().add(boxOP.invader2(root, dSize, 150, 30, zCount));
			}
		}
		zCount = 1200;//Goes back to where it started
		for(int i = 0; i < 9; i++){
			if(i == 0){
				root.getChildren().add(boxOP.invader3(root, dSize, 300, 30, zCount));
			}
			else if (i > 0 && i < 5){
				zCount = zCount + 10;
				dSize = dSize + 3;
				root.getChildren().add(boxOP.invader3(root, dSize, 300, 30, zCount));
			}
			else{
				zCount = zCount + 10;
				dSize = dSize - 3;
				root.getChildren().add(boxOP.invader3(root, dSize, 300, 30, zCount));
			}
		}
		zCount = 1200;//Goes back to where it started
		for(int i = 0; i < 9; i++){
			if(i == 0){
				root.getChildren().add(boxOP.invader4(root, dSize, 450, 30, zCount));
			}
			else if (i > 0 && i < 5){
				zCount = zCount + 10;
				dSize = dSize + 3;
				root.getChildren().add(boxOP.invader4(root, dSize, 450, 30, zCount));
			}
			else{
				zCount = zCount + 10;
				dSize = dSize - 3;
				root.getChildren().add(boxOP.invader4(root, dSize, 450, 30, zCount));
			}
		}

		//create sub scene for tool bar             
		SubScene subScene = new SubScene(root, sW, sH-100,true,SceneAntialiasing.DISABLED);                           //make sub scene add group
		subScene.setFill(Color.BLACK);                                          //fill scene with color
		subScene.setCamera(camera);                                             //add camera to scene
		cameraGroup.getChildren().add(camera);
		root.getChildren().add(cameraGroup);
		BorderPane pane = new BorderPane();                                         //make outer display
		pane.setCenter(subScene);
		

		tfs = new Label("SCORE: "+score);                                           //add the score to tool bar
		tfh = new Label("Health: "+health);                                         //add the score to tool bar


		Button start = new Button("Start game");           //Start game                  
		start.setOnAction(e->{
			//code set up here
		});
		toolBar = new ToolBar(start,tfs,tfh);                                       //tool bar add button and box

		toolBar.setOrientation(Orientation.HORIZONTAL);                             //set tool bar horizontal
		pane.setBottom(toolBar);                                                    //put tool bar in bottom pane
		pane.setPrefSize(300,300);                                                  //size of center element
		Scene scene = new Scene(pane);                                              //add pane to scene
		scene.setOnMousePressed((MouseEvent me) -> {                                //add mouse PRESSED event
			mouseOldX = me.getSceneX();                                             //get starting location X
			mouseOldY = me.getSceneY();                                             //get starting location Y
		});
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				Node tank = tankGroup.getChildren().get(0);

				switch (event.getCode()){
					case UP:
						if(bc.tankZClamp(tank)){
							re.rotateTank(tank, facing, Movement.forwards);
							tank.setTranslateZ(tank.getTranslateZ()+20);
							facing=Movement.forwards;
							event.consume();
						}else{
							re.rotateTank(tank, facing, Movement.forwards);
							tank.setTranslateZ(tank.getTranslateZ()-60);
							facing=Movement.forwards;
							event.consume();
						}
						break;
					case DOWN:
						if(bc.tankZClamp(tank)){
							re.rotateTank(tank, facing, Movement.backwards);
							tank.setTranslateZ(tank.getTranslateZ()-20);
							facing=Movement.backwards;
							event.consume();
						}else{
							re.rotateTank(tank, facing, Movement.backwards);
							tank.setTranslateZ(tank.getTranslateZ()+60);
							facing=Movement.backwards;
							event.consume();
						}
						break;
					case LEFT:
						if(bc.tankXClamp(tank)){
							re.rotateTank(tank, facing, Movement.left);
							tank.setTranslateX(tank.getTranslateX()-20);
							facing=Movement.left;
							event.consume();
						}
						else{
							re.rotateTank(tank, facing, Movement.left);
							tank.setTranslateX(tank.getTranslateX()+60);
							facing=Movement.left;
							event.consume();
						}
						break;
					case RIGHT:
						if(bc.tankXClamp(tank)){
							re.rotateTank(tank, facing, Movement.right);
							tank.setTranslateX(tank.getTranslateX()+20);
							facing=Movement.right;
							event.consume();
						}else{
							re.rotateTank(tank, facing, Movement.right);
							tank.setTranslateX(tank.getTranslateX()-60);
							facing=Movement.right;
							event.consume();
						}
						break;
					case COMMA://When user press Comma button to shoot the bullet
						//tank
						break;
					default:
						break;
				}

			}
		});
		scene.setOnMouseClicked((event)->{                                          //make picked objects red
			PickResult res = event.getPickResult();                                 //pick 3d object
			if (res.getIntersectedNode() instanceof Box){                           //if object is box
				((Box)res.getIntersectedNode()).setMaterial(                        //set material
						new PhongMaterial(event.isShiftDown() ? Color.BLACK : Color.RED));
				root.getChildren().remove(res);
			}
		});
		final long startNanoTime = System.nanoTime();           //get current time

		new AnimationTimer()                                    //make animation timer
		{
			public void handle(long currentNanoTime)           //Default method as inner class
			{
				double time = (currentNanoTime - startNanoTime) / 1000000000.0;      //USED TO UPDATE LOCATIONS ECT
			    //GAME LOOP 
				
				
				
				
				
				
				
				

			}
		}.start();


		facing = Movement.forwards;
		gvg.setTankXsize(100); //Stretching sideways (left and right)
		gvg.setTankYsize(50); //Stretching upwards (up and down)
		gvg.setTankZsize(50); //Stretching across (towards and away)
		gvg.setTankPositon(500, 500, 1050);
		tankGroup.getChildren().add(boxOP.makeTank(gvg.getTankXPosition(), gvg.getTankYPosition(), gvg.getTankZPosition(), gvg.getTankXsize(),gvg.getTankYsize(),gvg.getTankZsize()));
		root.getChildren().add(tankGroup);
		root.getChildren().add(boxOP.ground());                //add ground to scene
		root.getChildren().add(boxOP.horizon());               //add background to scene
		//root.getChildren().add(boxOP.gameBound(root, 0, 0, 800, 5));
		root.getChildren().add(boxOP.gameBox());			   //creating the box environment
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());      //add css to ui
		stage.setScene(scene);                                                     // Add the Scene to the Stage
		stage.setTitle("3D Libary Development");                                   // Set the Title of the Stage
		stage.show();                                                              // show to user
	}

}
