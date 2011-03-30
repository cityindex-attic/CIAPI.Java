package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * The mid price at a particular point in time.
 */
public class PriceTickDTO {

	/**
	 * No argument constructor
	 */
	public PriceTickDTO() {
	}

	
	private String TickDate;
	
	/**
	 * The datetime at which a price tick occured. Accurate to the millisecond
	 */
	public String getTickDate() {
		return TickDate;
	}
	
	public void setTickDate(String TickDate) {
		this.TickDate = TickDate;
	}

	private double Price;
	
	/**
	 * The mid price
	 */
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double Price) {
		this.Price = Price;
	}

}

