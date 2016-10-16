package operations;


import application.MainView;
import com.interactivemesh.jfx.importer.ImportException;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import com.interactivemesh.jfx.importer.tds.TdsModelImporter;
import com.sun.javafx.tk.Toolkit;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
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
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSource;


/**
 * this class imports .obj mesh models ready for texturing
 * Created by Liandri on 25/09/2016.
 */
public class ModelImporter {

    ObjModelImporter objImporter = new ObjModelImporter();
    private TdsModelImporter tmi = new TdsModelImporter();
    private static final String MESH_FILENAME =
            "/Users/lilyshard/Downloads/Perfect Diamond/Perfect Diamond.STL";

    private static final Color jewelColor = Color.rgb(0, 190, 222);

    /**
     * testing method for viewing meshes
     * @return
     */
    static MeshView[] loadMeshViews() {
        StlMeshImporter importer = new StlMeshImporter();
        importer.read("C:\\Users\\Liandri\\Downloads\\models\\BMO.stl");
        Mesh mesh = importer.getImport();

        return new MeshView[]{new MeshView(mesh)};
    }

    /**
     * make the mesh selected by make asset class make model method
     * @param modelNum
     * @return
     */
    public MeshView[] makeMesh(int modelNum){
        URL modelUrl=  null;
        try {
            switch (modelNum){
                case 0:
                    modelUrl = this.getClass().getResource("/models/aliens_APC.obj");
                    break;
                case 1:
                    modelUrl = this.getClass().getResource("/models/Tank.obj");         //tank
                    break;
                case 2:
                    modelUrl = this.getClass().getResource("/models/AVMT300.obj");      //missle
                    break;
                case 3:
                    modelUrl = this.getClass().getResource("/models/Space_Invader.obj");   //invaer 1
                    break;
                case 4:
                    modelUrl = this.getClass().getResource("/models/UFO.obj");      //ufo
                    break;
                case 5:
                    modelUrl = this.getClass().getResource("/models/PJS_aircraft_bomb.obj");   //invader bomb
                    break;
                case 6:
                    modelUrl = this.getClass().getResource("/models/mediumblast.obj");         //invader bomb blast
                    break;
                case 7:
                    modelUrl = this.getClass().getResource("/models/Crate1.obj");            //reward crate
                    break;
                case 8:
                    modelUrl = this.getClass().getResource("/models/glassDoor.obj");         //reward parachute
                    break;
                case 9:
                    modelUrl = this.getClass().getResource("/models/GlassDoor.obj");         //sheild
                    break;
                case 10:
                    modelUrl = this.getClass().getResource("/models/Tankshell.obj");      //tank reward shell
                    break;
                case 11:
                    modelUrl = this.getClass().getResource("/models/Aliens_APC.obj");
                    break;
                case 12:
                    modelUrl = this.getClass().getResource("/models/Aliens_APC.obj");
                    break;
                case 13:
                    modelUrl = this.getClass().getResource("/models/Aliens_APC.obj");
                    break;
                case 14:
                    modelUrl = this.getClass().getResource("/models/Aliens_APC.obj");
                    break;
                case 15:
                    modelUrl = this.getClass().getResource("/models/Aliens_apc.obj");
                    break;
                case 16:
                    modelUrl = this.getClass().getResource("/models/Aliens_APC.obj");
                    break;
                default:
                    modelUrl = this.getClass().getResource("/models/Aliens_APC.obj");
                    break;
            }
           // System.out.println("obj import url string "+modelUrl);
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
