package operations;


import com.interactivemesh.jfx.importer.ImportException;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import com.interactivemesh.jfx.importer.tds.TdsModelImporter;
import com.sun.javafx.tk.Toolkit;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.MeshView;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.io.File;
import java.net.URL;


/**
 * Created by Liandri on 25/09/2016.
 */
public class ModelImporter {

    TdsModelImporter tmi = new TdsModelImporter();
    private static final String MESH_FILENAME =
            "/Users/lilyshard/Downloads/Perfect Diamond/Perfect Diamond.STL";

    private static final double MODEL_SCALE_FACTOR = 400;
    private static final double MODEL_X_OFFSET = 0; // standard
    private static final double MODEL_Y_OFFSET = 0; // standard

    private static final int VIEWPORT_SIZE = 800;

    private static final Color lightColor = Color.rgb(244, 255, 250);
    private static final Color jewelColor = Color.rgb(0, 190, 222);

    public Node[] importObj() {
        Group imp = new Group();
        Node[] objMesh = null;
        try {
            ObjModelImporter objImporter = new ObjModelImporter();
            objImporter.read("C:\\Users\\Liandri\\workspace - Copy\\Box\\src\\models\\apc\\Aliens_APC.obj");
            // C:\Users\Liandri\workspace - Copy\Box\src\models\apc\Aliens_APC.obj
            objMesh = objImporter.getImport();
            objImporter.close();
            System.out.println("import success");
        } catch (Exception e) {
            System.out.println("model importer exception");
            System.out.println(e);
        }
        return objMesh;
    }

    static MeshView[] loadMeshViews() {
        File file = new File(MESH_FILENAME);
        StlMeshImporter importer = new StlMeshImporter();
        importer.read("C:\\Users\\Liandri\\Downloads\\models\\BMO.stl");
        Mesh mesh = importer.getImport();

        return new MeshView[]{new MeshView(mesh)};
    }

    public Group buildScene() {

        MeshView[] meshViews = loadMeshViews();
        for (int i = 0; i < meshViews.length; i++) {
            //meshViews[i].setTranslateX(VIEWPORT_SIZE / 2 + MODEL_X_OFFSET);
            //meshViews[i].setTranslateY(VIEWPORT_SIZE / 2 + MODEL_Y_OFFSET);
            //meshViews[i].setTranslateZ(VIEWPORT_SIZE / 2);
           // meshViews[i].setScaleX(MODEL_SCALE_FACTOR);
            //meshViews[i].setScaleY(MODEL_SCALE_FACTOR);
            //meshViews[i].setScaleZ(MODEL_SCALE_FACTOR);

            PhongMaterial sample = new PhongMaterial(jewelColor);
            //sample.setSpecularColor(lightColor);
            //sample.setSpecularPower(16);
            meshViews[i].setMaterial(sample);

            //meshViews[i].getTransforms().setAll(new Rotate(38, Rotate.Z_AXIS), new Rotate(20, Rotate.X_AXIS));
        }
        return new Group(meshViews);
    }

    public MeshView[] makeMesh(int modelNum){
        ObjModelImporter objImporter = new ObjModelImporter();
        URL modelUrl=  null;
        try {
            switch (modelNum){
                case 0:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");      //battle tank
                    break;
                case 1:
                    modelUrl = this.getClass().getResource("/models/tank.obj");         //tank
                    break;
                case 2:
                    modelUrl = this.getClass().getResource("/models/avmt300.obj");      //missle
                    break;
                case 3:
                    modelUrl = this.getClass().getResource("/models/space_invader.obj");   //invaer 1
                    break;
                case 4:
                    modelUrl = this.getClass().getResource("/models/UFO.obj");      //ufo
                    break;
                case 5:
                    modelUrl = this.getClass().getResource("/models/pjs_aircraft_bomb.obj");   //invader bomb
                    break;
                case 6:
                    modelUrl = this.getClass().getResource("/models/mediumblast.obj");         //invader bomb blast
                    break;
                case 7:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 8:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 9:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 10:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 11:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                default:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
            }
            objImporter.read(modelUrl);
            //System.out.println("obj import success!!!!!!!");
        }
        catch (ImportException e) {

            System.out.println("error in makemesh modelImporter "+ e);
        }
        MeshView[] meshViews = objImporter.getImport();

        return meshViews;
    }
}
