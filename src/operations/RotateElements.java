package operations;

import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Group;
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

	Rotate r180 = new Rotate(0,0,0,50, Rotate.Y_AXIS);	//A variable that will store a number that rotates a Node 180 degrees
	Rotate r90 = new Rotate(0,0,0,50, Rotate.Y_AXIS);	//A variable that will store a number that rotates a Node 90 degrees
	Rotate mr90 = new Rotate(0,0,0,50, Rotate.Y_AXIS);	//A variable that will store a number that rotates a Node -90 degrees
	Rotate rLeft = new Rotate(0,0,0,50, Rotate.Y_AXIS);	//A variable that will store a number that rotates a Node -90 degrees
	Rotate rRight = new Rotate(0,0,0,50, Rotate.Y_AXIS);	//A variable that will store a number that rotates a Node -90 degrees
	Rotate rVert = new Rotate(90,0,0,50, Rotate.Z_AXIS);	//A variable that will store a number that rotates a Node -90 degrees

	public void rotateVert(Group group, double amountVertRotate){
		rLeft.setAngle(amountVertRotate);
		for(int i =0;i<group.getChildren().size();i++) {
			Node node = group.getChildren().get(i);
			node.getTransforms().add(rVert);    //This rotates the node amount degrees to end up right.
		}
	}

	/**
	 * this method will rotate the tank around its Y axis the amount of the amount argument
	 *
	 * @param group
	 * @param amountLeftRotate
	 */
	public void rotateLeft(Group group, double amountLeftRotate){
		rLeft.setAngle(amountLeftRotate);
		for(int i =0;i<group.getChildren().size();i++) {
			Node node = group.getChildren().get(i);
			node.getTransforms().add(rLeft);    //This rotates the node amount degrees to end up right.
		}
	}

	/**
	 * this method will rotate the tank around its y axis the amount of the amount argument
	 *
	 * @param group
	 * @param amountRightRotate
	 */
	public void rotateRight(Group group, double amountRightRotate){
		rRight.setAngle(amountRightRotate);
		for(int i =0;i<group.getChildren().size();i++) {
			Node node = group.getChildren().get(i);
			node.getTransforms().add(rRight);    //This rotates the node amount degrees to end up right.
		}
	}

	public void rotateTank(Group group, Movement facing, Movement turnTo, Point3D axis){
		//testing rotate method with tank generated point
		//Rotate test = new Rotate(90,0,0,55,Rotate.Y_AXIS);
		r180.setAngle(180);	//This sets the variable value so the Node will rotate 180 degrees
		r90.setAngle(90);	//This sets the variable value so the Node will rotate 90 degrees
		mr90.setAngle(-90);	//This sets the variable value so the Node will rotate -90 degrees
		switch(facing){
			case forwards:	//This means the current position must be forwards for this switch case to run.
				switch(turnTo){
					case right:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(r90);    //This rotates the node 90 degrees to end up right.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					case backwards:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(r180); //This rotates the node 180 degrees to end up backwards.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					case left:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(mr90); //This rotates the node -90 degrees to end up left.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					default:
						break;
				}
				break;
			case right:		//This means the current position must be right for this switch case to run.
				switch(turnTo){
					case forwards:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(mr90); //This rotates the node -90 degrees to end up forwards.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					case backwards:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(r90); //This rotates the node 90 degrees to end up backwards.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					case left:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(r180); //This rotates the node 180 degrees to end up left.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					default:
						break;
				}
				break;
			case backwards:		//This means the current position must be backwards for this switch case to run.
				switch(turnTo){
					case forwards:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(r180); //This rotates the node 180 degrees to end up forwards.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					case right:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(r90); //This rotates the node 90 degrees to end up right.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					case left:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(mr90); //This rotates the node -90 degrees to end up left.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					default:
						break;
				}
				break;
			case left:		//This means the current position must be left for this switch case to run.
				switch(turnTo){
					case forwards:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(r90); //This rotates the node 90 degrees to end up forwards.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					case right:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(r180); //This rotates the node 180 degrees to end up right.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
						break;
					case backwards:
						for(int i =0;i<group.getChildren().size();i++) {
							Node node = group.getChildren().get(i);
							node.getTransforms().add(mr90); //This rotates the node -90 degrees to end up backwards.
							//node.getTransforms().add(test);    //This rotates the node 90 degrees to end up right.
						}
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
		 * @param
		 */
		public void rotateBox(Node node) {                                                //make an animation

			//for(int i=0;i<group.getChildren().size();i++){
				//Node node = group.getChildren().get(i);

			RotateTransition rtrans = new RotateTransition(Duration.millis(1000), node);   //make a new rotateTransform 1/20 of a second duration
			rtrans.setFromAngle(0);                                                  //start angle of rotation
			rtrans.setToAngle(180);                                                  //angle to rotate to
			rtrans.setAutoReverse(false);                                            //does not reverse direction of rotation
			rtrans.setCycleCount(1);                                                //rotate once
			rtrans.setAxis(new Point3D(0.0, 0.0, 0.0));                                //rotational axis
			rtrans.play();                                                           //play the animation}
			//}

		}
}
