package operations;

import application.MainView;
import application.Splash;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.Random;
/**
 * this class is the class that creates 3D object for use in your games
 * the classes are called from the MainView class or internally to make larger
 * groups of 3D objects as groups
 * @author Liandri
 *
 */
public class CreateBox {
	
	static Group invaderGroup;                                               //group invaders together 
	RotateElements re = new RotateElements();
	ModelImporter mi = MainView.mi;
	static WorldCoOrdinates wc;                                         //get world co-ordinate system
	static ArrayList<Point3D> bo = new ArrayList<>();                       //ArrayList of points of world boundary
	Random rand = new Random();
	Img img = MainView.img;


	/**
	 * constructor for box factory
	 */
	public CreateBox()
	{
		img.setupTextures();                                                    //apply images to textures
		wc = Splash.wc;
		bo = wc.getBounds();
		invaderGroup = new Group();
	}

	/**
	 * create corner markers
	 * @return
	 */
	public Group corners(){
		Group cnr = new Group();
		cnr.getChildren().add(makeConers(wc.case0.getX(),wc.case0.getY(),wc.case0.getZ(),5));
		cnr.getChildren().add(makeConers(wc.getCase1().getX(),wc.getCase1().getY(),wc.getCase1().getZ(),10));
		cnr.getChildren().add(makeConers(wc.getCase2().getX(),wc.getCase2().getY(),wc.getCase2().getZ(),10));
		cnr.getChildren().add(makeConers(wc.getCase3().getX(),wc.getCase3().getY(),wc.getCase3().getZ(),10));
		cnr.getChildren().add(makeConers(wc.getCase4().getX(),wc.getCase4().getY(),wc.getCase4().getZ(),10));
		cnr.getChildren().add(makeConers(wc.getCase5().getX(),wc.getCase5().getY(),wc.getCase5().getZ(),10));
		cnr.getChildren().add(makeConers(wc.getCase6().getX(),wc.getCase6().getY(),wc.getCase6().getZ(),10));
		cnr.getChildren().add(makeConers(wc.getCase7().getX(),wc.getCase7().getY(),wc.getCase7().getZ(),10));
		return cnr;
	}

/**
 * make a bullet for the tank to fire	
 * @param start
 * @return Cylinder object for tank to fire
 */
	public Cylinder bullet(Point3D start){
		Cylinder bull = new Cylinder(30,10,10);
		bull.setTranslateX(start.getX());                            //set x location
		bull.setTranslateY(start.getY());                             //set y location
		bull.setTranslateZ(start.getZ());
		bull.setMaterial(img.getTexture(14));               //set light side texture
		return bull;
	}
/**
 * create the box that is textured with the horizon	
 * @return box set to location of horizon
 */
	public Box horizon(){
		Box horizion = new Box(7000,4000,5);
		horizion.setTranslateX(480);                            //set x location
		horizion.setTranslateY(100);                             //set y location
		horizion.setTranslateZ(2500);
		horizion.setMaterial(img.getTexture(11));               //set light side texture
		return horizion;
	}
/**
 * make the ground scene	
 * @return box set to location of ground
 */
	public Box ground(){
		Box ground = new Box(4500,5,2400);
		ground.setTranslateX(480);                            //set x location
		ground.setTranslateY(1200);                             //set y location
		ground.setTranslateZ(1200);
		ground.setMaterial(img.getTexture(13));
		return ground;
	}

	/**
	 * corner markers
	 * @param x
	 * @param y
	 * @param z
	 * @param sizeX
	 * @return
	 */
	public Cylinder makeConers(double x, double y, double z, double sizeX){
		Cylinder boarderBox = new Cylinder(sizeX, sizeX);                  //make 3D box
		boarderBox.setTranslateX(x);                            //set x location
		boarderBox.setTranslateY(y);                             //set y location
		boarderBox.setTranslateZ(z); 
		boarderBox.setMaterial(img.getTexture(14));               //set light side texture

		return boarderBox;
		
	}

	/**
	 * make 3D models with shape and skin
	 * @param modelNumber
	 * @param skinNum
	 * @return
	 */
	public Group makeModel(int modelNumber, int skinNum){
		Group beast = new Group();
		MeshView[] mv = mi.makeMesh(modelNumber);
		//System.out.println("before test object mi.size "+mv.length);

		for (int i = 0; i < mv.length; i++) {
			mv[i].setTranslateX(500);                  //was 500
			mv[i].setTranslateY(535);                  //was 535
			mv[i].setTranslateZ(1050);                 //was 1050
			mv[i].setScaleX(2.0);
			mv[i].setScaleY(2.0);
			mv[i].setScaleZ(2.0);

			PhongMaterial sample = new PhongMaterial(Color.BEIGE);
			sample.setSpecularColor(Color.ALICEBLUE);
			sample.setSpecularPower(16);
			mv[i].setMaterial(img.getTexture(skinNum));
			beast.getChildren().add(mv[i]);

		}
		return beast;
	}

	/**
	 * old invader for testing purposes
	 * @param modelNumber
	 * @param skinNum
	 * @param start
	 * @return
	 */
	public Group makeInvader(int modelNumber, int skinNum, Point3D start){
		Group beast = new Group();
		MeshView[] mv = mi.makeMesh(modelNumber);
		//System.out.println("before test object mi.size "+mv.length);

		for (int i = 0; i < mv.length; i++) {
			mv[i].setTranslateX(start.getX());
			mv[i].setTranslateY(start.getY());
			mv[i].setTranslateZ(start.getZ());
			mv[i].setScaleX(2.0);
			mv[i].setScaleY(2.0);
			mv[i].setScaleZ(2.0);

			PhongMaterial sample = new PhongMaterial(Color.BEIGE);
			sample.setSpecularColor(Color.ALICEBLUE);
			sample.setSpecularPower(16);
			mv[i].setMaterial(img.getTexture(skinNum));
			beast.getChildren().add(mv[i]);

		}
		re.rotateLeft(beast,135.0);
		return beast;
	}

	/**
	 * create mouse pointer shapes for boundry tests pre junit 4 method
	 * @param xloc
	 * @param yloc
	 * @param zloc
	 * @return
	 */
	public Group poly(double xloc, double yloc, double zloc){

		Group g = new Group();

		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(0.0, 0.0,
				20.0, 10.0,
				10.0, 20.0);
		polygon.setTranslateX(xloc);
		polygon.setTranslateY(yloc);
		polygon.setTranslateZ(zloc);
		g.getChildren().add(polygon);
		return g;
	}
/**
 * make a single square box and return to caller (make tank)	
 * @param x    the location on the x axis the box will be
 * @param y    the location on the y axis the box will be
 * @param z    the location on the z axis the box will be
 * @param boxSize    the height width and length of the box made
 * @return  3D box at the location of x,y,z
 */
	public Box singleBox(int x, int y, int z, int boxSize){
		Box boarderBox = new Box(boxSize, boxSize, boxSize);                  //make 3D box
		boarderBox.setTranslateX(x);                            //set x location
		boarderBox.setTranslateY(y);                             //set y location
		boarderBox.setTranslateZ(z); 
		boarderBox.setMaterial(img.getTexture(13));               //set light side texture
		return boarderBox;
		
	}

	/**
	 * This the method that creates the 3D box environment where all the game play occurs
	 * @return It returns the 3D box created and added to the scene.
	 */

	public Group gameBox()
	{
		Group boarderGroup = new Group();
		int[] sequence = {1,2,3,4};  // The sequence of how the box is drawn
		Box leftBox = new Box(3, 500, 495); // These are the boxes that forms up the 3D box environment
		Box rightBox = new Box(3, 500, 495);
		Box topBox = new Box(990, 5, 495);
		Box groundBox = new Box(990, 5, 495);

		int startZ = (((int)bo.get(4).getZ() - (int)bo.get(0).getZ()) / 2) + (int)bo.get(0).getZ(); // This value is fixed
		int startX = 0;
		int startY = 0;

		for(int i = 0; i < 3; i++)                    //changes for testing from 4 t0 3
		{
			switch(sequence[i])
			{
				case 1:
					startX = (int)bo.get(0).getX();
					startY = 250; 					// from the World coordination(case(1)-case(0)) / 2
					leftBox.setTranslateX(startX);  // This is the left side of the box
					leftBox.setTranslateY(startY);
					leftBox.setTranslateZ(startZ);
					leftBox.setMaterial(img.getTexture(2));
					boarderGroup.getChildren().add(leftBox);
					break;
				case 2:
					startX = ((int)bo.get(2).getX()-(int)bo.get(0).getX()) / 2;
					startY += 250; 					//goes to the ground floor
					//groundBox.setMaterial(img.getTexture(15)); //pasting the image on the ground 3D box
                    groundBox.setTranslateX(startX);// This is the ground side of the box
					groundBox.setTranslateY(startY);
					groundBox.setTranslateZ(startZ);
					groundBox.setMaterial(img.getTexture(2));
					boarderGroup.getChildren().add(groundBox);
					break;
				case 3:
					startX += ((int)bo.get(2).getX()-(int)bo.get(0).getX()) / 2;
					startY = startY - 250;
					rightBox.setTranslateX(startX); // This is the right side of the box
					rightBox.setTranslateY(startY);
					rightBox.setTranslateZ(startZ);
					rightBox.setMaterial(img.getTexture(2));
					boarderGroup.getChildren().add(rightBox);
					break;
				case 4:
					startY = 0;
					startX = ((int)bo.get(3).getX()- (int)bo.get(0).getX()) / 2;
					topBox.setTranslateX(startX); // This is the top side of the box
					topBox.setTranslateY(startY);
					topBox.setTranslateZ(startZ);
					topBox.setMaterial(img.getTexture(2));
					boarderGroup.getChildren().add(topBox);
					break;
			}

		}
		return boarderGroup;
	}

/**
 * this method allows for different ground textures to used for different games or levels
 * it is hard coded to the size of the 3D box that the games are in	
 * @param x            do not change
 * @param y            do not change
 * @param z            do not change
 * @param boxSizeX     do not change
 * @param boxSizeY     do not change
 * @param boxSizeZ     do not change
 * @param imgNum       change to different textures for ground image
 * @return 3D box in the location of the ground
 */
	public Box groundBox(int x, int y, int z, int boxSizeX,int boxSizeY,int boxSizeZ, int imgNum){
		Box boarderBox = new Box(boxSizeX, boxSizeY, boxSizeZ);                  //make 3D box
		boarderBox.setTranslateX(x);                            //set x location
		boarderBox.setTranslateY(y);                             //set y location
		boarderBox.setTranslateZ(z); 
		PhongMaterial pm3 = new PhongMaterial();  //texture material
		pm3.setDiffuseColor(Color.BEIGE);        //set dark side color
		Image imgcurr = img.getImg(1);
		switch(imgNum){                                //randomly pick a texture to use
		case 1:
			imgcurr = img.getImg(1);break;
		case 2:
			imgcurr = img.getImg(2);break;
		case 3:
			imgcurr = img.getImg(3);break;
		case 4:
			imgcurr = img.getImg(4);break;
		case 5:
			imgcurr = img.getImg(5);break;
		case 6:
			imgcurr = img.getImg(6);break;
		case 7:
			imgcurr = img.getImg(7);break;
		case 8:
			imgcurr = img.getImg(8);break;
		case 9:
			imgcurr = img.getImg(9);break;
		case 10:
			imgcurr = img.getImg(10);break;
		case 11:
			imgcurr = img.getImg(12);break;	
		}
		pm3.setDiffuseMap(imgcurr);                //add texture to box on light side
		boarderBox.setMaterial(pm3);               //set light side texture
		return boarderBox;
	}
/**
 *
 * create a single enemy box called in a loop from main, its location is predefined
 *  to be inside the 3D world. change the number of enemies in the GameValuesYOURNAME class to
 *  increase decrease the number created	
 * @param x             predefined in WorldCoOrdinates class
 * @param y             predefined in WorldCoOrdinates class
 * @param z             predefined in WorldCoOrdinates class
 * @param bX            predefined in GameValuesInvader class
 * @param bY            predefined in GameValuesInvader class
 * @param bZ            predefined in GameValuesInvader class
 * @return              3D box to add to enemy ArrayList
 */
	public Group singleEnemyBox(int x, int y, int z, int bX, int bY, int bZ){
		Group boxHolder = new Group();
		Box boarderBox = new Box(bX, bY, bZ);                  //make 3D box
		boarderBox.setTranslateX(x);                            //set x location
		boarderBox.setTranslateY(y);                             //set y location
		boarderBox.setTranslateZ(z); 
		PhongMaterial pm3 = new PhongMaterial();  //texture material
		pm3.setDiffuseColor(Color.BEIGE);        //set dark side color
		int tex = rand.nextInt(10)+1;
		Image imgcurr = img.getImg(1);
		switch(tex){                                //randomly pick a texture to use
		case 1:
			imgcurr = img.getImg(1);break;
		case 2:
			imgcurr = img.getImg(2);break;
		case 3:
			imgcurr = img.getImg(3);break;
		case 4:
			imgcurr = img.getImg(4);break;
		case 5:
			imgcurr = img.getImg(5);break;
		case 6:
			imgcurr = img.getImg(6);break;
		case 7:
			imgcurr = img.getImg(7);break;
		case 8:
			imgcurr = img.getImg(8);break;
		case 9:
			imgcurr = img.getImg(9);break;
		case 10:
			imgcurr = img.getImg(10);break;
		}
		pm3.setDiffuseMap(imgcurr);                //add texture to box on light side
		boarderBox.setMaterial(pm3);               //set light side texture
		boxHolder.getChildren().add(boarderBox);
		return boxHolder;
		
	}

/**
 * create the game box that the enemies are inside of
 * DO NOT CHANGE ANYTHING IN THIS METHOD
 * talk to glen if you need to make cjhanges here	
 * @param root
 * @param xR
 * @param yR
 * @param zR
 * @param bS
 */
	public Group gameBound(Group root, int xR, int yR, int zR, int bS){                  //build the boarder for the 3D game
		//size 5
		Group boarderGroup = new Group();
		int[] boarder  =  {3,10,9,11,12,8,10,9,11,1,12,2,12,3,12,14};                   //switch pattern move to location draw line, move draw, move draw
		int startX = xR;
		int startY = yR;
		int startZ = zR;
		int boxSize = 5;

		for(int x =0; x<16;x++){        //25
			Box temp = new Box();
			switch(boarder[x]){
			case 0:                                                                  //move to top left front corner
				startX = (int)bo.get(0).getX();
				startY = (int)bo.get(0).getY();
				startZ = (int)bo.get(0).getZ();
				break;
			case 1:                                                                  //move to bottom left front corner
				startX = (int)bo.get(1).getX();
				startY = (int)bo.get(1).getY();
				startZ = (int)bo.get(1).getZ();
				break;
			case 2:                                                                  //move to bottom right front corner
				startX = (int)bo.get(2).getX();
				startY = (int)bo.get(2).getY();
				startZ = (int)bo.get(2).getZ();
				break;
			case 3:                                                                  //move to top right front corner
				startX = (int)bo.get(3).getX();
				startY = (int)bo.get(3).getY();
				startZ = (int)bo.get(3).getZ();
				break;
			case 4:                                                                  //move to top right back corner
				startX = (int)bo.get(4).getX();
				startY = (int)bo.get(4).getY();
				startZ = (int)bo.get(4).getZ();
				break;
			case 5:                                                                  //move to bottom left back corner
				startX = (int)bo.get(5).getX();
				startY = (int)bo.get(5).getY();
				startZ = (int)bo.get(5).getZ();
				break;
			case 6:                                                                  //move to bottom right back corner
				startX = (int)bo.get(6).getX();
				startY = (int)bo.get(6).getY();
				startZ = (int)bo.get(6).getZ();
				break;
			case 7:                                                                  //move to top right back corner
				startX = (int)bo.get(7).getX();
				startY = (int)bo.get(7).getY();
				startZ = (int)bo.get(7).getZ();
				break;
			case 8:                                                                   //draw line of boxes left to right
				for(int i =0;i<wc.getWorldWidth();i++){
					temp = singleBox(startX, startY, startZ, boxSize);
					boarderGroup.getChildren().add(temp);
					startX +=5;
				}
				break;
			case 9:                                                                    //draw line of boxes right to left
				for(int i =0;i<wc.getWorldWidth();i++){
					temp = singleBox(startX, startY, startZ, boxSize);
					boarderGroup.getChildren().add(temp);
					startX -=5;
				}
				break;
			case 10:                                                                    //draw line of boxes top to bottom
				for(int i =0;i<wc.getWorldHeight();i++){
					temp = singleBox(startX, startY, startZ, boxSize);
					boarderGroup.getChildren().add(temp);
					startY +=5;
				}
				break;
			case 11:                                                                   //draw line of boxes bottom to top    
				for(int i =0;i<wc.getWorldHeight();i++){
					temp = singleBox(startX, startY, startZ, boxSize);
					boarderGroup.getChildren().add(temp);
					startY -=5;
				}
				break;
			case 12:                                                                   //draw line of boxes front to back
				for(int i =0;i<wc.getWorldDepth();i++){
					temp = singleBox(startX, startY, startZ, boxSize);
					boarderGroup.getChildren().add(temp);
					startZ +=5;
				}
				break;
			case 13:                                                                  //draw line of boxes back to front
				for(int i =0;i<wc.getWorldDepth();i++){
					temp = singleBox(startX, startY, startZ, boxSize);
					boarderGroup.getChildren().add(temp);
					startZ -=5;
				}
				break;
			case 14:                                                                 //draw ground box
				startX = (int)bo.get(5).getX()+500;
				startY = (int)bo.get(5).getY();
				startZ = (int)bo.get(5).getZ();
				startZ+=5;
				startX+=5;
	     		Box randBox = new Box(990, 5, 495);                  //make 3D box
				randBox.setTranslateX(startX-5);                            //set x location
				randBox.setTranslateY(startY);                             //set y location
				randBox.setTranslateZ(startZ-250); 
				PhongMaterial texMat = new PhongMaterial();  //texture material
				texMat.setDiffuseColor(Color.BEIGE);        //set dark side color
				texMat.setDiffuseMap(img.getImg(3));                //add texture to box on light side
				randBox.setMaterial(texMat);               //set light side texture
				boarderGroup.getChildren().add(randBox);             

			}
		}
		return boarderGroup;	
	}

/**
 * OLD UNUSED method for testing
 * this method generates a single invader from an array pattern
 * it returns a group to the caller in the shape of a single invader	
 * @param root
 * @param image5
 * @param boxSize
 * @param curX
 * @param curY
 */
	public Group invader(Group root, Image image5,int boxSize, int curX, int curY, int curZ){    //make individual invaders
		Group invaderGroup = new Group();
		int[][] shape  = {{0,0,0,0,0,0,0,0}                                           //pattern for switch to make each invader
		                 ,{0,0,0,0,0,0,0,0}
		                 ,{0,0,0,0,0,0,0,0}
		                 ,{0,1,1,1,1,1,1,0}
		                 ,{0,1,0,0,0,0,1,0}
		                 ,{0,1,0,1,1,0,1,0}
		                 ,{1,0,0,0,0,0,0,1}
		                 ,{1,0,0,0,0,0,0,1}};
		int currX = curX;
		int currY = curY;
		int currZ = curZ;
		for(int x =0;x<8;x++){              //rows y down
			for(int y=0;y<8;y++){           //rows x across
				switch(shape[x][y]){
				case 1:                                                           //if the array has a 1 do this
					Box textbox6 = new Box(boxSize, boxSize, boxSize);                  //make 3D box
					textbox6.setTranslateX(currX);                            //set x location
					textbox6.setTranslateY(currY);                             //set y location
					textbox6.setTranslateZ(currZ-500); 
					textbox6.setMaterial(img.getTexture(4));               //set light side texture
					invaderGroup.getChildren().add(textbox6);
					break;
				case 0:                                                        //if the array has a 0 do nothing (space)
					break;
				}
				currX+=10;                                                    //move to next block location
			}	
			currX-=80;                                                        //got to new line of blocks
			currY+=10;
		}
		return invaderGroup;
	}

    /**
     * OLD UNUSED method for testing
     * this method generates a single invader from an array pattern
     * it returns a group to the caller in the shape of a single invader
     * @param curZ
     * @param boxSize
     * @param curX
     * @param curY
     */
    public Group invader(int boxSize, int curX, int curY, int curZ){    //make individual invaders
        Group is = new Group();
        int[][] shape  = {
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
                {0,0,1,1,1,0,1,1,1,1,0,1,1,1,0,0},
                {0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0},
                {0,1,1,1,0,0,0,1,1,0,0,0,1,1,1,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1}};

        int currX = curX;
        int currY = curY;
        int currZ = curZ;
        for(int x =0;x<16;x++){              //rows y down
            for(int y=0;y<16;y++){           //rows x across
                switch(shape[x][y]){
                    case 1:                                                           //if the array has a 1 do this
                        Box textbox6 = new Box(boxSize, boxSize, boxSize);                  //make 3D box
                        textbox6.setTranslateX(currX);                            //set x location
                        textbox6.setTranslateY(currY);                             //set y location
                        textbox6.setTranslateZ(currZ);
                        textbox6.setMaterial(img.getTexture(15));   //pasting image to the 3D box created
                        is.getChildren().add(textbox6);
                        break;
                    case 0:                                                        //if the array has a 0 do nothing (space)
                        break;
                }
                currX+=10;                                                    //move to next block location
            }
            currX-=160;                                                        //got to new line of blocks
            currY+=10;
            curZ += 10;
        }
        return is;
    }
    //invader type 2
    public Group invader2(Group root, int boxSize, int curX, int curY, int curZ){    //make individual invaders
        Group is = new Group();
        int[][] shape  = {
                {0,0,1,1,1,1,1,0,0},
                {0,1,0,0,1,0,0,1,0},
                {1,0,0,1,1,1,0,0,1},
                {1,0,1,0,0,0,1,0,1},
                {0,1,0,0,0,0,0,1,0},
                {0,0,0,1,1,1,0,0,0},
                {0,0,0,0,1,0,0,0,0},
                {1,0,0,0,0,0,0,0,1},
                {1,1,0,0,0,0,0,1,1}};

        int currX = curX;
        int currY = curY;
        int currZ = curZ;
        for(int x =0;x<9;x++){              //rows y down
            for(int y=0;y<9;y++){           //rows x across
                switch(shape[x][y]){
                    case 1:                                                           //if the array has a 1 do this
                        Box textbox6 = new Box(boxSize, boxSize, boxSize);                  //make 3D box
                        textbox6.setTranslateX(currX);                            //set x location
                        textbox6.setTranslateY(currY);                             //set y location
                        textbox6.setTranslateZ(currZ);
                        is.getChildren().add(textbox6);
                        break;
                    case 0:                                                        //if the array has a 0 do nothing (space)
                        break;
                }
                currX+=10;                                                    //move to next block location
            }
            currX-=90;                                                        //got to new line of blocks
            currY+=10;
            curZ += 10;
        }
        return is;
    }
    //invader type 3
    public Group invader3(Group root, int boxSize, int curX, int curY, int curZ){    //make individual invaders
        Group is = new Group();
        int[][] shape  = {
                {0,1,0,0,0,1,1,0,0,0,1,0},
                {1,0,0,0,1,0,0,1,0,0,0,1},
                {1,1,1,1,1,0,0,1,1,1,1,1},
                {1,0,0,0,1,0,0,1,0,0,0,1},
                {0,1,0,0,0,1,1,0,0,0,1,0}};

        int currX = curX;
        int currY = curY;
        int currZ = curZ;
        for(int x =0;x<5;x++){              //rows y down
            for(int y=0;y<12;y++){           //rows x across
                switch(shape[x][y]){
                    case 1:                                                           //if the array has a 1 do this
                        Box textbox6 = new Box(boxSize, boxSize, boxSize);                  //make 3D box
                        textbox6.setTranslateX(currX);                            //set x location
                        textbox6.setTranslateY(currY);                             //set y location
                        textbox6.setTranslateZ(currZ);
                        is.getChildren().add(textbox6);
                        break;
                    case 0:                                                        //if the array has a 0 do nothing (space)
                        break;
                }
                currX+=10;                                                    //move to next block location
            }
            currX-=120;                                                        //got to new line of blocks
            currY+=10;
            curZ += 10;
        }
        return is;
    }

    //invader type 4
    public Group invader4(Group root, int boxSize, int curX, int curY, int curZ){    //make individual invaders
        Group is = new Group();
        int[][] shape  = {
                {0,0,0,1,1,0,0,0},
                {0,0,0,1,1,0,0,0},
                {0,0,1,0,0,1,0,0},
                {0,1,0,1,1,0,1,0},
                {0,0,1,0,0,1,0,0},
                {1,0,0,1,1,0,0,1},
                {1,1,0,1,1,0,1,1},
                {0,0,1,0,0,1,0,0},
                {0,0,0,1,1,0,0,0}};

        int currX = curX;
        int currY = curY;
        int currZ = curZ;
        for(int x =0;x<9;x++){              //rows y down
            for(int y=0;y<8;y++){           //rows x across
                switch(shape[x][y]){
                    case 1:                                                           //if the array has a 1 do this
                        Box textbox6 = new Box(boxSize, boxSize, boxSize);                  //make 3D box
                        textbox6.setTranslateX(currX);                            //set x location
                        textbox6.setTranslateY(currY);                             //set y location
                        textbox6.setTranslateZ(currZ);
                        is.getChildren().add(textbox6);
                        break;
                    case 0:                                                        //if the array has a 0 do nothing (space)
                        break;
                }
                currX+=10;                                                    //move to next block location
            }
            currX-=80;                                                        //got to new line of blocks
            currY+=10;
            curZ += 10;
        }
        return is;
    }
}
