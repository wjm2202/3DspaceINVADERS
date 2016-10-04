package operations;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

public class Img {

	private Group boarderGroup;                                               //group boarders together
	private Group groundGroup;                                                //group tanks together
	private Image image;                                                      //images used in box texture
	private Image image2;
	private Image image3;
	private Image image4;
	private Image image5;
	private Image image6;
	private Image image7;
	private Image image8;
	private Image image9;
	private Image image10;
	private Image horizon;
	private Image tanktex;
	private Image groundtex;
	private Image bullcolor;
	private Image groundGrid;
	private Image explosion;
	private Image ship;
	private Image crate;
	private PhongMaterial textureMaterial;                                   //images use this to paste texture to box
	private PhongMaterial textureMaterial2;
	private PhongMaterial textureMaterial3;
	private PhongMaterial textureMaterial4;
	private PhongMaterial textureMaterial5;
	private PhongMaterial textureMaterial6;
	private PhongMaterial textureMaterial7;
	private PhongMaterial textureMaterial8;
	private PhongMaterial textureMaterial9;
	private PhongMaterial temp;
	private PhongMaterial horizonTex;
	private PhongMaterial tankTex;
	private PhongMaterial groundTex;
	private PhongMaterial bullColor;
	private PhongMaterial groundGridph;
	private PhongMaterial expPH;
	private PhongMaterial cratePH;
	
	public void setupTextures(){
		boarderGroup = new Group();                                         //make group able to hold boarder boxes
		groundGroup = new Group();                                          //make group able to hold tanks
		image = new Image("/pics/block_brick.png");    //get image to wrap cube in
		image2 = new Image("/pics/scratch.png");    //get image to wrap cube in
		image3 = new Image("/pics/rocktextures.jpg");    //get image to wrap cube in
		image4 = new Image("/pics/lava_brick.png");    //get image to wrap cube in
		image5 = new Image("/pics/bubbles_brick.png");    //get image to wrap cube in
		image6 = new Image("/pics/fluid_brick.png");    //get image to wrap cube in
		image7 = new Image("/pics/pokeball_brick.png");    //get image to wrap cube in
		image8 = new Image("/pics/meta_brick.png");    //get image to wrap cube in
		image9 = new Image("/pics/eye_brick.png");    //get image to wrap cube in
		image10 = new Image("/pics/bolt_brick.png");    //get image to wrap cube in
		horizon = new Image("/pics/space.jpg");    //get image to wrap cube in
		tanktex = new Image("/pics/tanktex.png");    //get image to wrap cube in
		groundtex = new Image("/pics/ground.jpg");    //get image to wrap cube in
		bullcolor = new Image("/pics/bullcolor.jpg");    //get image to wrap cube in
		explosion = new Image("/pics/impact Sparks.png");	//get image for explosion
		crate = new Image("/pics/crate_1.jpg");


		textureMaterial = new PhongMaterial();  //texture material
		textureMaterial2 = new PhongMaterial();  //texture material
		textureMaterial3 = new PhongMaterial();  //texture material
		textureMaterial4 = new PhongMaterial();  //texture material
		textureMaterial5 = new PhongMaterial();  //texture material
		textureMaterial6 = new PhongMaterial();  //texture material
		textureMaterial7 = new PhongMaterial();  //texture material
		textureMaterial8 = new PhongMaterial();  //texture material
		textureMaterial9 = new PhongMaterial();  //texture material
		groundGridph = new PhongMaterial();
		expPH = new PhongMaterial();  //texture material
		cratePH = new PhongMaterial();  //texture material

		temp = new PhongMaterial();  //texture material
		horizonTex = new PhongMaterial();  //texture material
		tankTex = new PhongMaterial();  //texture material
		groundTex = new PhongMaterial();  //texture material
		bullColor = new PhongMaterial();  //texture material
		textureMaterial.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial.setDiffuseMap(image);                //set light side texture
		textureMaterial2.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial2.setDiffuseMap(image2);                //set light side texture
		textureMaterial3.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial3.setDiffuseMap(image3);                //set light side texture
		textureMaterial4.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial4.setDiffuseMap(image4);                //set light side texture
		textureMaterial5.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial5.setDiffuseMap(image5);                //set light side texture
		textureMaterial6.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial6.setDiffuseMap(image6);
		textureMaterial7.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial7.setDiffuseMap(image7);   
		textureMaterial8.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial8.setDiffuseMap(image8);
		textureMaterial9.setDiffuseColor(Color.BEIGE);        //set dark side color
		textureMaterial9.setDiffuseMap(image9);
		horizonTex.setDiffuseColor(Color.BEIGE);        //set dark side color
		horizonTex.setDiffuseMap(horizon);
		tankTex.setDiffuseColor(Color.BEIGE);        //set dark side color
		tankTex.setDiffuseMap(tanktex);
		groundTex.setDiffuseColor(Color.BEIGE);        //set dark side color
		groundTex.setDiffuseMap(groundtex);
		bullColor.setDiffuseColor(Color.BEIGE);        //set dark side color
		bullColor.setDiffuseMap(bullcolor);
		groundGridph.setDiffuseColor(Color.BEIGE);        //set dark side color
		groundGridph.setDiffuseMap(groundGrid);                //set light side texture
		expPH.setDiffuseColor(Color.BEIGE);        //set dark side color
		expPH.setDiffuseMap(explosion);                //set light side texture
		cratePH.setDiffuseColor(Color.BEIGE);        //set dark side color
		cratePH.setDiffuseMap(crate);                //set light side texture
		
	}
	public PhongMaterial getTexture(int textNum){
		PhongMaterial getTextureMaterial;  //texture material
		switch(textNum){
		case 1:
			getTextureMaterial = textureMaterial;break;
		case 2:
			getTextureMaterial = textureMaterial2;break;
		case 3:
			getTextureMaterial = textureMaterial3;break;
		case 4:
			getTextureMaterial = textureMaterial4;break;
		case 5:
			getTextureMaterial = textureMaterial5;break;
		case 6:
			getTextureMaterial = textureMaterial6;break;
		case 7:
			getTextureMaterial = textureMaterial7;break;
		case 8:
			getTextureMaterial = textureMaterial8;break;
		case 9:
			getTextureMaterial = textureMaterial9;break;
		case 10:
			getTextureMaterial = horizonTex;break;           //not used
		case 11:
			getTextureMaterial = horizonTex;break;
		case 12:
			getTextureMaterial = tankTex;break;
		case 13:
			getTextureMaterial = groundTex;break;
		case 14:
			getTextureMaterial = bullColor;break;
			case 15:
				getTextureMaterial = expPH;break;
			case 16:
				getTextureMaterial = cratePH;break;
		default:
			getTextureMaterial = textureMaterial;break;
			
		}
		return getTextureMaterial;
	}
	public Image getImg(int imgNum){
		Image selImage =new Image("/pics/bullcolor.jpg");
		switch(imgNum){
		case 1:
			selImage = image;break;
		case 2:
			selImage = image2;break;
		case 3:
			selImage = image3;break;
		case 4:
			selImage = image4;break;
		case 5:
			selImage = image5;break;
		case 6:
			selImage = image6;break;
		case 7:
			selImage = image7;break;
		case 8:
			selImage = image8;break;
		case 9:
			selImage = image9;break;
		case 10:
			selImage = image10;break;
		case 11:
			selImage = horizon;break;
		case 12:
			selImage = tanktex;break;
		case 13:
			selImage = groundtex;break;
		case 14:
			selImage = bullcolor;break;
		}
		return selImage;
	}
}
