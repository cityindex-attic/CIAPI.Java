package CIAPI.Java.test;

import static org.junit.Assert.*;

import org.junit.Test;

import CIAPI.Java.Calculator;

public class CalculatorTest {

	@Test
	public void CanPassTest() {
		assertTrue(true);
	}
	
	@Test
	public void WhenAddingOneAndThreeThenFourShouldBeReturned()
	{
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.add(1,3));
	}
}
