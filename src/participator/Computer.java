/****************
 * Author: Du Xue 
 * ----------------
 * Computer Object stands for AI computer
 ***************/
package participator;

import java.util.Random;

import entities.Coordinate;
import entities.Grid;
import entities.Ship;
import entities.Direction;

public class Computer {
	/****
	 * Constructor
	 *******/
	public Computer()
	{
		/////empty
	}
	
	/**********
	 * computer put the ship on the grid
	 * @param startPosition the random coordinate stands for the starting position of the ship
	 * @param ship the ship to be placed
	 * @param grid the grid contains the ship
	 * @return boolean success or not
	 */
	public boolean placeShip(Coordinate startPosition, Ship ship, Grid grid)
	{
		boolean success = false;
		ship.setStartPostion(startPosition);
		Coordinate endPosition = new Coordinate();
		
		for(Direction d : Direction.random())
		{
			int newX = startPosition.getXCoordinate()+(ship.getSize())*(d.getXDirection());
			endPosition.setXCoordinate(newX);
			int newY = startPosition.getYCoordinate()+(ship.getSize())*(d.getYDirection());
			endPosition.setYCoordinate(newY);
			if(grid.checkCoordianteIsValid(startPosition)&&grid.checkCoordianteIsValid(endPosition))
			{
				Coordinate direction = new Coordinate(d.getXDirection(), d.getYDirection());
				ship.generateShipLocations(direction);
		 	    if(grid.addShip(ship))
		 	    {
		 	    	success = true;
		 	    	ship.setDirection(direction);
		 	    	break;
		 	    }
		 	    else
		 	    {
		 	    	success = false;
		 	    }
			}
			else{
				success = false;
			}
		}
	    return success;
	}
	
	
	/*******
	 * once the ship is aimed, the computer can choose to move the ship according to the "speed" of the ship
	 * based on the "direction", which means the ship only can be move vertically or horizontally,
	 * if original direction is south, then the ship only can move south or north horizontally.
	 * @param ship the ship which is hit
	 * @param grid the grid contains the ship
	 * @return
	 */
	public boolean moveShip(Ship ship, Grid grid)
    {
		Random random = new Random();
		int speed = ship.getSpeed();
		int direc= random.nextInt(2)-1;
		int randomMove = random.nextInt(speed) * direc;//randomly move based on the ship speed
		
        //System.out.println(randomMove+"*****");
		////////////////////generate new startPosition and endPosition//////////////////////////////////
		boolean success = false;
		Coordinate startPosition = new Coordinate(ship.getStartPostion().getXCoordinate() + ship.getDirection().getXCoordinate()*randomMove, ship.getStartPostion().getYCoordinate() + ship.getDirection().getYCoordinate()*randomMove);
		Coordinate endPosition = new Coordinate();

		int newX = startPosition.getXCoordinate() + (ship.getSize())
				* (ship.getDirection().getXCoordinate());
		endPosition.setXCoordinate(newX);
		int newY = startPosition.getYCoordinate() + (ship.getSize())
				* (ship.getDirection().getYCoordinate());
		endPosition.setYCoordinate(newY);
		if (grid.checkCoordianteIsValid(startPosition)
				&& grid.checkCoordianteIsValid(endPosition)) {
            ship.setStartPostion(startPosition);
			ship.generateShipLocations(ship.getDirection());
			if (grid.addShip(ship)) {
				success = true;
			} else {
				success = false;
			}
		} else {
			success = false;
		}

		return success;

	}

}
