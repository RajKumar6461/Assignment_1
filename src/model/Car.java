package model;


/**
 * This is abstract Class contain customer data eg: Model , Id , Price;
 * 
 * @author rajkumar
 * 
 *@variables 3 variables
 *@first mModel for Car(String Type)
 *@second mId for Car (int Type)
 *@third mPrize for Car (double Type)
 *
 *
 *2 abstract methods
 *3 public methods
 *
 */
public abstract class Car {
    private String mModel;
    private int mId;
    private long mPrice;
    
    /**
     * This is Constructor of Car to intialize its variables
     * 
     * @param model of Stering type 
     * @param id of int type
     * @param price of double type
     */
    
    
    public Car(final String model, final int id, final long price){
    	this.mModel=model;
    	this.mId=id;
    	this.mPrice=price;
    }
    
    /**
     * this method used to get id of Car
     * 
     * @return Id of current object of int type
     */
    
    public int getId() {
    	return this.mId;
    }
    

    /**
     * this method used to get Model of Car
     * 
     * @return Model of current object of String type
     */
    
    
    public String getModel() {
 	   return this.mModel;
    }
    

    /**
     * this method used to get Prize of Car
     * 
     * @return Prize of current object of double type
     */
    
    public long getPrice() {
 	   return this.mPrice;
    }
    
    /**
     * these are abstract methods 
     * 
     * @first this method used to caluclate Resale Value of Car
     * @return double type 
     * 
     * @second This method Used to PrintCar Details
     */
    
    public abstract double calculateResalePrice();
    public abstract void printCarDetails();
    
}

