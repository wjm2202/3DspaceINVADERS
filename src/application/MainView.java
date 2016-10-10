package application;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import camera.CreateCamera;
import camera.MoveCamera;
import com.sun.javafx.application.LauncherImpl;
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
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.stage.Stage;
import operations.*;

import javax.swing.*;

/**
 * This is where the control logic goes for the main flow of the Model Veiw Controller
 * most of this code is to set up the environment 
 * you will need to talk to glen before making changes in this class
 * EXCEPT for the HANDLE method, you can add code where you see your name commented
 * @author Liandri
 *
 */
public class MainView extends Application{

	private Label camLoc;
	private Label camAngleLBL;
	private Label levelNum;
	private Label isAlive;
	private Group root;                                                  //array that holds all objects on screen
	private Label tfs;                                                   //label on tool bar that displays score
	private Label tfh;                                                   //label on tool bar that displays health
	private Rectangle2D screen = Screen.getPrimary().getVisualBounds();  //get screen size
	private PickResult selectedNode;                                     //mouse has clicked this object
	private Node node;                                                   //a single 3D object
	private ToolBar toolBar;                                             //the button bar at the bottom of scene
//GROUPS
	private static Group invaderGroup = new Group();                    //a group of 3D objects of type invader
	private static Group boarderGroup = new Group();                     //a group of 3D objects that make up the world box
	private static Group cameraGroup = new Group();                      //a group of view objects that give you a scene to look at
	private static Group tankGroup = new Group();                        //a group of tanks
	private static Group bulletGroup = new Group();                      //a group of bullets
	private static Group bombGroup = new Group();                        //a group of bombs
	private static Group homingGroup = new Group();
	private static Group explosionGroup = new Group();
	private static Group rewardGroup = new Group();
//CAMERA stuff
	private static boolean picked;                                       //is an object selected
	private double centX = screen.getMaxX()/2;                           //location of center of the screen width
	private double centY = screen.getMaxY()/2;                           //location of center of the screem height
	private int translocateX = (int)centX;                               //center X
	private int translocateY = (int)centY;                               //center Y
	private double sW = screen.getMaxX();
	private double sH = screen.getMaxY();
	private double cx= 483;                                                      //camera start location X
	private double cy= -36;                                                      //camera start location Y
	private double cz= 0.0;                                                      //camera start location Z
	private double cRoll = 0;                                                    //camera start roll amount
	private double mousePosX, mousePosY;                                 //mouse drag position
	private double mouseOldX, mouseOldY;                                 //mouse drag position
	private final Rotate rotateX = new Rotate(0, Rotate.X_AXIS);         //rotate transform X
	private final Rotate rotateY = new Rotate(20, Rotate.Y_AXIS);        //rotate transform Y
	private final Rotate rotateZ = new Rotate(0, Rotate.Z_AXIS);         //rotate transform Z
//SINGLE CONTRUCT OBJECTS
	public static WorldCoOrdinates loc3D = Splash.wc;                     //get preset points important for game
	public static LevelValues gvg = new LevelValues();                   //get gameVariable for invader game
	public static Img img = new Img();                                                 //image class to get images
	public static SoundEffects se = new SoundEffects();
	public static ModelImporter mi = new ModelImporter();
//OBJECTS
	private MoveCamera mc = new MoveCamera();
	private LightingElements lightEle = new LightingElements();                  //lighting
	private CreateCamera perCamera = new CreateCamera();                         //camera
	private CreateBox boxOP = new CreateBox();                                   //box factory
	private PerspectiveCamera camera;                                            //camera variable
	private ArrayList<Enemy> removeEnemies = new ArrayList<>();
	private ArrayList<Node> collectedRewards = new ArrayList<>();
	FirstPreloader fp = new FirstPreloader();
	private Update update = new Update();                                        //update all elements locations and detect collisions
	private ArrayList<Enemy> enemy = new ArrayList<>();                          //array of current enemies
	private ArrayList<Point3D> startP3d = new ArrayList<>();                     //get pre generated start locations for enemies
	private BoundsClamp bc = new BoundsClamp();                                  //contain the 3D objects inside the 3D world box
	private Random rand = new Random();                                          //random value used for testing
	private RotateElements re = new RotateElements();                            //rotate transform for 3D objects
	private ScaleElements scale = new ScaleElements();                           //scale transform for 3D objects
	private Movement facing = Movement.forwards;                                 //ENUM starting value
	private Point3D bulletStart = new Point3D(0.0,0.0,0.0);                      //the location of the start of the bullet
	private Point3D bombStart;                                                   //the location of the start of the bomb
	private Point3D invaderStart;
	private Point3D tankLocation;
	private Point3D homingStart;
	private MakeAssets ma = new MakeAssets();
	private Homing homing = new Homing();
	private NewLevelStart nls = new NewLevelStart();

	private Node grnd;
//VARIABLES
	private int trigger=0;                                                       //the limiter to the number of bombs dropped
	private int score=0;                                                         //the player score
	private int health=100;                                                      //the player health
	public static boolean gameIsRunning = false;                                       //game state started or stoped
	private int currHitsOnTank =0;                                               //the amount of hits on the tank since last update
	private int gameLevel = 1;                                                   //track the game level
	private boolean alive = true;
	private double moveX = 0.5;
	private double moveZ = 0.5;
	private boolean started = false;
	private int camView = 1;
	private int camdirection = 1;
    public static boolean nextLevel = false;
	public int boxScale=0;
	public int numEnimies;
	private static Stage window;
	private static boolean tankView = false;
	private Point3D oldCameraView;
	public int viewsInTankView = 0;
	public boolean resetView = false;
	public boolean firstTime = true;

	@Override
	public void stop(){                                                  //if the game stops or window is closed these methods will be called
		Platform.exit();
	}

	public static void main(String[] args)//DO NOT CODE HERE
	{                                     //DO NOT CODE HERE
		//Application.launch(args);         //DO NOT CODE HERE
		LauncherImpl.launchApplication(MainView.class, FirstPreloader.class, args);

	}                                     //DO NOT CODE HERE

    public static void nextLevel() {
        Platform.runLater(new Runnable() {
            public void run() {
                //run another application from here
                new NextLevel().start(new Stage());
            }
        });
    }
	public static void worldToFront() {
		Platform.runLater(new Runnable() {
			public void run() {
				//run another application from here
				window.toFront();
			}
		});
	}

	@Override
	public void init(){
		enemy =nls.initLevel();
		for(int i=0;i<enemy.size();i++){
			invaderGroup.getChildren().add(enemy.get(i).getGroup());
		}
		numEnimies = gvg.getNumEnimies();
	}

	@Override
	public void start(Stage stage)        //TREAT THIS AS MAIN
	{
		window = stage;
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


		//create sub scene for tool bar
		SubScene subScene = new SubScene(root, sW, sH-100,true,SceneAntialiasing.DISABLED);                           //make sub scene add group
		subScene.setFill(Color.BLACK);                                          //fill scene with color
		subScene.setCamera(camera);                                             //add camera to scene
		cameraGroup.getChildren().add(camera);
		root.getChildren().add(cameraGroup);
		BorderPane pane = new BorderPane();                                         //make outer display
		pane.setCenter(subScene);
		//System.out.println("application test START  at top");
		tfs = new Label("SCORE: "+score);                                           //add the score to tool bar
		tfh = new Label("Health: "+health);                                         //add the score to tool bar
		isAlive = new Label("Alive: "+alive);
		levelNum = new Label("Level: "+gameLevel);
		camAngleLBL = new Label("Camera Angle: "+mc.getCameraAngle(camera));
		camLoc = new Label("Camera Location: X: "+camera.getTranslateX()+" Y: "+camera.getTranslateY()+" Z: "+camera.getTranslateZ());
		VBox vbox = new VBox();
		vbox.getChildren().addAll(camAngleLBL,camLoc);

		Button exit = new Button("Exit game");           //Exit game
		exit.setOnAction(e->{
			gameIsRunning=false;
			Platform.exit();
		});
		Button changeView = new Button("Camera View");           //Exit game
		changeView.setOnAction(e->{
			if(!tankView){
				if(camView==1){
					perCamera.birdCamera(1);
					camdirection = 1;
				}else if(camView==2){
					perCamera.birdCamera(2);
					camdirection = -1;
				}
				camView += camdirection;
				camera = perCamera.getCamera();
			}

		});
		Button pause = new Button("Pause/Un-Pause");           //Pause game
		pause.setOnAction(e->{
			gameIsRunning = gameIsRunning != true;
		});
		Button tankCamera = new Button("Tank View");           //Pause game
		tankCamera.setOnAction(e->{
			if(camView!=3){
				if(tankView==false){
					tankView=true;

					//System.out.println("tankCamera clicked resetView is "+resetView);
				}else if(tankView==true){
					viewsInTankView=0;
					tankView=false;
					resetView=true;
				}
				//System.out.println("tankCamera clicked state is "+tankView);
			}

		});
		Button start = new Button("Start game");           //Start game
		start.setOnAction(e->{

			if(!gameIsRunning){
				gameIsRunning=true;
				started=true;
			}else{
				worldToFront();
			}
		});

		toolBar = new ToolBar(start,pause,exit,tfs,tfh,levelNum,isAlive,camLoc,tankCamera,changeView);         //                              //tool bar add button and box

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
				Boolean isClamped = false;
				tankLocation = new Point3D((tankGroup.getTranslateX()+500.0),(tankGroup.getTranslateY()+500),(tankGroup.getTranslateZ()+1100.0));
				switch (event.getCode()){
					case UP:	//This case executes when the up key is pressed on the keyboard.
						if(bc.tankZClamp(tankGroup)){
							re.rotateTank(tankGroup, facing, Movement.forwards, tankLocation);
							moveZ = -gvg.getTankSpeedZ();
							facing= Movement.forwards;
							event.consume();
						}else{
							re.rotateTank(tankGroup, facing, Movement.forwards, tankLocation);
							moveZ = gvg.getTankSpeedY();
							facing= Movement.forwards;
							event.consume();
						}
						break;
					case DOWN:	//This case executes when the down key is pressed on the keyboard.
						if(bc.tankZClamp(tankGroup)){
							re.rotateTank(tankGroup, facing, Movement.backwards, tankLocation);
							moveZ = gvg.getTankSpeedY();
							facing= Movement.backwards;
							event.consume();
						}else{
							re.rotateTank(tankGroup, facing, Movement.backwards, tankLocation);
							moveZ = -gvg.getTankSpeedY();
							facing= Movement.backwards;
							event.consume();
						}
						break;
					case LEFT:	//This case executes when the left key is pressed on the keyboard.
						if(bc.tankXClamp(tankGroup)){
							re.rotateTank(tankGroup, facing, Movement.left, tankLocation);
							moveX = -gvg.getTankSpeedX();
							facing= Movement.left;
							event.consume();
						}
						else{
							re.rotateTank(tankGroup, facing, Movement.left, tankLocation);
							moveX = -gvg.getTankSpeedX();
							facing= Movement.left;
							event.consume();
						}
						break;
					case RIGHT:	//This case executes when the right key is pressed on the keyboard.
						if(bc.tankXClamp(tankGroup)){
							re.rotateTank(tankGroup, facing, Movement.right, tankLocation);
							moveX = gvg.getTankSpeedX();
							facing= Movement.right;
							event.consume();
						}else{
							re.rotateTank(tankGroup, facing, Movement.right, tankLocation);
							moveX = -gvg.getTankSpeedX();
							facing= Movement.right;
							event.consume();
						}
						break;
					case COMMA:	//This case executes when the right key is pressed on the keyboard.
						if(gameIsRunning){
							if(bulletGroup.getChildren().size()<gvg.getBulletRate()) {
								//System.out.println("tank X: "+tank.getTranslateX()+" tank Y: "+tank.getTranslateY()+" tank Y: "+tank.getTranslateZ());
								//bulletStart =  new Point3D((tankGroup.getTranslateX()+500.0),(tankGroup.getTranslateY()+500),(tankGroup.getTranslateZ()+1100.0));
								bulletStart = new Point3D((tankGroup.getTranslateX() + 10.0), (tankGroup.getTranslateY() - 70.0), (tankGroup.getTranslateZ() + 15.0));
								//System.out.println("bullet start: X: "+bulletStart.getX()+" Y: "+bulletStart.getY()+ " Z: "+bulletStart.getZ());
								Node bull = ma.makeMissle(bulletStart);
								bulletGroup.getChildren().add(bull);
								se.playLaunch();
							}
						}
						event.consume();
						break;
					case H://cant use space
						if(gameIsRunning){
							homingStart =  new Point3D((tankGroup.getTranslateX()+500.0),(tankGroup.getTranslateY()+650.0),(tankGroup.getTranslateZ()+260.0));
							Node hom = ma.makeMissle(homingStart);
							homingGroup.getChildren().add(hom);
							homing.seekTargetTEST(root,enemy.get(0).getGroup(),0, hom);
						}
						event.consume();
						break;
					case B://cant use space


						event.consume();
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
						new PhongMaterial(event.isShiftDown() ? Color.BLACK : Color.RED));  //hold shift click 3D object for black else red
				root.getChildren().remove(res);
			}
		});
		final long startNanoTime = System.nanoTime();           //get current time

		new AnimationTimer()                                    //make animation timer
		{

			public void handle(long currentNanoTime)           //Default method as inner class
			{

				double time = (currentNanoTime - startNanoTime) / 1000000000.0;                   //USED TO UPDATE LOCATIONS ECT
			    //GAME LOOP

				if(gameIsRunning){

					tankGroup.setTranslateX((tankGroup.getTranslateX()+moveX));
					tankGroup.setTranslateZ((tankGroup.getTranslateZ()+moveZ));
					bc.clamp(enemy);                                                          //trap invaders in bounds and move them
					update.updateBullets(bulletGroup);                                            //make bullets move
					update.updateReward(rewardGroup);
					removeEnemies = update.bulletCollision(enemy, bulletGroup);                                    //test bullets for collision with invaders
					update.homingColision(enemy, homingGroup);
					health -= update.bombCollision(tankGroup, bombGroup);
					gvg.setPlayerHealth(health);
					update.updateBombs(bombGroup);
					explosionGroup.getChildren().add(update.bombColisionGround(bombGroup));
					collectedRewards = update.collectReward(tankGroup,rewardGroup);
					for(int i =0;i<collectedRewards.size();i++){
						rewardGroup.getChildren().remove(collectedRewards.get(i));
					}
					collectedRewards.clear();
					for(int i =0;i<removeEnemies.size();i++){

							if(invaderGroup.getChildren().contains(removeEnemies.get(i).getGroup())) {     //test if in invader hit is in invadergroup

								Point3D genPoint = new Point3D(0.0,-150.0,0.0);
								//System.out.println("reward gernerated at  X "+genPoint.getX()+" Y "+genPoint.getY()+" Z "+genPoint.getZ());
								Group temp = update.generateReward(genPoint);
								invaderGroup.getChildren().remove(removeEnemies.get(i).getGroup());       //remove hit invader from group
								enemy.remove(removeEnemies.get(i));
								score += gvg.getPointsPerKill();                                   //add points to score
								gvg.setPlayerScore(score);

								if (temp.getChildren().size() > 0) {
									rewardGroup.getChildren().add(temp);
								}
							}
					}
					for(int i = 0;i<enemy.size();i++){
						if((enemy.get(i).isLanded())||(health<1)){                                               //if invader is landed
							alive=false;                                                           //change alive flag
							isAlive.setText("Alive: "+alive);                                      //temp display of state
							gameIsRunning=false;
							int reply = JOptionPane.showConfirmDialog(null,
									"Score: "+score+"\n Health: "+health+"\n Level: "+gameLevel, " Restart Level?", JOptionPane.YES_NO_OPTION);
							if (reply == JOptionPane.YES_OPTION) {
								health = 100;
								gameIsRunning=true;
								alive=true;
								isAlive.setText("Alive:  "+alive);
							}else{
								health=100;
							}
						}
					}

					tfs.setText("SCORE: "+gvg.getPlayerScore());                                                        //display new score
					tfh.setText("Health: "+gvg.getPlayerHealth());
					levelNum.setText("Level: "+gvg.getPlayerLevel());
					trigger++;
					if(enemy.size()>0){
						bombStart = update.dropBombLocation(enemy);
					}

					if(trigger==gvg.getDropsPerSecond()){
						trigger=0;
						Node bomb = ma.makeBomb(bombStart);
						bombGroup.getChildren().add(bomb);

					}
					if(((trigger%5)==0)&&(explosionGroup.getChildren().size()>0)){
						for(int i =0;i<explosionGroup.getChildren().size();i++){

							explosionGroup.getChildren().remove(i);
						}
					}
					//test if level is complete and then make new level nodes
				    if(((invaderGroup.getChildren().size()==0)&&(started==true)&&(numEnimies==0))){
							gvg.levelUP(gvg.getGameDiffucultyIncrease());
							enemy = nls.initLevel();
							for (int i = 0; i < enemy.size(); i++) {

								invaderGroup.getChildren().add(enemy.get(i).getGroup());
							}
							gvg.levelUP(gvg.getGameDiffucultyIncrease());
                    }
                    if(tankView==true) {

						if (((viewsInTankView == 0) && (camView == 1) || (camView == 2))) {
							//System.out.println("tank view viewsInTankView ==0"+(viewsInTankView==0));
							oldCameraView = new Point3D(camera.getTranslateX(), camera.getTranslateX(), camera.getTranslateZ());
							Point3D tankView = new Point3D(tankGroup.getTranslateX() + 500, tankGroup.getTranslateY() + 500, tankGroup.getTranslateZ() + 1050);
							viewsInTankView++;
							camera.setRotationAxis(Rotate.X_AXIS);
							//System.out.println("camView value "+camView);
							if (camView == 1) {                                 //front view
								//System.out.println("camview 1 rotate 90");
								camera.setRotate(90.0);
								camera.setTranslateX(tankView.getX());
								camera.setTranslateY(tankView.getY());
								camera.setTranslateZ(tankView.getZ());
							} else if (camView == 2) {                            //top view
								camera.setRotate(180.0);
								//System.out.println("camview 2 rotate 180");
								camera.setTranslateX(tankView.getX());
								camera.setTranslateY(tankView.getY());
								camera.setTranslateZ(tankView.getZ());
							}
						} else {
							Point3D tankView = new Point3D(tankGroup.getTranslateX() + 500, tankGroup.getTranslateY() + 500, tankGroup.getTranslateZ() + 1050);  //1050
							camera.setTranslateX(tankView.getX());
							camera.setTranslateY(tankView.getY());
							camera.setTranslateZ(tankView.getZ());
						}
					}else if (tankView == false) {
						if (resetView == true) {

								camera.setRotationAxis(Rotate.X_AXIS);                         //first time through
								if (camView == 1) {
									//System.out.println("camview 1 reset tank view 0");
									camera.setRotate(0.0);
									camera.setTranslateX(oldCameraView.getX());
									camera.setTranslateY(oldCameraView.getY()-500);
									camera.setTranslateZ(oldCameraView.getZ());
								} else if (camView == 2) {
									//System.out.println("camview 2 reset tank view 0");
									camera.setRotate(0.0);
									camera.setTranslateX(oldCameraView.getX());
									camera.setTranslateY(oldCameraView.getY()-1000);
									camera.setTranslateZ(oldCameraView.getZ());
								}
								resetView = false;
						}
					}
					moveX=0;                                                                          //reset tank velocity
					moveZ=0;
                }
                                                                                          //reset tank velocity
            }

		}.start();

		facing = Movement.forwards;	//This makes the tank currently face forwards.

		tankGroup = boxOP.makeModel(1, 12);         //first int is model number second int is skin number
		root.getChildren().add(invaderGroup);
		root.getChildren().add(tankGroup);
		tankGroup.setTranslateY(tankGroup.getTranslateY()-40);
		root.getChildren().add(bulletGroup);
		root.getChildren().add(bombGroup);
		root.getChildren().add(homingGroup);
		root.getChildren().add(explosionGroup);
		root.getChildren().add(rewardGroup);
		root.getChildren().add(boxOP.ground());                //add ground to scene
		root.getChildren().add(boxOP.horizon());               //add background to scene
		root.getChildren().add(boxOP.gameBox());			   //creating the box environment
		root.getChildren().add(boxOP.corners());               // corner boxes
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());      //add css to ui
		stage.getIcons().add(new Image("/pics/spaceinvadericon.png"));
		stage.setScene(scene);                                                     // Add the Scene to the Stage
		stage.setTitle("3D Space Invaders");                                   // Set the Title of the Stage
		stage.show();                                                              // show to user
	}

}


