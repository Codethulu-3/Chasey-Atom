package maze;

/**
*
* @author Ryan
*/

public class Character {
	//Save variables
	private int numRooms;
	private int direction;
	private int xPos;
	private int yPos;
	private int zPos;
	private int exp;
	private int health;
	private int endX;
	private int endY;
	private int endZ;
	private int difficulty;
	private int weapon;
	private int armor;
	private int magic;
	
	//Referenced variables
	private int level;
	private double distToEnd;
	
	//Unreferenced variables
	private int lvlToXP=100;
	
	public Character() {												//Constructor
		//PUT CODE HERE?
	}
	
	//SaveVars Setters
	public void setnumRooms(int numRooms) {this.numRooms = numRooms;}
	public void setdirection(int direction) {this.direction = direction;}
	public void setxPos(int xPos) {this.xPos = xPos;}
	public void setyPos(int yPos) {this.yPos = yPos;}
	public void setzPos(int zPos) {this.zPos = zPos;}
	public void setexp(int exp) {this.exp = exp;setlevel();}
	public void sethealth(int health) {this.health = health;}
	public void setendX(int endX) {this.endX = endX;}
	public void setendY(int endY) {this.endY = endY;}
	public void setendZ(int endZ) {this.endZ = endZ;}
	public void setdifficulty(int difficulty) {this.difficulty = difficulty;}
	public void setweapon(int weapon) {this.weapon = weapon;}
	public void setarmor(int armor) {this.armor = armor;}
	public void setmagic(int magic) {this.endX = magic;}
	
	//RefVars Setters
	public void setlevel() {
		level = exp * lvlToXP;
	}
	public void setdistToEnd() {
		distToEnd = Math.sqrt(Math.pow(endX-xPos,2)+Math.pow(endY-yPos,2)+Math.pow(endZ-zPos,2));
	}
	
	//SaveVars Getters
	public int getnumRooms() {return numRooms;}
	public int getdirection() {return direction;}
	public int getxPos() {return xPos;}
	public int getyPos() {return yPos;}
	public int getzPos() {return zPos;}
	public int getexp() {return exp;}
	public int gethealth() {return health;}
	public int getendX() {return endX;}
	public int getendY() {return endY;}
	public int getendZ() {return endZ;}
	public int getdifficulty() {return difficulty;}
	public int getweapon() {return weapon;}
	public int getarmor() {return armor;}
	public int getmagic() {return magic;}
	
	//RefVars Getters
	public int getlevel() {return level;}
	public double getdistToEnd() {return distToEnd;}
	
	public void newGame() {
		numRooms = 0;
		direction = 0;
		xPos = (int)(Math.random()*21);
		yPos = (int)(Math.random()*21);
		zPos = (int)(Math.random()*3);
		exp = 0;
		health = 100;
		endX = (int)(Math.random()*21);
		while(Math.abs(endX-xPos) <= 3){
			endX = (int)(Math.random()*21);
		}
		endY = (int)(Math.random()*21);
		while(Math.abs(endY-yPos) <= 3){
			endY = (int)(Math.random()*21);
		}
		endZ = (int)(Math.random()*3);
		//difficulty menu to be shown from start menu
		weapon = (int)(Math.random()*5) +8;		//between 8 and 12
		armor = 5*(20-weapon);					//blocks 90% of damage, takes 110% as much
		magic = 18-weapon;						//inversely mapped to damage (8 to 10 and 12 to 6)
	}
	public void loadSave(String saveName) {
		Inputter in1 = new Inputter("document",saveName);
	}
}
