package operations;

import gameValues.LevelValues;
import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;


/**
 * Created by Liandri on 21/09/2016.
 */
public class Update {
    LevelValues lv = new LevelValues();
    ArrayList<Group> remove = new ArrayList<>();                          //array of enemies to be removed on the next loop
    ArrayList<Node> removebomb = new ArrayList<>();                      //array of bombs to remove on the next loop

    public ArrayList<Enemy> moveEnemies(ArrayList<Enemy> enemies) {
        Group inv;

        for(int i=0;i<enemies.size();i++){
            inv = enemies.get(i).getGroup();
            for(int j=0;j<inv.getChildren().size();j++){
                Node current = inv.getChildren().get(j);
                current.setTranslateX(current.getTranslateX()+lv.getXvelocity());
                current.setTranslateY(current.getTranslateY()+lv.getYvelocity());
                current.setTranslateZ(current.getTranslateZ()+lv.getZvelocity());
            }

        }
        return enemies;
    }
    /**
     * this method is to update the location of the bullets after they are fired from the tank
     * it moves the location of the bullet by an offset called bulletSpeed
     * bulletSpeed is in gameValuesYOURNAME along with all other values that can be set
     * @param bulletGroup
     */
    public void updateBullets(Group bulletGroup){
        for(int i =0;i<bulletGroup.getChildren().size();i++){
            bulletGroup.getChildren().get(i).setTranslateY(bulletGroup.getChildren().get(i).getTranslateY()-lv.getBulletSpeed());
        }
    }
    public ArrayList<Enemy> bulletColision(ArrayList<Enemy> enemies, Group bullet){
        Node bull;
        Node brick;
        Group inv;
        for(int i =0;i<enemies.size();i++){                                                    //loop size of enemy array
            inv =enemies.get(i).getGroup();                                                    //get group from each enemy
            for(int x = 0;x<inv.getChildren().size();x++){                                     //loop size of each invader
                brick = inv.getChildren().get(x);                                              //get each node from each invader
                for(int j=0;j<bullet.getChildren().size();j++){                                //loop through each bullet
                    bull = bullet.getChildren().get(j);                                        //get each bullet from group
                    if(brick.getBoundsInParent().intersects(bull.getBoundsInParent())) {       //collision detection
                        enemies.get(i).setAlive(false);
                    }
                }
            }
        }
     return enemies;
    }


}
