/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/


public class Model {
	private int imgWidth;
	private int imgHeight;
	private int frameWidth;
	private int frameHeight;
	private int xLoc = 0;
	private int yLoc = 0;
	private int xIncr = 8;
	private int yIncr = 2;
	private int xFactor = 1;
	private int yFactor = 1;
	private Direction direction;
	
	public Model(int fWidth, int fHeight, int iWidth, int iHeight) { //Model constructor
		this.frameWidth = fWidth;
		this.frameHeight = fHeight;
		this.imgWidth = iWidth;
		this.imgHeight = iHeight;
	}

	public void updateLocationAndDirection() {
		
		//Direction Changes
    	if(xFactor == 1 && yFactor == 1) {
    		direction = Direction.SOUTHEAST;
    	}
    	if(xFactor == 1 && yFactor == -1) {
    		direction = Direction.NORTHEAST;
    	}
    	if(xFactor == -1 && yFactor == 1) {
    		direction = Direction.SOUTHWEST;
    	}
    	if(xFactor == -1 && yFactor == -1) {
    		direction = Direction.NORTHWEST;
    	}
    	
    	if(yLoc > frameHeight-imgHeight) {
    		yFactor = -1;
    	}
    	if(yLoc < 0) {
    		yFactor = 1;
    	}
    	
    	if(xLoc > frameWidth-imgWidth) {
    		xFactor = -1;
    	}
    	if(xLoc < 0) {
    		xFactor = 1;
    	}
    	
    	//Location Changes
    	xLoc+=(xIncr*xFactor);
    	
    	yLoc+=(yIncr*yFactor);
	}
	
	//Getters
	public int getX() {
		return this.xLoc;
	}
	
	public int getY() {
		return this.yLoc;
	}
	
	public Direction getDirect() {
		return this.direction;
	}
	

}
