package operations;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Created by Liandri on 28/09/2016.
 */
public class Homing {

    double Xoff = 0.0;
    double Yoff = 0.0;
    double Zoff = 0.0;
    Point3D homingStart;
    MakeAssets ma = new MakeAssets();


    public void seekTargetTEST(Group root, Group target, int tar, Node missle) {
        float step1 = 0.01f;
        float vx =  (float)(target.getChildren().get(tar).getTranslateX()) -  (float)(missle.getTranslateX());
        float vy =  (float)(target.getChildren().get(tar).getTranslateY()) -  (float)(missle.getTranslateY());
        float vz =  (float)(missle.getTranslateZ()) - (float)(target.getChildren().get(tar).getTranslateZ());
        //vz = (-vz);
        for (float t = 0; t < 1.0; t += step1) {
            Xoff = (vx * t);
            Yoff = (vy * t);
            Zoff = (vz * t);
            missle.setTranslateX(Xoff);
            missle.setTranslateY(Yoff);
            missle.setTranslateY(Yoff);
            homingStart =  new Point3D(Xoff,Yoff,Zoff);
            Node hom = ma.makeMissle(homingStart);
            root.getChildren().add(hom);
        }
    }
    public void seekTarget(Group root, Group target, int tar, Node missle) {
        float step1 = 0.01f;
        float vx =  (float)(target.getChildren().get(tar).getTranslateX()) -  (float)(missle.getTranslateX());
        float vy =  (float)(target.getChildren().get(tar).getTranslateY()) -  (float)(missle.getTranslateY());
        for (float t = 0; t < 1.0; t += step1) {
            Xoff = (vx * t);
            Yoff = (vy * t);
            missle.setTranslateX(Xoff);
            missle.setTranslateY(Yoff);
            homingStart =  new Point3D(Xoff,Yoff,Zoff);
            Node hom = ma.makeMissle(homingStart);
            root.getChildren().add(hom);
        }
    }
}

