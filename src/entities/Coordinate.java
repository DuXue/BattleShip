/**********************
 * Author: Du Xue
 * --------
 * generate the coordinate which can be used for 
 * Grid and can be used as location or the hit of 
 * battleship
*************** */
package entities;

import java.util.Random;

public class Coordinate {
	/*
	 * the default format of location is integer + integer
	 * for example (1, 1)
	 * x = 1, y = 1
	 * the first grid 
	 */
	private int xCoord;
	private int yCoord;

	/******************************
	 * Default constructor
	 * @param xCoord for X coordinate (1 to 10)
	 * @param yCoord for Y coordinate (1 to 10)
	 ****************************/
	public Coordinate(int xCoord, int yCoord)
	{
		this.xCoord = xCoord;
	    this.yCoord = yCoord;
	}
	/**************************
	 * constructor for a random coordinate used for 
	 * computer place the battle ship
	 * @param xCoord for X coordinate (1 to 10)
	 * @param yCoord for Y coordinate (1 to 10)
	 ****************************/
	public Coordinate()
	{
		Random r = new Random();
		this.xCoord = r.nextInt(10);
	    this.yCoord = r.nextInt(10);
	}
	/************************
	 * constructor for String format of coordinate, such as 
	 * "A1"
	 * @param hit the coordinate chosen by player to hit
	 *************************/
	public Coordinate(String hit)
	{
		String X = hit.substring(0, 1);
		this.xCoord = Xaxis.tanslateAlphabet(X);
		this.yCoord = Integer.parseInt(hit.substring(1));
	}

	/*
	 * set the value of X coordinate
	 * @param x the setting value
	 */
	public void setXCoordinate(int x)
	{
		xCoord = x;
	}
	
	/*
	 * set the value of Y coordinate
	 * @param y the setting value
	 */
	public void setYCoordinate(int y)
	{
		yCoord = y;
	}
	
	/*
	 * @return the value of X coordinate 
	 */
	public int getXCoordinate()
	{
		return xCoord;
	}
	
	/*
	 * @return the value of Y coordinate
	 */
	public int getYCoordinate(){
		return yCoord;
	}
	
}
