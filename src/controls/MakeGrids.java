package controls;

import application.MainView;
import camera.CameraPath;
import camera.CreateCamera;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

/**
 * Created by Liandri on 10/10/2016.
 */
public class MakeGrids {

    CameraPath cp = new CameraPath();
    CreateCamera perCamera = new CreateCamera(8);
    PerspectiveCamera tempCam = new PerspectiveCamera();


    public GridPane makeCameraMoveGrid(PerspectiveCamera camera){

        Button tester = new Button("-Z");           //move camera
        tester.setOnAction(e->{
            System.out.println("held down in tester button");
        });

        Button camMIUNSz = new Button("-Z");           //move camera
        camMIUNSz.setOnAction(e->{
            camera.setTranslateZ(camera.getTranslateZ()-10);
        });

        Button camPLUSz = new Button("+Z");           //move camera
        camPLUSz.setOnAction(e->{
            camera.setTranslateZ(camera.getTranslateZ()+10);
        });

        Button camPLUSx = new Button("+X");           //move camera
        camPLUSx.setOnAction(e->{
            camera.setTranslateX(camera.getTranslateX()+10);
        });
        Button camMINUSx = new Button("-X");           //move camera
        camMINUSx.setOnAction(e->{
            camera.setTranslateX(camera.getTranslateX()-10);
        });
        Button camMINUSy = new Button("-Y");           //move camera
        camMINUSy.setOnAction(e->{
            camera.setTranslateY(camera.getTranslateY()-10);
        });
        Button camPLUSy = new Button("+Y");           //move camera
        camPLUSy.setOnAction(e->{
            camera.setTranslateY(camera.getTranslateY()+10);
        });
        Button camCenter = new Button("0.0");           //move camera
        camCenter.setOnAction(e->{
            camera.setRotationAxis(Rotate.Y_AXIS);
            camera.setRotate(0.0);

        });
        Button camROTATEyRight = new Button("RL");           //move camera
        camROTATEyRight.setOnAction(e->{
            camera.setRotationAxis(Rotate.Y_AXIS);
            camera.setRotate(90.0);
        });
        Button camROTATEyLeft = new Button("RR");           //move camera
        camROTATEyLeft.setOnAction(e->{
            camera.setRotationAxis(Rotate.Y_AXIS);
            camera.setRotate(-90.0);
        });
        GridPane gp = new GridPane();
        //Label test = new Label("Camera");

        GridPane.setConstraints(camROTATEyRight,0,0);
        GridPane.setConstraints(camPLUSy,1,0);                                         //display boxes grid start
        GridPane.setConstraints(camPLUSz,2,0);
        GridPane.setConstraints(camMINUSx,0,1);
        GridPane.setConstraints(camCenter,1,1);
        GridPane.setConstraints(camPLUSx,2,1);
        GridPane.setConstraints(camMIUNSz,0,2);
        GridPane.setConstraints(camMINUSy,1,2);
        GridPane.setConstraints(camROTATEyLeft,2,2);
        gp.setPadding(new Insets(5,5,5,5));                                       //style
        gp.setVgap(5);
        gp.setHgap(5);
        gp.getChildren().addAll(camROTATEyRight,camPLUSy,camPLUSz,camMINUSx,camCenter,camPLUSx,camMIUNSz,camMINUSy,camROTATEyLeft);
    return gp;
    }
}
