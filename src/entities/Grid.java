/*****************
 * Author: Du Xue
 * -----
 * Grid contains each single grid in the battle ship map
 * the grid can be used for placing the battle ship
 * also can be chosen by player to hit in order to destroy the 
 * battle ships 
 *****************/
package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Grid {
	private HashMap<Ship, ArrayList<Coordinate>> shipHashMap;// map contains key  object "ship", value List of "coordinate"
	
	/*****************
	 * constructor
	 ****************/
	public Grid()
	{
		shipHashMap = new HashMap<Ship, ArrayList<Coordinate>>();
	}
	
	/*****
	 * check the coordinate is invalid or not
	 * @param coordinate the coordinate used for checking
	 * @return boolean valid or in valid
	 *******/
	public boolean checkCoordianteIsValid(Coordinate coordinate)
	{
		int Xaxis = coordinate.getXCoordinate(); 
		int Yaxis = coordinate.getYCoordinate();
		
		if(Xaxis <= 0 || Xaxis >10 || Yaxis <=0 || Yaxis > 10)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/*****
	 * add the ship to the grid
	 * @param ship the ship is added to the grid
	 * @return boolean success or not
	 *******/
	public boolean addShip(Ship ship)
	{
		boolean success = true;
		if(shipHashMap.isEmpty())
		{
			shipHashMap.put(ship, ship.getShipLocations());
			success = true;
		}
		else 
		{
			for(Coordinate coordinate : ship.getShipLocations())
			{
				if(!checkGridIsFree(coordinate))
				{
					success = false;
					break;
				}
			}
			if(success)
			{
				shipHashMap.put(ship, ship.getShipLocations());
			}	
		}	
		return success;
	}
	/****
	 * Check the chosen grid or coordinate is occupied or not
	 * @param coordinate the chosen coordinate 
	 * @return boolean success or not
	 */
	public boolean checkGridIsFree(Coordinate coordinate)
	{
		boolean success = true;
		for(Entry<Ship, ArrayList<Coordinate>> entry : shipHashMap.entrySet())
		{
			for(Coordinate coord : entry.getValue())
			{
				if(coordinate.getXCoordinate() == coord.getXCoordinate()&&coordinate.getYCoordinate() == coord.getYCoordinate())
				{
					success = false;
					break;
				}
			}
		}
		return success;
	}
	
	/****
	 * Check the ship is shot or not in the grid 
	 * @param coordinate the grid is shot
	 * @return Ship the ship is shot
	 *****/
	public Ship checkShipIsAimed(Coordinate coordinate)
	{
		Ship ship = new Ship("Default", 0);
		for(Entry<Ship, ArrayList<Coordinate>> entry : shipHashMap.entrySet())
		{
			for(Coordinate coord : entry.getValue())
			{
				if(coordinate.getXCoordinate() == coord.getXCoordinate()&&coordinate.getYCoordinate() == coord.getYCoordinate())
				{
					ship = entry.getKey();
					break;
				}
			}
		}
		return ship;
	}
	/****
	 * check the final locations of ships, this is for test
	 *****/
	public void checkAllLocations()
	{
		for(Entry<Ship, ArrayList<Coordinate>> entry : shipHashMap.entrySet())
		{
			for(Coordinate coord : entry.getValue())
			{
                 System.out.println("( "+coord.getXCoordinate()+" , " + coord.getYCoordinate() + ")");
			}
		}
	}
}
  