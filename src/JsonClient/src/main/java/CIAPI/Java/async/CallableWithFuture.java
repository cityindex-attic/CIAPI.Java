package CIAPI.Java.async;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public abstract class CallableWithFuture<T> implements Callable<T> {

	public CallableWithFuture(Future<T> future){
		
	}
	
}
