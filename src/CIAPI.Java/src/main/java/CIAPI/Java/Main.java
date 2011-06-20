package CIAPI.Java;

import CIAPI.Java.core.dto.AccountInformationResponseDTO;
import CIAPI.Java.core.dto.ApiLogOnResponseDTO;
import CIAPI.Java.core.dto.GetPriceBarResponseDTO;
import CIAPI.Java.core.dto.GetPriceTickResponseDTO;
import CIAPI.Java.core.dto.ListCfdMarketsResponseDTO;
import CIAPI.Java.core.impl.ServiceMethodsImpl;
import JsonClient.Java.ApiException;
import JsonClient.Java.DefaultJsonClient;
import JsonClient.Java.JsonApi;

public class Main {
	private static final int sony_id = 100687;

	public static void main(String[] args) throws ApiException {
		JsonApi api = new JsonApi("http://ciapipreprod.cityindextest9.co.uk/TradingApi", new DefaultJsonClient());
		ServiceMethodsImpl methods = new ServiceMethodsImpl();
		ApiLogOnResponseDTO resp = methods.LogOn("DM238300", "password", api);
		api.addConstantParameter("session", resp.getSession());
		api.addConstantParameter("username", "DM238300");
		AccountInformationResponseDTO account = methods.GetClientAndTradingAccount(api);
		GetPriceBarResponseDTO ticks = methods.GetPriceBars(1577+"", "minute", 10, "300", api);
		System.out.println(ticks.getPriceBars().length);
	}
}
