package operations;

import application.MainView;
import gameValues.LevelValues;
import javafx.geometry.Point3D;

import java.util.ArrayList;

/**
 * Created by Liandri on 1/10/2016.
 */
public class NewLevelStart {

    ArrayList<Point3D> startP3d = new ArrayList<>();                     //get pre generated start locations for enemies
    WorldCoOrdinates loc3D = new WorldCoOrdinates();                     //get preset points important for game
    LevelValues gvg = MainView.gvg;                                      //get the values from VIEW to restart level
    CreateBox boxOP = new CreateBox();                                   //box factory
    ArrayList<Enemy> enemy = new ArrayList<>();                          //array of current enemies

    public ArrayList<Enemy> initLevel() {

        startP3d = loc3D.getStartLocationsInvaders(gvg.getNumEnimies());
        for (int i = 0; i < gvg.getNumEnimies(); i++) {
            Enemy Menemy = new Enemy(startP3d.get(i), gvg.getXvelocity(), gvg.getYvelocity(), gvg.getZvelocity(), 10, 10);
            Menemy.setMinv(boxOP.singleEnemyBox((int) startP3d.get(i).getX(), (int) startP3d.get(i).getY(), (int) startP3d.get(i).getZ(), 60, 20, 60));
            enemy.add(Menemy);
        }
        return enemy;
    }
}
