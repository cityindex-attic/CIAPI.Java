package CIAPI.Java.pricewidget.model.stock.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CIAPI.Java.pricewidget.model.stock.IStock;
import CIAPI.Java.pricewidget.model.stock.IStockSearch;

public class FakeStockSearch implements IStockSearch {

	private static final Map<String, IStock> ric_stock = new HashMap<String, IStock>();
	private static final Map<Integer, IStock> id_stock = new HashMap<Integer, IStock>();

	@Override
	public List<IStock> searchForName(String name, int max) {
		return null;
	}

	@Override
	public IStock getFromRICCode(String ric) {
		if (!ric_stock.containsKey(ric)) {
			IStock stock = new FakeStock(ric);
			ric_stock.put(ric, stock);
			id_stock.put(stock.getId(), stock);
		}
		return ric_stock.get(ric);
	}

	@Override
	public IStock getById(int id) {
		if (!id_stock.containsKey(id)) {
			FakeStock stock = new FakeStock(id + "_name");
			stock.setId(id);
			ric_stock.put(id + "_name", stock);
			id_stock.put(id, stock);
		}
		return id_stock.get(id);
	}

}
