package gameValues;

import java.util.ArrayList;

import javafx.geometry.Point3D;
import operations.Enemy;
import operations.WorldCoOrdinates;

public class SpawnEnemies {
	//import classes used
	WorldCoOrdinates loc3D = new WorldCoOrdinates();
	LevelValues gvg = new LevelValues();
	//make arrays for objects
	ArrayList<Enemy> enemy = new ArrayList<>();
	ArrayList<Point3D> startP3d = new ArrayList<>();
	
	
	public ArrayList<Enemy> getEnemeyArray(int numEnemies){
		startP3d = loc3D.getStartLocationsInvaders(numEnemies);                //add new world co ordinates start position to add more enemies
		for(int i=0;i<startP3d.size();i++){
			double dX = gvg.getXvelocity();
			double dY = gvg.getYvelocity();
			double dZ = gvg.getZvelocity();
			Enemy e = new Enemy(startP3d.get(i), dX,dY,dZ,1,50);
			enemy.add(e);
			
		}
		return enemy;
	}

}
