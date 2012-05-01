package br.batcave.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FibonacciNumberTest {
	
	private FibonacciNumber f;
	
	@Before
	public void setUp(){
		f = new FibonacciNumber();
	}
	
	@Test
	public void fibonacciOfOneShouldReturnOne() throws Exception {
		assertEquals(1, f.calculate(1));
	}
	
	@Test
	public void fibonacciOfTwoShouldReturnOne() throws Exception {
		assertEquals(1, f.calculate(2));
	}
	
	@Test
	public void fibonacciOfThreeShouldReturnTwo() throws Exception {
		assertEquals(2, f.calculate(3));
	}
	
	@Test
	public void fibonacciOfFourShouldReturnThree() throws Exception {
		assertEquals(3, f.calculate(4));
	}
	
	@Test
	public void fibonacciOfFiveShouldReturnFive() throws Exception {
		assertEquals(5, f.calculate(5));
	}
	
}
