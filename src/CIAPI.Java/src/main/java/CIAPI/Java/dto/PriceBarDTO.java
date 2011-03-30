package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * The details of a specific price bar, useful for plotting candlestick charts
 */
public class PriceBarDTO {

	/**
	 * No argument constructor
	 */
	public PriceBarDTO() {
	}

	
	private String BarDate;
	
	/**
	 * The date of the start of the price bar interval
	 */
	public String getBarDate() {
		return BarDate;
	}
	
	public void setBarDate(String BarDate) {
		this.BarDate = BarDate;
	}

	private double Open;
	
	/**
	 * The price at the open of the price bar interval
	 */
	public double getOpen() {
		return Open;
	}
	
	public void setOpen(double Open) {
		this.Open = Open;
	}

	private double High;
	
	/**
	 * The highest price occuring during the interval of the price bar
	 */
	public double getHigh() {
		return High;
	}
	
	public void setHigh(double High) {
		this.High = High;
	}

	private double Low;
	
	/**
	 * The lowest price occuring during the interval of the price bar
	 */
	public double getLow() {
		return Low;
	}
	
	public void setLow(double Low) {
		this.Low = Low;
	}

	private double Close;
	
	/**
	 * The price at the end of the price bar interval
	 */
	public double getClose() {
		return Close;
	}
	
	public void setClose(double Close) {
		this.Close = Close;
	}

}

