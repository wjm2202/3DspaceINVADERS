package operations;


import javafx.geometry.Point3D;
import javafx.scene.Group;

/**
 * this class makes completed 3D objects ready for scenes
 * Created by Liandri on 27/09/2016.
 */
public class MakeAssets {
    private CreateBox boxOP = new CreateBox();
    private RotateElements re = new RotateElements();
    private  ScaleElements se = new ScaleElements();

    /**
     * testing for make a sheild object
     * @param location
     * @return
     */
    public Group makeSheild(Point3D location){
        //makeModel(model number, texture number);
        Group sheildGroup = boxOP.makeModel(9, 8);
        sheildGroup.setTranslateX(location.getX());
        sheildGroup.setTranslateY(location.getY());
        sheildGroup.setTranslateZ(location.getZ());
        se.scaleAll(sheildGroup,10.0);
        re.rotateVert(sheildGroup, 90);
        return sheildGroup;
    }

    /**
     * make a finished bomb object ready for scene
     * @param location
     * @return
     */
    public Group makeBomb(Point3D location){
        Group missleGroup = boxOP.makeModel(5, 16);
        missleGroup.setTranslateX(location.getX());
        missleGroup.setTranslateY(location.getY());
        missleGroup.setTranslateZ(location.getZ());
        se.scaleAll(missleGroup,10.0);
        return missleGroup;
    }

    /**
     * make a reward object ready for scene
     * @param location
     * @return
     */
    public Group makeReward(Point3D location){
        Group reward = boxOP.makeModel(10, 16);
        reward.setTranslateX(location.getX());
        reward.setTranslateY(location.getY());    //height
        reward.setTranslateZ(location.getZ());
        se.scaleAll(reward,8.0);
        return reward;
    }

    /**
     * make an explosion for when a bomb explodes
     * @param location
     * @return
     */
    public Group makeBombExplosion(Point3D location){
        Group explosionGroup = boxOP.makeModel(6, 15);
        explosionGroup.setTranslateX(location.getX());
        explosionGroup.setTranslateY(location.getY());
        explosionGroup.setTranslateZ(location.getZ());
        se.scaleAll(explosionGroup,40.0);
        return explosionGroup;
    }

    /**
     * create a finished missle ready for scene
     * @param location
     * @return
     */
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

    /**
     * test object for invaders ready for scene
     * @param location
     * @return
     */
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

    /**
     * make old tank design possable use with two player
     * @param location
     * @return
     */
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
