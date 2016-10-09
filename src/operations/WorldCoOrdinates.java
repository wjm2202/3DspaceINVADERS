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

	private int WORLD_WIDTH = 200;
	private int WORLD_HEIGHT = 100;
	private int WORLD_DEPTH = 100;

	public void resetScaleGameBox(){
		System.out.println("WorldCoordinates  resetScale  ");
		ArrayList<Point3D> bigBox = new ArrayList<>();                           //ArrayList of bounds for boarder locations
		this.case0 = new Point3D(0.0,0.0,1600.0);                              //bound TOP FRONT LEFT LOCATION
		this.case1 = new Point3D(0.0,1000.0,1600.0);                            //bound BOTTOM FRONT LEFT LOCATION
		this.case2 = new Point3D(2000.0,1000.0,1600.0);                         //bound BOTTOM FRONT RIGHT LOCATION
		this.case3 = new Point3D(2000.0,0.0,1600.0);                           //bound TOP FRONT RIGHT LOCATION
		this.case4 =new Point3D(0.0,0.0,2600.0);                             //bound TOP BACK LEFT LOCATION
		this.case5 = new Point3D(0.0,1000.0,2600.0);                           //bound BOTTOM BACK LEFT LOCATION
		this.case6 = new Point3D(2000.0,1000.0,2600.0);                        //bound BOTTOM BACK RIGHT LOCATION
		this.case7 = new Point3D(2000.0,0.0,2600.0);                          //bound TOP BACK RIGHT LOCATION
		this.start = new Point3D(0.0,0.0,0.0);
		WORLD_WIDTH = 400;
		WORLD_HEIGHT = 200;
		WORLD_DEPTH = 200;
	}

	public void scaleUpGameBox(){
		System.out.println("WorldCoordinates  scaleUpGameBox  ");
		ArrayList<Point3D> bigBox = new ArrayList<>();                           //ArrayList of bounds for boarder locations
		this.case0 = new Point3D(0.0,0.0,1600.0);                              //bound TOP FRONT LEFT LOCATION
		this.case1 = new Point3D(0.0,1000.0,1600.0);                            //bound BOTTOM FRONT LEFT LOCATION
		this.case2 = new Point3D(2000.0,1000.0,1600.0);                         //bound BOTTOM FRONT RIGHT LOCATION
		this.case3 = new Point3D(2000.0,0.0,1600.0);                           //bound TOP FRONT RIGHT LOCATION
		this.case4 =new Point3D(0.0,0.0,2600.0);                             //bound TOP BACK LEFT LOCATION
		this.case5 = new Point3D(0.0,1000.0,2600.0);                           //bound BOTTOM BACK LEFT LOCATION
		this.case6 = new Point3D(2000.0,1000.0,2600.0);                        //bound BOTTOM BACK RIGHT LOCATION
		this.case7 = new Point3D(2000.0,0.0,2600.0);                          //bound TOP BACK RIGHT LOCATION
		this.start = new Point3D(0.0,0.0,0.0);
		WORLD_WIDTH = 400;
		WORLD_HEIGHT = 200;
		WORLD_DEPTH = 200;
	}
	public void scaleDownGameBox(){
		System.out.println("WorldCoordinates  scaleDownGameBox  ");
		this.case0 = new Point3D(0.0,0.0,400.0);                              //bound TOP FRONT LEFT LOCATION
		this.case1 = new Point3D(0.0,400.0,400.0);                    //bound BOTTOM FRONT LEFT LOCATION
		this.case2 = new Point3D(500.0,5250.0,400.0);                         //bound BOTTOM FRONT RIGHT LOCATION
		this.case3 = new Point3D(500.0,0.0,400.0);                           //bound TOP FRONT RIGHT LOCATION
		this.case4 = new Point3D(0.0,0.0,650.0);                             //bound TOP BACK LEFT LOCATION
		this.case5 = new Point3D(0.0,250.0,650.0);                           //bound BOTTOM BACK LEFT LOCATION
		this.case6 = new Point3D(500.0,250.0,650.0);                        //bound BOTTOM BACK RIGHT LOCATION
		this.case7 = new Point3D(500.0,0.0,650.0);                          //bound TOP BACK RIGHT LOCATION
		this.start = new Point3D(0.0,0.0,0.0);
		WORLD_WIDTH = 100;
		WORLD_HEIGHT = 500;
		WORLD_DEPTH = 50;
	}
/**
 * DO NOT TOUCH
 * this is where the world box is made into an array so we can make the 3D world box	
 */
	public WorldCoOrdinates(){                                              //add bounds to ArrayList for use with other classes
		addBoundsWorld();
	}
	public void addBoundsWorld(){
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
 *
 */
	public int getWORLD_WIDTH() {
		return WORLD_WIDTH;
	}

		public void setWORLD_WIDTH(int WORLD_WIDTH) {
			this.WORLD_WIDTH = WORLD_WIDTH;
		}

		public int getWORLD_HEIGHT() {
			return WORLD_HEIGHT;
		}

		public void setWORLD_HEIGHT(int WORLD_HEIGHT) {
			this.WORLD_HEIGHT = WORLD_HEIGHT;
		}

		public int getWORLD_DEPTH() {
			return WORLD_DEPTH;
		}

		public void setWORLD_DEPTH(int WORLD_DEPTH) {
			this.WORLD_DEPTH = WORLD_DEPTH;
		}


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

	public Point3D getCase0() {
		return case0;
	}

	public void setCase0(Point3D case0) {
		this.case0 = case0;
	}

	public Point3D getCase2() {
		return case2;
	}

	public void setCase2(Point3D case2) {
		this.case2 = case2;
	}

	public Point3D getCase3() {
		return case3;
	}

	public void setCase3(Point3D case3) {
		this.case3 = case3;
	}

	public Point3D getCase4() {
		return case4;
	}

	public void setCase4(Point3D case4) {
		this.case4 = case4;
	}

	public Point3D getCase5() {
		return case5;
	}

	public void setCase5(Point3D case5) {
		this.case5 = case5;
	}

	public Point3D getCase6() {
		return case6;
	}

	public void setCase6(Point3D case6) {
		this.case6 = case6;
	}

	public Point3D getCase7() {
		return case7;
	}

	public void setCase7(Point3D case7) {
		this.case7 = case7;
	}

	public Point3D getStart() {
		return start;
	}

	public void setStart(Point3D start) {
		this.start = start;
	}
}
