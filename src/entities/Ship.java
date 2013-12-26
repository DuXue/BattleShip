/**********************
 *Author: Du Xue
 *------
 * Ship object stands for ships
 *********************/
package entities;

import java.util.ArrayList;

public class Ship {
	private String name;
	private int size;
	private int speed;// decides how far the ship can be moved
	
	
	private boolean isSunk;
	private String[] shipBody;
	
	private Coordinate startPosition;// the starting coordinate of ship
	private Coordinate direction;// (-1, 0) stands for West, ( 1, 0 ) stands for East, ( 0, 1 ) stands for North, ( 0, -1) stands for South
	private ArrayList<Coordinate> locations;// the total coordinates of ship
	
	
	/********
	 * Constructor for ship
	 * @param name ship name
	 * @param size ship size
	 */
	public Ship(String name, int size)
	{
		this.name = name;
		this.size = size;
		speed = 0;   // the default ship is static speed = 0
		shipBody = new String[size];
		isSunk = false;// the default ship is not Sunk
		startPosition = new Coordinate(); // set default starting position of ship is (1, 1)
		direction = new Coordinate();
		locations = new ArrayList<Coordinate>(); 
	}
	
	/**
	 * set ship name
	 * @param name ship name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	/****
	 * get ship name
	 * @return ship name
	 *****/
	public String getName()
	{
		return name;
	}
	
	/*********
	 * set the speed of ship
	 * @param speed the speed of ship
	 */
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	/****
	 * get the speed of ship
	 * @return the speed of ship
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/******
	 * get the size of ship
	 * @return the size of ship
	 */
	public int getSize()
	{
		return size;
	}
	
	
	/******
	 * set the direction of ship
	 * @param direction the direction of ship 
	 */
	public void setDirection(Coordinate direction)
	{
		this.direction = direction;
	}
	
	/******
	 * get the direction of ship
	 * @return direction the direction of ship 
	 */
	public  Coordinate getDirection()
	{
		return direction;
	}
	
	
	/***************
	 * check the ship body is destroyed or not
	 * @param partNumber the number of which part of ship
	 * @return boolean destroyed already or not
	 */
	public boolean setShipBody(int partNumber)
	{
		if(shipBody[partNumber-1].equals("destroyed"))
		{
			return false;
		}
		else
		{
			shipBody[partNumber-1] = "destroyed";// shipBody[0] stands for the first part of ship
			return true;
		}	
	}
	
	/*****
	 * get the situation of ship body
	 * @return the ship body
	 */
	public String[] getShipBody()
	{
		return shipBody;
	}

	/********
	 * set the starting position if ship
	 * @param coordinate 
	 */
	public void setStartPostion(Coordinate coordinate)
	{
		startPosition = coordinate;
	}
	
	/*****
	 * get the starting position
	 * @return starting position
	 */
	public Coordinate getStartPostion()
	{
		return startPosition;
	}
	
	
	/****
	 * generate all locations of ship
	 * @param direction starting position
	 */
	public void generateShipLocations(Coordinate direction)
	{
		locations.clear();
		locations.add(startPosition);
		for(int i = 1; i < size; i ++)
		{
			Coordinate nextCoord = new Coordinate();
			
			int newX = startPosition.getXCoordinate() + (direction.getXCoordinate())*i;
			nextCoord.setXCoordinate(newX);
			
			int newY = startPosition.getYCoordinate() + (direction.getYCoordinate())*i;
			nextCoord.setYCoordinate(newY);
			
			locations.add(nextCoord);
		/*	for(Coordinate c : locations)
			{
				System.out.println(c.getXCoordinate()+" , " + c.getYCoordinate());
			}*/
		}
		
	}
	
	/*******
	 * get the all locations of the ship
	 * @return the list of locations
	 */
	public ArrayList<Coordinate> getShipLocations()
	{
		return locations;
	}
	
	public void checkAllShipbody()
	{
		for(int i = 0; i < size; i ++)
		{
			shipBody[i] = "perfect";
		}
	}
	
	/****
	 * check the ship body in order to check the ship is sank or not
	 * @return boolean
	 */
	public boolean isSunk()
	{
		int i = 0;
		for(String s : shipBody)
		{
			if(s.equals("destroyed"))
			{
				i ++;
			}
			else
			{
				continue;
			}
		}
		if(i == size)
		{
			isSunk = true;
		}
		else
		{
			isSunk = false;
		}
		return isSunk;
	}
	
	/*****
	 * return message about the situation of the ship after the ship is aimed
	 * @param shot the grid or coordinate the player choose to shoot
	 * @return the result of shooting
	 */
	public String getShottedMessage(Coordinate shot)
	{
		String message = null;
		int number = 0;
		number = shot.getXCoordinate() - startPosition.getXCoordinate() + shot.getYCoordinate() - startPosition.getYCoordinate();
		if(number >= 0)
		{
			number ++;
		}
		else
		{
			number = number*(-1) + 1;
		}
		if(setShipBody(number))
		{
			message =  " was shotted!";
		}
		else
		{
			message = " was shotted before!!!";
		}
		return message;
	}
}
