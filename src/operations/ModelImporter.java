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

    private TdsModelImporter tmi = new TdsModelImporter();
    private static final String MESH_FILENAME =
            "/Users/lilyshard/Downloads/Perfect Diamond/Perfect Diamond.STL";

    private static final Color jewelColor = Color.rgb(0, 190, 222);


    static MeshView[] loadMeshViews() {
        StlMeshImporter importer = new StlMeshImporter();
        importer.read("C:\\Users\\Liandri\\Downloads\\models\\BMO.stl");
        Mesh mesh = importer.getImport();

        return new MeshView[]{new MeshView(mesh)};
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
                    modelUrl = this.getClass().getResource("/models/crate1.obj");            //reward crate
                    break;
                case 8:
                    modelUrl = this.getClass().getResource("/models/glassDoor.obj");         //reward parachute
                    break;
                case 9:
                    modelUrl = this.getClass().getResource("/models/glassDoor.obj");         //sheild
                    break;
                case 10:
                    modelUrl = this.getClass().getResource("/models/tankshell.obj");      //tank reward shell
                    break;
                case 11:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 12:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 13:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 14:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 15:
                    modelUrl = this.getClass().getResource("/models/aliens_apc.obj");
                    break;
                case 16:
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
