package CIAPI.Java.pricewidget.model.stock;

import java.util.List;

public interface IStockSearch {

	public List<IStock> searchForName(String name, int maxResults);

	public IStock getFromRICCode(String ric);

	public IStock getById(int id);
}
