package model;


/**
 * 
 * @author rajkumar
 *
 *This Class extends the property of Car class 
 *and Override 2 Car class abstract methods
 *
 */
public class Hyundai extends Car{
	
	/**
	 * This is Constructor of Toyota class
	 * this methos calls parent constructer
	 * 
	 * 
	 * @param price of double type 
	 * @param modal of String Type
	 * @param id of int type
	 */
	
	Hyundai(final long price,final String modal,final int id){
		super(modal,id,price);
	}
	
	/**
	 * This method caluclate the resale value of car
	 * 
	 * {@link Car} used to get prize
	 * 
	 * @return double type value resale value of car
	 */
	@Override
	public double calculateResalePrice() {
		// TODO Auto-generated method stub
		return 0.4*getPrice();
	}
	
	/**
	 * This method used to print the Details of car
	 * 
	 * {@link Car} used to get Deatils of Car
	 * and Print them
	 * 
	 * @return nothing
	 */

	@Override
	public void printCarDetails() {
		// TODO Auto-generated method stub
		System.out.println("Car Name : Hyundai "
				+ " \n Car Id : "+getId()
						+ "\n Car Model : "+getModel()
						+"\n Car Price : "+getPrice()
						+"\n Car Resale Price : "+calculateResalePrice());

		
	}
}
