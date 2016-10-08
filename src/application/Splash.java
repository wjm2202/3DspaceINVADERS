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
import javafx.stage.Stage;
import operations.CreateBox;
import operations.RotateElements;

import java.io.InputStream;

public class Splash extends Application {

    private RotateElements re = new RotateElements();
    private CreateCamera cc = new CreateCamera();
    private CreateBox cb = new CreateBox();

    public static void main(String[] args) {
        launch(args);
    }

    public static void run3Dworld() {
        Platform.runLater(new Runnable() {
            public void run() {
                //run another application from here
                if(!MainView.gameIsRunning){
                    new MainView().start(new Stage());
                }
            }
        });
    }
    public static void rundataBase() {
        Platform.runLater(new Runnable() {
            public void run() {
                //run another application from here
                new Input().start(new Stage());
            }
        });
    }

    public void init(){

    }


    @Override
    public void start(Stage primaryStage) {
        Class<?> clazz = this.getClass();
        InputStream input = clazz.getResourceAsStream("/pics/space.jpg");

        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        InputStream input2 = clazz.getResourceAsStream("/pics/space.jpg");
        Image image2 = new Image(input2,500,500,false,true);
        ImageView imageView2 = new ImageView(image2);
        Pane root = new Pane();
        root.setPadding(new Insets(20));



        try{
            Button button1 = new Button("Play");
            button1.setOnAction(e->{
                run3Dworld();
            });
            Button button2 = new Button("Enter Player Details");
            button2.setOnAction(e->{
                rundataBase();
            });

            GridPane gp = new GridPane();

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


            gp.setPadding(new Insets(20,20,20,20));
            gp.setVgap(8);
            gp.setHgap(10);
            GridPane.setConstraints(button1,0,0);
            GridPane.setConstraints(button2,1,0);
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
            GridPane.setConstraints(best,1,6);
            gp.getChildren().addAll(button1,button2,playLbl,play,levelLbl,lvl,score,sc,numEnimiew,enemyTF,difficulty,diff,bestScore,best);
            root.getChildren().add(imageView);
            root.getChildren().add(gp);
            Scene scene = new Scene(root, 600,600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("3D Space Invaders");
            primaryStage.getIcons().add(new Image("/pics/spaceinvadericon.png"));
            scene.setFill(Color.BLACK);
            primaryStage.show();
        }catch(Exception e){
            System.out.println("details page crashed");
        }
    }
}
