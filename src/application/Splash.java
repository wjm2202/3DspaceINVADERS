package application;/**
 * Created by Liandri on 9/10/2016.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Splash extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static void run3Dworld() {
        Platform.runLater(new Runnable() {
            public void run() {
                //run another application from here
                new MainView().start(new Stage());
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


    @Override
    public void start(Stage primaryStage) {
        Image img = MainView.img.getImg(11);
        try{
            BorderPane root = new BorderPane();
            Button button1 = new Button("Play");
            button1.setOnAction(e->{
                run3Dworld();
            });
            Button button2 = new Button("Enter Player Details");
            button2.setOnAction(e->{
                rundataBase();
            });
            HBox hbox = new HBox();
            hbox.getChildren().addAll(button1,button2);

            root.setBottom(hbox);
            Scene scene = new Scene(root, 600,600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("3D Space Invaders");
            scene.setFill(Color.BLACK);
            primaryStage.show();
        }catch(Exception e){
            System.out.println("details page crashed");
        }
    }
}
