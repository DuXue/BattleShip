/***************************************************
 * Author: Du Xue	
 * ------
 * Enum object to set the four different directions of Ships
 **************************************************/
package entities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Direction {
	NORTH (0, 1),
	SOUTH (0, -1),
	WEST (-1, 0),
	EAST (1, 0);
	
	private int xDirection;
	private int yDirection;
	
	private static final List<Direction> VALUES = Arrays.asList(Direction.values());
	
	/**********************************************
	 * Constructor
	 **********************************************/
	Direction(int xDirection, int yDirection){
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}

	/*
	 * return integer xDirection standing for 
	 * the value of Horizontal direction (WEST, EAST) 
	 * @return xDirection value
	 */
	public int getXDirection(){
		return xDirection;
	}
	
	/*
	 * return integer yDireciton standing for 
	 * the value of Vertical Direction (NORTH, SOUTH)
	 * @return yDirection value
	 */
	public int getYDirection(){
		return yDirection;
	}
	
	/*
	 * shuffle the list of four directions, more possibility for AI to put the ship direction 
	 * @return the list of random sequence of four directions( East, West, South, North)
	 */
	public static List<Direction> random()  
	{
		Collections.shuffle(VALUES);
	/*	for(Direction d : VALUES)
		{
			System.out.println(d.xDirection+","+d.yDirection);
		}*/
		return VALUES;
	}
}
