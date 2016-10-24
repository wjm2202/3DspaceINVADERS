package operations;

import java.util.ArrayList;

import application.MainView;
import application.Splash;
import gameValues.LevelValues;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;


/**
 * Bounds clamp keeps everything inside the 3D box 
 * it accepts a node(3d object) or a group (group of 3d objects) and
 * changes the velocity in a negative direction to switch direction of travel
 * every node or group created should be clamped to ensure they stay inside the box
 * i will be helping you to create custom clamps depending on what game you want to build
 * @author Liandri
 *
 */
public class BoundsClamp {
	

	LevelValues gvg = MainView.gvg;
	ArrayList<Point3D> bc = new ArrayList<>();                                     
	WorldCoOrdinates wc = Splash.wc;                                  //the 3D points that define the world boundaries
	Node eachNode;                                                                     //the box object holder used for testing in clamp
	RotateElements re = new RotateElements();
	/**
	 * constructor sets the clamp coordinates to the world coordinates
	 * the world coordinates define how big the 3D box the encloses the game is
	 */
	public BoundsClamp(){
		bc = wc.getBounds();                                                        //create arraylist of co-ordinates of world bounds
	}
	/**
	 * this method takes an arraylist of enemies and will extract the node(3D object)
	 * that is the enemy and check it is within the 3D box for the game
	 * if the enemy is outside the world clamp with make the velocity negitive and the enemy will change direction
	 * if the enemy hits the ground they are removed
	 * @param e
	 */
	public void clamp(ArrayList<Enemy> e){                                            //ensure enemies are within world bounds
		for(int j=0;j<e.size();j++){
			Enemy ef = e.get(j);                                                                        //get the enemy class holding the group
			Group test = ef.getGroup();                                                                 //get each megaInvader
			for(int i=0;i<test.getChildren().size();i++){                                                //loop for the number of enemies in arraylist
				eachNode = test.getChildren().get(i);
				eachNode.setTranslateX(eachNode.getTranslateX()+ef.getxOffset());
				eachNode.setTranslateY(eachNode.getTranslateY()+ef.getyOffset());
				eachNode.setTranslateZ(eachNode.getTranslateZ()+ef.getzOffset());
				if((eachNode.getTranslateX()<=wc.case0.getX())                                           //if the enemy is to far left
				||(eachNode.getTranslateX()>=wc.case3.getX())){                                          //or if the enemy is to far right
					//tb.setXhit(new Point3D(eachNode.getTranslateX(),eachNode.getTranslateY(),eachNode.getTranslateZ()));    //log position
					//offset is the amount of movement the enemy will move, negitive to left positive to right
					ef.setxOffset(-(ef.getxOffset()));                                                   //change the offset to the opposite value (negative value becomes positive value or positive value becomes negative value)
					eachNode.setTranslateX(eachNode.getTranslateX()+ef.getxOffset());                    //set the x location (using the current x location + the Xoffset)
					eachNode.setTranslateY(eachNode.getTranslateY()+gvg.getSpinDrop());                  //make the enemy move down the amount of the y offset (hit the wall move down)
					re.rotateBox(eachNode);                                                              //rotate each group

				}
				if((eachNode.getTranslateZ()<=wc.getCase1().getZ())                                      //if the enemy is too far forward
				||(eachNode.getTranslateZ()>=wc.case5.getZ())){                                          //or if the enemy is too far back
					//tb.setZhit(new Point3D(eachNode.getTranslateX(),eachNode.getTranslateY(),eachNode.getTranslateZ()));        //log position
					ef.setzOffset(-(ef.getzOffset()));                                                   //change the offset to the opposite value (negative value becomes positive value or positive value becomes negative value)
					eachNode.setTranslateZ(eachNode.getTranslateZ()+ef.getzOffset());                    //set the z location (using the current z location + the Zoffset)
					eachNode.setTranslateY(eachNode.getTranslateY()+gvg.getSpinDrop());                  //make the enemy move down the amount of the y offset (hit the wall move down)
					re.rotateBox(eachNode);                                                                  //rotate the group
				}
				if(eachNode.getTranslateY()>=wc.getCase1().getY()-15){                                   //if the enemy hits the floor
					//tb.setYhit(new Point3D(eachNode.getTranslateX(),eachNode.getTranslateY(),eachNode.getTranslateZ()));        //log position
					ef.setxOffset(0);                                                                    //change the Xoffset to zero to stop moving left/right
					ef.setyOffset(0);                                                                    //change the Yoffset to zero to stop moving forward/back
					ef.setzOffset(0);                                                                    //change the Zoffset to zero to stop moving down
					ef.setLanded(true);                                                                  //set the landed boolean to true
				}
			}
		}
	}
/**
 * clamp the contents of the world 3D box within the x dimension
 * also adds velocity to the movement of the enemies in the x dimension	
 * @param e
 */
	public void clampX(ArrayList<Enemy> e){                                          //ensure enemies are within world bounds
		for(int i=0;i<e.size();i++){                                                //loop for the number of enemies in arraylist
			eachNode = e.get(i).getNode();                                              //get the current node (enemies store the box node)
			Enemy ef = e.get(i);                                                    //get the enemy class holding the node
			eachNode.setTranslateX(eachNode.getTranslateX()+ef.getxOffset());
			if((eachNode.getTranslateX()<=wc.case0.getX())                              //if the enemy is to far left
			||(eachNode.getTranslateX()>=wc.case3.getX())){                             //or if the enemy is to far right
				//offset is the amount of movement the enemy will move, negitive to left positive to right
				ef.setxOffset(-(ef.getxOffset()));                                  //change the offset to the opposite value (negative value becomes positive value or positive value becomes negative value)
				eachNode.setTranslateX(eachNode.getTranslateX()+ef.getxOffset());           //set the x location (using the current x location + the Xoffset)
			}
		}
	}
/**
 * clamp the contents of the 3D world box within the Z dimension	
 * also adds velocity to the movement of the enemies in the z dimension
 * @param e
 */
	public void clampZ(ArrayList<Enemy> e){                                          //ensure enemies are within world bounds
		for(int i=0;i<e.size();i++){                                                //loop for the number of enemies in arraylist
			eachNode = e.get(i).getNode();                                              //get the current node (enemies store the box node)
			Enemy ef = e.get(i);                                                    //get the enemy class holding the node
			eachNode.setTranslateZ(eachNode.getTranslateZ()+ef.getzOffset());
			if((eachNode.getTranslateZ()<=wc.getCase1().getZ())                              //if the enemy is too far forward
			||(eachNode.getTranslateZ()>=wc.case5.getZ())){                             //or if the enemy is too far back
				ef.setzOffset(-(ef.getzOffset()));                                  //change the offset to the opposite value (negative value becomes positive value or positive value becomes negative value)
				eachNode.setTranslateZ(eachNode.getTranslateZ()+ef.getzOffset());           //set the z location (using the current z location + the Zoffset)
			}   
		}
	}
/**
 * clamp the contents of the 3D workd Box within the Y dimension
 * also adds velocity to the movement of the enemies in the y dimension	
 * @param e
 */
	public void clampY(ArrayList<Enemy> e){                                          //ensure enemies are within world bounds
		for(int i=0;i<e.size();i++){                                                //loop for the number of enemies in arraylist
			eachNode = e.get(i).getNode();                                              //get the current node (enemies store the box node)
			Enemy ef = e.get(i);                                                    //get the enemy class holding the node
			//test.setTranslateX(test.getTranslateX()+ef.getxOffset());
			eachNode.setTranslateY(eachNode.getTranslateY()+ef.getyOffset());
			//test.setTranslateZ(test.getTranslateZ()+ef.getzOffset());
  
			if((eachNode.getTranslateY()>=wc.getCase1().getY()-15)||
					eachNode.getTranslateY()<=wc.case0.getY()){                     //if the enemy hits the floor
				ef.setyOffset(-(ef.getyOffset()));
				eachNode.setTranslateY(eachNode.getTranslateY()+ef.getyOffset());
			} 
		}
	}

	/**
	 * this method stops the tank from going outside the x 
	 * it returns a boolean to block movement in the MainView class
	 * @param tank
	 * @return boolean
	 */
	public boolean tankXClamp(Point3D tank){                                         //ensure tank is within the world X bounds
		boolean canMove = true;                                                   //boolean test
		//if the tank is touching the left X boundary + box width or if the tank is touching the right Y boundary - box width
		if((tank.getX()<=wc.case0.getX()+60) || (tank.getX()>=wc.case3.getX()-40)){
			canMove = false;                                          //set the flag to false preventing movement
		}

		return canMove;                                                           //return if the tank can continue to move further in the X direction
	}
	/**
	 * this method stops the tank from going outside the z
	 * it returns a boolean to block movement in the MainView class
	 * @param tank
	 * @return boolean
	 */
	public boolean tankZClamp(Point3D tank){                                           //ensure tank is within the world X bounds
		boolean canMove = true;                                                     //boolean test
		//if the tank is touching the left Z boundary + box width or if the tank is touching the right Y boundary - box width
		if((tank.getZ()<=wc.case0.getZ()+100) || (tank.getZ()>=wc.case4.getZ())){
			canMove = false;                                                         //set the flag to false preventing movement
		}

		return canMove;                                                              //return if the tank can continue to move further in the Z direction
	}
}