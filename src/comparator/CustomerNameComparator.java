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

public class CustomerNameComparator implements Comparator<Customer>{

	/**
	 * This method used to Compare to Variables of particular object
	 * 
	 * 
	 * @param objCustmer1 of Customer class type  used to get name in object
	 * @param objCustmer2 of Customer class type used to get name in object
	 * 
	 * @return int type after comparing two names
	 */
	
	@Override
	public int compare(Customer objCustmer1, Customer objCustmer2) {
		
		return objCustmer1.getName().compareTo(objCustmer2.getName());
		
	}
	
}