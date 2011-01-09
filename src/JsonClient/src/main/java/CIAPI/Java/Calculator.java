package CIAPI.Java;

public class Calculator {

	public int add(int arg1, int arg2) {
		return arg1 + arg2;
	}
	
	public int subtract(int i, int j){
		return i - j;
	}
	
	public int multpily(int i, int j){
		return i * j;
	}
	
	public int abstractMath(MathOp op, int arg1, int arg2){
		return op.doOp(arg1, arg2);
	}
}
