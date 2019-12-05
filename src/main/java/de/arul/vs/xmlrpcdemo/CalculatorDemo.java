package de.arul.vs.xmlrpcdemo;

public class CalculatorDemo {

	public int add(int i1, int i2) {
		System.out.println("add called with parameters: " + i1 + " and " + i2);
		return i1 + i2;
	}

	public int subtract(int i1, int i2) {
		System.out.println("subtract called with parameters: " + i1 + " and " + i2);
		return i1 - i2;
	}
}
