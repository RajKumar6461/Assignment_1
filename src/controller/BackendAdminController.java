package controller;

import util.ValidationUtil;
import java.io.BufferedReader;
import model.Customer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import comparator.CustomerNameComparator;
import comparator.CustomerIdComparator;


/**
 * 
 * @author rajkumar
 * 
 * This Class for Admin Backend Process
 * 2 Variables 
 * @first vaiable of ArrayList Type to Store Customer Object
 * @second variable for taking input
 *
 * 5 Public Method
 * @first method used to add Customer in arrayList
 * @second method used to add Car
 * @third method used to print customer Details with there cars
 * @fourth method used to print customer details by sort name
 * @fifth method used to generate Prizes
 *
 */

public class BackendAdminController {
    
	private ArrayList<Customer> mCustomer = new ArrayList<Customer>();
    private final BufferedReader INPUT = new BufferedReader(new InputStreamReader(System.in)); 
    
    /**
     * This method add customer in ArrayList 
     * 
     * {@link ValidityUtility} used for Validation
     * 
     * {@link Custmer} used to create its Object and 
     * 
     * Variables 2 String type (name , valiCkeck) name for storing name and validCheck store inital input value
     * 1 boolean for while loops
     * i integer type id
     * 
     * @loops 3 do while loops not nested
     * @first while is true till not entering correct ID
     * and Id should not Exists
     * @Second  while is true till not entering correct First Name
     * @third while is true till not entering correct Last Name
     * 
     * @throws IOException for INPUT variable of BufferReader Class
     * 
     */
 
    public void addCustomer() throws IOException {
        String firstName="";
        String lastName="";
        int id=0;
        boolean access=false;
    	System.out.println("    ENTER  CUSTOMER  ID:  \n ");
    	
    	// loop for finding valid id true till valid id is not entered
    	do {
    		final String validCheckId = INPUT.readLine();
    		if(ValidationUtil.isValidId(validCheckId)) {
    			id = Integer.parseInt(validCheckId);
    			if(mCustomer.size()==0) {
    				access=false;
    			}
    			else {
    				for(Customer cmt : mCustomer) {
    					if(cmt.getId()==id) {
    						System.out.println("\n Id Already Exists Enter Valid Id");
    						access=true;
    						break;
    					}
    					access=false;
    				}
    			}
    		}
    		else {
    			System.out.println("\n Enter Valid Id of NUMBER Type (max length 9) ");
    			access=true;
    		}
    	}while(access);
    	
    	// loop for finding valid id true till valid First name is not entered
    	// minimum length is 3 max is 20 only alphabets
    	
    	do {
    		System.out.println("   ENTER  CUSTOMER  FIRST NAME  \n");
    		final String validCheckName = INPUT.readLine();
    		if(ValidationUtil.isValidName(validCheckName)) {
    			firstName = validCheckName;
    			access=false;
    		}
    		else {
    			System.out.println("\n Enter Valid Name of CHARACTER Type (eg: raj in length(min_lenght(3),Max_Length(20))");
    			access=true;
    		}
    	}while(access);
    	
    	// loop for finding valid id true till valid Last name is not entered
    	// minimum length is 3 max is 20 only alphabets
    	
    	do {
    		System.out.println("   ENTER  CUSTOMER  LAST NAME  \n");
    		final String validCheckName = INPUT.readLine();
    		
    		// validation check
    		if(ValidationUtil.isValidName(validCheckName)) {
    			lastName = validCheckName;
    			access=false;
    		}
    		else {
    			System.out.println("\n Enter Valid Name of CHARACTER Type (eg: raj in length(min_lenght(3),Max_Length(20))");
    			access=true;
    		}
    	}while(access);
    	Customer customer= new Customer(id, firstName,lastName);
    	// adding in list
    	mCustomer.add(customer);
    	
    }
    
    /**
     * This method add Car for particular Custmoer
     * {@link Custmer}for calling AddNewCar, calling getId function for compare id
     * 
     * {@link ValidityUtility}for validation purpose
     * 
     * @loops 1 while loop for repetion till Id not valid
     * 1 for each loop for Searching input id 
     * 
     * Variable 1 of String type for initial input for ValidCheck
     * 1 of boolean type used in while
     * 
     * @throws IOException for BufferReader Class
     */
    
    
    public void addCar() throws IOException {
    	if(mCustomer.size()==0) System.out.println(" ALERT! NOT CUSTMER  ADDED STILL");
    	else {
    		boolean access=true;
    		
    		// loop for finding valid id true till valid id is not entered
    		
    		do {
    			System.out.println("\n Enter Customer Id ");
        		final String validCheckId = INPUT.readLine();
        		if(ValidationUtil.isValidId(validCheckId)) {
        			final int id = Integer.parseInt(validCheckId);
        			for(Customer cmt : mCustomer) {
        				if(cmt.getId()==id) {
        					cmt.addNewCar();
        					access=false;
        					break;
        				}	
        			}
        			if(access)
        				System.out.println("Wrong Id ");
        		}
        		else System.out.println("\n Enter Valid Id of NUMBER Type ");
        		
        	}while(access);
    	}
    }
    
    /**
     * This Method Used to print Details for Customer 
     * @throws IOException 
     * 
     * @loop 1 for loop for traversing Objects to find id
     * and calling Customer print function
     * 
     * {@link Customer} for calling its function
     */
    
    public void printCustomerDetailOnId() throws IOException {
    	if(mCustomer.size()!=0)
    	{
    		boolean access=true;
    		// loop for finding valid id true till valid id is not entered
    		do {
    			System.out.println("\n Enter Customer Id ");
        		final String validCheckId = INPUT.readLine();
        		// validation check
        		if(ValidationUtil.isValidId(validCheckId)) {
        			final int id = Integer.parseInt(validCheckId);
        			for(Customer cmt : mCustomer) {
        				if(cmt.getId()==id) {
        					cmt.printDetails();
        					access=false;
        					break;
        				}	
        			}
        			if(access) System.out.println("Wrong Id ");
        			}
        			else System.out.println("\n Enter Valid Id of NUMBER Type ");
        		}while(access);
    	}
    	else System.out.println(" Sorry! Not Customer added Yet");
    }
    
    /**
     * This Method Used to print Details for Customer 
     * 
     * @loop 1 for loop for traversing Objects in Customer ArrayList
     * and calling Customer function
     * 
     * {@link Customer} for calling its function
     */
    
    public void printCustomer() {
    	if(mCustomer.size()!=0)
    	for(Customer cmt : mCustomer) 
    		cmt.printDetails();
    	else System.out.println(" Sorry! Not Customer added Yet");
    }
    
    /**
     * This Method Sort the Customer ArrayList by Name
     * 
     * {@link NameComparatorCustomer} for using Compare function in Comparator 
     * 
     * {@link Customer} for using its functions
     */
    

	public void sortByCustomerName() {
		// TODO Auto-generated method stub
		
		if(mCustomer.size()!=0) {
		Collections.sort(mCustomer, new CustomerNameComparator());
		
		// loop for printing of customer data
		for(Customer custObj:mCustomer) {
			custObj.printDetails();
		}
		}else System.out.println(" Sorry! Not Customer added Yet");
	}
	
	/**
     * This Method Sort the Customer ArrayList by Name
     * 
     * {@link NameComparatorCustomer} for using Compare function in Comparator 
     * 
     * {@link Customer} for using its functions
     */
    

	public void sortByCustomerId() {
		// TODO Auto-generated method stub
		
		if(mCustomer.size()!=0) {
		Collections.sort(mCustomer, new CustomerIdComparator());
		for(Customer custObj:mCustomer) {
			custObj.printDetails();
		}
		}else System.out.println(" Sorry! Not Customer added Yet");
	}
	
	/**
	 * This method is used to Generate Prizes
	 * In this Admin Enter 3 Random Id and function generate 6 Random customer Id
	 * Id that Matches Got Prize
	 * 
	 * Create new ArrayList for storing 3 Numbers from admin
	 * 
	 * {@link Random} used for generating Random number
	 * 
	 * 2 while loops not nested
	 * 1 while for input three numbers with validations
	 * 1 while loop for generating 6 Random Number 
	 * 
	 * @throws IOException Used while Input (Object of BufferReader Class)
	 */
	

	public void generatePrizes() throws IOException {
		// TODO Auto-generated method stub
		
		if(mCustomer.size()==0) 
		{
			System.out.println(" NO CUSTOMER ADDED STILL");
		}
		
		else {
			ArrayList<Integer> prizeId=new ArrayList<Integer>(3);
			System.out.println("\n ENTER 3 RANDOM ID FOR PRIZE GENERATION ");
			Random random= new Random();
	
			int index=0;
			
			// while loop for getting three ids from admin
				while(index<3) {
					final String randomAdmin=INPUT.readLine();
					if(ValidationUtil.isValidId(randomAdmin)) {
						prizeId.add(Integer.parseInt(randomAdmin));
						index++;
					}else System.out.println("\n Enter valid Id of NUMBER type (max length 9)");
				}
		
			index=0;
		
			// while loop for generating 6 random numbers and check id matched with 3 ids from admin
			while(index<6 && prizeId.size()!=0) {
				final int generateRandom=random.nextInt(mCustomer.size());
				final int customerId=mCustomer.get(generateRandom).getId();
				if(prizeId.contains(customerId)) {
					System.out.println("\n Contratulation Won prize Custmer with Id "+customerId);
					prizeId.remove(new Integer(customerId));
				}
				index++;
			}	
		}
	}
	
	
}

