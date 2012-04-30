package br.batcave.math;

public class FibonacciNumber {

	public int calculate(int i) {
		
		int f1 = 0;
		int f2 = 1;
		int fbNumber = 1;
		
		
		for (int j = 1; j < i; j++){
			fbNumber = f1 + f2;
			f1 = f2;
			f2 = fbNumber;
		}
		
		return fbNumber;
	}

}
