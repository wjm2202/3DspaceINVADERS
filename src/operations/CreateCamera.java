package operations;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
/**
 * this method creates the camera and camera transforms 
 * so the camera can be moved or relocated 
 * see glen if you want to learn more about cameras or movement of view
 * in a three d world
 * @author Liandri
 *
 */
public class CreateCamera {
	
	static PerspectiveCamera camera;
	private final Rotate rotateX = new Rotate(-20, Rotate.X_AXIS);    //set camera location x
	private final Rotate rotateY = new Rotate(-20, Rotate.Y_AXIS);    //set camera location y
	
	public CreateCamera(){
		setUp();
	}
	
	public PerspectiveCamera getCamera(){
		return camera;
	}
	
	public void setUp(){
		camera = new PerspectiveCamera(true);    //add camera view x,y,z
		camera.getTransforms().addAll (rotateX, rotateY, new Translate(0, 0, 0));  //add transforms to camera
		camera.setTranslateX(483.0);                              
		camera.setTranslateY(-36);
		camera.setTranslateZ(0.0);
		camera.setRotate(0);
		camera.setNearClip(0.4);
		camera.setFarClip(3000.0);
		camera.setFieldOfView(45);
	}
	public static void rotateCam(PerspectiveCamera camera){
		RotateTransition rt = new RotateTransition(Duration.seconds(2), camera);
		rt.setCycleCount(Animation.INDEFINITE);
		rt.setFromAngle(0);
		rt.setToAngle(360);
		rt.setAutoReverse(true);
		rt.setAxis(new Point3D(5,5,5));
		rt.play();
	}
	public static void camRotateC(Camera c){
		c.setRotate(45);
	}
	public static void camRotateA(Camera c){
		c.setRotate(-45);
	}
}
