package application;/**
 * Created by Liandri on 9/10/2016.
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Input extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        Image img = MainView.img.getImg(11);
        try{
            BorderPane root = new BorderPane();
            Button button1 = new Button("Done");
            button1.setOnAction(e->{
                //do database stuff
                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        System.out.println("Data is Stored");
                    }
                });
                primaryStage.close();
            });

            HBox hbox = new HBox();
            hbox.getChildren().add(button1);

            root.setBottom(hbox);
            Scene scene = new Scene(root, 400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("User Details");
            scene.setFill(Color.BLACK);
            primaryStage.show();



        }catch(Exception e){
            System.out.println("details page crashed");
        }
    }
}
