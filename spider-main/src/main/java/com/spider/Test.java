package com.spider;

public class Test {

	private int a;
	private int b;

	public int plus() {
		return a + b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void do1() {
		Test test = new Test();
		test.plus();
	}

}
