package operations;

import javafx.scene.Group;

/**
 * This class contains the method used in order to create the 3D affect for the Invaders
 * Created by Jonathan on 20/09/2016.
 */
public class MegaInvader {

    public Group makeMega(int dSize, int xLocation, int yLocation, int zLocation) {

        CreateBox boxOP = new CreateBox();// needed in order to create the box
        Group firstLayer = new Group();   //these are the layers that creates the 3D effect, which are created on different location
        Group secondLayer = new Group();
        Group thirdLayer = new Group();
        Group invader3D = new Group();    //where all the layers of 'invaders' are added to, to make a full 3D invader

        //loop that creates multiple invader of the same type but moves along Z axis to create the 3D affect
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                firstLayer.getChildren().add(boxOP.invader(dSize, xLocation, yLocation, zLocation));
            } else if (i > 0 && i < 5) {
                zLocation = zLocation + 10; //move back on the axis and creating another replica of the invader to create 3D effect
                dSize = dSize + 3;
                secondLayer.getChildren().add(boxOP.invader(dSize, xLocation, yLocation, zLocation));
            } else {
                zLocation = zLocation + 10;
                dSize = dSize - 3;
                thirdLayer.getChildren().add(boxOP.invader(dSize, xLocation, yLocation, zLocation));
            }
        }
        invader3D.getChildren().addAll(firstLayer,secondLayer,thirdLayer);
        return invader3D;
    }

}
