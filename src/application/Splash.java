package application;/**
 * Created by Liandri on 9/10/2016.
 */

import camera.CreateCamera;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import operations.CreateBox;
import operations.RotateElements;
import operations.WorldCoOrdinates;

import java.io.InputStream;

public class Splash extends Application {

    private RotateElements re = new RotateElements();
    private CreateCamera cc = new CreateCamera();
    private CreateBox cb = new CreateBox();
    public static WorldCoOrdinates wc = new WorldCoOrdinates();
    public static int scaleSize=0;


    public static void main(String[] args) {
        launch(args);
    }

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
    public static void rundataBase() {                             //method run 3D world Application
        Platform.runLater(new Runnable() {                         //GUI SAFE thread
            public void run() {                                    //run
                                                                   //run another application from here
                                                                   //ALWAYS launch input when clicked(no if statement)
                new Input().start(new Stage());                    //launch input Application
            }
        });
    }

    public void init(){

    }


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setResizable(false);
        Class<?> clazz = this.getClass();                                           //get this class
        InputStream input = clazz.getResourceAsStream("/pics/splashShot.jpg");           //get this picture
        Image image = new Image(input,800,600,false,true);                                             //Make an image
        ImageView imageView = new ImageView(image);                                 //Make an imageview
        imageView.setFitWidth(Screen.getPrimary().getBounds().getWidth());
        imageView.setFitWidth(Screen.getPrimary().getBounds().getHeight());
       // InputStream input2 = clazz.getResourceAsStream("/pics/spacebox.jpg");          //get sceond Picture
        //Image image2 = new Image(input2,200,200,false,true);                         //make as imageV2
        //ImageView imageView2 = new ImageView(image2);                                //not used
        Pane root = new Pane();                                                      //scene
        root.setPadding(new Insets(20));                                             //style



        try{
            Button button1 = new Button("Play");                                    //make button1 play
            button1.setOnAction(e->{                                                //if button 1 is clicked
                //System.out.println("play clicked");
                run3Dworld();
            });
            Button button2 = new Button("Enter Player Details");                   //make button update details
            button2.setOnAction(e->{                                               //if button2 is clicked
                rundataBase();                                                     //run DataBase Application
            });
            Button button3 = new Button("EXIT Game");                   //make button update details
            button3.setOnAction(e->{                                               //if button2 is clicked
    // ADD Database save here
                Platform.setImplicitExit(true);                           //close down clean
                System.exit(0);
            });

            Button scaleBounds = new Button("Scale Box");                   //make button update details
            scaleBounds.setOnAction(e->{                                               //if button2 is clicked
                if(scaleSize==0) {                                                     //run DataBase Application
                    wc.resetScaleGameBox();
                    scaleSize++;
                }else if(scaleSize==1){
                    wc.scaleUpGameBox();
                    scaleSize++;
                }else if(scaleSize==2){
                    wc.scaleDownGameBox();
                    scaleSize = 0;
                }
               // System.out.println("Splash scale bounds mouse click "+scaleSize);
            });
            GridPane gp = new GridPane();                                          //layout style

            Label playLbl = new Label("Name:  ");
            TextField play= new TextField("Player Name");
            Label levelLbl = new Label("Level: ");
            TextField lvl = new TextField("Current Level");
            Label score = new Label("Score: ");
            TextField sc = new TextField("");
            Label numEnimiew = new Label("Enemies: ");
            TextField enemyTF = new TextField("");
            Label difficulty = new Label("Difficultly: ");
            TextField diff = new TextField("");
            Label bestScore = new Label("Personal Best ");
            TextField best = new TextField("");


            gp.setPadding(new Insets(20,20,20,20));                                       //style
            gp.setVgap(8);
            gp.setHgap(10);

            GridPane.setConstraints(button1,0,0);                                         //display boxes grid start
            GridPane.setConstraints(button2,1,0);
            GridPane.setConstraints(button3,2,0);
            GridPane.setConstraints(scaleBounds,4,0);
            GridPane.setConstraints(playLbl,0,1);
            GridPane.setConstraints(play,1,1);
            GridPane.setConstraints(levelLbl,0,2);
            GridPane.setConstraints(lvl,1,2);
            GridPane.setConstraints(score,0,3);
            GridPane.setConstraints(sc,1,3);
            GridPane.setConstraints(numEnimiew,0,4);
            GridPane.setConstraints(enemyTF,1,4);
            GridPane.setConstraints(difficulty,0,5);
            GridPane.setConstraints(diff,1,5);
            GridPane.setConstraints(bestScore,0,6);
            GridPane.setConstraints(best,1,6);                                            //display boxes grid end
            gp.getChildren().addAll(button1,button2,button3,playLbl,play,levelLbl,lvl,score,sc,numEnimiew,enemyTF,difficulty,diff,bestScore,best);//add everything
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
