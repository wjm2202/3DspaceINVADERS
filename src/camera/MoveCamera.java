package camera;


import javafx.scene.PerspectiveCamera;

/**
 * Created by Liandri on 7/10/2016.
 */
public class MoveCamera {

    public double getCameraAngle(PerspectiveCamera pc){
        double yx = pc.getLocalToSceneTransform().getMyx();  //get the locale to scene Affine transform value for yx
        double yy = pc.getLocalToSceneTransform().getMyy();   //get the locale to scene Affine transform value for yy
        double angle = Math.atan2(yx, yy);                    //Convert rectangular coordinates (x, y) to polar (r, theta)
        angle = Math.toDegrees(angle);                        //convert from radians to degrees
        angle = angle < 0 ? angle + 360 : angle;              //set angle from 0-360-0
        return angle;
    }
}
