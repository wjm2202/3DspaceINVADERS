package application;/**
 * Created by Liandri on 9/10/2016.
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import database.*;

import java.io.InputStream;

public class Input extends Application {

    Name playerName = new Name();
    Score playerscore = new Score();


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        try{

            Button button1 = new Button("Done");
            Image lvls = new Image(getClass().getResourceAsStream("/pics/done.png"));
            button1.setGraphic(new ImageView(lvls));
            button1.setOnAction(e->{
                //do database stuff
                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {

                        System.out.println("Data is Stored");

                    }
                });
                //do DATABASE STUFF HERE
                primaryStage.close();
            });

            Class<?> clazz = this.getClass();
            InputStream input = clazz.getResourceAsStream("/pics/space.jpg");
            Image image = new Image(input,500,500,false,true);
            ImageView imageView = new ImageView(image);
            Pane root = new Pane();
            root.setPadding(new Insets(20));
                GridPane gp = new GridPane();
                Label save = new Label("Save");
                Label playLbl = new Label("Name:  ");
                TextField play= new TextField("Player Name");
                Label levelLbl = new Label("Email: ");
                TextField lvl = new TextField("Your Email");
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
                GridPane.setConstraints(save,0,0);
                GridPane.setConstraints(button1,1,0);
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
                gp.getChildren().addAll(save,button1,playLbl,play,levelLbl,lvl,score,sc,numEnimiew,enemyTF,difficulty,diff,bestScore,best);
                root.getChildren().add(imageView);
                root.getChildren().add(gp);

            playerName.setNickname(play.getText());

            Scene scene = new Scene(root, 400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("3D Space Invaders");
            primaryStage.getIcons().add(new Image("/pics/spaceinvadericon.png"));
            scene.setFill(Color.BLACK);
            primaryStage.show();
        }catch(Exception e){
            System.out.println("Input.java Application failed to load");
        }
    }
}
