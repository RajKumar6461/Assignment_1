package comparator;

import java.util.Comparator;
import model.Customer;

/**
 * This Class is used for Override method of Comparator
 * help in sorting of object on particular type of variable
 * 
 * @author rajkumar
 *
 */
public class CustomerIdComparator implements Comparator<Customer>{

	/**
	 * This method used to Compare to Variables of particular object
	 * 
	 * 
	 * @param  objCustomer1 of Customer class type  used to get id in object
	 * @param objCustmer2 of Customer class type used to get id in object
	 * 
	 * @return int type after comparing two names
	 */
	@Override
	public int compare(Customer objCustmer1, Customer objCustmer2) {
		// TODO Auto-generated method stub
		return Integer.toString(objCustmer1.getId()).compareTo(Integer.toString(objCustmer2.getId()));
		
	}
	
}
