package operations;

import gameValues.LevelValues;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;
/**
 * this method is a wrapper class for the enemies you want to place on the screen
 * this class allows you to track and to update the location and state of the enemy
 * it holds a node which is the 3D box that represents the enemy on screen
 * @author Liandri
 *
 */
public class Enemy {
	
	LevelValues gvg = new LevelValues();
	public Point3D currLoc;                                                             //enemy start at this location
	private int boxSize = 0;                                                             //enemy size
	private int enemyType =0;                                                            //used to differentiate different enemies
	private boolean isAlive = true;                                                      //is this enemy still alive or crashing
	private boolean isLanded = false;                                                    //has the enemy landed 
	private double xOffset=0.0;                                                          //the amount the enemy moves in the X direction each loop (left/right)
	private double yOffset=0.0;                                                          //the amount the enemy moves in the Y direction each loop (forward/back)
	private double zOffset=0.0;                                                          //the amount the enemy moves in the Z direction each loop (up/down)
	private Node node;                                                                   //node is the 3D box that is an enemy on screen
	ArrayList<Node> bombs = new ArrayList<>();                                           //arrayList of bombs dropped by enemy that are unexploded
	Group Minv = new Group();
	CreateBox cb = new CreateBox();                                                      //make a box for this enemy to control

	public Group getGroup() {
		return Minv;
	}

	public void setMinv(Group minv) {
		Minv = minv;
	}


/**
 * constructor creates a 3D box and sets fields for location and size	
 * @param loc       Point3D location of box (future multi-player use)
 * @param xO        preset in LEVELVALUES
 * @param yO        preset in LEVELVALUES
 * @param zO        preset in LEVELVALUES
 * @param eType     to be used in future multi-player mode
 * @param boxS      size of box x,y,z
 */
	public Enemy(Point3D loc, double xO, double yO, double zO,int eType, int boxS ){
		setCurrLoc(loc);
		setxOffset(xO);
		setyOffset(yO);
		setzOffset(zO);
		setEnemyType(eType);
		setBoxSize(boxS);
		//node = cb.singleEnemyBox((int)currLoc.getX(), (int)currLoc.getY(), (int)currLoc.getZ(), gvg.getEnemyXsize(), gvg.getEnemyYsize(),gvg.getEnemyZsize());
	}

/**
 * 	
 * @return node(3D box) to update remove or move
 */
	public Node getNode(){
		return node;
	}
	public void setNode(Node node){this.node=node;}
/**
 * 	
 * @return ArrayList of bombs (future multi-player use)
 */
	public ArrayList<Node> getBombs(){
		return bombs;
	}
/**
 * 	
 * @return Point3D (future multi-player use)
 */
	public Point3D getCurrLoc() {
		return currLoc;
	}
/**
 * 
 * @param currLoc Point3D (future multi-player use)
 */
	public void setCurrLoc(Point3D currLoc) {
		this.currLoc = currLoc;
	}
/**
 * 
 * @return enemyType Point3D (future multi-player use)
 */
	public int getEnemyType() {
		return enemyType;
	}
/**
 * 
 * @param enemyType Point3D (future multi-player use)
 */
	public void setEnemyType(int enemyType) {
		this.enemyType = enemyType;
	}
/**
 * used to move this enemy, is equivalent to velocity
 * @return velocity in the X direction
 */
	public double getxOffset() {
		return xOffset;
	}
	/**
	 * used to move this enemy, is equivalent to velocity
	 * @return velocity in the Y direction
	 */
	public void setxOffset(double xOffset) {
		this.xOffset = xOffset;
	}
	/**
	 * used to move this enemy, is equivalent to velocity
	 * @return velocity in the Z direction
	 */
	public double getyOffset() {
		return yOffset;
	}
/**
 * set the velocity of the y axis movement
 * @param yOffset
 */
	public void setyOffset(double yOffset) {
		this.yOffset = yOffset;
	}
/**
 * set the velocity of the z axis movement
 * @return void
 */
	public double getzOffset() {
		return zOffset;
	}
/**
 * set the z axis velocity
 * @param zOffset
 */
	public void setzOffset(double zOffset) {
		this.zOffset = zOffset;
	}
/**
 * flag if the enemy is alive or is to be removed
 * @return boolean
 */
	public boolean isAlive() {
		return isAlive;
	}
/**
 * change flag alive to false, will be removed from enemy array
 * @param isAlive
 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
/**
 * 
 * @return the size of this enemies box 
 */
	public int getBoxSize() {
		return boxSize;
	}
/**
 * set the size of this enemies box
 * HAS NO EFFECT
 * @param boxSize
 */
	public void setBoxSize(int boxSize) {
		this.boxSize = boxSize;
	}
/**
 * set flag to true if landed clamp is activated
 * remove from observable list if true
 * @return
 */
	public boolean isLanded() {
		return isLanded;
	}
/**
 * change flag so remoal is ordered next loop
 * @param isLanded
 */
	public void setLanded(boolean isLanded) {
		this.isLanded = isLanded;
	}
}
