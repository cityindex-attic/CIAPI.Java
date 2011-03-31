package CIAPI.Java;

import java.util.concurrent.Future;

import JsonClient.Java.ApiException;
import JsonClient.Java.async.CallBack;

public class Main {
	public static void main(String[] args) throws ApiException,
			InterruptedException {
		final AsyncApi api = new ApiFActory().getAsyncApi();
		System.out.println(api.getSessionId());
		Future<Object> result = api.logIn("DM904310", "password", true, new CallBack() {
			@Override
			public void doCallBack(Object result, String baseUrl,
					String methodName) {
				System.out.println(api.getSessionId());
			}
			
			@Override
			public void handleException(Exception e) {
				super.handleException(e);
				System.err.println(e);
			}
		});
		while(!result.isDone())Thread.sleep(100);
	}
}
