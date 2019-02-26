package model;

import util.ValidationUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author rajkumar
 *This Class contain customer data eg: Name , Id , No. of cars
 *
 *@variables 4 variables
 *@first Id for customer(Integer Type)
 *@second Name for Customer (String Type)
 *@third mCars ArrayList of Car type for storing car type object 
 *@fourth INPUT for input variables (BufferReader Type)
 *
 *1 Constructor with two Parameters
 *@Method 4 methods 
 */

public class Customer {
	
	private int mId;
	private String mFirstName;
	private String mLastName;
	private ArrayList<Car> mCars= new ArrayList<>();
	private final BufferedReader INPUT = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * This is Custructor of Customer Class Used to intialize Variables
	 * 
	 * @param id of Integer Type to store in mId
	 * @param name of String Type to store in mName
	 */
	
	public Customer(final int id,final String firstName, final String lastName){
		this.mId=id;
		this.mFirstName=firstName;
		this.mLastName=lastName;
	}
	
	/**
	 * This Method used to get Id of Customer
	 * 
	 * @return Id of current Object of int type
	 */
	public int getId() {
		return this.mId;
	}
	
	/**
	 * This Method used to get Name of Customer
	 * 
	 * 
	 * @return Name of current Object of String type
	 */
	
	public String getName() {
		return (this.mFirstName+" "+this.mLastName);
	}
	
	/**
	 * This method used to print Custmer Details (ID,NAME) and calling PrintCarDetails
	 * for printing Car Details
	 * 
	 * if else is used to check Customer Own car or not
	 * 
	 * @return nothing
	 */
	
	public void printDetails(){
		System.out.println("\n Name:  "+getName());
		System.out.println("  Id:  "+getId());
		if(mCars.size()==0) {
			System.out.println("Customer not Owned Car");
		}
		else {
			for(Car car: mCars)
				car.printCarDetails();
		}
	}
	
	/**
	 * This method used to add car for existing customer
	 * used switch case for selecting type of car
	 * 
	 * {@link ValidityUtility} for validations like Id, Model , Prize by calling respective functions
	 * {@link Car} for creating car object  
	 * 
	 * @loops 4 while loops used not nested
	 * @first for repetetion till choice not correct
	 * @second for repetetion till Id not correct
	 * @third for repetetion till Model not correct
	 * @fourth for repetetion till Prize not correct
	 * 
	 * if else is used in every loop for validation 
	 * 
	 * @throws IOException for INPUT variable of BufferReader Class
	 */
	
	public void addNewCar() throws IOException{
	
		final int hyundai=1;
    	final int maruti=2;
    	final int toyota=3;
    	
		int choice=-1;
		final Car car;
		int carId=-1;
		long price=0;
		String model=""; 
		boolean access=false;
		do {
			System.out.println("Enter your car choice \n"
				+ "1. Hyundai \n"
				+ "2. Maruti \n"
				+ "3. Toyota ");
			
			final String validCheckChoice=INPUT.readLine();
			
			if(ValidationUtil.isValidChoiceCar(validCheckChoice)) {
				choice=Integer.parseInt(validCheckChoice);
				access=false;
			}
			else {
				System.out.println("Enter valid choice 1 to 3");
				access=true;
			}
		}while(access);
		System.out.println(" Enter valid Car Id \n");
		
		do {
    		final String validcarId =INPUT.readLine();
    		if(ValidationUtil.isValidId((validcarId))) {
    			carId=Integer.parseInt(validcarId);
    			access=false;
    			for(Car ocars : mCars) {
    	    		if(ocars.getId()==carId) {
    	    			System.out.println("Id Already Exists Enter Valid Id");
    	    			access=true;
    	    			break;
    	    		}
    	    	}
    		}
    		else {
    			System.out.println(" Enter Valid car ID (only Numbers) max Length 9");
    			access=true;
    		}
    		
    	}while(access);
		
		
    	do {
    		System.out.println(" ENTER VALID CAR MODEL \n");
    		
    		final String validModelName =INPUT.readLine();
    		if(ValidationUtil.isValidModalName(validModelName)) {
    			model=validModelName;
    			access=false;
    		}
    		else {
    			System.out.println(" Enter Valid model Name (only characters and Numbers) maxLength(20) ");
    			access=true;
    		}
    		
    	}while(access);

    	do {
    		System.out.println(" ENTER VALID CAR PRICE \n");
    		
    		final String validCarPrice = INPUT.readLine();
    		if(ValidationUtil.isValidCarPrice((validCarPrice))){
    			price=Long.parseLong(validCarPrice);
    			access=false;
    		}
    		else {
    			System.out.println(" Enter Valid price (min prize 99999, max prize 99999999999)");
    			access=true;
    		}
    		
    	}while(access);
    	
		switch(choice) {
		case hyundai:
			car = new Hyundai(price, model, carId);
			mCars.add(car);
			break;
		case maruti:
			car = new Maruti(price, model, carId);
			mCars.add(car);
			break;
		case toyota:
			car = new Toyota(price, model, carId);
			mCars.add(car);
			break;
		}
	}
	

}
