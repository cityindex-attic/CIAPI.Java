package CIAPI.Java.pricewidget.model;

import static CIAPI.Java.android.Constants.TAG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import CIAPI.Java.core.ServiceMethods;
import CIAPI.Java.core.dto.ApiMarketInformationDTO;
import CIAPI.Java.core.dto.GetPriceTickResponseDTO;
import CIAPI.Java.core.dto.PriceTickDTO;
import CIAPI.Java.core.impl.ServiceMethodsImpl;
import JsonClient.Java.ApiException;
import android.content.Context;
import android.util.Log;

public class RealStock implements IStock {
	public static final String[] WHITE_LIST = ("123 456 789 38959 38990 39009 39755 41813 42160 "
			+ "52077 63274 71442 71443 99506 99609 99612 99626 133240 133504 146720 154289 154981 "
			+ "400156103 400158421 400158433 400159936 400164737 400188540 400195587 400195712 400272693 "
			+ "400315915 400368520 400379908 400390750 400421302 400429952 400433200 400480968 400481115 "
			+ "400481119 400481120 400481126 400481128 400481136 400481138 400481139 400481140 400481141 "
			+ "400481142 400481211 400481217 400481223 400481229 400481235 400481241 400481247 400481253 "
			+ "400481259 400481590 400481664 400481665 400481666 500000000").split("\\s+");
	private static List<Integer> realWhiteList;
	private static int TICS_PER_REQUEST = 10;

	private List<Integer> pastPrices;
	private long lastUpdatedTime;
	private ServiceMethods methods = new ServiceMethodsImpl();

	private ApiMarketInformationDTO info;

	private final int id;

	public RealStock(int id, Context context) throws ApiException {
		if (realWhiteList == null) {
			Integer[] arr = new Integer[WHITE_LIST.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(WHITE_LIST[i].trim());
			}
			realWhiteList = Arrays.asList(arr);
		}
		if (!realWhiteList.contains(id)) {
			throw new IllegalArgumentException("The given id was not in the whitelist.");
		}
		this.id = id;
		try {
			this.info = methods.GetMarketInformation(id + "", LogOnStatus.api()).getMarketInformation();
		} catch (ApiException e) {
			Log.e(TAG, "Eff, failed to build RealStock: " + e.getMessage());
			throw new ApiException("Eff, failed to build RealStock: " + e.getMessage());
		}
		if (id != info.getMarketId()) {
			throw new Error("Returned id did not match given id");
		}
		this.pastPrices = new ArrayList<Integer>();
	}

	@Override
	public String getName() {
		return info.getName();
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getRICCode() {
		return info.getName().substring(0, 3);
	}

	@Override
	public double currentPrice() {
		try {
			GetPriceTickResponseDTO tickResp = methods.GetPriceTicks(id + "", TICS_PER_REQUEST + "", LogOnStatus.api());
			PriceTickDTO[] ticks = tickResp.getPriceTicks();
			String date = ticks[0].getTickDate();
			Log.e(TAG, "Woah!! - " + date);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double lastPrice() {
		return 0;
	}

	@Override
	public double[] getLastNPrices(int n) {
		return null;
	}

	@Override
	public PriceStatus getStatus() {
		return null;
	}

	@Override
	public PriceStatus getStatusOverNTicks(int n) {
		return null;
	}
}
