/************
 * Author: Du Xue
 * ------
 * main part of the game, start the game, offer information for the game
 ************/
package main;

import java.util.Scanner;

import participator.Computer;
import participator.Player;
import entities.Coordinate;
import entities.Grid;
import entities.Ship;

public class Play {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*final Map<String, Integer> ratingMap = new HashMap<String, Integer>();*/
		
		System.out.println("******************************");
		System.out.println("* Welcome to battleShip Game!*");
		System.out.println("******************************");
		
		/////////////////////////input player name////////////////////////////
		Scanner in = new Scanner(System.in);
		System.out.println("Please input your Name:");
		String inputName = in.next();
		Player player = new Player(inputName);
		int shot = 0;
		
		////////////////generate the grid map//////////////////////////////////
		System.out.println("Generating the Map......");
		Grid grid = new Grid();
		
		/////////////////generate the ships//////////////////////////////////
		System.out.println("Generating the Ships......");
		Ship battleship = new Ship("BattleShip", 5);
		battleship.checkAllShipbody();
		battleship.setSpeed(6);
		Ship destroyer1 = new Ship("Destroyer1", 4);
		destroyer1.checkAllShipbody();
		destroyer1.setSpeed(5);
		Ship destroyer2 = new Ship("Destroyer2", 4);
		destroyer2.checkAllShipbody();
		destroyer2.setSpeed(5);
		
		/////////////////AI place the ships in the Grid////////////////////////////
		System.out.println("AI start to put the ships on the grid Map......");
		Computer AI = new Computer();
		Coordinate startPosition = new Coordinate();
		while(!AI.placeShip(startPosition, battleship, grid))
	    {
	        startPosition = new Coordinate();
	    }

        while(!AI.placeShip(startPosition, destroyer1, grid))
        {
        	startPosition = new Coordinate();
        }
        
        while(!AI.placeShip(startPosition, destroyer2, grid))
        {
        	startPosition = new Coordinate();
        }
        
        //grid.checkAllLocations();
        //Mode 1: the information of which part of the ship is offered, once the player aimed a ship//
        //Mode 2: normal one, the ships are static//
        //Mode 3: once one ship is aimed, the computer can move it based on its original direction and speed//
    	Scanner mode = new Scanner(System.in);
    	System.out.println("Mode 1: easy ");
    	System.out.println("Mode 2: normal ");
    	System.out.println("Mode 3: hard ");
    	System.out.println("Mode 1: the information of which part of the ship is offered, once the player aimed a ship ");
    	System.out.println("Mode 2: normal one, the ships are static ");
    	System.out.println("Mode 3: once one ship is aimed, the computer can move it based on its original direction and speed ");
		System.out.println("Please Choose the Mode: (input integer 1 or 2 or 3:)");
		int chosenMode = mode.nextInt();
		
		///////check all ships are sunk or not//////////////////
		while (!battleship.isSunk() || !destroyer1.isSunk() || !destroyer2.isSunk()) 
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Please input your target grid (example A1):");
			String inputLocation = input.next();
			Coordinate Location = new Coordinate(inputLocation);
			
			////////check the input coordinate is valid or not///////
			while (!grid.checkCoordianteIsValid(Location)) {
				System.out.println("Please input a valid target!!!");
				input = new Scanner(System.in);
				System.out
						.println("Please input your target grid (example A1):");
				inputLocation = input.next();
				Location = new Coordinate(inputLocation);
			}
			
            shot++;
            player.setShotsNumber(shot);
			Ship ship = grid.checkShipIsAimed(Location);
			if (ship.getName() == "Default" || ship.getSize() == 0) 
			{
				System.out.println("no ship was hitted!");
			} 
			else
			{
				System.out.println(ship.getName() +" " +ship.getShottedMessage(Location));
				
				///////////Mode 1 offer the ship body information/////////
				if (chosenMode == 1) 
				{
					for (String s : ship.getShipBody()) 
					{
						System.out.println("-- " + s + " ---");
					}
				}
				if (ship.isSunk()) 
				{
					System.out.println(ship.getName() + " was Sank!");
				}
				
				else
					
				{
					//////Mode 3 starts, AI can move the aimed ship/////////
					if(chosenMode == 3)
					{
					int j =0;
					
					///////the AI can use 5 times to move a ship again, if 5 times are failed, then keep the ship static/////
					while(j < 5)
						{
						     if(AI.moveShip(ship, grid))
						     {
						    	 j++;
						     }
						     else
						     {
						    	 break;
						     }
						}
					}
				}
			}
		}
		
		System.out.println("All ships are destroyed!! You Win!!!");
/*		ratingMap.put(player.getUserName(), player.getShotsNumber());
		final List<Map.Entry<String, Integer>> list_Data = new ArrayList<Map.Entry<String, Integer>>(ratingMap.entrySet());
		
		Collections.sort(list_Data, new Comparator<Map.Entry<String, Integer>>()
	    {
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2)
			{
				return(m2.getValue() - m1.getValue());
			}
			
	    });
		
		System.out.println("Rating:");
		System.out.println(list_Data);*/
	}	
}
