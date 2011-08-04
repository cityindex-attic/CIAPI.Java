package CIAPI.Java;

import CIAPI.Java.core.dto.AccountInformationResponseDTO;
import CIAPI.Java.core.dto.ApiLogOnRequestDTO;
import CIAPI.Java.core.dto.ApiLogOnResponseDTO;
import CIAPI.Java.core.dto.ApiMarketDTO;
import CIAPI.Java.core.dto.GetMarketInformationResponseDTO;
import CIAPI.Java.core.dto.GetPriceBarResponseDTO;
import CIAPI.Java.core.dto.GetPriceTickResponseDTO;
import CIAPI.Java.core.dto.ListSpreadMarketsResponseDTO;
import CIAPI.Java.core.impl.ServiceMethodsImpl;
import JsonClient.Java.ApiException;
import JsonClient.Java.DefaultJsonClient;
import JsonClient.Java.JsonApi;

public class Main {
	private static final int[] sony_id = { 100687, 400169951 };

	public static void main(String[] args) throws ApiException {
		String username="DM332844";
		JsonApi api = new JsonApi("http://ciapipreprod.cityindextest9.co.uk/TradingApi", new DefaultJsonClient());
		ServiceMethodsImpl methods = new ServiceMethodsImpl();
		ApiLogOnRequestDTO logReq = new ApiLogOnRequestDTO();
		logReq.setPassword("password");
		logReq.setUserName(username);
		ApiLogOnResponseDTO resp = methods.LogOn(logReq, api);
		api.addConstantParameter("session", resp.getSession());
		api.addConstantParameter("username", username);
		AccountInformationResponseDTO account = methods.GetClientAndTradingAccount(api);
		ListSpreadMarketsResponseDTO spreads = methods.ListSpreadMarkets("Sony", "no_ne", account.getClientAccountId(),
				100, api);
		ApiMarketDTO[] markets = spreads.getMarkets();
		System.out.println(markets.length);
		GetMarketInformationResponseDTO mktInfo = methods.GetMarketInformation(sony_id[1] + "", api);
		System.out.println(mktInfo.getMarketInformation());

		GetPriceTickResponseDTO ticks = methods.GetPriceTicks(sony_id[1] + "", "200", api);
		System.out.println(ticks.getPriceTicks().length);

		GetPriceBarResponseDTO bars = methods.GetPriceBars(sony_id[1] + "", "day", 1, "200", api);
		System.out.println(bars.getPriceBars().length);
	}
}
