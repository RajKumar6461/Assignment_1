package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Thais is util class used here for providing validations
 * 
 * @author rajkumar
 * 
 *
 *6 Methods define in this of static type called directly by class name 
 *without creating objects
 *
 */

public final class ValidationUtil {

	/**
	 * 
	 * This method used to check input name is of character type or not
	 * in this regex define language of valid input ^[a-zA-Z ]+$
	 * 
	 * {@link Pattern} for generating pattern for given language
	 * {@link Matcher} used for matching input name and pattern generated
	 * 
	 * @param name String type to check is the valid or not
	 * @return boolean type provide results in [true , false] for input name
	 * 
	 */
	
	public static boolean isValidName(final String name) {
		String regex="^[a-zA-Z]{3,20}$";
		final Pattern pattern = Pattern.compile(regex);;
		
		Matcher matcher = pattern.matcher(name);
		
		return matcher.matches();
	}
	
	/**
	 * This method used to check input id is of int type or not
	 * in this regex define language of valid input ^[1-9]+[0-9]*$
	 * 
	 * {@link Pattern} for generating pattern for given language
	 * {@link Matcher} used for matching input id and pattern generated
	 * 
	 * @param id String type to check is the valid or not
	 * @return boolean type provide results in [true , false] for input id
	 * 
	 */
	
	public static boolean isValidId(final String id) {
		String regex="^[1-9][0-9]*$";
		final Pattern pattern = Pattern.compile(regex);;
		
		Matcher matcher = pattern.matcher(id);
		
		return (matcher.matches()&& id.length()<10);
	}
	
	/**
	 * This method used to check input choice is in range from [1-6] or not
	 * in this regex define language of valid input [1-6]+$
	 * 
	 * {@link Pattern} for generating pattern for given language
	 * {@link Matcher} used for matching input choice and pattern generated
	 * 
	 * @param choice String type to check is the valid or not
	 * @return boolean type provide results in [true , false] for input choice
	 * 
	 */
	
	public static boolean isValidChoiceAdmin(final String choice) {
		String regex="[1-8]+$";
		final Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(choice);
		
		return matcher.matches();
		
	}
	
	/**
	 * This method used to check input model is in given language or not
	 * in this regex define language of valid input ^[a-zA-Z0-9]+$
	 * 
	 * {@link Pattern} for generating pattern for given language
	 * {@link Matcher} used for matching input choice and pattern generated
	 * 
	 * @param model String type to check is the valid or not
	 * @return boolean type provide results in [true , false] for input model
	 * 
	 */
	
	
	public static boolean isValidModalName(final String model) {
		String regex="^[a-zA-Z0-9]{1,20}$";
		final Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(model);
		
		return matcher.matches();
	}
	
	/**
	 * This method used to check input price is of double type or not
	 * in this regex define language of valid input ^[1-9]+[0-9.]*$
	 * 
	 * {@link Pattern} for generating pattern for given language
	 * {@link Matcher} used for matching input choice and pattern generated
	 * 
	 * @param price String type to check is the valid or not
	 * @return boolean type provide results in [true , false] for input price
	 * 
	 */
	
	
	public static boolean isValidCarPrice(final String price) {
		String regex="^[1-9][0-9]{5,11}$";
		final Pattern pattern = Pattern.compile(regex);;
		
		Matcher matcher = pattern.matcher(price);
		
		return matcher.matches();
	}
	
	/**
	 * This method used to check input choice is in range from [1-3] or not
	 * in this regex define language of valid input [1-3]+$
	 * 
	 * {@link Pattern} for generating pattern for given language
	 * {@link Matcher} used for matching input choice and pattern generated
	 * 
	 * @param choice String type to check is the valid or not
	 * @return boolean type provide results in [true , false] for input choice
	 * 
	 */
	
	
	public static boolean isValidChoiceCar(final String choice) {
		String regex="[1-3]+$";
		final Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(choice);
		
		return matcher.matches();
		
	}
}
