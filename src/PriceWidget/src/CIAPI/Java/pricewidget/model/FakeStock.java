package CIAPI.Java.pricewidget.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeStock implements IStock {

	private static final double FACTOR = .05;
	private static final double START_PRICE = 15;
	private static final double GUARENTEE = .05;
	private List<Double> historicPrices;
	private final String name;
	private int id;
	private final Random r;

	public FakeStock(String name) {
		r = new Random();
		historicPrices = new ArrayList<Double>();
		historicPrices.add(START_PRICE);
		currentPrice();
		currentPrice();
		currentPrice();
		this.name = name;
		this.id = r.nextInt(10000000);
	}

	private double generateNextPrice(double lastPrice) {
		double changeAmnt = lastPrice * r.nextDouble() * FACTOR;
		changeAmnt = r.nextBoolean() ? changeAmnt : -changeAmnt;
		return Math.abs(lastPrice + changeAmnt + GUARENTEE);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getRICCode() {
		return name.substring(0, 3);
	}

	@Override
	public int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	@Override
	public double currentPrice() {
		historicPrices.add(generateNextPrice(historicPrices.get(historicPrices.size() - 1)));
		double nextPrice = historicPrices.get(historicPrices.size() - 1);
		String prStr = String.format("%.2f", nextPrice);
		nextPrice = Double.parseDouble(prStr);
		return nextPrice;
	}

	@Override
	public double lastPrice() {
		return historicPrices.get(historicPrices.size() - 2);
	}

	@Override
	public double[] getLastNPrices(int n) {
		double[] ret = new double[n];
		for (int i = historicPrices.size() - n, j = 0; i < historicPrices.size(); i++, j++) {
			ret[j] = historicPrices.get(i);
		}
		return ret;
	}

	@Override
	public PriceStatus getStatus() {
		return historicPrices.get(historicPrices.size() - 1) > historicPrices.get(historicPrices.size() - 2) ? PriceStatus.RISING
				: PriceStatus.FALLING;
	}

	@Override
	public PriceStatus getStatusOverNTicks(int n) {
		double[] lastN = getLastNPrices(n);
		return lastN[0] > lastN[lastN.length - 1] ? PriceStatus.RISING : PriceStatus.FALLING;
	}
}
