package operations;

import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.util.Duration;
/**
 * this method is used to rotate 3D objects
 * @author Liandri
 *
 */
public class RotateElements {
/**
 * this method makes a single 3D box turn 180 degrees
 * just call the method and supply the individual box
 * and it will be rotated 180 degrees once	
 * @param node
 */
	public void rotateBox(Node node){                                                //make an animation
		RotateTransition rtrans = new RotateTransition(Duration.millis(250),node);   //make a new rotateTransform 1/20 of a second duration
		rtrans.setFromAngle(0);                                                  //start angle of rotation
		rtrans.setToAngle(180);                                                  //angle to rotate to
		rtrans.setAutoReverse(false);                                            //does not reverse direction of rotation
		rtrans.setCycleCount(1);                              					//rotate once
		rtrans.setAxis(new Point3D(0.0,5.0,0.0));                                //rotational axis
		rtrans.play();                                                           //play the animation
	}
/**
 * DO NOT ALTER
 * see glen if you want different behavior for your player	
 * this makes the player tank face the direction of the arrow key press
 * it uses a facing and move to face variable in amin to calculate which way to move
 * if you require different movement for your player see glen for help
 * @param node
 * @param facing
 * @param turnTo
 */
	public void rotateTank(Node node, int facing, int turnTo){                                                //make an animation
		//for each in arraylist do
		RotateTransition rtrans = new RotateTransition(Duration.millis(250),node);   //make a new rotateTransform 1/20 of a second duration
		rtrans.setFromAngle(0);                                                  //start angle of rotation
		switch(facing){
		case 0:
			switch(turnTo){
			case 0:
				break;
			case 1:
				rtrans.setToAngle(-90);
				break;
			case 2:
				rtrans.setToAngle(-180);
				break;
			case 3:
				rtrans.setToAngle(90);
				break;
			}
			break;
		case 1:
			switch(turnTo){
			case 0:
				rtrans.setToAngle(90);
				break;
			case 1:
				break;
			case 2:
				rtrans.setToAngle(90);
				break;
			case 3:
				rtrans.setToAngle(180);
				break;
			}
			break;
		case 2:
			switch(turnTo){
			case 0:
				rtrans.setToAngle(180);
				break;
			case 1:
				rtrans.setToAngle(90);
				break;
			case 2:
				break;
			case 3:
				rtrans.setToAngle(90);
				break;
			}
			break;
		case 3:
			switch(turnTo){
			case 0:
				rtrans.setToAngle(90);
				break;
			case 1:
				rtrans.setToAngle(180);
				break;
			case 2:
				rtrans.setToAngle(90);
				break;
			case 3:
				break;
			}
			break;
		}                                            //angle to rotate to
		rtrans.setAutoReverse(false);                                            //does not reverse direction of rotation
		rtrans.setCycleCount(1);                              					//rotate once
		rtrans.setAxis(new Point3D(0.0,5.0,0.0));                                //rotational axis
		rtrans.play();                                                           //play the animation
		//end the stream
	}
}
