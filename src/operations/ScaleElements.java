package operations;

import javafx.scene.Group;
import javafx.scene.Node;
/**
 * this method allows you to resize entire groups of objects or single objects
 * 
 * @author Liandri
 *
 */
public class ScaleElements {
/**
 * scale up all nodes in a 3D group by a factor of two(bigger)
 * @param root
 */
	public void scaleUpAll(Group root){                                                   //change size of a group of 3D objects(nodes)
		root.getChildren().stream()                                                  //stream is like a loop
		.forEach(e->{                                              //for each 3d object
			e.setScaleX(2.0);                                        //make it 2.0 times bigger X dimension
			e.setScaleY(2.0);                                        //make it 2.0 times bigger Y dimension
			e.setScaleZ(2.0);                                        //make it 2.0 times bigger Z dimension
		});                                                        //end the stream (like a loop)
	}
/**
 * scale down all nodes in a 3D group by half (smaller)	
 * @param root
 */
	public void scaleDownAll(Group root){                                                  //same as above but return to normal size
		root.getChildren().stream()
		.forEach(e->{
			e.setScaleX(1.0);
			e.setScaleY(1.0);
			e.setScaleZ(1.0);
		});
	}
/**
 * scale a single node by a factor(double) you decide	
 * @param node 3D object to change size of
 * @param factor double amount to change (0.1 very small)(1.0 same size) (2.0 twice the size)
 */
	public void scaleSingle(Node node,double factor){
		node.setScaleX(factor);
		node.setScaleY(factor);
		node.setScaleZ(factor);
	}
/**
 * scale a group of 3D objects by a factor(double) you decide	
 * @param root       group of 3D objects to change size of
 * @param factor  double amount to change (0.1 very small)(1.0 same size) (2.0 twice the size) 
 */
	public void scaleAll(Group root, double factor){                                                  //same as above but return to normal size
		root.getChildren().stream()
		.forEach(e->{
			e.setScaleX(factor);
			e.setScaleY(factor);
			e.setScaleZ(factor);
		});
	}
	
}
