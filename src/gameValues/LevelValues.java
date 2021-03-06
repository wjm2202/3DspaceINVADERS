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
	private int numEnemies = 10;                //total number of enemies (auto generated)
	private int enemyBombDamage = 20;            //amount each bomb hit hurts the tank
	private int enemyBombSpeed = 5;             //the speed the enemy bombs fall
	private int enemyXsize = 40;                //the size in width of the enemies
	private int enemyYsize = 15;                //the size in height of the enemies
	private int enemyZsize = 40;                //the size in depth of the enemies
	private double Xvelocity = 5.0;             //the speed the enemy moves left/right
	private double Yvelocity = 0.0;             //the speed the enemy moves up/down
	private double Zvelocity = 5.0;             //the speed the enemy moves front/back
	private double spinDrop = 1.0;              //the amount the enemies drop each time they hit a wall and turn around
	private int dropsPerSecond = 30;         //60 means 1 bomb dropped per second if less than 60 more bombs drop

	//player values
	private int playerLives = 3;
	private int playerSheild = 0;
	private int playerScore = 0;
	private int playerLevel = 1;
	private int pointsPerKill = 10;             //the amount of points the player get for an ememy kill
	private int playerHealth =100;              //the starting amount of health of the player
	private double bulletSpeed = 10.0;          //the speed of the tanks bullets
    private int tankXsize = 40;                 //the size in width of the tank
    private int tankYsize = 10;                 //the size in height of the tank
    private int tankZsize = 10;                 //the size in depth of the tank
	private double tankSpeedX = 10.0;
	private double tankSpeedY = 10.0;
	private double tankSpeedZ = 5.0;
	private int tankXPosition;					//this is the x position of the tank
	private int tankYPosition;					//this is the y position of the tank
	private double gameDiffucultyIncrease =0.5;
	private int bulletRate =5;
	//world values
	private int worldScale = 0;

	public int getNumEnemies() {
		return numEnemies;
	}

	public void setNumEnemies(int numEnemies) {
		this.numEnemies = numEnemies;
	}

	public int getWorldScale() {
		return worldScale;
	}

	public void setWorldScale(int worldScale) {
		this.worldScale = worldScale;
	}




	public int getPlayerLevel() {
		return playerLevel;
	}
	public void setPlayerLevel(int playerLevel) {
		this.playerLevel = playerLevel;
	}
	public int getPlayerLives() {
		return playerLives;
	}

	public void setPlayerLives(int playerLives) {
		this.playerLives = playerLives;
	}


	public int getPlayerSheild() {
		return playerSheild;
	}

	public void setPlayerSheild(int playerSheild) {
		this.playerSheild = playerSheild;
	}

	public int getBulletRate() {
		return bulletRate;
	}

	public void setBulletRate(int bulletRate) {
		this.bulletRate = bulletRate;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}


	public int getDropsPerSecond() {
		return dropsPerSecond;
	}

	public void setDropsPerSecond(int getDropsPerSecond) {
		this.dropsPerSecond = getDropsPerSecond;
	}

	public double getGameDiffucultyIncrease() {
		return gameDiffucultyIncrease;
	}
	public void setGameDiffucultyIncrease(double gameDiffucultyIncrease) {
		this.gameDiffucultyIncrease = gameDiffucultyIncrease;
	}
	public void levelUP(double up){
		this.numEnemies = numEnemies +1;
		this.enemyBombDamage = enemyBombDamage +1;
		this.enemyBombSpeed = enemyBombSpeed +1;
		this.Xvelocity = Xvelocity + up;
		this.Zvelocity = Zvelocity + up;
		this.spinDrop = spinDrop + 0.2;
		setDropsPerSecond(dropsPerSecond-1);
	}

	public double getTankSpeedZ() {
		return tankSpeedZ;
	}

	public void setTankSpeedZ(double tankSpeedZ) {
		this.tankSpeedZ = tankSpeedZ;
	}

	public double getTankSpeedX() {
		return tankSpeedX;
	}

	public void setTankSpeedX(double tankSpeedX) {
		this.tankSpeedX = tankSpeedX;
	}

	public double getTankSpeedY() {
		return tankSpeedY;
	}

	public void setTankSpeedY(double tankSpeedY) {
		this.tankSpeedY = tankSpeedY;
	}

	private int tankZPosition;					//this is the z position of the tank

	/**
	 * This method sets the x, y and z position of the tank.
	 * @param x
	 * @param y
	 * @param z
	 */
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


	/**
	 * Below are getters and setters of the tank position variables.
	 * @return
	 */
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
