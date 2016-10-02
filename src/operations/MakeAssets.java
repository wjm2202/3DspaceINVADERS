package operations;


import javafx.geometry.Point3D;
import javafx.scene.Group;

/**
 * Created by Liandri on 27/09/2016.
 */
public class MakeAssets {
    CreateBox boxOP = new CreateBox();
    RotateElements re = new RotateElements();
    ScaleElements se = new ScaleElements();

    public Group makeBomb(Point3D location){
        Group missleGroup = boxOP.makeModel(5, 16);
        missleGroup.setTranslateX(location.getX());
        missleGroup.setTranslateY(location.getY());
        missleGroup.setTranslateZ(location.getZ());
        se.scaleAll(missleGroup,10.0);
        return missleGroup;
    }
    public Group makeReward(Point3D location){
        Group reward = boxOP.makeModel(7, 16);
        reward.setTranslateX(location.getX()-500);
        reward.setTranslateY(location.getY()-535);    //height
        reward.setTranslateZ(location.getZ()-1050);
        se.scaleAll(reward,15.0);
        return reward;
    }
    public Group makeBombExplosion(Point3D location){
        Group explosionGroup = boxOP.makeModel(6, 15);
        explosionGroup.setTranslateX(location.getX());
        explosionGroup.setTranslateY(location.getY());
        explosionGroup.setTranslateZ(location.getZ());
        se.scaleAll(explosionGroup,40.0);
        return explosionGroup;
    }

    public Group makeMissle(Point3D location){
        Group missleGroup = boxOP.makeModel(2, 7);
        re.rotateLeft(missleGroup,45);
        re.rotateVert(missleGroup, 100);
        missleGroup.setTranslateX(location.getX());
        missleGroup.setTranslateY(location.getY());
        missleGroup.setTranslateZ(location.getZ());
        se.scaleAll(missleGroup,1.5);
        return missleGroup;
    }
    public Group makeInvader1(Point3D location){
        Group invader1Group = boxOP.makeModel(3, 6);
        //re.rotateLeft(invader1Group,45);
        //re.rotateVert(invader1Group, 100);
        invader1Group.setTranslateX(location.getX());
        invader1Group.setTranslateY(location.getY());
        invader1Group.setTranslateZ(location.getZ());
        //System.out.println(invader1Group.getRotationAxis());

        //se.scaleAll(invader1Group,0.5);
        return invader1Group;
    }
    public Group makeTank(Point3D location){
        Group tGroup = boxOP.makeModel(1, 12);
        re.rotateLeft(tGroup,45);
        //re.rotateVert(invader1Group, 100);
        tGroup.setTranslateX(location.getX());
        tGroup.setTranslateY(location.getY());
        tGroup.setTranslateZ(location.getZ());
        return tGroup;
    }
}
