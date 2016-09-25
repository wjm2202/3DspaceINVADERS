package operations;

import javafx.geometry.Point3D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.Random;
/**
 * this class is the class that creates 3D object for use in your games
 * the classes are called from the Main class or internally to make larger 
 * groups of 3D objects as groups
 * @author Liandri
 *
 */
public class CreateBox {
	
	static Group invaderGroup;                                               //group invaders together 
/*	static Group boarderGroup;                                               //group boarders together
	static Group groundGroup;                                                //group tanks together
	static Image image;                                                      //images used in box texture
	static Image image2;
	static Image image3;
	static Image image4;
	static Image image5;
	static Image image6;
	static Image image7;
	static Image image8;
	static Image image9;
	static Image image10;
	static Image horizon;
	static Image tanktex;
	static Image groundtex;
	static Image bullcolor;
	static PhongMaterial textureMaterial;                                   //images use this to paste texture to box
	static PhongMaterial textureMaterial2;
	static PhongMaterial textureMaterial3;
	static PhongMaterial textureMaterial4;
	static PhongMaterial textureMaterial5;
	static PhongMaterial textureMaterial6;
	static PhongMaterial textureMaterial7;
	static PhongMaterial textureMaterial8;
	static PhongMaterial textureMaterial9;
	static PhongMaterial textureMaterial100;
	static PhongMaterial textureMaterial101;
	static PhongMaterial temp;
	static PhongMaterial horizonTex;
	static PhongMaterial tankTex;
	static PhongMaterial groundTex;
	static PhongMaterial bullColor;                    */

	static WorldCoOrdinates wc;                                         //get world co-ordinate system
	static ArrayList<Point3D> bo = new ArrayList<>();                       //ArrayList of points of world boundary
	Random rand = new Random();
	Rectangle2D screen = Screen.getPrimary().getVisualBounds();
	Img img = new Img();
	
	
	
	public CreateBox()
	{
		img.setupTextures();                                                    //apply images to textures
		wc = new WorldCoOrdinates();
		bo = wc.getBounds();
		invaderGroup = new Group();
	}

/**
 * 	make a bomb for enemy to drop
 * @param start
 * @return Cylinder 3D object
 */
	public Cylinder bomb(Point3D start){
		Cylinder bull = new Cylinder(10,10,10);
		bull.setTranslateX(start.getX());                            //set x location
		bull.setTranslateY(start.getY());                             //set y location
		bull.setTranslateZ(start.getZ());
		bull.setMaterial(img.getTexture(14));               //set light side texture
		return bull;
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
		Box horizion = new Box(5000,2000,5);
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
		Box ground = new Box(3500,5,1200);
		ground.setTranslateX(480);                            //set x location
		ground.setTranslateY(800);                             //set y location
		ground.setTranslateZ(1300);
		ground.setMaterial(img.getTexture(13));   
		return ground;
	}
	public Box makeTank(int x, int y, int z, int sizeX, int sizeY, int sizeZ){
		Box boarderBox = new Box(sizeX, sizeY, sizeZ);                  //make 3D box
		boarderBox.setTranslateX(x);                            //set x location
		boarderBox.setTranslateY(y);                             //set y location
		boarderBox.setTranslateZ(z); 
		boarderBox.setMaterial(img.getTexture(12));               //set light side texture
		return boarderBox;
		
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

		for(int i = 0; i < 4; i++)
		{
			switch(sequence[i])
			{
				case 1:
					startX = (int)bo.get(0).getX();
					startY = 250; 					// from the World coordination(case(1)-case(0)) / 2
					leftBox.setTranslateX(startX);  // This is the left side of the box
					leftBox.setTranslateY(startY);
					leftBox.setTranslateZ(startZ);
					boarderGroup.getChildren().add(leftBox);
					;break;
				case 2:
					startX = ((int)bo.get(2).getX()-(int)bo.get(0).getX()) / 2;
					startY += 250; 					//goes to the ground floor
					groundBox.setMaterial(img.getTexture(15)); //pasting the image on the ground 3D box
                    groundBox.setTranslateX(startX);// This is the ground side of the box
					groundBox.setTranslateY(startY);
					groundBox.setTranslateZ(startZ);
					boarderGroup.getChildren().add(groundBox);
					;break;
				case 3:
					startX += ((int)bo.get(2).getX()-(int)bo.get(0).getX()) / 2;
					startY = startY - 250;
					rightBox.setTranslateX(startX); // This is the right side of the box
					rightBox.setTranslateY(startY);
					rightBox.setTranslateZ(startZ);
					boarderGroup.getChildren().add(rightBox);
					;break;
				case 4:
					startY = 0;
					startX = ((int)bo.get(3).getX()- (int)bo.get(0).getX()) / 2;
					topBox.setTranslateX(startX); // This is the top side of the box
					topBox.setTranslateY(startY);
					topBox.setTranslateZ(startZ);
					boarderGroup.getChildren().add(topBox);
					;break;
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
	public Box singleEnemyBox(int x, int y, int z, int bX, int bY, int bZ){
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
		return boarderBox;
		
	}
/**
 * clear the entire scene of enemies
 * @param root
 */
	public void clear(Group root){                                                    //remove 3D objects from screen 
		for(int i =5;i<root.getChildren().size();i++){
			root.getChildren().remove(i);
		}
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
				;break;
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
 * OLD UNUSED method for making a swarm of invaders
 * uses invader to generate a single invader at a time 
 * to add to a group of invaders in a predefined pattern
 * uses an array to arrange the single invaders into a patterned group	
 * @param root
 * @return group of invaders in a patttern
 */
	public Group invaderSwarm(Group root){            //make a group of invaders in a pattern of an invader
		int posInvaders = 0;
		int posY = 0;
		int[][] shape  = {{0,0,0,1,1,0,0,0}          //array of switches to make differnt invaders for different places
						 ,{2,0,2,2,2,2,0,2}
						 ,{0,3,0,3,3,0,3,0}
						 ,{0,4,4,4,4,4,4,0}
						 ,{0,5,0,0,0,0,5,0}
						 ,{0,6,0,6,6,0,6,0}
						 ,{7,0,0,0,0,0,0,7}
						 ,{8,0,0,0,0,0,0,8}};
		for(int y =0;y<2;y++){
			for(int x=0;x<8;x++){
				switch(shape[y][x]){
				case 0:
					break;
				case 1:
					invader(root,img.getImg(1), 10, posInvaders,posY);               //make individual invader to add to swarm group
					break;
				case 2:
					invader(root,img.getImg(2), 10, posInvaders,posY);
					break;
				case 3:
					invader(root,img.getImg(3), 10, posInvaders,posY);
					break;
				case 4:
					invader(root,img.getImg(4), 10, posInvaders,posY);
					break;
				case 5:
					invader(root,img.getImg(5), 10, posInvaders,posY);
					break;
				case 6:
					invader(root,img.getImg(6), 10, posInvaders,posY);
					break;
				case 7:
					invader(root,img.getImg(7), 10, posInvaders,posY);
					break;
				case 8:
					invader(root,img.getImg(8), 10, posInvaders,posY);
					break;
				}
				posInvaders+=100;                                              //move to new location after each invader is made
			}
			posInvaders-=800;                                                  //move back to start of next line of invaders
			posY+=100;
		}
		return invaderGroup;                                                   //return finished group of invaders
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
	public void invader(Group root, Image image5,int boxSize, int curX, int curY){    //make individual invaders
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
		int currZ = 1200;
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
                        //temp.setDiffuseColor(Color.BEIGE);        //set dark side color
                        //temp.setDiffuseMap(image4);                //add texture to box on light side
                        //textbox6.setMaterial(temp);               //set light side texture
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
                        //temp.setDiffuseColor(Color.BEIGE);        //set dark side color
                        //temp.setDiffuseMap(image4);                //add texture to box on light side
                        //textbox6.setMaterial(temp);               //set light side texture
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
                        //temp.setDiffuseColor(Color.BEIGE);        //set dark side color
                        //temp.setDiffuseMap(image4);                //add texture to box on light side
                        //textbox6.setMaterial(temp);               //set light side texture
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
                        //temp.setDiffuseColor(Color.BEIGE);        //set dark side color
                        //temp.setDiffuseMap(image4);                //add texture to box on light side
                        //textbox6.setMaterial(temp);               //set light side texture
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
