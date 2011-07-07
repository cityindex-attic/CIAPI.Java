package CIAPI.Java.pricewidget.model;

public interface IStock {
	public String getName();

	public String getRICCode();

	public int getId();

	public double currentPrice();

	public double lastPrice();

	public double[] getLastNPrices(int n);

	public PriceStatus getStatus();

	public PriceStatus getStatusOverNTicks(int n);

	public static enum PriceStatus {
		RISING, SAME, FALLING;
	}
}
