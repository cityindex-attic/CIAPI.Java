package CIAPI.Java.test;

import static org.junit.Assert.*;

import org.junit.Test;

import CIAPI.Java.Calculator;
import CIAPI.Java.MathOp;

public class CalculatorTest {

	@Test
	public void CanPassTest() {
		assertTrue(true);
	}

	@Test
	public void WhenAddingOneAndThreeThenFourShouldBeReturned() {
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.add(1, 3));
	}

	@Test
	public void AnonClasAdding() {
		Calculator calc = new Calculator();
		assertEquals(7, calc.abstractMath(new MathOp() {
			@Override
			public int doOp(int arg1, int arg2) {
				return arg1 + arg2 * 2;
			}
		}, 3, 2));
	}
}
