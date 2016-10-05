package application;

import javafx.application.Preloader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by Liandri on 5/10/2016.
 */
public class FirstPreloader extends Preloader {
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    ProgressBar bar;
    Stage stage;

    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        BorderPane p = new BorderPane();
        p.setBottom(bar);
        Scene scene = new Scene(p,300,300);
        return scene;
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Loading 3D Assets");

        stage.setScene(createPreloaderScene());
        stage.show();
    }


    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        bar.setProgress(pn.getProgress());
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }
}
