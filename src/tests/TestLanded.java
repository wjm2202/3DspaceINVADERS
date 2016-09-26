package tests;

import javafx.geometry.Point3D;

import java.util.ArrayList;

/**
 * Created by Liandri on 26/09/2016.
 */
public class TestLanded {

    public boolean isLandError() {
        return landError;
    }

    public void setLandError(boolean landError) {
        this.landError = landError;
    }

    boolean landError = false;

    ArrayList<Point3D> landedTest = new ArrayList<>();
    public void landedTest(Point3D land){
        landedTest.add(land);
        landError = true;
    }
    public ArrayList<Point3D> getLandingErrors(){
        return landedTest;
    }
}
