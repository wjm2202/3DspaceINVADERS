package operations;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;

/**
 * Created by Liandri on 27/09/2016.
 */
public class Asset {

    private double offsetXstart = 0.0;
    private double offsetYstart = 0.0;
    private double offsetZstart = 0.0;
    Rotate rX = new Rotate(0,0,0,50, Rotate.X_AXIS);
    Rotate rY = new Rotate(0,0,0,50, Rotate.Y_AXIS);
    Rotate rZ = new Rotate(0,0,0,50, Rotate.Z_AXIS);

    public Group getAssetModel() {
        return assetModel;
    }

    public void setAssetModel(Group assetModel) {
        this.assetModel = assetModel;
    }

    Group assetModel;

    public double getOffsetXstart() {
        return offsetXstart;
    }

    public void setOffsetXstart(double offsetXstart) {
        this.offsetXstart = offsetXstart;
    }

    public double getOffsetYstart() {
        return offsetYstart;
    }

    public void setOffsetYstart(double offsetYstart) {
        this.offsetYstart = offsetYstart;
    }

    public double getOffsetZstart() {
        return offsetZstart;
    }

    public void setOffsetZstart(double offsetZstart) {
        this.offsetZstart = offsetZstart;
    }





}
