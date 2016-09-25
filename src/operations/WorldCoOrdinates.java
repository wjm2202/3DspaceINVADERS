package operations;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.geometry.Point3D;
/**
 * this method is used to generate start points for your eneimes
 * it also outlines the dimensions of the 3D game box
 * ITS NOT A GOOD IDEA TO MAKE ANY CHANGES HERE
 * PLEASE SEE GLEN but please read comments to understand this class(open class and read)
 * @author Liandri
 *
 */
public class WorldCoOrdinates {
	
	/**
	 * this class is where you load start locations into your getStartLocationsYourName
	 * the start locations are inside the 3D box that are the boundry for all the games
	 * CASE 0 is top left front corner
	 * CASE 1 is bottom left front corner
	 * CASE 2 is bottom right front corner
	 * CASE 3 is top right front corner
	 * CASE 4 is top right back corner
	 * CASE 5 is top left back corner
	 * CASE 6 is bottom left back corner
	 * CASE 7 is bottom right back corner
	 * CASE 8 is top right back corner
	 * 
	 * YOU MUST SET THE ENEMY INSIDE THE 3D BOX BY MAKING POINT3D INSIDE THE 9 CORNERS EXAMPLE BELOW
	 *             location left/right                       location up/down                           location forward/rear
	 * CENTER OF BOUNDRY        X=490                                   Y=245                                        Z=645
	 * 
	 * VALUES YOU CAN USE TO ADD A POINT3d HAVE TO BE BETWEEN A MIN AND MAX VALUE TO BE INSIDE THE BOX
	 * Point3D(X value>10.0 OR X value<990.0,         Y value>10.0 OR Y value<490,                Z value>810 OR Z value<1290);
	 */
/**
 * 
 * DO NOT TOUCH THIS PART BELOW	
 */
    Point3D case0 = new Point3D(0.0,0.0,800.0);                              //bound TOP FRONT LEFT LOCATION
	private Point3D case1 = new Point3D(0.0,500.0,800.0);                            //bound BOTTOM FRONT LEFT LOCATION
	Point3D case2 = new Point3D(1000.0,500.0,800.0);                         //bound BOTTOM FRONT RIGHT LOCATION
	Point3D case3 = new Point3D(1000.0,0.0,800.0);                           //bound TOP FRONT RIGHT LOCATION
	Point3D case4 = new Point3D(0.0,0.0,1300.0);                             //bound TOP BACK LEFT LOCATION
	Point3D case5 = new Point3D(0.0,500.0,1300.0);                           //bound BOTTOM BACK LEFT LOCATION
	Point3D case6 = new Point3D(1000.0,500.0,1300.0);                        //bound BOTTOM BACK RIGHT LOCATION
	Point3D case7 = new Point3D(1000.0,0.0,1300.0);                          //bound TOP BACK RIGHT LOCATION
	Point3D start = new Point3D(0.0,0.0,0.0);
	ArrayList<Point3D> bounds = new ArrayList<>();                           //ArrayList of bounds for boarder locations
	ArrayList<Point3D> enemies = new ArrayList<>();                          //ArrayList of start 3D locations for enemies
	private final int WORLD_WIDTH = 200;
	private final int WORLD_HEIGHT = 100;
	private final int WORLD_DEPTH = 100;
	
/**
 * DO NOT TOUCH
 * this is where the world box is made into an array so we can make the 3D world box	
 */
	public WorldCoOrdinates(){                                              //add bounds to ArrayList for use with other classes
		bounds.add(case0);
		bounds.add(getCase1());
		bounds.add(case2);
		bounds.add(case3);
		bounds.add(case4);
		bounds.add(case5);
		bounds.add(case6);
		bounds.add(case7);
		bounds.add(start);
	}
/**
 * 	
 * @return an ArrayList of the 3D points that are the corners of the box
 */
	public ArrayList<Point3D> getBounds(){                                 //get bounds array for testing if boxes are inside boarders
		return bounds;
	}
/**
 * DONT TOUCH AUTO GENERATED BY GAMEVALUE YOURNAME
 * @param numEnemies
 * @return
 */
	public ArrayList<Point3D> getStartLocationsInvaders(int numEnemies){                         //load start points into array for enemies start locations
		for(int i=0;i<numEnemies;i++){
			
			enemies.add(getPoints());
		}
		return enemies;
	}

	public Point3D getCase1() {
		return case1;
	}
	public void setCase1(Point3D case1) {
		this.case1 = case1;
	}
/**
 * generate 3d Points within the range of the inside of the 3D world Box	
 * @return
 */
	public Point3D getPoints(){
		double x = ThreadLocalRandom.current().nextDouble(10.0, 990.0);
		double y = ThreadLocalRandom.current().nextDouble(10.0, 12.0);
		double z = ThreadLocalRandom.current().nextDouble(810.0, 1290.0);
		Point3D randPoint = new Point3D(x,y,z);
		return randPoint;
	}

	public int getWorldWidth() {
		return WORLD_WIDTH;
	}
	public int getWorldHeight() {
		return WORLD_HEIGHT;
	}
	public int getWorldDepth() {
		return WORLD_DEPTH;
	}
}
