package camera;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Node;
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

	int wasLast = 1;
	static PerspectiveCamera camera;
	private final Rotate rotateX = new Rotate(-20, Rotate.X_AXIS);    //set camera location x
	private final Rotate rotateY = new Rotate(-20, Rotate.Y_AXIS);    //set camera location y
	private final Rotate rotateZ = new Rotate(-20, Rotate.Z_AXIS);    //set camera location z
	private Rotate rVertDOWN = new Rotate(-70,0,0,50, Rotate.X_AXIS);	//A variable that will store a number that rotates a Node -90 degrees
	private Rotate rVertUP = new Rotate(+70,0,0,50, Rotate.X_AXIS);	//A variable that will store a number that rotates a Node -90 degrees
	private Rotate rVertBottomUP = new Rotate(+35,0,0,50, Rotate.X_AXIS);	//A variable that will store a number that rotates a Node -90 degrees
	private Rotate rVertBottomDOWN = new Rotate(-35,0,0,50, Rotate.X_AXIS);	//A variable that will store a number that rotates a Node -90 degrees
	
	public void birdCamera(int view){
		switch(view){
			case 1:
				//TOP VIEW
				//camera = new PerspectiveCamera();
				//System.out.println("actual case 1 location BEFORE X "+camera.getTranslateX()+" Y "+camera.getTranslateY()+" Z "+camera.getTranslateZ());
				camera.setTranslateX(483.0);
				camera.setTranslateY(-836.0);
				camera.setTranslateZ(1050);
				camera.getTransforms().add(rVertDOWN);
				//System.out.println("actual case 1 location AFTER X "+camera.getTranslateX()+" Y "+camera.getTranslateY()+" Z "+camera.getTranslateZ());

			break;
			case 2:
				//FRONT VIEW
				camera.getTransforms().add(rVertUP);
				//camera = new PerspectiveCamera();
				//System.out.println("actual case 2 location BEFORE X "+camera.getTranslateX()+" Y "+camera.getTranslateY()+" Z "+camera.getTranslateZ());
				camera.setTranslateX(483.0);
				camera.setTranslateY(-36.0);
				camera.setTranslateZ(0.0);

				//System.out.println("actual case 2 location AFTER X "+camera.getTranslateX()+" Y "+camera.getTranslateY()+" Z "+camera.getTranslateZ());

				break;
			case 3:
				//FRONT VIEW
				//camera = new PerspectiveCamera();
				//System.out.println("actual case 2 location BEFORE X "+camera.getTranslateX()+" Y "+camera.getTranslateY()+" Z "+camera.getTranslateZ());
				camera.setTranslateX(483.0);
				camera.setTranslateY(764.0);
				camera.setTranslateZ(-1050.0);
				camera.getTransforms().add(rVertBottomUP);
				//System.out.println("actual case 2 location AFTER X "+camera.getTranslateX()+" Y "+camera.getTranslateY()+" Z "+camera.getTranslateZ());

				break;
		}

	}
	public  PerspectiveCamera setTankView(Node tank){
		//X 483.0 Y -36.0 Z 0.0
		//System.out.println("actual case 2 location BEFORE X "+camera.getTranslateX()+" Y "+camera.getTranslateY()+" Z "+camera.getTranslateZ());
		camera.setTranslateX(tank.getTranslateX());
		camera.setTranslateY(tank.getTranslateY());
		camera.setTranslateZ(tank.getTranslateZ());
		//camera.getTransforms().add(rVertLVL);
		//System.out.println("actual case 2 location AFTER X "+camera.getTranslateX()+" Y "+camera.getTranslateY()+" Z "+camera.getTranslateZ());
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
	public CreateCamera(){
		setUp();
	}

	public PerspectiveCamera getCamera(){
		return camera;
	}
	public static void camRotateC(Camera c){
		c.setRotate(45);
	}
	public static void camRotateA(Camera c){
		c.setRotate(-45);
	}
}
