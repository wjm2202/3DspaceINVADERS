package application;/**
 * Created by Liandri on 9/10/2016.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NextLevel extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image img = MainView.img.getImg(11);
        try{
            BorderPane root = new BorderPane();
            Button button1 = new Button("Start Next level");
            button1.setOnAction(e->{
                MainView.nextLevel= true;
                primaryStage.close();
            });
            Button button2 = new Button("End Game");
            button2.setOnAction(e->{
                MainView.nextLevel= false;
                primaryStage.close();
            });

            HBox hbox = new HBox();
            hbox.getChildren().addAll(button1,button2);

            root.setBottom(hbox);
            Scene scene = new Scene(root, 300,300);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("3D Space Invaders");
            scene.setFill(Color.BLACK);
            primaryStage.show();
        }catch(Exception e){
            System.out.println("Level Passed");
        }
    }
}
