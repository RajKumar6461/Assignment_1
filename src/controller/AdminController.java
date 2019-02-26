package controller;

import util.ValidationUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Integer;

/**
 * @author rajkumar
 * 
 * Main Class having only Main function
 * 
 * Switch is used user selection operation
 * 
 */

public class AdminController {
	
	/**
	 * Main function Used switch case for User input
	 * 
	 * ValidUtiliy Class is Used for Validation (Used Regex)
	 * do While loop for again asking input till pressed Exit option
	 * 
	 * if else is used for validation 
	 * 
	 * @param args not Used
	 * @throws IOException for BufferedReader Class
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		final int ADD_CUSTOMER=1;
		final int ADD_CAR=2;
		final int GET_DETAIL_ON_ID=3;
		final int GET_CUSTOMER_DETAIL=4;
		final int GET_SORTED_CUSTOMER_DETAIL_BY_NAME=5;
		final int GET_SORTED_CUSTOMER_DETAIL_BY_ID=6;
		final int GENERATE_PRIZES=7;
		final int EXIT=8;
		
		final BufferedReader INPUT = new BufferedReader(new InputStreamReader(System.in));
		final BackendAdminController BACKEND_ADMIN= new BackendAdminController();
		
		boolean access=true;
		
		System.out.println("Hello Everyone");
		
		System.out.println("========Car----Purchase----Utility=======\n");
		
		// loop for getting valid choice and continue till exit
		do {
			System.out.println("\n \n Enter Your Choice "
				+ "\n 1.  ADD NEW CUSTOMER"
				+ "\n 2.  ADD NEW CAR FOR EXISTING CUSTOMER"
				+ "\n 3.  GET CUSTOMER DETAIL BY ID"
				+ "\n 4.  LIST ALL CUSTOMER WITH THERE CARS"
				+ "\n 5.  LIST ALL CUSTOMER SORT BY NAME WITH THERE CARS"
				+ "\n 6.  LIST ALL CUSTOMER SORT BY ID WITH THERE CARS "
				+ "\n 7.  GENERATE PRIZES FOR CUSTOMER"
				+ "\n 8.  Exit");
			
			final int CHOICE;
			final String VALIDCHECKCHOICE=INPUT.readLine();
			if(ValidationUtil.isValidChoiceAdmin(VALIDCHECKCHOICE))
			    CHOICE=Integer.parseInt(VALIDCHECKCHOICE);
			else {
				System.out.println("Enter valid choice 1 to 8");
				continue;
			}
			
			switch(CHOICE) {
			
				case ADD_CUSTOMER:
					BACKEND_ADMIN.addCustomer();
					break;
				case ADD_CAR:
					BACKEND_ADMIN.addCar();
					break;
				case GET_DETAIL_ON_ID:
					
					break;
				case GET_CUSTOMER_DETAIL:
					BACKEND_ADMIN.printCustomer();
					break;
				case GET_SORTED_CUSTOMER_DETAIL_BY_NAME:
					BACKEND_ADMIN.sortByCustomerName();
					break;
				case GET_SORTED_CUSTOMER_DETAIL_BY_ID:
					BACKEND_ADMIN.sortByCustomerId();
					break;
				case GENERATE_PRIZES: 
					BACKEND_ADMIN.generatePrizes();
					break;
				case EXIT:
					access=false;
					break;
			}
		}while(access);
		System.out.println("Thank You");
		INPUT.close();
	}

}