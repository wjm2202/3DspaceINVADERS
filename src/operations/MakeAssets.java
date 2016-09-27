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


    public Group makeMissle(Point3D location){
        Group missleGroup = boxOP.makeModel(2, 7);
        re.rotateLeft(missleGroup,45);
        re.rotateVert(missleGroup, 100);
        missleGroup.setTranslateX(location.getX());
        missleGroup.setTranslateY(location.getY());
        missleGroup.setTranslateZ(location.getZ());
        se.scaleAll(missleGroup,0.9);
        return missleGroup;
    }
    public Group makeInvader1(Point3D location){
        Group invader1Group = boxOP.makeModel(3, 6);
        //re.rotateLeft(invader1Group,45);
        //re.rotateVert(invader1Group, 100);
        invader1Group.setTranslateX(location.getX());
        invader1Group.setTranslateY(location.getY());
        invader1Group.setTranslateZ(location.getZ());
        //se.scaleAll(invader1Group,0.5);
        return invader1Group;
    }
}
