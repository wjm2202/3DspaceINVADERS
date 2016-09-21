package operations;

import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import gameValues.Movement;

public class RotateElements {
	/**
	 * This method is used to rotate 3D objects
	 * @author Inderjit Singh Janjua
	 *
	 */

	Rotate r180 = new Rotate(0,0,0,0, Rotate.Y_AXIS);	//A variable that will store a number that rotates a Node 180 degrees
	Rotate r90 = new Rotate(0,0,0,0, Rotate.Y_AXIS);	//A variable that will store a number that rotates a Node 90 degrees
	Rotate mr90 = new Rotate(0,0,0,0, Rotate.Y_AXIS);	//A variable that will store a number that rotates a Node -90 degrees

	public void rotateTank(Node node, Movement facing, Movement turnTo){
		r180.setAngle(180);	//This sets the variable value so the Node will rotate 180 degrees
		r90.setAngle(90);	//This sets the variable value so the Node will rotate 90 degrees
		mr90.setAngle(-90);	//This sets the variable value so the Node will rotate -90 degrees
		switch(facing){
			case forwards:	//This means the current position must be forwards for this switch case to run.
				switch(turnTo){
					case right:
						node.getTransforms().add(r90);	//This rotates the node 90 degrees to end up right.
						break;
					case backwards:
						node.getTransforms().add(r180); //This rotates the node 180 degrees to end up backwards.
						break;
					case left:
						node.getTransforms().add(mr90); //This rotates the node -90 degrees to end up left.
						break;
					default:
						break;
				}
				break;
			case right:		//This means the current position must be right for this switch case to run.
				switch(turnTo){
					case forwards:
						node.getTransforms().add(mr90); //This rotates the node -90 degrees to end up forwards.
						break;
					case backwards:
						node.getTransforms().add(r90); //This rotates the node 90 degrees to end up backwards.
						break;
					case left:
						node.getTransforms().add(r180); //This rotates the node 180 degrees to end up left.
						break;
					default:
						break;
				}
				break;
			case backwards:		//This means the current position must be backwards for this switch case to run.
				switch(turnTo){
					case forwards:
						node.getTransforms().add(r180); //This rotates the node 180 degrees to end up forwards.
						break;
					case right:
						node.getTransforms().add(r90); //This rotates the node 90 degrees to end up right.
						break;
					case left:
						node.getTransforms().add(mr90); //This rotates the node -90 degrees to end up left.
						break;
					default:
						break;
				}
				break;
			case left:		//This means the current position must be left for this switch case to run.
				switch(turnTo){
					case forwards:
						node.getTransforms().add(r90); //This rotates the node 90 degrees to end up forwards.
						break;
					case right:
						node.getTransforms().add(r180); //This rotates the node 180 degrees to end up right.
						break;
					case backwards:
						node.getTransforms().add(mr90); //This rotates the node -90 degrees to end up backwards.
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
