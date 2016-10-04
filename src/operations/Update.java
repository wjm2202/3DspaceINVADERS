package operations;

import application.MainView;
import gameValues.LevelValues;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.Random;

import static application.MainView.gvg;


/**
 * Created by Liandri on 21/09/2016.
 */
public class Update {
    LevelValues lv = gvg;
    ArrayList<Enemy> remove = new ArrayList<>();                          //array of enemies to be removed on the next loop
    ArrayList<Node> removebomb = new ArrayList<>();                      //array of bombs to remove on the next loop
    Random rand = new Random();
    MakeAssets ma = new MakeAssets();



    public Group generateReward(){
        Group rewardGroup = new Group();
        int rewardNum = rand.nextInt(20);
        if(rewardNum==10) {
            rewardGroup = ma.makeReward(MainView.loc3D.getPoints());
        }
        return rewardGroup;
    }

    public void updateBombs(Group bombGroup){
        for(int i =0;i<bombGroup.getChildren().size();i++){
            bombGroup.getChildren().get(i).setTranslateY(bombGroup.getChildren().get(i).getTranslateY()+lv.getEnemyBombSpeed());
        }
    }

    public Point3D dropBombLocation(ArrayList<Enemy> enemies){
        int dropper = rand.nextInt(enemies.size());
        Point3D dropPoint = new Point3D(enemies.get(dropper).getGroup().getChildren().get(0).getTranslateX()-490,enemies.get(dropper).getGroup().getChildren().get(0).getTranslateY()-500,enemies.get(dropper).getGroup().getChildren().get(0).getTranslateZ()-1050);
        return dropPoint;
    }

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
            Node bull = bulletGroup.getChildren().get(i);
            if(bull.getTranslateY()  < -500){
                bulletGroup.getChildren().remove(i);
            }else{
                bulletGroup.getChildren().get(i).setTranslateY(bulletGroup.getChildren().get(i).getTranslateY()-lv.getBulletSpeed());
            }

        }
    }
    public void updateReward(Group rewardGroup){
        for(int i =0;i<rewardGroup.getChildren().size();i++){
          if((rewardGroup.getChildren().get(i).getTranslateY())< -60) {
                rewardGroup.getChildren().get(i).setTranslateY(rewardGroup.getChildren().get(i).getTranslateY()+10);
          }
        }
    }

    public ArrayList<Enemy> bulletCollision(ArrayList<Enemy> enemies, Group bullet){
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
                        remove.add(enemies.get(i));
                        MainView.se.invaderExplosion();
                        //bullet.getChildren().remove(bull);
                    }
                }
            }
        }
     return remove;
    }
    public ArrayList<Enemy> homingColision(ArrayList<Enemy> enemies, Group bullet){
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
    public int bombCollision(Group tank, Group bombs){
        int damage =0;
        for(int i =0;i<bombs.getChildren().size();i++){                                                    //loop size of enemy array
            Node bomb = bombs.getChildren().get(i);                                                    //get group from each enemy

            if(bomb.getBoundsInParent().intersects(tank.getBoundsInParent())) {       //collision detection
                damage +=gvg.getEnemyBombDamage();
                bombs.getChildren().remove(bomb);
                MainView.se.tankHit();
            }
        }
        return damage;
    }
    public Group bombColisionGround(Group bombs){
        int damage =0;
        Group explosion = new Group();
        for(int i =0;i<bombs.getChildren().size();i++){                                                    //loop size of enemy array
            Node bomb = bombs.getChildren().get(i);                                                    //get group from each enemy

            if(bomb.getTranslateY()>MainView.loc3D.getCase1().getY()-555) {
                Point3D expLoc = new Point3D(bombs.getChildren().get(i).getTranslateX(),bombs.getChildren().get(i).getTranslateY(),bombs.getChildren().get(i).getTranslateZ());
                bombs.getChildren().remove(bomb);
                explosion = ma.makeBombExplosion(expLoc);
                MainView.se.playBlast();
            }
        }
        return explosion;
    }
}
