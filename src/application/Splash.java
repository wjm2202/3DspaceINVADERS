package application;/**
 * Created by Liandri on 9/10/2016.
 */

import camera.CreateCamera;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import operations.CreateBox;
import operations.RotateElements;
import operations.WorldCoOrdinates;

import java.io.InputStream;
import database.*;

/**
 * This application is the entry point into the program and controls which stage is viewed by the user
 * there are switches that allow the various screens to be displayed controlled by buttons
 *
 */

public class Splash extends Application {

    private RotateElements re = new RotateElements();                //transoforms for rotation
    private CreateCamera cc = new CreateCamera(8);                   //camera transforms
    private CreateBox cb = new CreateBox();                          //box creator
    public static WorldCoOrdinates wc = new WorldCoOrdinates();      //world boundries
    public static int scaleSize=0;                                   //world scale value
    static Name playerName = new Name();                             //name of the player
    static TextField play, email;                                    //text feilds for data entry

    /**
     * the stage launcher is used to start different stages
     * the stages are set to run at the end of the screen update cycle
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * launch the 3D game world
     */
    public static void run3Dworld() {                               //method run 3D world Application
        Platform.runLater(new Runnable() {                          //GUI SAFE thread
            public void run() {                                     //run
                                                                    //run another application from here
                if(!MainView.gameIsRunning){                        //if game is not running launch 3DWorld when clicked
                    new MainView().start(new Stage());              //launch MainView Application
                }
            }
        });
    }

    /**
     * launch the data entry screen
     */
    public static void rundataBase() {                             //method run 3D world Application
        Platform.runLater(new Runnable() {                         //GUI SAFE thread
            public void run() {                                    //run
                                                                   //run another application from here
                                                                   //ALWAYS launch input when clicked(no if statement)
                new Input().start(new Stage());                    //launch input Application
            }
        });
    }

    /**
     * carry out pre loading tasks
     */
    public void init(){                                           //pre load any resources before display

    }

    /**
     * create the scenes layout and form and set button actions
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        //call database


        primaryStage.setResizable(false);
        Class<?> clazz = this.getClass();                                           //get this class
        InputStream input = clazz.getResourceAsStream("/pics/splashshot.jpg");       //get this picture
        Image image = new Image(input,800,600,false,true);                           //Make an image
        ImageView imageView = new ImageView(image);                                 //Make an imageview
        imageView.setFitWidth(Screen.getPrimary().getBounds().getWidth());          //fit the image to stage size width
        imageView.setFitWidth(Screen.getPrimary().getBounds().getHeight());         //fit the image to stage size height
        Pane root = new Pane();                                                      //scene
        root.setPadding(new Insets(20));                                             //style
        try{
            ImageView invicon = new ImageView(new Image("/pics/invader11.png"));     //make icon for button
            Button button1 = new Button("Play",invicon);                             //make button1 play
            button1.setOnAction(e->{
                run3Dworld();                                                        //run the stage for the game
            });
            ImageView ed = new ImageView(new Image("/pics/details.png"));            //make icon for button
            Button button2 = new Button("Enter Player Details",ed);                   //make button update details
            button2.setOnAction(e->{                                               //if button2 is clicked
                rundataBase();                                                     //run DataBase Application
            });
            ImageView ex = new ImageView(new Image("/pics/logout.png"));            //make icon for button
            Button button3 = new Button("EXIT",ex);                   //make button update details
            button3.setOnAction(e->{                                               //if button2 is clicked
    // ADD Database save here
                Platform.setImplicitExit(true);                           //close down clean up
                System.exit(0);                                           //exit with code 0
            });
/*                                                                         SPRINT 3 ROLL OUT
            Button scaleBounds = new Button("Scale Box");                   //make button update details
            scaleBounds.setOnAction(e->{                                               //if button2 is clicked
                if(scaleSize==0) {                                                     //test world scale size
                    wc.resetScaleGameBox();                                            //rescale size
                    scaleSize++;                                                       //update scale size
                }else if(scaleSize==1){
                    wc.scaleUpGameBox();
                    scaleSize++;
                }else if(scaleSize==2){
                    wc.scaleDownGameBox();
                    scaleSize = 0;
                }
            });                                               */
            GridPane gp = new GridPane();                                               //layout style
            Label playLbl = new Label("Name:  ");                                       //label
            //TextField play= new TextField("Player Name");                             //text box
            play = new TextField("Player Name");
            Label levelLbl = new Label("Email: ");
            //TextField lvl = new TextField("Current Level");                           //lvl.settext(""+);
            email = new TextField("Email Address");
            Label score = new Label("Score: ");
            TextField sc = new TextField("");
           // Label numEnimiew = new Label("Enemies: ");                                //add once DB user stories are finished
            //TextField enemyTF = new TextField("");                                    //
            //Label difficulty = new Label("Difficultly: ");                            //
            //TextField diff = new TextField("");                                       //
            //Label bestScore = new Label("Personal Best ");                            //
           // TextField best = new TextField("");                                       //add once DB user stories are finished
            gp.setPadding(new Insets(20,20,20,20));                                       //style
            gp.setVgap(8);                                                                //set verticle gap between buttons
            gp.setHgap(10);                                                               //set horizontal gap between buttons
            GridPane.setConstraints(button1,0,0);                                         //display boxes grid start
            GridPane.setConstraints(button2,1,0);
            GridPane.setConstraints(button3,2,0);
           // GridPane.setConstraints(scaleBounds,4,0);                                 //sprint 3
            GridPane.setConstraints(playLbl,0,1);
            GridPane.setConstraints(play,1,1);
            GridPane.setConstraints(levelLbl,0,2);
            GridPane.setConstraints(email,1,2);
            GridPane.setConstraints(score,0,3);
            GridPane.setConstraints(sc,1,3);
           // GridPane.setConstraints(numEnimiew,0,4);                                  //add once DB user stories are finsihed
            //GridPane.setConstraints(enemyTF,1,4);                                     //
            //GridPane.setConstraints(difficulty,0,5);                                  //
            //GridPane.setConstraints(diff,1,5);                                         //
            //GridPane.setConstraints(bestScore,0,6);                                       //add once DB user stories are finishes
            //GridPane.setConstraints(best,1,6);                                            //display boxes grid end
            gp.getChildren().addAll(button1,button2,button3,playLbl,play,levelLbl,email,score,sc);//add everything
            root.getChildren().add(imageView);                                            //display the screen background picture
            root.getChildren().add(gp);                                                   //add the grid and buttons onto the root node
            Scene scene = new Scene(root, 700,580);                                       //generate the scene
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());              //add css
            primaryStage.setScene(scene);                                                                        //add scene to stage
            primaryStage.setTitle("3D Space Invaders");                                                          //set the tittle
            primaryStage.getIcons().add(new Image("/pics/spaceinvadericon.png"));                                //set the stage icon
            scene.setFill(Color.BLACK);                                                                          //basic fill
            primaryStage.show();                                                                                 //make visible
        }catch(Exception e){                                                                                     //catch Application faild to load
            System.out.println("Splash.java Application failed to load");                                        //location of fault
        }
    }
}
