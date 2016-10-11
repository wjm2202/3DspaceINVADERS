package camera;


import javafx.scene.PerspectiveCamera;

import java.util.ArrayList;

/**
 * Created by Liandri on 7/10/2016.
 */
public class MoveCamera {

    CreateCamera perCamera = new CreateCamera(8);

    public ArrayList<PerspectiveCamera> makeCamList(){
        ArrayList<PerspectiveCamera> camList = new ArrayList<>();
        perCamera.setUp(1);
        PerspectiveCamera cam1 = perCamera.getCamera();
        camList.add(cam1);
        perCamera.setUp(2);
        PerspectiveCamera cam2 = perCamera.getCamera();
        camList.add(cam2);
        perCamera.setUp(3);
        PerspectiveCamera cam3 = perCamera.getCamera();
        camList.add(cam3);
        perCamera.setUp(4);
        PerspectiveCamera cam4 = perCamera.getCamera();
        camList.add(cam4);
        perCamera.setUp(5);
        PerspectiveCamera cam5 = perCamera.getCamera();
        camList.add(cam5);
        perCamera.setUp(6);
        PerspectiveCamera cam6 = perCamera.getCamera();
        camList.add(cam6);
        perCamera.setUp(7);
        PerspectiveCamera cam7 = perCamera.getCamera();
        camList.add(cam7);
        perCamera.setUp(8);
        PerspectiveCamera cam8 = perCamera.getCamera();
        camList.add(cam8);
        perCamera.setUp(9);
        PerspectiveCamera cam9 = perCamera.getCamera();
        camList.add(cam9);
        return camList;
    }

    public double getCameraAngle(PerspectiveCamera pc){
        double yx = pc.getLocalToSceneTransform().getMyx();  //get the locale to scene Affine transform value for yx
        double yy = pc.getLocalToSceneTransform().getMyy();   //get the locale to scene Affine transform value for yy
        double angle = Math.atan2(yx, yy);                    //Convert rectangular coordinates (x, y) to polar (r, theta)
        angle = Math.toDegrees(angle);                        //convert from radians to degrees
        angle = angle < 0 ? angle + 360 : angle;              //set angle from 0-360-0
        return angle;
    }
}
