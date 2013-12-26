/*************
 * Author: Du Xue
 * ------
 * Object Player stands for player
 ***********/

package participator;

public class Player {
	String userName;
	int shots;
	
	
	/****
	 * Constructor
	 * @param userName user name
	 */
	public Player(String userName)
	{
		this.userName = userName;
		shots = 0;
	}
	
	/*********
	 * set the shooting time
	 * @param shots set the player shooting times
	 ******/
	public void setShotsNumber( int shots)
	{
		this.shots = shots;
	}
	
	/**************
	 * get the shooting time
	 * @return shooting times
	 ****************/
	public int getShotsNumber()
	{
		return shots;
	}
	
	/******
	 * set user name
	 * @param userName user name
	 */
	public void setUserName( String userName)
	{
		this.userName = userName;
	}
	
	/*******
	 * get user name
	 * @return user name
	 */
	public String getUserName()
	{
		return userName;
	}

}
