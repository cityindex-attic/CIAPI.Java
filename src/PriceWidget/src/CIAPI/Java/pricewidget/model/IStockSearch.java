package CIAPI.Java.pricewidget.model;

import java.util.List;

public interface IStockSearch {

	public List<IStock> searchForName(String name);

	public IStock getFromRICCode(String ric);

	public IStock getById(int id);
}
