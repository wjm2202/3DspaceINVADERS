package operations;

import javafx.geometry.Rectangle2D;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.stage.Screen;
/**
 * this class sets the lights in the 3D space so that objects can be seen
 * see GLEN if you want to change this class
 * but have a play with making a new light and place it some where
 * examples are below
 * @author Liandri
 *
 */
public class LightingElements {

	private Group lightGroup;
	private PointLight light;
	private PointLight light2;
	private PointLight light3;
	private AmbientLight light4;
	private AmbientLight light5;
	private AmbientLight light6;
	private AmbientLight light7;
	private int cx=0;
	private int cy=0;
	private int cz= -1000;
	private Rectangle2D screen = Screen.getPrimary().getVisualBounds();
	private double sW = screen.getMaxX();
	private double sH = screen.getMaxY();
	private double centX = screen.getMaxX()/2;
	private double centY = screen.getMaxY()/2;
	
	public LightingElements(){
		setUp();
	}
	public Group getLights(){
		return lightGroup;
	}
	public void setUp(){
		lightGroup = new Group();
		light = new PointLight();                 //add point of light x,y,z
		light.setTranslateX(350);
		light.setTranslateY(100);
		light.setTranslateZ(300);
		
		light2 = new PointLight();                 //add point of light x,y,z
		light2.setTranslateX(0);
		light2.setTranslateY(0);
		light2.setTranslateZ(0);
		
		light3 = new PointLight();                 //add point of light x,y,z
		light3.setTranslateX(500);
		light3.setTranslateY(325);
		light3.setTranslateZ(-600);
		
		light4 = new AmbientLight();                 //add point of light x,y,z
		light4.setTranslateX(0);
		light4.setTranslateY(0);
		light4.setTranslateZ(0);
		
		light5 = new AmbientLight();                 //add point of light x,y,z
		light4.setTranslateX(sW);
		light4.setTranslateY(sH);
		light4.setTranslateZ(cz+200);
		
		light6 = new AmbientLight();                 //add point of light x,y,z
		light4.setTranslateX(centX-500);
		light4.setTranslateY(centY-500);
		light4.setTranslateZ(cz);
		
		light7 = new AmbientLight();                 //add point of light x,y,z
		light4.setTranslateX(centX-500);
		light4.setTranslateY(centY-500);
		light4.setTranslateZ(cz+200);
	}
}
