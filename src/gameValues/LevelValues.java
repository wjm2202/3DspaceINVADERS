package gameValues;

/**
 * this class lets you set all the game variables in one place
 * this is for learning purposes
 * you will learn more by playing around here at the start
 * we will cover in depth the way this works once you can change stuff
 * go read the comments in the class for more information
 * @author Liandri
 *
 */
public class LevelValues {

	//enemy values
	private int numEnemies = 20;                //total number of enemies (auto generated)
	private int enemyBombDamage = 5;            //amount each bomb hit hurts the tank
	private int enemyBombSpeed = 5;             //the speed the enemy bombs fall
	private int enemyXsize = 40;                //the size in width of the enemies
	private int enemyYsize = 15;                //the size in height of the enemies
	private int enemyZsize = 40;                //the size in depth of the enemies
	private double Xvelocity = 5.0;             //the speed the enemy moves left/right
	private double Yvelocity = 0.2;             //the speed the enemy moves up/down
	private double Zvelocity = 5.0;             //the speed the enemy moves front/back
	private double spinDrop = 5.0;              //the amount the enemies drop each time they hit a wall and turn around
	
	//player values
	private int pointsPerKill = 10;             //the amount of points the player get for an ememy kill
	private int playerHealth =100;              //the starting amount of health of the player
	private double bulletSpeed = 10.0;          //the speed of the tanks bullets
    private int tankXsize = 40;                 //the size in width of the tank
    private int tankYsize = 10;                 //the size in height of the tank
    private int tankZsize = 10;                 //the size in depth of the tank
	private int tankXPosition;
	private int tankYPosition;
	private int tankZPosition;

	public void setTankPositon(int x, int y, int z){
		setTankXPosition(x);
		setTankYPosition(y);
		setTankZPosition(z);
	}
	
	public int getNumEnimies(){
		return numEnemies;
	}

	public void setNumEnimies(int numEnimies) {
		this.numEnemies = numEnimies;
	}

	public int getPointsPerKill() {
		return pointsPerKill;
	}

	public void setPointsPerKill(int pointsPerKill) {
		this.pointsPerKill = pointsPerKill;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}

	public double getXvelocity() {
		return Xvelocity;
	}

	public void setXvelocity(double xvelocity) {
		Xvelocity = xvelocity;
	}

	public double getYvelocity() {
		return Yvelocity;
	}

	public void setYvelocity(double yvelocity) {
		Yvelocity = yvelocity;
	}

	public double getZvelocity() {
		return Zvelocity;
	}

	public void setZvelocity(double zvelocity) {
		Zvelocity = zvelocity;
	}

	public double getSpinDrop() {
		return spinDrop;
	}

	public void setSpinDrop(double spinDrop) {
		this.spinDrop = spinDrop;
	}

	public int getEnemyBombDamage() {
		return enemyBombDamage;
	}

	public void setEnemyBombDamage(int enemyBombDamage) {
		this.enemyBombDamage = enemyBombDamage;
	}

	public double getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(double bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}

	public int getEnemyBombSpeed() {
		return enemyBombSpeed;
	}

	public void setEnemyBombSpeed(int enemyBombSpeed) {
		this.enemyBombSpeed = enemyBombSpeed;
	}

	public int getEnemyXsize() {
		return enemyXsize;
	}

	public void setEnemyXsize(int enemyXsize) {
		this.enemyXsize = enemyXsize;
	}

	public int getEnemyYsize() {
		return enemyYsize;
	}

	public void setEnemyYsize(int enemyYsize) {
		this.enemyYsize = enemyYsize;
	}

	public int getEnemyZsize() {
		return enemyZsize;
	}

	public void setEnemyZsize(int enemyZsize) {
		this.enemyZsize = enemyZsize;
	}

	public int getTankXsize() {
		return tankXsize;
	}

	public void setTankXsize(int tankXsize) {
		this.tankXsize = tankXsize;
	}

	public int getTankYsize() {
		return tankYsize;
	}

	public void setTankYsize(int tankYsize) {
		this.tankYsize = tankYsize;
	}

	public int getTankZsize() {
		return tankZsize;
	}

	public void setTankZsize(int tankZsize) {
		this.tankZsize = tankZsize;
	}

	public int getTankXPosition() {
		return tankXPosition;
	}

	public void setTankXPosition(int tankXPosition) {
		this.tankXPosition = tankXPosition;
	}

	public int getTankYPosition() {
		return tankYPosition;
	}

	public void setTankYPosition(int tankYPosition) {
		this.tankYPosition = tankYPosition;
	}

	public int getTankZPosition() {
		return tankZPosition;
	}

	public void setTankZPosition(int tankZPosition) {
		this.tankZPosition = tankZPosition;
	}
}
