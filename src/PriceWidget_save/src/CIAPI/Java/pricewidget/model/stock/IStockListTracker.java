package CIAPI.Java.pricewidget.model.stock;

import java.util.SortedSet;

public interface IStockListTracker extends Iterable<IStock> {
	public SortedSet<IStock> listStocks();

	public boolean add(IStock stock);

	public IStock remove(IStock stock);

	public IStock remove(int id);

	public IStock get(int id);

	public boolean contains(int id);

	public boolean contains(IStock stock);
}
