/****************************
 * Author: Du Xue
 * ------
 * set the alphabet (A to J) as integer value ( 1 to 10)
 * the integer value can be used in Coordinate (X, Y)
 ********************************/
package entities;

public enum Xaxis {
	A (1),
	B (2),
	C (3),
	D (4), 
	E (5),
	F (6),
	G (7),
	H (8),
	I (9),
	J (10);
	/****************
	 * constructor
	 * x stands for the value of X axis of coordinate
	 ****************/
	private int x;
	Xaxis(int x)
	{
		this.x = x;
	}

	/******************
	 * get the value if x axis
	 * @return x value
	 */
	public int getXValue()
	{
		return x;
	}
	
	/********************
	 * translate the String to integer value of X axis
	 * @param X the String stands for X axis
	 * @return the translated integer value of String X
	 */
	public static int tanslateAlphabet(String X)
	{
		int xInt = 0;
		for(Xaxis x : Xaxis.values())
		{
			if(x.toString().equals(X))
			{
				xInt = x.getXValue();
		    }
		}
		return xInt;// can not find: return 0
	}
}
