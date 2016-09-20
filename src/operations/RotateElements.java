package operations;

import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import glen14852903.Movement;

public class RotateElements {
	/**
	 * This method is used to rotate 3D objects
	 * @author Inderjit Singh Janjua
	 *
	 */

	Rotate r180 = new Rotate(0,0,0,0, Rotate.Y_AXIS);
	Rotate r90 = new Rotate(0,0,0,0, Rotate.Y_AXIS);
	Rotate mr90 = new Rotate(0,0,0,0, Rotate.Y_AXIS);

	public void rotateTank(Node node, Movement facing, Movement turnTo){
		r180.setAngle(180);
		r90.setAngle(90);
		mr90.setAngle(-90);
		switch(facing){
			case forwards:
				switch(turnTo){
					case right:
						node.getTransforms().add(r90);
						break;
					case backwards:
						node.getTransforms().add(r180);
						break;
					case left:
						node.getTransforms().add(mr90);
						break;
					default:
						break;
				}
				break;
			case right:
				switch(turnTo){
					case forwards:
						node.getTransforms().add(mr90);
						break;
					case backwards:
						node.getTransforms().add(r90);
						break;
					case left:
						node.getTransforms().add(r180);
						break;
					default:
						break;
				}
				break;
			case backwards:
				switch(turnTo){
					case forwards:
						node.getTransforms().add(r180);
						break;
					case right:
						node.getTransforms().add(r90);
						break;
					case left:
						node.getTransforms().add(mr90);
						break;
					default:
						break;
				}
				break;
			case left:
				switch(turnTo){
					case forwards:
						node.getTransforms().add(r90);
						break;
					case right:
						node.getTransforms().add(r180);
						break;
					case backwards:
						node.getTransforms().add(mr90);
						break;
					default:
						break;
				}
				break;
		}
		}

		/**
		 * this method makes a single 3D box turn 180 degrees
		 * just call the method and supply the individual box
		 * and it will be rotated 180 degrees once
		 * @param node
		 */
		public void rotateBox(Node node) {                                                //make an animation
			RotateTransition rtrans = new RotateTransition(Duration.millis(250), node);   //make a new rotateTransform 1/20 of a second duration
			rtrans.setFromAngle(0);                                                  //start angle of rotation
			rtrans.setToAngle(180);                                                  //angle to rotate to
			rtrans.setAutoReverse(false);                                            //does not reverse direction of rotation
			rtrans.setCycleCount(1);                                                //rotate once
			rtrans.setAxis(new Point3D(0.0, 0.0, 0.0));                                //rotational axis
			rtrans.play();                                                           //play the animation}
		}
}
