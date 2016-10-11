package camera;

import application.MainView;
import javafx.animation.*;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.awt.*;

/**
 * Created by Liandri on 10/10/2016.
 */
public class CameraPath {

    int wasFacing = 1;
    int firstTime = 0;
    double rotateAmount =10;
    public void viewSwitch(PerspectiveCamera camera,int value){
        if(value==1){
            view1(camera);
        }else if(value == 2){
            view2(camera);
        }else if(value==3){
            view3(camera);
        }
    }

    public void view1(PerspectiveCamera camera) {            //start view

        TranslateTransition translate = new TranslateTransition(Duration.millis(50), camera);
        translate.setFromX(camera.getTranslateX());translate.setFromY(camera.getTranslateY());translate.setFromZ(camera.getTranslateZ());
        translate.setToX(500);translate.setToY(0.0);translate.setToZ(0.0);                   //translate to first position
        translate.playFromStart();
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(rotateAmount);
        System.out.println("view2 location  500 0  0");
        System.out.println("view1 rotate amount "+rotateAmount);
        rotateAmount = -rotateAmount;


        wasFacing=1;
    }
    public void view2(PerspectiveCamera camera) {         //middle view
        TranslateTransition translate = new TranslateTransition(Duration.millis(50), camera);
        translate.setFromX(camera.getTranslateX());translate.setFromY(camera.getTranslateY());translate.setFromZ(camera.getTranslateZ());
        translate.setToX(500);translate.setToY(-500.0);translate.setToZ(0.0);                   //translate to first position
        translate.playFromStart();
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(rotateAmount);
        System.out.println("view2 location  500 -500  0");
        System.out.println("view2 rotate amount "+rotateAmount);
    }
    public void view3(PerspectiveCamera camera) {          //top view
        TranslateTransition translate = new TranslateTransition(Duration.millis(50), camera);
        translate.setFromX(camera.getTranslateX());translate.setFromY(camera.getTranslateY());translate.setFromZ(camera.getTranslateZ());
        translate.setToX(500);translate.setToY(-500.0);translate.setToZ(500.0);                   //translate to first position
        translate.playFromStart();
        wasFacing=3;
        firstTime++;
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(rotateAmount);
        System.out.println("view2 location  500 -500  500");
        System.out.println("view3 rotate amount "+rotateAmount);
        rotateAmount = -rotateAmount;
    }
    public void tankView(PerspectiveCamera camera){
        TranslateTransition translate = new TranslateTransition(Duration.millis(750),camera);
        translate.setFromX(camera.getTranslateX());translate.setFromY(camera.getTranslateY());translate.setFromZ(camera.getTranslateZ());
        translate.setToX(500);translate.setToY(400);translate.setToZ(980);                   //translate to first position
        translate.playFromStart();
        rotateXup90(camera);

    }


    public void camTest(PerspectiveCamera camera){
    Path path = new Path();
        path.getElements().add(new MoveTo(20,20));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
    PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(camera);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
    }
    public void rotateXup90(PerspectiveCamera camera){
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(90.0);
    }
    public void rotateXdown90(PerspectiveCamera camera){
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(-90.0);
    }
    public void rotateXup180(PerspectiveCamera camera){
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(180.0);
    }
    public void rotateXdown180(PerspectiveCamera camera){
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(-180.0);
    }
}
