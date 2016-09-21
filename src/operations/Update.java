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
    ArrayList<Node> remove = new ArrayList<>();                          //array of enemies to be removed on the next loop
    ArrayList<Node> removebomb = new ArrayList<>();                      //array of bombs to remove on the next loop

    public void moveEnemies(ArrayList<Enemy> enemies) {
        Node inv;
        for(int i=0;i<enemies.size();i++){
            inv = enemies.get(i).getNode();
            inv.setTranslateX(inv.getTranslateX()+lv.getXvelocity());
            inv.setTranslateY(inv.getTranslateY()+lv.getYvelocity());
            inv.setTranslateZ(inv.getTranslateZ()+lv.getZvelocity());
        }
    }
    public void moveBullets(Group bullets){
        Node bull;
        for(int i=0;i<bullets.getChildren().size();i++){
            bull = bullets.getChildren().get(i);
            bull.setTranslateY(bull.getLayoutY()+lv.getBulletSpeed());
        }
    }
    public ArrayList<Enemy> bulletColision(ArrayList<Enemy> invader, Group bullet){
        Node bull;
        Node inv;
        for(int i =0;i<invader.size();i++){
            inv =invader.get(i).getNode();
            for(int j=0;j<bullet.getChildren().size();j++){
                bull = bullet.getChildren().get(i);
                if(inv.getBoundsInParent().intersects(bull.getBoundsInParent())) {//collision detection
                    remove.add(inv);
                }
            }
        }
        for(int i=0;i<remove.size();i++){
            invader.remove(remove.get(i));
        }
     return invader;
    }

}
